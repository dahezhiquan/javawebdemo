package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 服务端内部转发案例
 */
public class ServerSideForwarding extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务端内部转发...");
        req.getRequestDispatcher("ssfp").forward(req,resp);
        // 客户端重定向
        // resp.sendRedirect("ssfp");
    }
}
