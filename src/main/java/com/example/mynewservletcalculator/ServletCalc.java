package com.example.mynewservletcalculator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calc")
public class ServletCalc extends HttpServlet {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
       double a = Double.parseDouble(req.getParameter("a"));
       double b = Double.parseDouble(req.getParameter("b"));
       String action = req.getParameter("action");
        double result = 0;
        switch (action) {
            case "plus":
                result = a + b;
                break;
                case "minus":
                    result = a - b;
                    break;
                    case "multiply":
                        result = a * b;
                        break;
                        case "divide":
                            if(b==0){
                            resp.setStatus(404);
                            }
                        result = a / b;
                            break;
        }



        JsonObject jResp = new JsonObject();
        jResp.addProperty("result", result);
        pw.print(gson.toJson(jResp));





        }
    }


