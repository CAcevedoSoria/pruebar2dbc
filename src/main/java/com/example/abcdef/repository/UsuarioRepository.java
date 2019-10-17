package com.example.abcdef.repository;


import com.example.abcdef.model.Usuario;

import io.reactivex.Maybe;

import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends RxJava2CrudRepository<Usuario, String> {





}
