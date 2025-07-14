import pandas as pd
import numpy as np
import random
from datetime import datetime

DISHES_PATH = r'resources\sys\dishes.csv'
ORDERS_PATH = r'resources\sys\orders.csv'

random.seed(0)

dishes = []
dishes_head = ['dish_id','dish_name','price','merchant_id','stock','popularity']
dishes_name = ['巨无霸汉堡', '麦辣鸡翅', '麦旋风', '可乐', '豆浆', '麦乐鸡块', '板烧鸡腿堡', '麦香鸡', '小份薯条', '中份薯条', '甜筒']

for i in range(len(dishes_name)): 
    dishes.append([
        i, dishes_name[i], round(5000 * random.random()) / 100, 2, round(200 * random.random()), round(200 * random.random())
    ])

dishes = np.array(dishes)
df_dishes = pd.DataFrame(dishes)
df_dishes.columns = dishes_head
df_dishes.to_csv(DISHES_PATH, index=False)


orders = []
orders_head = ['order_id','student_id','merchant_id','dish_name','quantity','total_price','order_time','status']

for i in range(20):
    quantity = round(5 * random.random())
    dish_name = dishes_name[round((len(orders_head)-1) * random.random())]
    total_price = float(df_dishes[df_dishes['dish_name'] == dish_name]['price'])
    orders.append([
        i, 3, 2, dish_name, quantity, total_price, datetime.now().strftime('%Y-%m-%d %H:%M:%S'), random.randint(1, 3)
    ])

orders = np.array(orders)
df_orders = pd.DataFrame(orders)
df_orders.columns = orders_head
df_orders.to_csv(ORDERS_PATH, index=False)



