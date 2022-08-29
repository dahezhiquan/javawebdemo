package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session会话技术演示
 */
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("sessionID是：" + session.getId());
        System.out.println("session是不是新的：" + session.isNew());
        // 默认为1800秒
        System.out.println("session的非激活间隔时间：" + session.getMaxInactiveInterval());
        // 设置session的非激活间隔时间
        session.setMaxInactiveInterval(900);
        // 强制使会话失效
        session.invalidate();
        // 获取session的创建时间
        System.out.println(session.getCreationTime());
        // 获取最近一次session的使用时间
        System.out.println(session.getLastAccessedTime());
    }
}
