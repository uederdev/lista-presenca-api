package br.com.ueder.listapresenca.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Erro {

    private String msg;
    private LocalDateTime dataHora = LocalDateTime.now();

    public Erro(String msg) {
        this.msg = msg;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getMsg() {
        return msg;
    }

}
