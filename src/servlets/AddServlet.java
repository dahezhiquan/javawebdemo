package servlets;

import jdbc.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 提交表单数据到数据库
 */
@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码，防止中文乱码
        request.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String school = request.getParameter("school");
        UserDAO userDAO = new UserDAO();
        int affectRow = userDAO.addUser(id, username, password, school);
        if (affectRow != 1) {
            System.out.println("添加失败！");
        } else {
            System.out.println("添加成功！");
        }
    }
}
