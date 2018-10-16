# spring 注解方式
## 容器启动方式
* ClassPathXmlApplicationContext  

``ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");``  
applicationContext.xml中配制：  
``<context:component-scan base-package="com.wjy"/>``
* AnnotationConfigApplicationContext  
``ApplicationContext context = new AnnotationConfigApplicationContext("com.wjy");``  
## 常用注解
### 对象创建
* Component/Controller/Service/Repository: 在容器中创建对应的java对象，Controller/Service/Repository在分层架构中使用  
* Scope：对象的作用域，对应xml方式中的scope属性  
* Postconstruct: 初始化方法，对应xml方式中的init-method
* Predestory: 销毁方法，对应xml方式中的destory-method
### 依赖注入
#### Value注解
##### Value:注入普通java类型
    @Value("1111")
    private Long id; 
##### Value:注入propertie中内容
    @Value("${driverClass}")
    private  String driverClass;
需要配合PropertySource注解或property-placeholder标签
##### Value:注入bean的字段
    @Value("#{customerDaoImpl.driverClass}")
    private String driverType;
* #{}中能执行spEL
* 需要字段有get方法
#### Autowired注解
    @Autowired
    private CustomerDao cd1;
* 优先按类型（CustomerDao）查找匹配的javabean
* 当按类型未找到唯一匹配对象时，按名称（cd1）查找名称相同的javabean
#### Qualifier注解
    @Autowired
    @Qualifier("cd1")
    private CustomerDao customerDao;
* 与@Autowired配合使用，直接按名称（cd1）查找名称相同的javabean
#### Resource注解
    @Resource(name="cd1")
    private CustomerDao customerDaoImpl;
* 优先按名称（cd1）查找名称相同的javabean
* 当按名称未找到唯一匹配对象时，按类型（CustomerDao）查找类型相同的javabean
* 如果不设置name="cd1"，默认以变量名（customerDaoImpl）查找名称与之相同的javabean
