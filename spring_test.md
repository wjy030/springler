# spring 整合junit4测试
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = {SpringConfig.class})
    public class SpringTest {
* @RunWith(SpringJUnit4ClassRunner.class) 是junit注解，通过SpringJUnit4ClassRunner开户测试
* @ContextConfiguration(classes = {SpringConfig.class}) /@ContextConfiguration("classpath:applicationContext.xml") 加载配置的两种方式
