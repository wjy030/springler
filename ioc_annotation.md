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
##### Value不支持jsr303数据校验
```
@Component
@Validate
public class Bean {
@NotEmpty
private String name;
```
@NotEmpty 注解不会生效
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
## spring新注解
* Configurable: 声明该类为配置类，用以替代applicationContext.xml实现零配置
* ComponentScan(basePackages = "com.wjy"): 声明查找包路径,相当于xml中的``<context:component-scan base-package="com.wjy"/>``
* @PropertySource("classpath:jdbc.properties")：加载properties文件，相当于xml中的``<context:property-placeholder location="jdbc.properties"/>``
* @Import({JDBCProperties.class})：通过导入的方式实现把实例加入springIOC容器中
* Import的三种使用方式：@Import注解只能注解在类上，以及唯一的参数value上可以配置3种类型的值：普通java对象，ImportSelector，ImportBeanDefinitionRegistrar
### Bean注解
    @Bean
    public CustomerDao getDao() {
        return new CustomerDaoImpl();
    }  
* 注解在方法上 spring容器会执行该方法并将返回的javabean放入容器，bean的name默认为customerDao, 也可以指定``@Bean(name="cd1")``
