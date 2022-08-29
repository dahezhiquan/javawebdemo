package servlets;

import jdbc.dao.UserDAO;
import jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 使用Thymeleaf渲染页面展示user列表
 */
@WebServlet("/showuser")
public class ShowUserServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.getUserList();
        // 将userList放到session 作用域
        HttpSession session = req.getSession();
        session.setAttribute("userList", userList);
        System.out.println(userList);
        // 注意：物理视图名称 = view-prefix + view-suffix
        // 这里结合xml文件拼接也就是/showuser.html
        super.processTemplate("showuser", req, resp);
    }
}
