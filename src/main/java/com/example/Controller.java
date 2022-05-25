package com.example;

import com.example.commands.Command;
import com.example.commands.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    //http://localhist:8080/Test/controller?command=login
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //(1) obtain a command name
        String commandName = req.getParameter("command");
        System.out.println("commandName ==> " + commandName);

        //(2) obtain a command
        Command command = CommandContainer.getCommand(commandName);
        System.out.println("command ==> " + command);
        //log.trace

        //(3) do action
        String address = "error.jps"; //address to go
        try {
            address = command.execute(req, resp);
        } catch (Exception e) {
            req.getSession().setAttribute("errorMessage", e.getMessage());
        }

        //(4) go to a view layer
        req.getRequestDispatcher(address).forward(req,resp);
        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String address = "error.jsp";
        String commandName = req.getParameter("command");
        Command command = CommandContainer.getCommand(commandName);
        try {
            address = command.execute(req, resp);
        } catch (Exception e) {
            req.getSession().setAttribute("errorMessage", e.getMessage());
        }
        resp.sendRedirect(address);
    }
}
