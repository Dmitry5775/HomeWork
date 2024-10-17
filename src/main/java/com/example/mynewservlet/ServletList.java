package com.example.mynewservlet;

import com.example.mynewservlet.logic.Model;
import com.example.mynewservlet.logic.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet(urlPatterns = "/get")

public class ServletList extends HttpServlet {

    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter pw = response.getWriter();

         int id = Integer.parseInt(request.getParameter("id"));

         if(id==0) {
             pw.println("<html>" + "<h3>Доступные пользователи:</h3><br/>" +
                     "ID пользователя: " +
                     "<ul>");

             for (Map.Entry<Integer, User> entry : model.getFrontList().entrySet()) {
                 pw.print("<li>" + entry.getKey() + "</li>" +
                         "<ul>" +
                         "<li>Имя: " + entry.getValue().getName() + "</li>" +
                         "<li>Фамилия: " + entry.getValue().getSurname() + "</li>" +
                         "<li>Зарлата: " + entry.getValue().getSalary() + "</li>" +
                         "</ul>");
             }
             pw.println("</ul>" +
                     "<a href=\"index.jsp\">Домой</a>" + "</html>");
         }
         else if (id > 0) {
            if (id > model.getFrontList().size()) {
                pw.print("<html>" +
                        "<h3>Такого пользователя нет :(</h3>" +
                        "<a href=\"index.jsp\">Домой</a>" + "</html>" );
            }
            else  {
                pw.print(
                        "<html>" +
                                "<h3>Запрошенный пользователь</h3>" +
                                "<br/>" +
                                "Имя: " + model.getFrontList().get(id).getName() + "<br/>" +
                                "Фамилия: " + model.getFrontList().get(id).getSurname() + "<br/>" +
                                "Зарплата: " + model.getFrontList().get(id).getSalary() + "<br/>" +
                                "<a href=\"index.jsp\">Домой</a>" + "</html>"
                );
            }

             }else {
                 pw.print("<html>" +
                         "<h3>ID должен быть больше нуля!</h3>" +
                         "<a href=\"index.jsp\">Домой</a>" + "</html>");
         }
     }*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        if (id == 0) {
            pw.print(gson.toJson(model.getFrontList()));
        } else if (id > 0) {
            if (id > model.getFrontList().size()) {
                pw.print(gson.toJson("Нет такого пользователя"));
            } else {
                pw.print(gson.toJson(model.getFrontList().get(id)));

            }
        } else {
            pw.print(gson.toJson("ID должен быть больше нуля!"));
        }


    }
}

