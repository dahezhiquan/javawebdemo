package servlets;

import jdbc.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 向User表中添加数据
 */
@WebServlet("/add.do")
public class AddUserServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String school = req.getParameter("school");
        UserDAO userDAO = new UserDAO();
        userDAO.addUserNoId(username, password, school);
        resp.sendRedirect("showuser");
    }
}
