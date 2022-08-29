package jdbc.test;

import jdbc.dao.UserDAO;
import jdbc.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * DAO测试类
 */
public class TestDAO {
    /**
     * 测试UserDAO
     */
    @Test
    public void testUserDAO() {
        UserDAO userDAO = new UserDAO();
        // 查询
        List<User> list = userDAO.queryMulti("select * from user where id >= ?", User.class, 100);
        for (User user : list) {
            System.out.println(user);
        }
        User user = userDAO.querySingle("select * from user where id = ?", User.class, 100);
        System.out.println(user);
        Object o = userDAO.queryScalar("select username from user where id = ?", 20);
        System.out.println(o);
        int update = userDAO.update("delete from user where id = ?", 66);
        System.out.println(update);
    }

    /**
     * 测试UserDao的添加单条数据
     */
    @Test
    public void testUserDaoAddUser() {
        // 添加数据到数据库
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(2, "username", "password", "school");
    }

}
