package jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * JDBC批处理
 */
public class BatchProcessing {
    /**
     * 普通方法批量执行sql语句
     * @throws Exception
     */
    @Test
    public void commonMethod() throws Exception {
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into user values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 50; i++) {
            preparedStatement.setInt(1, i + 7);
            preparedStatement.setString(2, "qy" + i);
            preparedStatement.setString(3, "adminadmin" + i);
            preparedStatement.setString(4, "中国大学" + i);
            preparedStatement.executeUpdate();
        }
        JdbcUtils.close(null, preparedStatement, connection);
    }

    /**
     * JDBC批处理演示
     * @throws Exception
     */
    @Test
    public void batchProcessingMethod() throws Exception {
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into user values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 50; i++) {
            preparedStatement.setInt(1, i + 107);
            preparedStatement.setString(2, "qyee" + i);
            preparedStatement.setString(3, "ppp" + i);
            preparedStatement.setString(4, "北京大学" + i);
            // 将sql语句加入到批处理中
            preparedStatement.addBatch();
            // 当存在10条数据时，批量处理执行
            if ((i + 1) % 10 == 0) {
                preparedStatement.executeBatch();
                // 清空数据继续待添加
                preparedStatement.clearBatch();
            }
        }
        JdbcUtils.close(null, preparedStatement, connection);
    }
}
