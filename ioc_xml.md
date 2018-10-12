# XML 方式
## ApplicationContext实现类：
* ClassPathXmlApplicationContext 读取类路径中的配置文件初始化容器
> ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
* FileSystemXmlApplicationContext 读取绝对/相对路径中的配置文件初始化容器
> ApplicationContext context = new FileSystemXmlApplicationContext("E:\\applicationContext.xml"); 绝对路径
> ApplicationContext context = new FileSystemXmlApplicationContext("./resource/applicationContext.xml"); 相对路径（相对项目的路径）
## 对象创建：  
### bean标签
``<bean id="customerDao" class="com.wjy.dao.impl.CustomerDaoImpl" scope="singleton" init-method="init" destroy-method="destory"></bean>``
* scope：bean的作用域。 常用作用域：
>  singleton: 以单例模式创建对象  
>  prototype: 以原型（多例）模式创建对象  
>  request: web应用中每个request创建一个对象  
>  session：web应用中每个会话创建一个对象  
* init-method：初始化方法，对象初始化时调用
* destroy-method: 销毁方法，对象销毁时调用。*只有作用域为singleton时有作用。销毁对象的办法((AbstractApplicationContext)context).registerShutdownHook()*
### 依赖注入
#### 通过构造方法和setter方法
##### 构造方法 constructor-arg
    <bean id="customerService" class="com.wjy.service.impl.CustomerServiceImpl">
      <constructor-arg index="0" ref="customerDao" />
    </bean>
* index:方法参数索引，从0开始  
* ref:依赖对象（bean）的id
##### setter方法 property
    <bean id="customerService" class="com.wjy.service.impl.CustomerServiceImpl">
      <property name="customerDao" ref="customerDao"/>
    </bean>
* name:方法参数名
