package com.poketienda.poketienda.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poketienda.poketienda.model.Usuario;
import com.poketienda.poketienda.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(int id, Usuario usuario){
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow();
        usuarioExistente.setUsername(usuario.getUsername()); 
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setPassword(usuario.getPassword());
        return usuarioRepository.save(usuarioExistente);
    }

    public String desactivarUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setActivo(false);
        usuarioRepository.save(usuario);
        return "Usuario desactivado";
    }
}