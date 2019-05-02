package lxd.Hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import lxd.entity.IDcard;
import lxd.entity.People;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookieShopInfo extends HttpServlet {
    static PeopleService peopleService;
    static IDcardService iDcardService;
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public void init() throws ServletException {

        ApplicationContext context=(ApplicationContext) getServletContext().getAttribute("springContex");;
        iDcardService  = (IDcardService) context.getBean("iDcardService");
        peopleService = (PeopleService) context.getBean("peopleService");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        String id=request.getParameter("id");
        People people=null;
        try {
            people=peopleService.getPeopleByIDcard(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(people==null)
        {
            return;
        }
        writer.print(mapper.writeValueAsString(people));
        StringBuilder str=new StringBuilder("");
        Cookie[] cookies=request.getCookies();
        if(cookies!=null)
        {
            for(Cookie cook:cookies)
            {
                if("history".equals(cook.getName()))
                {
                     String tempstr=cook.getValue();
                     List<String> tem=new ArrayList<String>(Arrays.asList(tempstr.split("\\#")));
                     if(tem.contains(people.getIdentity()))
                     {
                        tem.remove(people.getIdentity());
                     }
                     if(tem.size()==1)
                     {
                         str.append(tem.get(0));
                         str.append("#");
                     }else if(tem.size()>=2){
                         str.append(tem.get(tem.size() - 2));
                         str.append("#");
                         str.append(tem.get(tem.size() - 1));
                         str.append("#");
                     }
                    break;
                }
            }
        }
        str.append(people.getIdentity());
        System.out.println(str.toString());
        Cookie cookie=new Cookie("history",str.toString());
        cookie.setMaxAge(24*3600);
        cookie.setPath("/hello");
        response.addCookie(cookie);
    }
}
