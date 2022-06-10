package com.example.commands;

import com.example.db.DBManager;
import com.example.db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String login = req.getParameter("login");
        System.out.println("login ==> " + login);

        String password = req.getParameter("password");

        User user = DBManager.getInstance().findUser(login);
        System.out.println("user ==> " + user);

        if (user != null && user.getPassword().equals(password)) {
            req.getSession().setAttribute("currentUser", user);
            return "admin.jsp";
        }

        req.getSession().setAttribute("errorMessage", "Illegal login or password!");
        return "login.jsp";
    }
}
