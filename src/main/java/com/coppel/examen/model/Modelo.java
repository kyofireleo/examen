package com.coppel.examen.model;

import com.google.gson.Gson;

public class Modelo {
    
    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
