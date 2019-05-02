package lxd.Hello;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
            out.write("你上次的访问时间是:");
            Cookie[] cookies=request.getCookies();
            if(cookies!=null)
            {
                for(Cookie cookie:cookies)
                {
                    if("lastTime".equals(cookie.getName()))
                    {
                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        long dat=Long.parseLong(cookie.getValue());
                        out.write(dateFormat.format(new Date(dat)));
                        break;
                    }
                }
            }
            Cookie newCookie=new Cookie("lastTime",System.currentTimeMillis()+"");
            newCookie.setPath("/hello");
            newCookie.setMaxAge(30*24*3600);
            response.addCookie(newCookie);
    }
}
