import sys
import pandas as pd

DISHES_CSV_PATH = r'resources\sys\dishes.csv'


def low_stock_notify(userID): 
    userID = int(userID)
    # 导入数据
    dishes = pd.read_csv(DISHES_CSV_PATH)

    dishes = dishes[dishes['merchant_id'] == userID]
    low_stock_dishes = dishes[dishes['stock'] <= 10]
    length = len(low_stock_dishes)

    print('\n=== 低库存预警 ===')
    for i in range(length): 
        dish = low_stock_dishes.iloc[i]
        print(f'菜品 {dish['dish_name']} 库存低于 20，剩余库存为 {dish['stock']}，请及时补充！')

    return


if __name__ == '__main__': 
    low_stock_notify(sys.argv[1])
