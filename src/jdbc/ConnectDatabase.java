package jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC连接数据库的方式
 */
public class ConnectDatabase {
    /**
     * 使用反射加载driver类
     */
    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/jdbc_test?useSSL=false&serverTimezone=GMT%2B8";
        Properties properties = new Properties();
        properties.setProperty("user","root"); // 用户名
        properties.setProperty("password","root"); // 密码
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    /**
     * 使用DriverManager进行统一管理
     */
    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/jdbc_test?useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "root";
        // 注册Driver驱动
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
    }

    /**
     * 简化DriverManager注册
     * 使用Class.forName自动完成注册驱动，进行简化
     */
    @Test
    public void test3() throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc_test?useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
    }

    /**
     * 使用properties配置文件读取完成连接
     */
    @Test
    public void test4() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
