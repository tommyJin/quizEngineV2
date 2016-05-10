package uk.ac.ncl.csc8499.model;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import org.junit.After;
import org.junit.BeforeClass;

/**
 * Created by tommy on 2016/5/9.
 */
public class Base {
    protected static DruidPlugin dp;
    protected static ActiveRecordPlugin activeRecord;

    private static final String  URL = "jdbc:mysql://localhost/quiz_engine?useUnicode=true&characterEncoding=UTF-8";

    private static final String  USERNAME = "root";

    private static final String  PASSWORD = "root";

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String DATABASE_TYPE = "mysql";

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dp=new DruidPlugin(URL, USERNAME,PASSWORD,DRIVER);

        dp.addFilter(new StatFilter());

        dp.setInitialSize(3);
        dp.setMinIdle(2);
        dp.setMaxActive(5);
        dp.setMaxWait(60000);
        dp.setTimeBetweenEvictionRunsMillis(120000);
        dp.setMinEvictableIdleTimeMillis(120000);

        WallFilter wall = new WallFilter();
        wall.setDbType(DATABASE_TYPE);
        dp.addFilter(wall);

        dp.getDataSource();
        dp.start();

        activeRecord = new ActiveRecordPlugin(dp);
        activeRecord.setDialect(new MysqlDialect());

        activeRecord.addMapping("user", User.class)
//                .addMapping("f_content", FContent.class)
//                .addMapping("f_content_type", FContentType.class)
//                .addMapping("f_column", FColumn.class)
//                .addMapping("f_comment", FComment.class)
        ;
        activeRecord.start();
    }

    @After
    public void tearDown() throws Exception {
//        activeRecord.stop();
//        dp.stop();
    }

}