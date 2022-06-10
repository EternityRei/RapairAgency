package com.example.db;

import com.example.db.entity.User;

import java.sql.*;

public class DBManager {


    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////

    private static final String CONNECTION_URL =
            "jdbc:mysql://localhost:3306/R_a";

    private static final String SQL_FIND_USER_BY_LOGIN =
            "select * from R_a.users where email=?";

    public User findUser(String login) {
        try (Connection con = getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL);
    }


}
