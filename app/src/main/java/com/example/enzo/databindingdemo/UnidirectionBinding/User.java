package com.example.enzo.databindingdemo.UnidirectionBinding;

/**
 * <p>
 * Created by ZENG Yuhao(Enzo)<br>
 * Contact: enzo.zyh@gmail.com
 * </p>
 */

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
