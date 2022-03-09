package com.ramiro.apifullstack.ApiUsuarios;

import com.ramiro.apifullstack.ApiUsuarios.entities.Usuario;
import com.ramiro.apifullstack.ApiUsuarios.services.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;

@Component
public class Main implements CommandLineRunner {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public void run(String... args) throws Exception {

        Set<Usuario> usuarios = new TreeSet<>();
        Usuario usuario2 = new Usuario(2L,"Pamela","Valenzuela","pam@gmail.com","55162684848","pam");
        Usuario usuario3 = new Usuario(3L,"Itzel","Ponce","pam@gmail.com","55162684848","pam");
        Usuario usuario4 = new Usuario(4L,"Perséfone","Pérez","pam@gmail.com","55162684848","pam");
        Usuario usuario5 = new Usuario(5L,"Calíope","Alvarez","pam@gmail.com","55162684848","pam");
        Usuario usuario6 = new Usuario(6L,"Atenea","Saldaña","pam@gmail.com","55162684848","pam");
        Usuario usuario7 = new Usuario(7L,"deimos","Morales","pam@gmail.com","55162684848","pam");


        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        usuarios.add(usuario5);
        usuarios.add(usuario6);
        usuarios.add(usuario7);




    }
}
