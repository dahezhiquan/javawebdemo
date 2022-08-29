package jdbc.dao;

import jdbc.domain.User;

import java.util.List;

/**
 * User类的DAO
 * 根据业务需求的User类的特有的方法
 */
public class UserDAO extends BasicDAO<User> {
    /**
     * 向User表中插入一条数据
     *
     * @param id       用户ID
     * @param username 用户名
     * @param password 密码
     * @param school   学校信息
     * @return 影响的条数
     */
    public int addUser(int id, String username, String password, String school) {
        // 添加数据到数据库
        return update("insert into user values(?,?,?,?)", id, username, password, school);
    }

    /**
     * 返回User的用户名和学校列表
     * @return 所有User的用户名和学校列表
     */
    public List<User> getUserList() {
        return queryMulti("select username,school from user", User.class);
    }
}
