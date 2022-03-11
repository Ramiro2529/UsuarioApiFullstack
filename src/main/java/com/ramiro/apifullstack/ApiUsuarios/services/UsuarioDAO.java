package com.ramiro.apifullstack.ApiUsuarios.services;

import com.ramiro.apifullstack.ApiUsuarios.entities.Usuario;

import java.util.Optional;

public interface UsuarioDAO {

    Optional<Usuario> obtenerUsuarioId(Long id);
    Iterable<Usuario> listaUsuarios();
    void guardar(Usuario usuario);
    void eliminarId(Long id);
    Iterable<Usuario> guardarTodos(Iterable<Usuario> usuarios);
    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);


    // Optional<Usuario> buscarPorCorreoYContra(String correo, String password);
}
