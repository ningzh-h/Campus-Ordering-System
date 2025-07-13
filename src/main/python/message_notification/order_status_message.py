import sys
import pandas as pd
import numpy as np
from datetime import datetime

USERS_CSV_PATH = r'resources\sys\users.csv'
ORDERS_CSV_PATH = r'resources\sys\orders.csv'

messages = ['您有新的订单，请注意查收！', '订单已被取消！', '订单已完成，请及时前往商家领取菜品！']


def send_message(username, phone, message): 
    print('\n=== 模拟短信发送 ===')
    print(f'向 {username} 的电话 {phone} 发送短信：')
    print(f'\n\t{message}\n')
    print(f'发送时间：{datetime.now().strftime('%Y-%m-%d %H:%M:%S')}')


def order_status_messgae(orderID, newStatus): 
    orderID = int(orderID)
    newStatus = int(newStatus)

    users  = pd.read_csv(USERS_CSV_PATH)
    orders = pd.read_csv(ORDERS_CSV_PATH)

    order = orders[orders['order_id'] == orderID]
    student_id = np.array(order['student_id'])[0]
    merchant_id = np.array(order['merchant_id'])[0]


    student = users[users['user_id'] == student_id]
    merchant = users[users['user_id'] == merchant_id]

    student_username = np.array(student['username'])[0]
    student_phone = np.array(student['phone'])[0]
    merchant_username = np.array(merchant['username'])[0]
    merchant_phone = np.array(merchant['phone'])[0]

    message = messages[newStatus - 1]

    if newStatus == 1: 
        send_message(merchant_username, merchant_phone, message)
    elif newStatus == 2: 
        send_message(merchant_username, merchant_phone, message)
    elif newStatus == 3:
        send_message(student_username, student_phone, message)
    else: 
        print('状态错误！')

    return


if __name__ == '__main__': 
    order_status_messgae(sys.argv[1], sys.argv[2])
