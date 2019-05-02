package lxd.Hello;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfigTest extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到指定的初始化参数
        String initarg=getServletConfig().getInitParameter("data1");
        System.out.println(initarg);

        //得到所有的初始化参数
        Enumeration args=getServletConfig().getInitParameterNames();
        while(args.hasMoreElements())
        {
            String argname= (String) args.nextElement();
            System.out.println(getServletConfig().getInitParameter(argname));
        }
    }


}
