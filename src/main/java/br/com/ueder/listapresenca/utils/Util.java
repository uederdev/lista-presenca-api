package br.com.ueder.listapresenca.utils;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Util {

    public static URI createUri(Long id, String path) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(path + "/{id}").buildAndExpand(id).toUri();
    }

}
