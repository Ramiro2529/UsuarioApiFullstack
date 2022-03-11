package com.ramiro.apifullstack.ApiUsuarios.controllers;

import com.ramiro.apifullstack.ApiUsuarios.entities.Usuario;
import com.ramiro.apifullstack.ApiUsuarios.services.UsuarioDAO;
import com.ramiro.apifullstack.ApiUsuarios.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("login")
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLog=usuarioDAO.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLog!=null){
            String tokenJWT=jwtUtil.create(String.valueOf(usuarioLog.getId()), usuarioLog.getCorreo());
            return tokenJWT;
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
