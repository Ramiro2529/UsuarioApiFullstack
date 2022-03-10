package com.ramiro.apifullstack.ApiUsuarios.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "usuarios")
@Getter
@Setter
public class Usuario implements Serializable, Comparable<Usuario>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "celular")
    private String celular;
    @Column(name = "password",length = 255)
    private String password;


    public Usuario( Long id, String nombre, String apellido, String correo, String celular, String password) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.password = password;
    }

    public Usuario(){

    }




    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(Usuario o) {
        if (this.id==null){
            return 0;
        }else {
            return this.id.compareTo(o.id);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(correo, usuario.correo) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correo, password);
    }
}
