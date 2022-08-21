package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC事务演示
 */
public class JdbcAffairs {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update user set school = '东南大学' where id = 1";
        String sql2 = "update user set school = '河海大学' where id = 2";
        try {
            connection = JdbcUtils.getConnection();
            // 将connection设置为不自动提交事务
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement1.executeUpdate();
            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            // 进行回滚
            try {
                // 默认回滚到事务开始的状态
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
}
