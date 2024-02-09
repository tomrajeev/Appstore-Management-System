package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String str = "select * from test where username=? and password=?";
    boolean flag = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        // Retrieve parameters
        String username = req.getParameter("FName");
        String password = req.getParameter("FPass");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
                    PreparedStatement ps = con.prepareStatement(str)) {
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if ((rs.getString(1)).equals(username) && rs.getString(2).equals(password)) {
                        pw.println("Authentication successful");
                        flag = true;
                        res.sendRedirect("WEB-INF/home.html");
                        return;
                    }
                }
            }

            // Forward the request to login.html if authentication fails
            if (!flag) {
                pw.println("Authentication failure");
                RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
                dispatcher.forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
