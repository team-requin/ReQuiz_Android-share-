package com.example.requiz;

import com.google.gson.annotations.SerializedName;

public class SignUpPost {
    @SerializedName("id") private String id;
    @SerializedName("pw") private String pw;
    @SerializedName("pw_check") private String pw_check;
    @SerializedName("name") private String name;

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getPw_check() {
        return pw_check;
    }

    public String getName() {
        return name;
    }
}
