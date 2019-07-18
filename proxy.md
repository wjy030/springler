# 动态代理
* 动态代理的两种方式
## JDK动态代理
    public class JDKProxyUtil {
    public static Object getProxy(final Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("======");
                return method.invoke(target,args);
                }
            });
     }
    }
### 创建动态代理对象 Proxy.newProxyInstance
* 参数1：classloader,类加载器target.getClass().getClassLoader() 使用被代理对象同样的即可
* 参数2：interfaces,被代理对象实现的接口target.getClass().getInterfaces()
* 参数3：InvocationHandler，用于实现代理的处理器，调用代理类的方法实际都会调用处理器的invoke方法
## Cglib动态代理
    public class CglibProxyUtil {
        public static   Object getProxy(final Object target) {
            return Enhancer.create(target.getClass(), new MethodInterceptor() {
                public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws
                        Throwable {
                    System.out.println("*******************");
                    return methodProxy.invokeSuper(proxy,objects);
                }
            });
        }
    }
### 创建动态代理对象 Enhancer.create
* 参数1：class,由CGLib动态生成的代理类实例
* 参数2：用于实现代理的处理器，调用代理类的方法实际都会调用处理器的invoke方法
### intercept方法
* 参数1：代理对象
* 参数2：被代理对象的方法
* 参数3：被代理对象的方法的参数
* 参数4：代理类对方法的代理引用
