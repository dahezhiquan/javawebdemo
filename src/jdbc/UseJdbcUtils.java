package jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用JdbcUtils工具类
 */
public class UseJdbcUtils {
    /**
     * 测试更新语句
     */
    @Test
    public void testDML() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update user set school = ? where id = ?";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "大和大学");
            preparedStatement.setInt(2, 4);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }

    /**
     * 测试查询语句
     */
    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String school = resultSet.getString("school");
                System.out.println(id + username + password + school);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            JdbcUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
