package servlets;

import jdbc.dao.UserDAO;
import jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编辑user表中的数据
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uidStr = req.getParameter("uid");
        if (uidStr != null && !"".equals(uidStr)) {
            int uid = Integer.parseInt(uidStr);
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserById(uid);
            // 保存到request作用域
            req.setAttribute("userInfo", user);
            super.processTemplate("edit", req, resp);
        }
    }
}
