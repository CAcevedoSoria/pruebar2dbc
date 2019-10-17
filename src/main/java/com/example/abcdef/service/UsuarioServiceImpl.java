package com.example.abcdef.service;

import com.example.abcdef.model.Usuario;
import com.example.abcdef.repository.UsuarioRepository;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Flowable<Usuario> findall() {
		return usuarioRepository.findAll();
	}


}
