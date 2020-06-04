
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.OutputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String pid=request.getParameter("pid");
        String sql="select webimg from image where pid=?";
        
            Connection con=mypkg.Data.connect();
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, pid);
           ResultSet rs= ps.executeQuery();
          if(rs.next()){
         
           byte[] imgdata = rs.getBytes("webimg");
           System.out.println(imgdata);
           response.setHeader("expires","0");
           response.setContentType("image/jpg");
           
           OutputStream os= response.getOutputStream();
           os.write(imgdata);
           os.close();
           con.close();
           }
        
    
  %>

