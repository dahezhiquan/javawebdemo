package jdbc;

import jdbc.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Apache - DBUtils演示
 */
public class ApDBUtils {
    public static void main(String[] args) {
        Connection connection = null;
        String sql = "select id,username,password,school from user where id >= ?";
        try {
            connection = DruidJdbcUtils.getConnection();
            // 创建一个QueryRunner
            QueryRunner queryRunner = new QueryRunner();
            // 执行查询语句
            // connection：连接
            // sql：sql语句
            // new BeanHandler<>(User.class)：将ResultSet --> User对象 --> 封装到ArrayList中
            // 底层使用反射机制去获取User类的属性，然后封装
            // 100：填充sql的参数，为可变参数
            // 结果集得到的list query函数底层会自动关闭
            List<User> list = queryRunner.query(connection, sql, new BeanListHandler<>(User.class), 100);
            for (User user : list) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            DruidJdbcUtils.close(null, null, connection);
        }
    }

    /**
     * 查询单条记录
     */
    @Test
    public void testQuerySingle() {
        Connection connection = null;
        String sql = "select id,username,password,school from user where id = ?";
        try {
            connection = DruidJdbcUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            User user = queryRunner.query(connection, sql, new BeanHandler<>(User.class), 50);
            System.out.println(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            DruidJdbcUtils.close(null, null, connection);
        }
    }

    /**
     * 查询单行单列
     */
    @Test
    public void testQueryScalar() {
        Connection connection = null;
        String sql = "select username from user where id = ?";
        try {
            connection = DruidJdbcUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            Object query = queryRunner.query(connection, sql, new ScalarHandler<>(), 100);
            System.out.println(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            DruidJdbcUtils.close(null, null, connection);
        }
    }

    /**
     * 演示DML语句
     */
    @Test
    public void testDML() {
        Connection connection = null;
        String sql = "delete from user where id = ?";
        try {
            connection = DruidJdbcUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            // 返回值为受影响的行数
            int affectedRow = queryRunner.update(connection, sql, 50);
            System.out.println(affectedRow);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            DruidJdbcUtils.close(null, null, connection);
        }
    }
}
