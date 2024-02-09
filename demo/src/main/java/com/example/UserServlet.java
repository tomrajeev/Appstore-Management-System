package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SELECT_APPS_QUERY = "SELECT * FROM apps";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
             Statement stm = connection.createStatement();
             ResultSet resultSet = stm.executeQuery(SELECT_APPS_QUERY)) 
        {

           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
