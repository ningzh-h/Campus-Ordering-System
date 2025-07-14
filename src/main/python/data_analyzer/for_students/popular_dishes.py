import pandas as pd

# csv 文件路径
DISHES_CSV_PATH = r'resources\sys\dishes.csv'
OUTPUT_CSV_PATH = r'resources\python\csv\dishes_top_10.csv'


def main(): 
    # 读取数据
    df_dishes = pd.read_csv(DISHES_CSV_PATH)

    # 按热度排序，将 TOP-10 写入新的 csv 文件中
    df_dishes.sort_values(by='popularity', inplace=True, ascending=False)
    if len(df_dishes) > 10: 
        df_dishes = df_dishes[:10]
    df_dishes.to_csv(OUTPUT_CSV_PATH, index=False)
    print(df_dishes)


if __name__ == '__main__': 
    main()

