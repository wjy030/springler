# spring aop xml配置方式
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
> expression: 表达式，表示所有
