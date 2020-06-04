

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    
    <body>
        <form action="SaveImg" method="post" enctype="multipart/form-data">
         <table width="400px" align="center" border="2">
                <tr>
                    <td align="center" colspan="2">Upload Image</td>
                </tr>
                <tr>
                   <td>pid</td>
                   <td><input type="text"  name="pid">
               </tr>
               <tr>
                   <td>pname</td>
                   <td><input type="text"  name="pname">
               </tr>
                  <tr>
                    <td>Image</td>
                    <td><input type="file"  name="img"/></td>
                </tr>
                  <tr>
                  <td></td>
                    <td><input type="submit" value="submit"/></td>
                </tr>
            </table>
        </form>
         <a href="ImageLoader">View Image</a>
    </body>
</html>
