package com.example.mynewservlet;

import com.example.mynewservlet.logic.Model;
import com.example.mynewservlet.logic.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/put")
public class ServletUpdate extends HttpServlet {


    Model model = Model.getInstance();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {

            System.out.println("Error");
        }
        JsonObject jobj = gson.fromJson(String.valueOf(jb),JsonObject.class);
        request.setCharacterEncoding("UTF-8");
        String name = jobj.get("name").getAsString();
        String surname = jobj.get("surname").getAsString();
        double salary = jobj.get("salary").getAsDouble();
        int id = jobj.get("id").getAsInt();
        User user = new User(name, surname, salary);

        model.add(user,id);

        response.setContentType("application/json;charset=UTF-8");


        PrintWriter pw = response.getWriter();

        pw.print(gson.toJson(model.getFrontList()));
    }
}
