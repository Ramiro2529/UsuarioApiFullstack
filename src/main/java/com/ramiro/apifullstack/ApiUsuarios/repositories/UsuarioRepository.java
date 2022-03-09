package com.ramiro.apifullstack.ApiUsuarios.repositories;

import com.ramiro.apifullstack.ApiUsuarios.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

     //List<Usuario> findUsuariosByCorreoAndPassword(String correo, String password);
     //Optional<Usuario> findUsuarioByCorreoAndPassword(String correo, String password);
}
