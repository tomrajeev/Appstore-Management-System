package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String headValue = request.getParameter("head");
        String creatorValue = request.getParameter("creator");
        String descValue = request.getParameter("desc");
        String UP_APPS_QUERY = "UPDATE apps SET developer=?, appdesc=? WHERE appname=?";
        //PrintWriter writer = response.getWriter();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
        PreparedStatement preparedStatement = connection.prepareStatement(UP_APPS_QUERY)) {

            // Set the values for the placeholders
            preparedStatement.setString(1, creatorValue);
            preparedStatement.setString(2, descValue);
            preparedStatement.setString(3, headValue);

            // Execute the query and get the number of rows affected
            preparedStatement.executeUpdate(); 
        } 
         catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
