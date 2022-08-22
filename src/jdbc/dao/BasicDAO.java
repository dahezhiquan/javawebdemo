package jdbc.dao;

import jdbc.DruidJdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 开发BasicDAO，是其他DAO的父类
 */
public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    /**
     * 开发通用的DML方法
     *
     * @param sql        待执行的sql语句
     * @param parameters 参数列表
     * @return 受影响的行数
     */
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = DruidJdbcUtils.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidJdbcUtils.close(null, null, connection);
        }
    }

    /**
     * 查询多条结果
     *
     * @param sql        待执行的sql语句
     * @param clazz      一个类的Class对象
     * @param parameters 参数列表
     * @return 查询到的结果集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = DruidJdbcUtils.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidJdbcUtils.close(null, null, connection);
        }
    }

    /**
     * 查询单行结果
     *
     * @param sql        待执行的sql语句
     * @param clazz      一个类的Class对象
     * @param parameters 参数列表
     * @return 查询到的数据库单行结果
     */
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = DruidJdbcUtils.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidJdbcUtils.close(null, null, connection);
        }
    }

    /**
     * 返回单行单列结果
     * @param sql 待执行的sql语句
     * @param parameters 参数列表
     * @return 查询到的单行单列结果
     */
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = DruidJdbcUtils.getConnection();
            return qr.query(connection, sql, new ScalarHandler<>(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidJdbcUtils.close(null, null, connection);
        }
    }
}
