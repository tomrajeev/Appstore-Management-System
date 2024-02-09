package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    boolean flag = false;
    private static final String str = "select * from dev where dev_mail=?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        // Retrieve parameters from html doc
        String username = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        PrintWriter writer = res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
            try {
                // Checking if the user exists
                String checkUserQuery = "SELECT * FROM users WHERE email=?";
                try (java.sql.PreparedStatement checkUserPs = con.prepareStatement(checkUserQuery)) {
                    checkUserPs.setString(1, email);
                    try (ResultSet checkUserRs = checkUserPs.executeQuery()) {
                        if (checkUserRs.next()) {
                            // User already exists in users table
                            writer.println("<html><body><script>");
                            writer.println("alert('User already exists! Please choose a different email.');");
                            writer.println("window.location.href = 'login.html';");
                            writer.println("</script></body></html>");
                            return;
                        }
                    }
                    java.sql.PreparedStatement ps = con.prepareStatement(str); 
                    {
                        // User already exists in dev table
                        ps.setString(1, email);
            
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            if ((rs.getString(2)).equals(email)) {
                                writer.println("<html><body><script>");
                                writer.println("alert('User already exists! Please choose a different email.');");
                                writer.println("window.location.href = 'login.html';");
                                writer.println("</script></body></html>");
                                return;
                            }
                        }
                    }
                }

                // User does not exist
                String insertUserQuery = "INSERT INTO users (uname, email, password) VALUES (?, ?, ?)";
                try (java.sql.PreparedStatement insertUserPs = con.prepareStatement(insertUserQuery)) {
                    insertUserPs.setString(1, username);
                    insertUserPs.setString(2, email);
                    insertUserPs.setString(3, password);

                    int rowsAffected = insertUserPs.executeUpdate();
                    if (rowsAffected > 0) {
                        // Insertion successful
                        writer.println("<html><body><script>");
                        writer.println("alert('User registration successful. You can now log in!');");
                        writer.println("window.location.href = 'login.html';");
                        writer.println("</script></body></html>");
                    } else {
                        // Insertion falied
                        writer.println("<html><body><script>");
                        writer.println("alert('User registration failed! Please try again.');");
                        writer.println("window.location.href = 'login.html';");
                        writer.println("</script></body></html>");
                    }
                }
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
