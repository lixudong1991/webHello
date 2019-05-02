package lxd.Hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String token=request.getParameter("token");
           String token1= (String) request.getSession(false).getAttribute("token");
           if(token==null||token1==null||!token.equals(token1))
           {
               System.out.println("请不要重复提交");
               return;
           }
        request.getSession(false).removeAttribute("token");
        System.out.println("注册成功");
    }
}
