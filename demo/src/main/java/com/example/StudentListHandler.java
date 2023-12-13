package com.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentListHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Your servlet logic goes here
        String htmlResponse = generateHtmlResponse();

        // Send the response
        exchange.sendResponseHeaders(200, htmlResponse.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(htmlResponse.getBytes());
        }
    }

    private String generateHtmlResponse() {
        // Fetch data from the database and generate HTML
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><body>");
        htmlBuilder.append("<h2>Student List</h2>");
        htmlBuilder.append("<table border=\"1\">");
        htmlBuilder.append("<tr><th>Name</th><th>Roll No</th><th>CGPA</th></tr>");

        // Fetch data from the database
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT name, roll, gpa FROM student";
            System.out.println("Executing SQL query: " + sql);  // Add this line for debugging

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check if the result set has any data
                    if (!resultSet.next()) {
                        System.out.println("No data found in the result set");  // Add this line for debugging
                    } else {
                        // Iterate through the result set and add table rows
                        do {
                            htmlBuilder.append("<tr>");
                            htmlBuilder.append("<td>").append(resultSet.getString("name")).append("</td>");
                            htmlBuilder.append("<td>").append(resultSet.getString("roll")).append("</td>");
                            htmlBuilder.append("<td>").append(resultSet.getDouble("gpa")).append("</td>");
                            htmlBuilder.append("</tr>");
                        } while (resultSet.next());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error fetching data from the database: " + e.getMessage());  // Add this line for debugging
            // Handle exceptions as needed
        }

        htmlBuilder.append("</table>");
        htmlBuilder.append("</body></html>");

        return htmlBuilder.toString();
    }
}
