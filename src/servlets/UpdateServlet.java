package servlets;

import jdbc.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新user表中的数据
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String school = req.getParameter("school");
        int id = Integer.parseInt(req.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        // 更新数据
        int affectRow = userDAO.updateUser(id, username, password, school);
        // 更新完数据之后，跳转到展示user信息的页面
        resp.sendRedirect("/showuser");
    }
}
