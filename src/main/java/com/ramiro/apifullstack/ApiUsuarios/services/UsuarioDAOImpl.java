package com.ramiro.apifullstack.ApiUsuarios.services;

import com.ramiro.apifullstack.ApiUsuarios.entities.Usuario;
import com.ramiro.apifullstack.ApiUsuarios.repositories.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDAOImpl implements UsuarioDAO{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerUsuarioId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
         usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminarId(Long id) {
                usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Iterable<Usuario> guardarTodos(Iterable<Usuario> usuarios) {
        return usuarioRepository.saveAll(usuarios);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE correo = :correo";


        List<Usuario> listaResultante= entityManager.createQuery(query)
                .setParameter("correo", usuario.getCorreo())
                .getResultList();
            if (listaResultante.isEmpty()){
                    return null;
                        }
        String passwordHashed = listaResultante.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed, usuario.getPassword())) {
            return listaResultante.get(0);
        }else {
            return null;
        }


    }

   /** @Override
    @Transactional
    public Optional<Usuario> buscarPorCorreoYContra(String correo, String password) {
        Optional<Usuario> usuarioEncontrado =usuarioRepository.findUsuarioByCorreoAndPassword(correo, password);


        return usuarioEncontrado;
    }**/


}
