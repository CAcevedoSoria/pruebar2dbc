package com.example.abcdef.controller;


import com.example.abcdef.model.Usuario;
import com.example.abcdef.service.UsuarioService;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1.0/usuario")
public class UsuarioController {

private final UsuarioService usuarioService;

public UsuarioController(final UsuarioService usuarioService){
this.usuarioService= usuarioService;
}

    @GetMapping("/")
    public Flowable<Usuario>list(){
        return  usuarioService.findall();

    }




    }


