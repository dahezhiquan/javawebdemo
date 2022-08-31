package servlets.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * request保存作用域演示
 * 保存
 */
@WebServlet("/requestsave")
public class RequestSave extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("username", "dahedahe");
        // 客户端重定向
        // 这种方式的作用域内容get无法获取，原因是request是一次请求响应的范围，而客户端重定向会启动两次请求
        // resp.sendRedirect("requestget");
        // 服务器端转发
        // 这种方式则可以获取username的内容，原因是服务器端转发只会启动一次请求
        req.getRequestDispatcher("requestget").forward(req, resp);
    }
}
