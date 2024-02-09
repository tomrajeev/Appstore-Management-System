package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class App1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SELECT_APPS_QUERY = "SELECT * FROM apps where appname=?";
    String a_name, a_dev, a_desc;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //get value from html doc
        String appName = request.getParameter("appName");
        PrintWriter writer = response.getWriter();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
                    java.sql.PreparedStatement ps = con.prepareStatement(SELECT_APPS_QUERY)) 
            {
                //to set the ?s
                ps.setString(1, appName);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    a_name = rs.getString(1);
                    a_dev = rs.getString(2);
                    a_desc = rs.getString(3);
                }
        {
        writer.println("<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
        "<title>APP1</title>" +
        "<style>" +
        "body {" +
        "    margin: 0;" +
        "    padding: 0;" +
        "    box-sizing: border-box;" +
        "}" +
        ".header {" +
        "    height: 26vh;" +
        "    width: 100%;" +
        "    background-image: url(\"banner3.jpg\");" +
        "    background-size: cover;" +
        "    padding-top: 90px;" +
        "    margin-top: -30px;" +
        "}" +
        "#head{" +
        "    margin-left: 90px;" +
        "    margin-top: 0px;" +
        "    height: 90px;" +
        "    width: 800px;" +
        "    border: transparent;" +
        "    color: thistle;" +
        "    font-size: 65px;" +
        "}" +
        ".detail{" +
        "    background-color: transparent;" +
        "    border: transparent;" +
        "    color: thistle;" +
        "}" +
        "h1 {" +
        "    margin-left: 90px;" +
        "    font-size: 65px;" +
        "    background: linear-gradient(rgb(255, 255, 255), rgb(54, 54, 54));" +
        "    -webkit-background-clip: text;" +
        "    background-clip: text;" +
        "    -webkit-text-fill-color: transparent;" +
        "}" +
        ".main {" +
        "    height: 100%;" +
        "    width: 100%;" +
        "    background: linear-gradient(#051f30, #000000);" +
        "    display: flex;" +
        "    background-repeat: no-repeat;" +
        "    background-attachment: fixed;" +
        "}" +
        "* {" +
        "    margin: 0;" +
        "    padding: 0;" +
        "    box-sizing: border-box;" +
        "}" +
        ".menu {" +
        "    align-items: flex-start;" +
        "    margin-top: -22vh;" +
        "    position: sticky;" +
        "    top: 0;" +
        "    height: 649px;" +
        "    transition: .3s;" +
        "    background: #ffffff12;" +
        "    padding: 170px 20px 20px 0;" +
        "    width: 85px;" +
        "    box-shadow: 8px 0px 9px 0px #00000014;" +
        "    backdrop-filter: blur(5px);" +
        "}" +
        ".menu:hover {" +
        "    width: 260px;" +
        "}" +
        ".menu:hover li span:nth-child(2) {" +
        "    display: block;" +
        "}" +
        ".menu-content li {" +
        "    list-style: none;" +
        "    border-radius: 0px 50px 50px 0;" +
        "    transition: .3s;" +
        "    margin-bottom: 70px;" +
        "    padding-left: 20px;" +
        "}" +
        ".menu-content li:hover {" +
        "    background: #0c0c0c;" +
        "}" +
        ".menu-content li span:nth-child(2) {" +
        "    display: none;" +
        "}" +
        "a {" +
        "    text-decoration: none;" +
        "    color: rgb(213, 213, 213);" +
        "    display: flex;" +
        "    align-items: center;" +
        "    font-family: 'calibri';" +
        "}" +
        ".material-symbols-outlined {" +
        "    font-size: 25px;" +
        "    margin-right: 10px;" +
        "    background: #0c0c0c;" +
        "    border-radius: 50%;" +
        "    padding: 5px;" +
        "}" +
        "#mainmain {" +
        "    width: 1300px;" +
        "    height: 1000px;" +
        "    padding-top: 40px;" +
        "    padding-left: 100px;" +
        "    font-size: 30px;" +
        "}" +
        "label{" +
        "    color: white;" +
        "}" +
        "#creat{" +
        "    padding-left: 20px;" +
        "    width: 200px;" +
        "    height: 40px;" +
        "    font-size: 30px;" +
        "}" +
        "#desc{" +
        "    margin-left: 5%;" +
        "    height:200px;" +
        "    width: 700px;" +
        "    font-size: 20px;" +
        "}" +
        ".icon {" +
        "    width: 40px" +
        "}" +
        ".subs {" +
        "    width: 100%;" +
        "    height: 100%;" +
        "    padding: 13%;" +
        "    padding-top: 20px;" +
        "    background-repeat: no-repeat;" +
        "    background-size: contain;" +
        "}" +
        "#apps {" +
        "  /*background-image: url(cat.jpeg);*/" +
        "    display: block;" +
        "}" +
        "#exit {" +
        "    background-image: url(confuse.jfif);" +
        "    display: none;" +
        "}" +
        "</style>" +
        "</head>" +
        "<body>" +
        "<div id=\"bigpp\" style=\"font-family: Arial, Helvetica, sans-serif;\">" +
        "<div>" +
        "<div class=\"header\">" +
        "<input class=\"detail\" type=\"text\" id=\"head\" value=\"" + a_name + "\">" +
        "</div>" +
        "</div>" +
        "<div class=\"main\">" +
        "<div class=\"menu\">" +
        "<ul class=\"menu-content\">" +
        "<li><a href=\"USER.html\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"home.png\"> </span><span>HOME</span></a></li>" +
        "<li><a href=\"LOGIN.html\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"exit.png\"> </span><span>Exit</span></a></li>" +
        "</ul>" +
        "</div>" +
        "<form id=\"data\" action=\"update\">" +
        "<div id=\"mainmain\" style=\"display: flex;\">" +
        "<div id=\"display\">" +
        "<label>Creator:</label>" +
        "<input class=\"detail\" type=\"text\" id=\"creat\" value=\"" + a_dev + "\" readonly><br><br><br>" +
        "<label>Description:</label><br>" +
        "<textarea class=\"detail\" id=\"desc\" readonly>" + a_desc + "</textarea>" +
        "</div>" +
        "<div id=delup>" +
        "<input type=\"button\" class=\"but\" id=\"reset\" value=\"Remove Application\" onclick=\"resetForm()\"><br>" +
        "<input type=\"button\" class=\"but\" id=\"update\" value=\"Update Info\" onclick=\"editMode()\">" +
        "</div>" +
        "</div>" +
        "</form>" +
        "</div>" +
        "</div>");
        writer.println("<script>");
        writer.println("    function resetForm() {");
        writer.println("        document.getElementById(\"head\").value=\"\";");
        writer.println("        document.getElementById(\"creat\").value=\"\";");
        writer.println("        document.getElementById(\"desc\").value=\"\";");
        writer.println("    }");
        
        writer.println("    function editMode() {");
        writer.println("        var headInput = document.getElementById(\"head\");");
        writer.println("        headInput.readOnly = !headInput.readOnly;");
        
        writer.println("        var creatorInput = document.getElementById(\"creat\");");
        writer.println("        creatorInput.readOnly = !creatorInput.readOnly;");
        
        writer.println("        var descInput = document.getElementById(\"desc\");");
        writer.println("        descInput.readOnly = !descInput.readOnly;");
        
        writer.println("        var xhr = new XMLHttpRequest();");
        
        writer.println("        // Configuring the request");
        writer.println("        xhr.open(\"POST\", \"update\", true);");
        writer.println("        xhr.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");");
        
        writer.println("        // Sending the data to the servlet");
        writer.println("        xhr.send(\"head=\" + encodeURIComponent(headInput.value) +");
        writer.println("                 \"&creator=\" + encodeURIComponent(creatorInput.value) +");
        writer.println("                 \"&desc=\" + encodeURIComponent(descInput.value));");
        
        writer.println("        // Handling the response from the servlet (if needed)");
        writer.println("        xhr.onreadystatechange = function() {");
        writer.println("            if (xhr.readyState == 4 && xhr.status == 200) {");
        writer.println("                console.log(xhr.responseText);");
        writer.println("            }");
        writer.println("        };");
        
        writer.println("        if (!headInput.readOnly) {");
        writer.println("            headInput.removeAttribute(\"readonly\");");
        writer.println("            creatorInput.removeAttribute(\"readonly\");");
        writer.println("            descInput.removeAttribute(\"readonly\");");
        writer.println("        }");
        writer.println("    }");
        writer.println("</script>");
        writer.println("</body>");
            writer.println("</html>");
        

           
        }
     } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
