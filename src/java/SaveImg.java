
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class SaveImg extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String pname="";
        byte imgdata[]=null;
        DiskFileItemFactory factory= new DiskFileItemFactory();
        ServletFileUpload upload= new  ServletFileUpload(factory);
       try
        {
            List<FileItem> items= upload.parseRequest(new ServletRequestContext(request));
                            for(FileItem item:items){
                                String name= item.getFieldName();
                                if(name.equals("pname"))
                                {
                                    pname=item.getString();
                                }
                                if(name.equals("img")){
                                    imgdata=item.get();
                                }
                            }
                           
          String pid=request.getParameter("pid"); 
          
         
          Connection con=mypkg.Data.connect();
          PreparedStatement ps1=con.prepareStatement("select pid from image");
          ResultSet rs=ps1.executeQuery();
          rs.next();
          PreparedStatement ps2=con.prepareStatement("insert into image values(?,?,?)");
          ps2.setInt(1, Integer.parseInt(pid));
          ps2.setString(2,pname);
          ps2.setBytes(3, imgdata);
          ps2.executeUpdate();
           out.println("<html>");
                out.println("<body>");
                out.println("<hr>");
                out.println("<h3>Image Uplaod Successfully </h3>");
                out.println("<hr>");
                out.println("<h5><a href=index.jsp>ADD-MORE</a></h5>");
                out.println("</body>");
                out.println("</html>");
            
        }catch(Exception e)
        {
            out.println(e);
        }
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
