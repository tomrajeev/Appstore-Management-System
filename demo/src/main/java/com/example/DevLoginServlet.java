package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DevLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String str = "select * from dev where dev_mail=? and dev_pass=?";
    boolean flag = false;
    public static String u_email = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
    
        // Retrieve parameters from html doc
        String email = req.getParameter("FName");
        String password = req.getParameter("FPass");



        PrintWriter writer = res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
                    java.sql.PreparedStatement ps = con.prepareStatement(str)) 
            {
                //to set the ?s
                ps.setString(1, email);
                ps.setString(2, password);
    
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if ((rs.getString(2)).equals(email) && rs.getString(3).equals(password)) {
                        u_email = String.valueOf(email);
                        writer.println("<html><body><script>");
                        writer.println("alert('Login successful!');");
                        writer.println("window.location.href = 'dev.html';");
                        writer.println("</script></body></html>");
                        return;
                    }
                }
            }
    
            // If error         
            writer.println("<script>");
            writer.println("alert('Invalid developer account.');");
            writer.println("setTimeout(function() { window.location.href = 'login.html'; }, 500);");
            writer.println("</script>");
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
