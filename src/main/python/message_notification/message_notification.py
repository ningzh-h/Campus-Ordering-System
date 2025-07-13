import pandas as pd
import random
from datetime import datetime

# 修改后的路径获取方式
USERS_CSV_PATH = r'resources\sys\users.csv'
DISHES_CSV_PATH = r'resources\sys\dishes.csv'
ORDERS_CSV_PATH = r'resources\sys\orders.csv'

class NotificationSystem:
    def __init__(self):
        # 读取数据时确保处理可能的异常
        try:
            self.users = pd.read_csv(USERS_CSV_PATH)
            self.dishes = pd.read_csv(DISHES_CSV_PATH)
            self.orders = pd.read_csv(ORDERS_CSV_PATH)

            # 检查数据是否加载成功
            print("数据加载成功！")
            print(f"用户记录数: {len(self.users)}")
            print(f"菜品记录数: {len(self.dishes)}")
            print(f"订单记录数: {len(self.orders)}")

        except Exception as e:
            print(f"数据加载失败: {str(e)}")
            raise

    def send_sms(self, phone, message):
        """模拟短信发送功能"""
        print(f"\n发送短信到 {phone}:")
        print(f"   [{datetime.now().strftime('%Y-%m-%d %H:%M:%S')}] {message}")

    def notify_order_status(self, order_id):
        """订单状态通知（修复dish_id问题）"""
        try:
            # 获取订单信息
            order = self.orders[self.orders['order_id'] == order_id]
            if order.empty:
                raise ValueError(f"订单 {order_id} 不存在")
            order = order.iloc[0]

            # 获取学生信息
            student = self.users[self.users['user_id'] == order['student_id']]
            if student.empty:
                raise ValueError(f"学生ID {order['student_id']} 不存在")
            student = student.iloc[0]

            # 通过菜品名称获取菜品信息（不再使用dish_id）
            dish = self.dishes[self.dishes['dish_name'] == order['dish_name']]
            if dish.empty:
                raise ValueError(f"菜品 {order['dish_name']} 不存在")
            dish = dish.iloc[0]

            # 获取商家信息
            merchant = self.users[self.users['user_id'] == dish['merchant_id']]
            if merchant.empty:
                raise ValueError(f"商家ID {dish['merchant_id']} 不存在")
            merchant = merchant.iloc[0]

            # 给学生发送通知
            student_msg = (
                f"亲爱的{student['user_name']}同学，您的订单 #{order_id} 已确认！\n"
                f"菜品: {dish['dish_name']} × {order['quantity']}\n"
                f"总价: ¥{order['total_price']:.2f}\n"
                f"预计送达时间: {datetime.now().strftime('%H:%M')}"
            )
            self.send_sms(student['phone'], student_msg)

            # 给商家发送通知
            merchant_msg = (
                f"新订单通知 #{order_id}！\n"
                f"菜品: {dish['dish_name']} × {order['quantity']}\n"
                f"学生: {student['user_name']}\n"
                f"总价: ¥{order['total_price']:.2f}"
            )
            self.send_sms(merchant['phone'], merchant_msg)

            return True

        except Exception as e:
            print(f"NO 订单通知失败: {str(e)}")
            import traceback
            traceback.print_exc()
            return False

    def check_low_stock(self, threshold=5):
        """低库存预警检查（修复索引越界问题）"""
        try:
            low_stock = self.dishes[self.dishes['stock'] < threshold]

            if low_stock.empty:
                print("\nYES 所有菜品库存充足")
                return

            print("\n！！ 低库存预警:")
            for _, dish in low_stock.iterrows():
                try:
                    # 安全获取商家信息
                    merchant = self.users[self.users['user_id'] == dish['merchant_id']]
                    if not merchant.empty:
                        merchant = merchant.iloc[0]
                        message = (
                            f"紧急：菜品 {dish['dish_name']} 库存仅剩 {dish['stock']} 份！\n"
                            f"请及时补货"
                        )
                        self.send_sms(merchant['phone'], message)
                    else:
                        print(f"！！ 找不到商家ID {dish['merchant_id']} 的信息")

                except Exception as e:
                    print(f"NO 处理菜品 {dish['dish_name']} 时出错: {str(e)}")

            return True

        except Exception as e:
            print(f"NO 库存检查失败: {str(e)}")
            import traceback
            traceback.print_exc()
            return False

# 测试用例
if __name__ == "__main__":
    # 初始化通知系统
    notifier = NotificationSystem()

    # 测试订单通知 - 使用实际存在的订单ID
    print("\n=== 测试订单通知 ===")
    valid_order_ids = notifier.orders['order_id'].sample(2).tolist()  # 随机选2个有效订单
    for order_id in valid_order_ids:
        print(f"\n测试订单ID: {order_id}")
        notifier.notify_order_status(order_id)

    # 测试库存预警 - 自动设置低库存
    print("\n=== 测试库存预警 ===")
    # 随机设置3个低库存菜品
    sample_dishes = notifier.dishes.sample(3)
    notifier.dishes.loc[sample_dishes.index, 'stock'] = 3
    notifier.check_low_stock()