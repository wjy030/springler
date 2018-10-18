### spring aop xml配置方式
## 配置切面
    <bean id="c1" class="com.wjy.service.impl.CustomerServiceImpl"></bean>
    <bean id="a1" class="com.wjy.config.LogAspect"></bean>
    <aop:config>
        <aop:aspect id="asp" ref="a1">
            <aop:pointcut id="logpt" expression="execution(public void com.wjy.service.impl.CustomerServiceImpl.*())"/>
            <aop:before method="log" pointcut-ref="logpt"/>
        </aop:aspect>
    </aop:config>
* config：aop配置都在此标签内。
* aspect: 切面，由切入点，通知组成。
> ref：切面关联的javabean
* pointcut: 切入点。
> expression: 切面表达式，表示所有要被通知的方法
* before: 前置通知，其他通知：after/around/after-returning等等。
> method: 实现通知（增强）的方法。  
> pointcut-ref: 要把通知织入的切入点
## 切面表达式
``execution(public void com.wjy.service.impl.CustomerServiceImpl.save(java.lang.Integer))''
1. execution--代表切入方式，固定语法
2. public--方法修饰符，通常为public
3. void--方法返回值，如有返回值要写类全名，如java.lang.String。可使用通配符 *
4. com.wjy.service.impl--包路径，可使用通配符：* 匹配一级目录，*..* 匹配任意级目录
5. CustomerServiceImpl--类名，可使用通配符：*
6. save--方法名，可使用通配符：*
7. java.lang.Integer--参数，可使用通配符 .. 表示任意个任意类型的参数
