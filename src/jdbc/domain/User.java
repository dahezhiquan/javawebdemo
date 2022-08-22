package jdbc.domain;

/**
 * User数据库表的对应类
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String school;

    /**
     * 一定要给一个无参构造器
     */
    public User() {
    }

    public User(Integer id, String username, String password, String school) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.school = school;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
