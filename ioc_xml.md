# XML 方式
## ApplicationContext实现类：
* ClassPathXmlApplicationContext 读取类路径中的配置文件初始化容器
> ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
* FileSystemXmlApplicationContext 读取绝对/相对路径中的配置文件初始化容器
> ApplicationContext context = new FileSystemXmlApplicationContext("E:\\applicationContext.xml"); 绝对路径
> ApplicationContext context = new FileSystemXmlApplicationContext("./resource/applicationContext.xml"); 相对路径（相对项目的路径）
