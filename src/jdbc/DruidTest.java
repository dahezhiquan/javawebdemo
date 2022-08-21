package jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid连接池演示
 */
public class DruidTest {
    /**
     * Druid连接池演示
     */
    @Test
    public void testDruid() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        // 创建一个指定参数的数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功！");
        connection.close();
    }
}
