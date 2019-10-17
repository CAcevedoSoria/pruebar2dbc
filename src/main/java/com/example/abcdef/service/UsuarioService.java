package com.example.abcdef.service;

import com.example.abcdef.model.Usuario;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;


public interface UsuarioService {

	public Flowable<Usuario> findall();



}
