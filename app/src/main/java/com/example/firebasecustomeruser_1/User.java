package com.example.firebasecustomeruser_1;

public class User {
    private String email;
    private String image;
    private String phone;
    private String name;
    private int role;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(String name, String email, String phone, String image, int role) {
        this.email = email;
        this.image = image;
        this.phone = phone;
        this.name = name;
        this.role = role;
    }
    public User( String name, String email, String phone, int role) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
