# aop注解方式
## 开启注解配置
### 在xml配置中开启
    <aop:aspectj-autoproxy/>
### 用注解方式开启
    @EnableAspectJAutoProxy
## 常用注解
### Aspect 切面
    @Aspect
    @Component
    public class LogAspect {
> 注解该类是一个切面  
> 该类必须是一个spring bean
### Pointcut 切入点
    @Pointcut("execution(public void com.wjy.service.impl.CustomerServiceImpl.add())")
    public void pointCut(){}
### Before/After/AfterReturning/AfterThrowing/Around  通知
    @Before("pointCut()")
Value 可以直接写表达式，也可以写注解了Pointcut的方法
