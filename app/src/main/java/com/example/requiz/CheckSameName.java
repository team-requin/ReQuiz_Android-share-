package com.example.requiz;

import com.google.gson.annotations.SerializedName;

public class CheckSameName {
    @SerializedName("name") private String name;

    public String getName() {
        return name;
    }
}