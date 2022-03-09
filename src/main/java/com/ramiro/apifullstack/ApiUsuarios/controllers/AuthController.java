package com.ramiro.apifullstack.ApiUsuarios.controllers;

import com.ramiro.apifullstack.ApiUsuarios.entities.Usuario;
import com.ramiro.apifullstack.ApiUsuarios.services.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    UsuarioDAO usuarioDAO;

    @PostMapping("login")
    public String login(@RequestBody Usuario usuario){
        if (usuarioDAO.verificarEmailPassword(usuario)){
            return "Ok";
        }
        return "Fail";
    }

    /**@GetMapping("login/usuarios/{correo}/{password}")
    public String obtenerUsuario(@PathVariable String correo,@PathVariable String password){
       Optional<Usuario> usuarioEn = usuarioDAO.buscarPorCorreoYContra(correo, password);

       if (usuarioEn.isEmpty()){
           return "fail";
       }else {
           return "ok";
       }
    }**/




}
