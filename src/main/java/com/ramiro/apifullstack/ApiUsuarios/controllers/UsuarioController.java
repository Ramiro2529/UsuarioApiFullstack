package com.ramiro.apifullstack.ApiUsuarios.controllers;

import com.ramiro.apifullstack.ApiUsuarios.entities.Usuario;
import com.ramiro.apifullstack.ApiUsuarios.services.UsuarioDAO;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    /**
     * Método que nos regresa un usuario buscado por id.
     * @param id
     * @return nos regresa un Optional de tipo Usuario
     */

    @GetMapping("usuario/{id}")
    public Optional<Usuario> prueba (@PathVariable Long id){

        return usuarioDAO.obtenerUsuarioId(id);
    }

    /**
     * Método que nos regresa una Lista de tipo Usuario
     * @return Iterable de tipo Usuario
     */
    @GetMapping("/listaUsuarios")
    public Iterable<Usuario> usuarios (){

        return usuarioDAO.listaUsuarios();

    }

    /**
     * Método que borra a un usuario por id.
     * @param id
     */
    @DeleteMapping("/borrarPorId/{id}")
    public void eliminarId(@PathVariable Long id){
        usuarioDAO.eliminarId(id);
    }

    /**
     * Método que nos permite crear un usuario
     * @param usuario
     */
    @PostMapping("crearUsuarios")
    public void registrarUsuario(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash= argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDAO.guardar(usuario);

    }



}

