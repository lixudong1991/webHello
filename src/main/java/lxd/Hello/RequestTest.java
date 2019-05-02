package lxd.Hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class RequestTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        testgetParam(request,response);
    }
    private void test(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
    }
    private void testgetParam(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("username");
        System.out.println(name);
        String checknum=request.getParameter("checknum");
        String checknum1= (String) request.getSession().getAttribute("checknum");
        System.out.println(checknum+" : "+checknum1);
        if(checknum==null||checknum1==null||!checknum.equals(checknum1))
        {
            System.out.println("校验码错误");
        }else{
            System.out.println("校验码正确");
        }

        Map<String,String[]> datamap=request.getParameterMap();
        for (Map.Entry<String,String[]> e:datamap.entrySet())
        {
            System.out.println(e.getKey()+" = "+Arrays.toString(e.getValue()));
        }


    }
}
