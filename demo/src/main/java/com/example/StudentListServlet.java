// StudentListServlet.java
package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Servlet logic
        PrintWriter out = response.getWriter();

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Prepare SQL query
            String sql = "SELECT name, roll, gpa FROM student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Generate HTML response
                    out.println("<html><body>");
                    out.println("<h2>Student List</h2>");
                    out.println("<table border=\"1\">");
                    out.println("<tr><th>Name</th><th>Roll No</th><th>CGPA</th></tr>");

                    // Iterate through the result set and print table rows
                    while (resultSet.next()) {
                        out.println("<tr>");
                        out.println("<td>" + resultSet.getString("name") + "</td>");
                        out.println("<td>" + resultSet.getString("roll") + "</td>");
                        out.println("<td>" + resultSet.getDouble("gpa") + "</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");
                    out.println("</body></html>");

                    // Additional debug prints
                    System.out.println("Servlet executed successfully.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions as needed
        }
    }
}