package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Profile extends HttpServlet{
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userEmail = DevLoginServlet.u_email;
        String SELECT_APPS_QUERY = "SELECT * FROM dev where dev_mail=" + userEmail;
        PrintWriter writer = response.getWriter();
        String username="";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234");
             Statement stm = connection.createStatement();
             ResultSet resultSet = stm.executeQuery(SELECT_APPS_QUERY)) 
        {
            while(resultSet.next())
            {
                username=resultSet.getString(1);
            }
            writer.println("<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<title>DEV HOME</title>" +
            "<style>" +
            "body {" +
            "    margin: 0;" +
            "    padding: 0;" +
            "    box-sizing: border-box;" +
            "}" +
            ".center {" +
            "    height: 110vh;" +
            "    display: flex;" +
            "    justify-content: center;" +
            "    align-items: center;" +
            "    background: #000;" +
            "    overflow: hidden;" +
            "}" +
            ".wave {" +
            "    width: 5px;" +
            "    height: 100px;" +
            "    background: linear-gradient(45deg, cyan, #fff);" +
            "    margin: 10px;" +
            "    animation: wave 1s linear infinite;" +
            "    border-radius: 20px;" +
            "}" +
            ".wave:nth-child(2) {" +
            "    animation-delay: 0.1s;" +
            "}" +
            ".wave:nth-child(3) {" +
            "    animation-delay: 0.2s;" +
            "}" +
            ".wave:nth-child(4) {" +
            "    animation-delay: 0.3s;" +
            "}" +
            ".wave:nth-child(5) {" +
            "    animation-delay: 0.4s;" +
            "}" +
            ".wave:nth-child(6) {" +
            "    animation-delay: 0.5s;" +
            "}" +
            ".wave:nth-child(7) {" +
            "    animation-delay: 0.6s;" +
            "}" +
            ".wave:nth-child(8) {" +
            "    animation-delay: 0.7s;" +
            "}" +
            ".wave:nth-child(9) {" +
            "    animation-delay: 0.8s;" +
            "}" +
            ".wave:nth-child(10) {" +
            "    animation-delay: 0.9s;" +
            "}" +
            "@keyframes wave {" +
            "    0% {" +
            "        transform: scale(0);" +
            "    }" +
            "    50% {" +
            "        transform: scale(1);" +
            "    }" +
            "    100% {" +
            "        transform: scale(0);" +
            "    }" +
            "}" +
            ".header {" +
            "    height: 26vh;" +
            "    width: 100%;" +
            "    background-image: url(\"banner3.jpg\");" +
            "    background-size: cover;" +
            "    padding-top: 100px;" +
            "    margin-top: -30px;" +
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
            "*" +
            "{" +
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
            "    margin-right: " +
            ".material-symbols-outlined {" +
            "    font-size: 25px;" +
            "    margin-right: 10px;" +
            "    background: #0c0c0c;" +
            "    border-radius: 50%;" +
            "    padding: 5px;" +
            "}" +
            "#add{" +
            "    height: 60px;" +
            "    padding-top: 10px;" +
            "    position: absolute;" +
            "    top: 86%;" +
            "    left: 95%;" +
            "    transform: translate(-50%, -50%);" +
            "    z-index: 9999;" +
            "}" +
            "#add:hover{" +
            "    background-color: #2e2e2e;" +
            "}" +
            "#mainmain {" +
            "    width: 1300px;" +
            "    height: 1000px;" +
            "    padding-left: 0" +
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
            "    /*background-image: url(cat.jpeg);*/" +
            "    display: block;" +
            "}" +
            "#acc {" +
            "    background-image: url(confucat.jpg);" +
            "    display: none;" +
            "}" +
            "#contat {" +
            "    background-image: url(TheWhat.jpeg);" +
            "    display: none;" +
            "}" +
            "#exit {" +
            "    background-image: url(confuse.jfif);" +
            "    display: none;" +
            "}" +
            "#accname{" +
            "    background-color: transparent;" +
            "    border: transparent;" +
            "    color: white;" +
            "    height: 80px;" +
            "    font-size: 60px;" +
            "}" +
            "</style>" +
            "</head>" +
            "<body>" +
            "<div id=\"bigpp\" style=\"font-family: Arial, Helvetica, sans-serif;\">" +
            "<div>" +
            "<div class=\"header\">" +
            "<h1>App Store Management</h1>" +
            "</div>" +
            "</div>" +
            "<div class=\"main\">" +
            "<div class=\"menu\">" +
            "<ul class=\"menu-content\">" +
            "<li><a href=\"#\" onclick=\"show('apps')\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"apps.png\"> </span><span>Apps</span></a></li>" +
            "<li><a href=\"#\" onclick=\"show('acc')\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"acc.png\"> </span><span>Account</span></a></li>" +
            "<li><a href=\"#\" onclick=\"show('contat')\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"contat.png\"> </span><span>Contact</span></a></li>" +
            "<li><a href=\"LOGIN.html\"><span class=\"material-symbols-outlined\"><img class=\"icon\" src=\"exit.png\"> </span><span>Exit</span></a></li>" +
            "</ul>" +
            "</div>" +
            "<div id=\"mainmain\">" +
            "<div class=\"subs\" id=\"acc\" style=\"display: block;\" readonly>" +
            "<h1>HELLO YOU ARE</h1>" +
            "<div style=\"margin-top: 100px; display: flex; justify-content: center;\">" +
            "<img style=\"height: 100px; width: 100px;\" src=\"acc.png\">" +
            "<input id=\"accname\" type=\"text\" value=\"" + username + "\">" +
            "</div>" +
            "</div>" +
            "<div class=\"subs\" id=\"contat\" style=\"display:none\">" +
            "<div class=\"devs\" id=\"Nanda\">" +
            "<h1>NANDAKISHORE T J</h1>" +
            "</div>" +
            "</div>" +
            "<a href=\"add.html\" ><span class=\"material-symbols-outlined\" id=\"add\"><img class=\"icon\" src=\"add.png\"> </span></a>" +
            "</div>" +
            "</div>" +
            "</div>" +
            "</body>" +
            "</html>");
    
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
