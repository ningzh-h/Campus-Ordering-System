import sys
import pandas as pd
import matplotlib.pyplot as plt
import warnings
warnings.filterwarnings('ignore')  # 忽略警告信息

# 获取当前工作目录并设置数据路径
DISHES_CSV_PATH = r'resources\sys\dishes.csv'
ORDERS_CSV_PATH = r'resources\sys\orders.csv'
OUTPUT_IMG_PATH = r'resources\python\img\for_merchants'

# 解决中文问题
plt.rcParams['font.sans-serif'] = ['SimHei']  # 使用黑体显示中文
plt.rcParams['axes.unicode_minus'] = False  # 解决负号显示问题

def analyze_sales_data(merchantID):
    try:
        # 读取数据文件
        orders = pd.read_csv(ORDERS_CSV_PATH)
        dishes = pd.read_csv(DISHES_CSV_PATH)

        # 提取对应商家的数据，且订单不能被取消
        orders = orders[orders['merchant_id'] == int(merchantID)]
        orders = orders[orders['status'] != 2]
        dishes = dishes[dishes['merchant_id'] == int(merchantID)]

        # 修改合并方式：使用 dish_name 作为关联键
        merged_data = pd.merge(orders, dishes, on='dish_name', how='left')

        # 计算每个菜品的销售数量和销售额
        # 使用正确的价格列（来自orders的total_price）
        dish_sales = merged_data.groupby('dish_name').agg(
            total_quantity=('quantity', 'sum'),
            total_sales=('total_price', 'sum')  # 使用正确的列名
        ).reset_index()

        # 按销售额排序
        dish_sales = dish_sales.sort_values('total_sales', ascending=False)
        
        # 数据可视化
        plt.figure(figsize=(12, 6))

        # 销售额TOP10柱状图
        plt.subplot(1, 2, 1)
        top_sales = dish_sales.head(10)
        plt.barh(top_sales['dish_name'], top_sales['total_sales'], color='skyblue')
        plt.xlabel('销售额/元')
        plt.title('菜品销售额 TOP-10')
        plt.gca().invert_yaxis()

        # 销量TOP10柱状图
        plt.subplot(1, 2, 2)
        top_quantity = dish_sales.sort_values('total_quantity', ascending=False).head(10)
        plt.barh(top_quantity['dish_name'], top_quantity['total_quantity'], color='lightgreen')
        plt.xlabel('销售量/份')
        plt.title('菜品销售量 TOP-10')
        plt.gca().invert_yaxis()

        plt.tight_layout()

        # 保存并显示图表
        output_path = OUTPUT_IMG_PATH + f'\\sales_analysis_merchant{merchantID}.png'
        plt.savefig(output_path)
        print(f"\n分析图表已保存至: {output_path}")
        # plt.show()

    except Exception as e:
        print(f"数据分析出错: {str(e)}")
        # 打印详细的错误信息
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    analyze_sales_data(sys.argv[1])