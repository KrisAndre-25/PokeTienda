package com.poketienda.poketienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poketienda.poketienda.model.Usuario;
import com.poketienda.poketienda.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id); // Aseguramos que el ID sea el correcto
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return usuarioService.desactivarUsuario(id);
    }
}