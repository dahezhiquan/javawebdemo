package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * C3P0数据库连接池演示
 */
public class C3P0Test {
    /**
     * 相关参数在程序中指定
     */
    @Test
    public void test1() throws IOException, PropertyVetoException, SQLException {
        // 创建数据库对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        // 给数据源comboPooledDataSource设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        // 初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        // 设置最大连接数，其余的将会进入等待队列
        comboPooledDataSource.setMaxPoolSize(50);
        // 获取连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接成功！");
        connection.close();
    }

    /**
     * 使用配置文件模板来完成连接
     */
    @Test
    public void test2() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("imustctf");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接成功！");
        connection.close();
    }
}
