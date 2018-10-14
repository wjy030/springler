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

