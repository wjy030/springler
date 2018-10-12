# XML 方式
## ApplicationContext实现类：
* ClassPathXmlApplicationContext 读取类路径中的配置文件初始化容器
> ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
* FileSystemXmlApplicationContext 读取绝对/相对路径中的配置文件初始化容器
> ApplicationContext context = new FileSystemXmlApplicationContext("E:\\applicationContext.xml"); 绝对路径
> ApplicationContext context = new FileSystemXmlApplicationContext("./resource/applicationContext.xml"); 相对路径（相对项目的路径）
## xml标签：  
1. <bean id="customerDao" class="com.wjy.dao.impl.CustomerDaoImpl" scope="singleton" init-method="init" destroy-method="destory"></bean> 
### scope：bean的作用域。 常用作用域：
>  singleton: 以单例模式创建对象  
>  prototype: 以原型（多例）模式创建对象  
>  request: web应用中每个request创建一个对象  
>  session：web应用中每个会话创建一个对象  
