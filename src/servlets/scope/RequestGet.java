package servlets.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * request保存作用域演示
 * 获取
 */
@WebServlet("/requestget")
public class RequestGet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object username = req.getAttribute("username");
        System.out.println("username" + username);
    }
}
