package servlets;

import jdbc.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据ID删除用户
 */
@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        userDAO.delUser(id);
        resp.sendRedirect("showuser");
    }
}
