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
     * 返回User的id用户名和学校列表
     *
     * @return 所有User的id用户名和学校列表
     */
    public List<User> getUserList() {
        return queryMulti("select id,username,school from user", User.class);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户的ID用户名，密码，学校信息
     */
    public User getUserById(int id) {
        return querySingle("select id,username,password,school from user where id = ?", User.class, id);
    }


    /**
     * delete user by id
     *
     * @param id 用户id
     * @return affect Row
     */
    public int delUser(int id) {
        return update("delete from user where id = ?", id);
    }

    /**
     * update user by id
     *
     * @param id       用户id
     * @param username 用户名
     * @param password 密码
     * @param school   学校
     * @return affect Row
     */
    public int updateUser(int id, String username, String password, String school) {
        return update("update user set username = ? , password = ? , school = ? where id = ?", username, password, school, id);
    }

    /**
     * 无ID添加用户
     *
     * @param username 用户名
     * @param password 密码
     * @param school   学校
     * @return 影响行数
     */
    public int addUserNoId(String username, String password, String school) {
        return update("insert into user values (0,?,?,?)", username, password, school);
    }

    /**
     * 查询指定页面的user数据
     *
     * @param page 页码
     * @return 指定页的user列表
     */
    public List<User> getUserListByPage(int page) {
        return queryMulti("select id,username,school from user limit (?-1)*5 , 5", User.class, page);
    }

}
