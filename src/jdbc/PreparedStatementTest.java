package jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * sql预处理方案
 */
public class PreparedStatementTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        // 问号相当于占位符
        String sql = "select id,username,password,school from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 给问号赋值
        preparedStatement.setInt(1,1);
        // 拿到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        // 循环取出数据
        while (resultSet.next()) {
            // 也可以通过列名来获取值，例如：
            // int id = resultSet.getInt("id");（推荐！！！）
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String userPassword = resultSet.getString(3);
            String school = resultSet.getString(4);
            System.out.println(id + "\t" + username + "\t" + userPassword +
                    "\t" + school);
        }

        // 添加数据
        String sqlAdd = "insert into user values(?,?,?,?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sqlAdd);
        preparedStatement1.setInt(1,6);
        preparedStatement1.setString(2,"zhiquan");
        preparedStatement1.setString(3,"admin");
        preparedStatement1.setString(4,"长安大学");
        int rows = preparedStatement1.executeUpdate();
        System.out.println(rows > 0 ? "数据添加成功":"数据添加失败");

        // 修改数据
        String sqlUpdate = "update user set school = ? where id = ?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sqlUpdate);
        preparedStatement2.setString(1,"花海大学");
        preparedStatement2.setInt(2,2);
        int i = preparedStatement2.executeUpdate();
        System.out.println(i > 0 ? "数据更新成功":"数据更新失败");

        // 删除数据
        String sqlDel = "delete from user where id = ?";
        PreparedStatement preparedStatement3 = connection.prepareStatement(sqlDel);
        preparedStatement3.setInt(1,3);
        int i1 = preparedStatement3.executeUpdate();
        System.out.println(i1 > 0 ? "数据删除成功":"数据删除失败");

        // 关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
