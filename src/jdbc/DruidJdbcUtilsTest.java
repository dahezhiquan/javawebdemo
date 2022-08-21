package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DruidJdbcUtils测试
 */
public class DruidJdbcUtilsTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update user set school = ? where id = ?";
        try {
            connection = DruidJdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "北疆大学");
            preparedStatement.setInt(2, 50);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            DruidJdbcUtils.close(null, preparedStatement, connection);
        }
    }
}
