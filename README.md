# 校园餐厅订餐系统
> 成员：宁中昊、金圣博、徐祖斌



## 项目结构

```commandline
src/
├─ main/
│  ├─ java/
│  │  ├─ Main.java        # 程序入口, 流程控制
│  │  ├─ entities/        # 实体类
│  │  │  ├─ users/
│  │  │  │  ├─ User.java     # 用户类 (父类)
│  │  │  │  ├─ Merchant.java # 商家类
│  │  │  │  └─ Student.java  # 学生类
│  │  │  ├─ Dish.java     # 菜品类
│  │  │  └─ Order.java    # 订单类
│  │  │
│  │  ├─ pages/
│  │  │  ├─ login_pages
│  │  │  │  ├─ LoginPage.java # 登录页面
│  │  │  │  ├─ Login.java     # 用户登录
│  │  │  │  └─ Register.java  # 用户注册
│  │  │  │
│  │  │  ├─ student_pages/
│  │  │  │  ├─ StudentPages.java
│  │  │  │  ├─ new_order/              # 新建订单
│  │  │  │  ├─ my_orders/              # 我的订单
│  │  │  │  ├─ student_popular_dishes/ # 热销菜品
│  │  │  │  └─ student_info/           # 学生信息
│  │  │  │
│  │  │  └─ merchant_pages/
│  │  │     ├─ MerchantPage.java  # 商家管理系统
│  │  │     ├─ dishes_manager/    # 菜品管理
│  │  │     ├─ orders_manager/    # 订单处理
│  │  │     ├─ sales_analyzer/    # 销售分析
│  │  │     └─ merchant_info/     # 商家信息
│  │  │
│  │  ├─ services/
│  │  │  ├─ LoginService.java # 登录注册
│  │  │  ├─ UserService.java  # 用户相关
│  │  │  ├─ DishService.java  # 菜品相关
│  │  │  └─ OrderService.java # 订单相关
│  │  │
│  │  └─ utils/
│  │     ├─ Input             # 方便读一个整数或字符串
│  │     ├─ ForCSV
│  │     │  ├─ CSVReader.java
│  │     │  ├─ CSVUpdater.java
│  │     │  └─ CSVWriter.java
│  │     └─ ForPython/ExecPython.java
│  │  
│  └─ python/
│     ├─ requirement.txt
│     ├─ data_analyzer/
│     └─ message_notification/
│  
├─ resources/
│  ├─ sys/  # 系统内部数据
│  │  ├─ users.csv
│  │  ├─ dishes.csv
│  │  └─ orders.csv
│  │ 
│  └─ python/ # 数据分析输出数据
│     ├─ csv/
│     └─ img/
└─ README # 自述文件

```

