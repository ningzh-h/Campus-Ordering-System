import pandas as pd
import matplotlib.pyplot as plt

# csv 文件路径
DISHES_CSV_PATH = r'resources\sys\dishes.csv'
OUTPUT_CSV_PATH = r'resources\python\csv\for_students\dishes_top_10.csv'

plt.rcParams['font.sans-serif'] = ['SimHei']  # 使用黑体显示中文
plt.rcParams['axes.unicode_minus'] = False  # 解决负号显示问题

def main(): 
    # 读取数据
    df_dishes = pd.read_csv(DISHES_CSV_PATH)

    # 按热度排序，将 TOP-10 写入新的 csv 文件中，并绘制柱状图
    df_dishes.sort_values(by='popularity', inplace=True, ascending=False)
    if len(df_dishes) > 10: 
        df_dishes = df_dishes[:10]
    df_dishes.to_csv(OUTPUT_CSV_PATH, index=False)


if __name__ == '__main__': 
    main()

