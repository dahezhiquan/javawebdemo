package jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 简单的JDBC演示
 */
public class HelloJdbc {
    public static void main(String[] args) throws SQLException {
        // 1.注册驱动
        Driver driver = new Driver();
        // 2.得到与数据库jdbc_test链接
        // 底层就是socket连接
        String url = "jdbc:mysql://localhost:3306/jdbc_test?useSSL=false&serverTimezone=GMT%2B8";
        Properties properties = new Properties();
        properties.setProperty("user","root"); // 用户名
        properties.setProperty("password","root"); // 密码
        // 开始获取链接
        Connection connect = driver.connect(url, properties);
        // 3.执行SQL
        String sql = "insert into user values(2,'dahezhiquan','111','中国大学')";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功":"失败");
        // 4.关闭链接
        statement.close();
        connect.close();
    }
}
