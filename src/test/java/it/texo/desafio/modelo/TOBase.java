package it.texo.desafio.modelo;

import com.google.gson.GsonBuilder;

public class TOBase {

    public String toJson() {
        return new GsonBuilder()
                .create()
                .toJson(this);
    }

}
