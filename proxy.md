# 动态代理
* 动态代理的两种方式
## JDK动态代理
    public class JDKProxyUtil {
    public static Object getProxy(final Object target) {
        return (target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("======");
                return method.invoke(target,args);
                }
            });
     }
    }
### 创建动态代理对象 Proxy.newProxyInstance
* 参数1：classloader,类加载器target.getClass().getInterfaces() 使用被代理对象同样的即可
* 参数2：interfaces,被代理对象实现的接口target.getClass().getInterfaces()
* 参数3：InvocationHandler，用于实现代理的处理器，调用代理类的方法实际都会调用处理器的invoke方法
