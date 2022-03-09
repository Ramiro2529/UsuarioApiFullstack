package com.ramiro.apifullstack.ApiUsuarios.controllers;

import com.ramiro.apifullstack.ApiUsuarios.entities.Usuario;
import com.ramiro.apifullstack.ApiUsuarios.services.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;


    @GetMapping("usuario/{id}")
    public Optional<Usuario> prueba (@PathVariable Long id){

        return usuarioDAO.obtenerUsuarioId(id);
    }

    @GetMapping("/listaUsuarios")
    public Iterable<Usuario> usuarios (){

        return usuarioDAO.listaUsuarios();

    }

    @DeleteMapping("/borrarPorId/{id}")
    public void eliminarId(@PathVariable Long id){
        usuarioDAO.eliminarId(id);
    }

    @PostMapping("crearUsuarios")
    public void registrarUsuario(@RequestBody Usuario usuario){
        usuarioDAO.guardar(usuario);

    }



}

