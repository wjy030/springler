# spring 事务管理，声明式事务
## xml配置方式
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="org.postgresql.Driver"/>
        <property name="url" value="jdbc:postgresql://127.0.0.1:5432/postgres"/>
        <property name="username" value="postgres"/>
        <property name="password" value="wjy199889"/>
    </bean>
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="add*" isolation="DEFAULT" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>
    <aop:config>
        <aop:pointcut id="txPointcut" expression="execution(public void com.wjy..*.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut"/>
    </aop:config>
1 配置数据源dataSource
2 配置事务管理器transactionManager 并设置dataSource
3 配置事务增强tx:advice，设置transactionManager和想要启用事务管理的方法  
4 配置aop pointcut切入点
5 配置aop advisor 设置事务增强，切入点
## 事务中可配置的属性
    <tx:method name="add*" isolation="DEFAULT" propagation="REQUIRED"/>
* name: 启用事务管理的方法，可以使用通配符*
* isolation: 数据库隔离级别
* propagation：事务传播方式
* no-rollback-for: 不回滚的Exception
* rollback-for: 回滚的Exception
* timeout: 事务超时时间
## isolation 数据库隔离级别
* READ_UNCOMMITTED 读未提交
* READ_COMMITTED 读已提交
* REPEATABLE_READ 不可重复读
* SERIALIZABLE 串行化
## propagation 事务传播方式
1 PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。
2 PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。
3 PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。
4 PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。
5 PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
6 PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
7 PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
