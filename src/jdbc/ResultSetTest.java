package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * ResultSet示例
 */
public class ResultSetTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = "select id,username,password,school from user";
        // 拿到结果集
        ResultSet resultSet = statement.executeQuery(sql);
        // 循环取出数据
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String userPassword = resultSet.getString(3);
            String school = resultSet.getString(4);
            System.out.println(id + "\t" + username + "\t" + userPassword +
                    "\t" + school);
        }
        // 关闭资源
        resultSet.close();
        statement.close();
        connection.close();

    }
}
