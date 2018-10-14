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
#### 通过p名称空间和spEL表达式
##### p名称空间（基于setter方法）
    <bean id="customerService" class="com.wjy.service.impl.CustomerServiceImpl" p:customerDao-ref="customerDao"
          p:name="eric">
    </bean>
* p:属性：注入普通数据（如String类型）
* p:属性-ref: 注入javabean对象
##### spEL表达式（基于setter方法和构造方法）
    <bean id="customerService" class="com.wjy.service.impl.CustomerServiceImpl">
        <property name="customerDao" value="#{customerDao}"/>
        <property name="name" value="#{'eric'}"/>
        <property name="id" value="#{10000}"/>
    </bean>
表达式以 #{} 包裹，几种常见表达式：  
* value="#{'eric'}" 注入的是字符串
* value="#{10000}" 注入的是数字
* value="#{customerDao}" 注入的是javabean对象
### 数组，List，Map，Properties类型的依赖注入
#### 数组  
    <bean id="customerService" class="com.wjy.service.impl.CustomerServiceImpl">
        <property name="cities">
            <array>
                <value>上海</value>
                <value>北京</value>
                <value>广州</value>
            </array>
        </property>
    </bean>
#### List
    <bean id="customerService" class="com.wjy.service.impl.CustomerServiceImpl">
        <property name="customerServiceList">
            <list>
                <ref bean="c1"/>
                <ref bean="c2"/>
                <ref bean="c3"/>
            </list>
        </property>
    </bean>
##### Map
        <bean id="customerService" class="com.wjy.service.impl.CustomerServiceImpl">
        <property name="customerServiceList">
            <list>
                <ref bean="c1"/>
                <ref bean="c2"/>
                <ref bean="c3"/>
            </list>
        </property>
    </bean></bean>
