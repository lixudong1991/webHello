package lxd.Hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ServletContextTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file=getServletContext().getRealPath("/WEB-INF/classes/db.properties");
        InputStream in=new FileInputStream(file);
        Properties props=new Properties();
        props.load(in);
        String url=props.getProperty("jdbc.url");
        String username=props.getProperty("jdbc.username");
    }
    private void test1() throws IOException {
        InputStream in=getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties props=new Properties();
        props.load(in);
        String url=props.getProperty("jdbc.url");
        String username=props.getProperty("jdbc.username");
        System.out.println(url+"\n"+username);
    }

}
