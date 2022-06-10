package com.example.db.entity;

public class User implements java.io.Serializable {

    private int id;

    private String email;

    private String password;

    private String fullName;

    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + email + ", password=" + password + ", fullName=" + fullName + "]";
    }

}
