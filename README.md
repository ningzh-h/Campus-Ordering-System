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
│  │  │  ├─ student_pages
│  │  │  │  ├─ StudentPage.java   # 学生订餐系统
│  │  │  │  ├─ new_order          # 新建订单
│  │  │  │  ├─ my_orders          # 我的订单
│  │  │  │  ├─ student_hot_dishes # 热销菜品排行
│  │  │  │  └─ student_info       # 待定
│  │  │  └─ merchant_pages
│  │  │     ├─ MerchantPage.java  # 商家管理系统
│  │  │     ├─ DishesManager.java # 菜品管理
│  │  │     ├─ OrdersManager.java # 订单处理
│  │  │     ├─ SalesAnalyzer.java # 销售分析
│  │  │     └─ MerchantInfo.java  # 待定
│  │  │
│  │  ├─ services/
│  │  │  ├─ LogInService.java # 登录注册
│  │  │  ├─ StudentService.java  # 菜品信息
│  │  │  ├─ MerchantService.java  # 菜品信息
│  │  │  └─ OrderService.java # 订单相关
│  │  │
│  │  └─ utils/
│  │     ├─ Input             # 方便读一个整数或字符串
│  │     ├─ CSVGenerate.java  # 写 CSV
│  │     └─ CSVReader         # 读 CSV
│  │  
│  └─ python/
│     ├─ requirement.txt
│     ├─ data_analyzer.py
│     └─
│  
├─ resources/
│  ├─ sys/  # 系统内部数据
│  └─ analyze/ # 数据分析输出数据
└─ README # 自述文件

```

