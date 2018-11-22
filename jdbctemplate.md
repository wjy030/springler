# jdbctemplate spring的orm框架
    JdbcTemplate template = new JdbcTemplate();
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
    dataSource.setUsername("postgres");
    dataSource.setPassword("wjy199889");
    template.setDataSource(dataSource);
    template.update("update pub_goods set goodsname = '超级' where goodsid = 139809");
* DriverManagerDataSource spring数据源，设置数据库连接参数
* JdbcTemplate 可以执行sql语句
    
