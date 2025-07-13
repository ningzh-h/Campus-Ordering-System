# 校园餐厅订餐系统
> 成员：宁中昊、金圣博、徐祖斌



## 项目结构

### 概览


```cmd
src/
├─ main/
│  ├─ java/
│  │  ├─ Main.java  
│  │  ├─ entities/
│  │  ├─ pages/
│  │  ├─ services/
│  │  └─ utils/
│  │  
│  └─ python/
│     ├─ requirement.txt
│     ├─ data_analyzer/
│     └─ message_notification/

resources/
├─ sys/  # 系统内部数据
│  ├─ users.csv
│  ├─ dishes.csv
│  └─ orders.csv
│ 
└─ python/ # 数据分析输出数据
   ├─ csv/
   └─ img/

```



### `Java` 部分

#### 实体类

```cmd
entities/        # 实体类
├─ users/
│  ├─ User.java     # 用户类 (父类)
│  ├─ Merchant.java # 商家类
│  └─ Student.java  # 学生类
├─ Dish.java     # 菜品类
└─ Order.java    # 订单类

```

#### 页面逻辑

```cmd
pages/
├─ login_pages
│  ├─ LoginPage.java # 登录页面
│  ├─ Login.java     # 用户登录
│  └─ Register.java  # 用户注册
│
├─ student_pages/
│  ├─ StudentPages.java
│  ├─ new_order/              # 新建订单
│  ├─ my_orders/              # 我的订单
│  ├─ student_popular_dishes/ # 热销菜品
│  └─ student_info/           # 学生信息
│
└─ merchant_pages/
   ├─ MerchantPage.java  # 商家管理系统
   ├─ dishes_manager/    # 菜品管理
   ├─ orders_manager/    # 订单处理
   ├─ sales_analyzer/    # 销售分析
   └─ merchant_info/     # 商家信息
   
```

#### 后端功能

```cmd
services/
├─ LoginService.java # 登录注册
├─ UserService.java  # 用户相关
├─ DishService.java  # 菜品相关
└─ OrderService.java # 订单相关

```

#### 工具

```cmd
utils/
├─ Input             # 方便读一个整数或字符串
├─ ForCSV
│  ├─ CSVReader.java
│  ├─ CSVUpdater.java
│  └─ CSVWriter.java
└─ ForPython/ExecPython.java

```



### `Python` 部分

```cmd
python/
├─ requirement.txt
├─ data_analyzer/
│  ├─ for_merchants/sales_analyzer.py # 商家销售分析，销售量与销售额可视化
│  └─ for_students/popular_dishes.py  # 热销菜品排行榜
└─ message_notification/
   ├─ low_stock_notify.py             # 低存量预警
   └─ order_status_message.py         # 订单状态提醒
   
```



### `CSV` 数据部分

```cmd
resources/
├─ sys/    # 订餐系统内部数据
│  ├─ users.csv
│  ├─ dishes.csv
│  └─ orders.csv
│ 
└─ python/ # 数据分析输出数据
   ├─ csv/dishes_top_10.csv
   └─ img/sales_analysis_{merchantID}.png

```



