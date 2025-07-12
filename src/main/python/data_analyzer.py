import pandas as pd
import matplotlib.pyplot as plt
import os

# 获取数据目录路径
current_dir = os.path.dirname(os.path.abspath(__file__))
data_dir = os.path.join(current_dir, '../data')

def analyze_sales_data():
    try:
        # 读取数据文件
        orders = pd.read_csv(os.path.join(data_dir, 'orders.csv'))
        dishes = pd.read_csv(os.path.join(data_dir, 'dishes.csv'))

        # 合并订单和菜品数据
        merged_data = pd.merge(orders, dishes, on='dish_id')

        # 计算每个菜品的销售数量和销售额
        dish_sales = merged_data.groupby('dish_name').agg(
            total_quantity=('quantity', 'sum'),
            total_sales=('total_price', 'sum')
        ).reset_index()

        # 按销售额排序
        dish_sales = dish_sales.sort_values('total_sales', ascending=False)

        # 打印热销菜品
        print("\n 热销菜品分析:")
        print(dish_sales.head(10).to_string(index=False))

        # 数据可视化
        plt.figure(figsize=(12, 6))

        # 销售额TOP10柱状图
        plt.subplot(1, 2, 1)
        top_sales = dish_sales.head(10)
        plt.barh(top_sales['dish_name'], top_sales['total_sales'], color='skyblue')
        plt.xlabel('销售额')
        plt.title('销售额TOP10菜品')
        plt.gca().invert_yaxis()

        # 销量TOP10柱状图
        plt.subplot(1, 2, 2)
        top_quantity = dish_sales.sort_values('total_quantity', ascending=False).head(10)
        plt.barh(top_quantity['dish_name'], top_quantity['total_quantity'], color='lightgreen')
        plt.xlabel('销售数量')
        plt.title('销量TOP10菜品')
        plt.gca().invert_yaxis()

        plt.tight_layout()

        # 保存并显示图表
        plt.savefig(os.path.join(data_dir, 'sales_analysis.png'))
        print("\n OK 分析图表已保存至: data/sales_analysis.png")
        plt.show()

    except Exception as e:
        print(f" No 数据分析出错: {str(e)}")

if __name__ == "__main__":
    analyze_sales_data()