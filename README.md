# 校园餐厅订餐系统
> 成员：宁中昊、金圣博、徐祖斌



## 项目结构

```commandline
CampusOrderingSystem/
<<<<<<< HEAD
├─ java/
=======
├─ src/
>>>>>>> 55143e1d9f144ce2cf65e15f8ba2db90531fc528
│  ├─ java/
│  │  ├─ Main.java        # 程序入口, 流程控制
│  │  ├─ models/
│  │  │  ├─ User.java     # 用户类 (父类)
│  │  │  ├─ Student.java  # 学生类
│  │  │  ├─ Merchant.java # 店家类
│  │  │  ├─ Dish.java     # 菜品类
│  │  │  └─ Order.java    # 订单类
│  │  │
│  │  ├─ services/
│  │  │  ├─ LogInService.java # 登录注册
│  │  │  ├─ MenuService.java  # 菜品信息
│  │  │  └─ OrderService.java # 订单相关
│  │  │
│  │  └─ utils/
│  │     ├─ CSVGenerate.java  # 菜品信息
│  │     └─ OrderService.java # 订单相关
│  │  
<<<<<<< HEAD
│  └─ codes.python/
=======
│  └─ python/
>>>>>>> 55143e1d9f144ce2cf65e15f8ba2db90531fc528
│     ├─ requirement.txt  # Python 依赖库
│     ├─ data_analyzer.py # 数据分析与可视化
│     └─ notification.py  # 短信通知(学生/店家)与低库存预警(店家)
│  
├─ data/
│  ├─ users.csv  # 用户信息 (user_id, user_name, password, role) 
│  ├─ dishes.csv # 菜品信息 (dish_id, merchant_id, dish_name, dish_price, stock)
│  └─ orders.csv # 订单记录 (order_id, student_id, dish_id, quantity, total_price, time)
└─ README # 简述文件

```

