package com.example.requiz;

import com.google.gson.annotations.SerializedName;

import java.security.PublicKey;

public class LoginPost {

    @SerializedName("id") private String id;
    @SerializedName("pw") private String pw;




    public String  getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
