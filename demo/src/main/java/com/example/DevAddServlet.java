package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DevAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INS_APPS_QUERY = "insert into apps(appname, developer, appdesc) values(?, ?, ?)";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        String appName = request.getParameter("AppName");
        String developer = request.getParameter("Creator");
        String appDescription = request.getParameter("msg");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
        PreparedStatement preparedStatement = connection.prepareStatement(INS_APPS_QUERY)) {

            // Set the values for the placeholders
            preparedStatement.setString(1, appName);
            preparedStatement.setString(2, developer);
            preparedStatement.setString(3, appDescription);

            // Execute the query and get the number of rows affected
            preparedStatement.executeUpdate();
            writer.println("<!DOCTYPE html>");
writer.println("<html>");
writer.println("<head>");
writer.println("    <title>DEV HOME</title>");
writer.println("    <style>");
writer.println("        body {");
writer.println("            margin: 0;");
writer.println("            padding: 0;");
writer.println("            box-sizing: border-box;");
writer.println("        }");
writer.println("        .center {");
writer.println("            height: 110vh;");
writer.println("            display: flex;");
writer.println("            justify-content: center;");
writer.println("            align-items: center;");
writer.println("            background: #000;");
writer.println("            overflow: hidden;");
writer.println("        }");
writer.println("        .wave {");
writer.println("            width: 5px;");
writer.println("            height: 100px;");
writer.println("            background: linear-gradient(45deg, cyan, #fff);");
writer.println("            margin: 10px;");
writer.println("            animation: wave 1s linear infinite;");
writer.println("            border-radius: 20px;");
writer.println("        }");
writer.println("        .wave:nth-child(2) {");
writer.println("            animation-delay: 0.1s;");
writer.println("        }");
writer.println("        .wave:nth-child(3) {");
writer.println("            animation-delay: 0.2s;");
writer.println("        }");
writer.println("        .wave:nth-child(4) {");
writer.println("            animation-delay: 0.3s;");
writer.println("        }");
writer.println("        .wave:nth-child(5) {");
writer.println("            animation-delay: 0.4s;");
writer.println("        }");
writer.println("        .wave:nth-child(6) {");
writer.println("            animation-delay: 0.5s;");
writer.println("        }");
writer.println("        .wave:nth-child(7) {");
writer.println("            animation-delay: 0.6s;");
writer.println("        }");
writer.println("        .wave:nth-child(8) {");
writer.println("            animation-delay: 0.7s;");
writer.println("        }");
writer.println("        .wave:nth-child(9) {");
writer.println("            animation-delay: 0.8s;");
writer.println("        }");
writer.println("        .wave:nth-child(10) {");
writer.println("            animation-delay: 0.9s;");
writer.println("        }");
writer.println("        @keyframes wave {");
writer.println("            0% {");
writer.println("                transform: scale(0);");
writer.println("            }");
writer.println("            50% {");
writer.println("                transform: scale(1);");
writer.println("            }");
writer.println("            100% {");
writer.println("                transform: scale(0);");
writer.println("            }");
writer.println("        }");
writer.println("        .header {");
writer.println("            height: 26vh;");
writer.println("            width: 100%;");
writer.println("            background-image: url(\"banner3.jpg\");");
writer.println("            background-size: cover;");
writer.println("            padding-top: 100px;");
writer.println("            margin-top: -30px;");
writer.println("        }");

writer.println("        h1 {");
writer.println("            margin-left: 90px;");
writer.println("            font-size: 65px;");
writer.println("            background: linear-gradient(rgb(255, 255, 255), rgb(54, 54, 54));");
writer.println("            -webkit-background-clip: text;");
writer.println("            background-clip: text;");
writer.println("            -webkit-text-fill-color: transparent;");
writer.println("        }");

writer.println("        .main {");
writer.println("            height: 100%;");
writer.println("            width: 100%;");
writer.println("            background: linear-gradient(#051f30, #000000);");
writer.println("            display: flex;");
writer.println("            background-repeat: no-repeat;");
writer.println("            background-attachment: fixed;");
writer.println("        }");

writer.println("        * {");
writer.println("            margin: 0;");
writer.println("            padding: 0;");
writer.println("            box-sizing: border-box;");
writer.println("        }");

writer.println("        .menu {");
writer.println("            align-items: flex-start;");
writer.println("            margin-top: -22vh;");
writer.println("            position: sticky;");
writer.println("            top: 0;");
writer.println("            height: 649px;");
writer.println("            transition: .3s;");
writer.println("            background: #ffffff12;");
writer.println("            padding: 170px 20px 20px 0;");
writer.println("            width: 85px;");
writer.println("            box-shadow: 8px 0px 9px 0px #00000014;");
writer.println("            backdrop-filter: blur(5px);");
writer.println("        }");

writer.println("        .menu:hover {");
writer.println("            width: 260px;");
writer.println("        }");

writer.println("        .menu:hover li span:nth-child(2) {");
writer.println("            display: block;");
writer.println("        }");

writer.println("        .menu-content li {");
writer.println("            list-style: none;");
writer.println("            border-radius: 0px 50px 50px 0;");
writer.println("            transition: .3s;");
writer.println("            margin-bottom: 70px;");
writer.println("            padding-left: 20px;");
writer.println("        }");

writer.println("        .menu-content li:hover {");
writer.println("            background: #0c0c0c;");
writer.println("        }");

writer.println("        .menu-content li span:nth-child(2) {");
writer.println("            display: none;");
writer.println("        }");
writer.println("        a {");
writer.println("            text-decoration: none;");
writer.println("            color: rgb(213, 213, 213);");
writer.println("            display: flex;");
writer.println("            align-items: center;");
writer.println("            font-family: 'calibri';");
writer.println("        }");

writer.println("        .material-symbols-outlined {");
writer.println("            font-size: 25px;");
writer.println("            margin-right: 10px;");
writer.println("            background: #0c0c0c;");
writer.println("            border-radius: 50%;");
writer.println("            padding: 5px;");
writer.println("        }");
        
writer.println("        #add {");
writer.println("            height: 60px;");
writer.println("            padding-top: 10px;");
writer.println("            position: absolute;");
writer.println("            top: 86%;");
writer.println("            left: 95%;");
writer.println("            transform: translate(-50%, -50%);");
writer.println("            z-index: 9999;");
writer.println("        }");
writer.println("        #add:hover {");
writer.println("            background-color: #2e2e2e;");
writer.println("        }");
        
writer.println("        #mainmain {");
writer.println("            width: 1300px;");
writer.println("            height: 1000px;");
writer.println("            padding-left: 0;");
writer.println("        }");

writer.println("        .icon {");
writer.println("            width: 40px;");
writer.println("        }");

writer.println("        .subs {");
writer.println("            width: 100%;");
writer.println("            height: 100%;");
writer.println("            padding: 13%;");
writer.println("            padding-top: 20px;");
writer.println("            background-repeat: no-repeat;");
writer.println("            background-size: contain;");
writer.println("        }");

writer.println("        #apps {");
writer.println("          /*background-image: url(cat.jpeg);*/");
writer.println("            display: block;");
writer.println("        }");
        
writer.println("        #acc {");
writer.println("            background-image: url(confucat.jpg);");
writer.println("            display: none;");
writer.println("        }");

writer.println("        #contat {");
writer.println("            background-image: url(TheWhat.jpeg);");
writer.println("            display: none;");
writer.println("        }");

writer.println("        #exit {");
writer.println("            background-image: url(confuse.jfif);");
writer.println("            display: none;");
writer.println("        }");

writer.println("        .appbox {");
writer.println("            display: flex;");
writer.println("            flex-wrap: wrap;");
writer.println("            justify-content: space-around;");
writer.println("        }");

writer.println("        .appCard {");
writer.println("            display: flex;");
writer.println("            flex-direction: column;");
writer.println("            width: 200px;");
writer.println("            height: 200px;");
writer.println("            margin: 20px;");
writer.println("            padding-left: 0px;");
writer.println("            border-radius: 8px;");
writer.println("            box-shadow: 0 8px 16px rgba(0, 0, 0, 0);");
writer.println("            background: transparent;");
writer.println("            backdrop-filter: blur(10px);");
writer.println("            color: #fff;");
writer.println("        }");

writer.println("        .appName {");
writer.println("            font-size: 30px;");
writer.println("            font-weight: bold;");
writer.println("            margin-bottom: 10px;");
writer.println("        }");

writer.println("        .appicon {");
writer.println("            width: 120px;");
writer.println("            height: 120px;");
writer.println("            margin-left: 40px;");
writer.println("            margin-top: 10px;");
writer.println("        }");
writer.println("        .appCard:hover {");
writer.println("            background-color: transparent;");
writer.println("            backdrop-filter: blur(20px);");
writer.println("            box-shadow: 0 8px 16px rgba(0, 0, 0, 1); /* Subtle shadow on hover */");
writer.println("        }");
writer.println("        .appLink {");
writer.println("            text-decoration: none;");
writer.println("            color: #3498db;");
writer.println("            font-weight: bold;");
writer.println("        }");
writer.println("        .tile {");
writer.println("            margin-top: 0;");
writer.println("            margin-left: 10px;");
writer.println("            background-color: transparent;");
writer.println("            border: transparent;");
writer.println("            width: 180px;");
writer.println("            height: 40px;");
writer.println("            text-align: center;");
writer.println("            font-size: 20px;");
writer.println("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
writer.println("            color: white;");
writer.println("        }");
writer.println("    </style>");
writer.println("</head>");
writer.println("<body>");
writer.println("    <div id=\"loading\" class=\"center\">");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("        <div class=\"wave\"></div>");
writer.println("    </div>");
writer.println("    <div id=\"bigpp\" style=\"font-family: Arial, Helvetica, sans-serif;\">");
writer.println("<div>");
writer.println("    <div class=\"header\">");
writer.println("        <h1>App Store Management</h1>");
writer.println("    </div>");
writer.println("</div>");
writer.println("<div class=\"main\">");
writer.println("    <div class=\"menu\">");
writer.println("        <ul class=\"menu-content\">");
writer.println("            <li><a href=\"#\" onclick=\"show('apps')\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"apps.png\"> </span><span>Apps</span></a></li>");
writer.println("            <li><a href=\"#\" onclick=\"show('acc')\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"acc.png\"> </span><span>Account</span></a></li>");
writer.println("            <li><a href=\"#\" onclick=\"show('contat')\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"contat.png\"> </span><span>Contact</span></a></li>");
writer.println("            <li><a href=\"#\" onclick=\"show('exit')\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"exit.png\"> </span><span>Exit</span></a></li>");
writer.println("        </ul>");
writer.println("    </div>");
writer.println("    <div id=\"mainmain\">");
writer.println("        <div class=\"subs\" id=\"apps\">");
writer.println("            <div>");
writer.println("                <form>");
writer.println("                    <div class=\"appbox\" id=\"appContainer\">");
writer.println("                        <a class=\"appCard\" href=\"app1?appName=ChatGPT\" target=\"_blank\">");
writer.println("                            <div class=\"appName\">");
writer.println("                                <img class=\"appicon\" src=\"gpt.png\">");
writer.println("                                <input type=\"text\" class=\"tile\" name=\"app1\" value=\"Chat-GPT\"> ");
writer.println("                            </div>");
writer.println("                        </a>");
writer.println("    <a class=\"appCard\" href=\"app1?appName=Clash of Clans\" target=\"_blank\">");
writer.println("        <div class=\"appName\">");
writer.println("            <img class=\"appicon\" src=\"coc.png\">");
writer.println("            <input type=\"text\" class=\"tile\" name=\"app2\" value=\"Clash of Clans\">");
writer.println("        </div>");
writer.println("    </a>");
writer.println("    <a class=\"appCard\" href=\"app1?appName=Whatsapp\" target=\"_blank\">");
writer.println("        <div class=\"appName\">");
writer.println("            <img class=\"appicon\" src=\"wussup.png\">");
writer.println("            <input type=\"text\" class=\"tile\" name=\"app3\" value=\"Whatsapp\">");
writer.println("        </div>");
writer.println("    </a>");
writer.println("    <a class=\"appCard\" href=\"app1?appName=Youtube\" target=\"_blank\">");
writer.println("        <div class=\"appName\">");
writer.println("            <img class=\"appicon\" style=\"margin-left: 30px; width: 140px;\" src=\"tube.png\">");
writer.println("            <input type=\"text\" class=\"tile\" name=\"app4\" value=\"YouTube\">");
writer.println("        </div>");
writer.println("    </a>");
writer.println("    <a class=\"appCard\" href=\"app1?appName=Random\" target=\"_blank\">");
writer.println("        <div class=\"appName\">");
writer.println("          <img class=\"appicon\" src=\"random.png\">");
writer.println("            <input type=\"text\" class=\"tile\" name=\"app5\" value=\"" + appName + "\">");
writer.println("        </div>");
writer.println("    </a>");
writer.println("    <a class=\"appCard\" href=\"app6.html\" target=\"_blank\">");
writer.println("        <div class=\"appName\">");
writer.println("            <input type=\"text\" class=\"tile\" name=\"app6\">");
writer.println("        </div>");
writer.println("    </a>");
writer.println("                    </div>");
writer.println("                </form>");
writer.println("            </div>");
writer.println("        </div>");
writer.println("        <div class=\"subs\" id=\"acc\"></div>");
writer.println("        <div class=\"subs\" id=\"contat\"></div>");
writer.println("        <div class=\"subs\" id=\"exit\"></div>");
writer.println("        <a href=\"add.html\" ><span class=\"material-symbols-outlined\" id=\"add\"><img class=\"icon\" src=\"add.png\"> </span></a>");
writer.println("    </div>");
writer.println("</div>");

writer.println("    </div>");
writer.println("    <script>");
writer.println("        setTimeout(() => {");
writer.println("            const box = document.getElementById('loading');");
writer.println("            loading.style.display = 'none';");
writer.println("        }, 100);");
writer.println("        function hideAll() {");
writer.println("            const sections = ['apps', 'acc', 'contat', 'exit'];");
writer.println("            sections.forEach(section => {");
writer.println("                document.getElementById(section).style.display = 'none';");
writer.println("            });");
writer.println("        }");
writer.println("        function show(sectionId) {");
writer.println("            hideAll();");
writer.println("            document.getElementById(sectionId).style.display = 'block';");
writer.println("        }");
writer.println("    </script>");
writer.println("</body>");
writer.println("</html>");

           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
