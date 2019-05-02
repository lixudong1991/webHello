package lxd.Hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import lxd.entity.IDcard;
import lxd.service.IDcardService;
import lxd.service.PeopleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class CookieShop extends HttpServlet {
    static PeopleService peopleService;
    static IDcardService iDcardService;
    @Override
    public void init() throws ServletException {

        ApplicationContext context= (ApplicationContext) getServletContext().getAttribute("springContex");
        iDcardService  = (IDcardService) context.getBean("iDcardService");
        peopleService = (PeopleService) context.getBean("peopleService");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ajax request");
       Enumeration<String> enumeration= request.getHeaderNames();
       while(enumeration.hasMoreElements())
       {
           String headname=enumeration.nextElement();
           System.out.println(headname+ " : "+request.getHeader(headname));
       }
        System.out.println("-------------------------------");
        Map<String,String[]> requestParameterMap=request.getParameterMap();
        for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet())
        {
            System.out.println(entry.getKey()+" : "+Arrays.asList(entry.getValue()));
        }


        response.setContentType("text/json;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String obj="[{ \"title\": \"身份证信息\",\"data\":#},{ \"title\": \"曾经看过\",\"data\":%}]";
        String s1="";
        try {
            List<IDcard> iDcards=iDcardService.getAllIdcard();
            s1=mapper.writeValueAsString(iDcards);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cookie[] cookies=request.getCookies();
        List<String> cooks=new ArrayList<String>();
        if(cookies!=null)
        {
            for(Cookie cook:cookies)
            {
                if("history".equals(cook.getName()))
                {
                    String[] tem=cook.getValue().split("\\#");
                    for(String ide:tem)
                    {
                        cooks.add(ide);
                    }
                    break;
                }
            }
        }
        String s2="";
        s2=mapper.writeValueAsString(cooks);
        obj=obj.replaceAll("\\#",s1);
        obj=obj.replaceAll("\\%",s2);
        writer.print(obj);
        System.out.println(obj);
       /* writer.print("身份证信息:<br/>");
        try {
            List<IDcard> iDcards=iDcardService.getAllIdcard();
            for(int i=0;i<iDcards.size();++i)
            {
                StringBuilder temp=new StringBuilder("");
                temp.append(iDcards.get(i));
                temp.append("<a href='/hello/CookieShopInfo?id=");
                temp.append(iDcards.get(i).getIdentity());
                temp.append("'>查看信息</a><br/>");
                writer.print(temp.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.print("你曾经看过:<br/>");
        Cookie[] cookies=request.getCookies();
        if(cookies!=null)
        {
            for(Cookie cook:cookies)
            {
                if("history".equals(cook.getName()))
                {
                    String[] tem=cook.getValue().split("\\#");
                    for(String ide:tem)
                    {
                        writer.print(ide+"<br/>");
                    }
                    break;
                }
            }
        }*/
    }

}
