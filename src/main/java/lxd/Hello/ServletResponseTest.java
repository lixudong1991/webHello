package lxd.Hello;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

public class ServletResponseTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        imagetest(request,response);
    }
    private void test(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //等价于 response.setHeader("Content-type","text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getOutputStream().write("中国".getBytes("UTF-8"));
    }
    private void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        OutputStream out=response.getOutputStream();
        out.write(" <meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>".getBytes());
        out.write("中国".getBytes("UTF-8"));
    }
    private void downloadTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename=getServletContext().getRealPath("/download/景色.jpg");
        response.setContentType("image/jpeg");
        File file=new File(filename);
        FileInputStream in=new FileInputStream(file);
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition","attachment;filename="+new String(file.getName().getBytes("GBK"),"ISO8859_1"));
        OutputStream out=response.getOutputStream();
        byte[] buff=new byte[4096];
        int len=0;
        while((len=in.read(buff))>0)
        {
            out.write(buff,0,len);
        }
        in.close();
        out.close();
    }
    private void imagetest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedImage ima=Ranima.getima();
        OutputStream out=response.getOutputStream();
        response.setContentType("image/jpeg");
        response.setDateHeader("Expires",-1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        ImageIO.write(ima,"jpg", out);
        request.getSession().setAttribute("checknum",Ranima.getimava());
    }

    private void showimagetest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename=getServletContext().getRealPath("/download/景色.jpg");
        response.setContentType("image/jpeg");
        response.setDateHeader("Expires",System.currentTimeMillis()+24*3600);
        File file=new File(filename);
        FileInputStream in=new FileInputStream(file);
        response.setContentLength((int) file.length());
        OutputStream out=response.getOutputStream();
        byte[] buff=new byte[4096];
        int len=0;
        while((len=in.read(buff))>0)
        {
            out.write(buff,0,len);
        }
        in.close();
        out.close();
    }
    private void responseRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
         /*
            相当于
            response.setStatus(HttpServletResponse.SC_SEE_OTHER);
            response.setHeader("location","/hello/redirectTest.html");
         */
        response.sendRedirect("/hello/redirectTest.html");
    }


}
