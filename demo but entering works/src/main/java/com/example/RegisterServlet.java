package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
    private static String qry="insert into test(nm, city, mob, dob) values(?,?,?,?)";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String mob = req.getParameter("mob");
        String dob = req.getParameter("dob");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
            java.sql.PreparedStatement ps = con.prepareStatement(qry);
            ps.setString(1, name);
            ps.setString(2, city);
            ps.setString(3, mob);
            ps.setString(4, dob);
            int count=ps.executeUpdate();
            if(count==0)
            {
                pw.println("Error");
            }
            else
            {
                pw.println("Storeed in databse");
            }
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}