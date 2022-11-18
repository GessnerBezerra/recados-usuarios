package com.recados.service;

import com.recados.entities.Dto.UsuarioDto;
import com.recados.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class UsuarioService {

    Random aux= new Random();

    List<Usuario> bd_usuario = new ArrayList<>();



    public String salvar(UsuarioDto userDto) {
        String strgretrn="";
        String aux1;
        //buscar o role que tem no outro banco de dados salvo
        Usuario user = new Usuario();

                if (Objects.nonNull(userDto)) {
                    long num = aux.nextInt(500);
                    user.setId(num);
                    user.setNome(userDto.getNome());
                    user.setSenha(userDto.getSenha());
                    user.setEmail(userDto.getEmail());
                    bd_usuario.add(user);
                    strgretrn = "Usuário " + userDto.getNome() + " salvo com sucesso";
                }
                return strgretrn;
            }



    public List<Usuario> buscarTodos() {
        return bd_usuario;
    }

    public UsuarioDto buscarPorUser(String user) {
        UsuarioDto userDto = new UsuarioDto();
        for (Usuario u : bd_usuario) {
            if (u.getNome().equals(user)) {
                userDto.setId(u.getId());
                userDto.setEmail(u.getEmail());
                userDto.setNome(u.getNome());
                userDto.setSenha(u.getSenha());
            }
        }
        return userDto;
    }

    public void atualizar(String user1, Usuario user2) {

        for (Usuario u : bd_usuario) {
            if (u.getNome().equals(user1)) {
                u.setNome(user2.getNome());
               u.setEmail(user2.getEmail());
               u.setSenha(user2.getSenha());
            }
        }
    }

    public String deletar(String user) {

        List<Usuario> usuarioRemove = new ArrayList<>(); //criar uma lista

        for (Usuario u : bd_usuario) {
            if (u.getNome().equals(user)) {
                usuarioRemove.add(u);//capturo que tem o id tal e coloco na lista
            }
        }
        //digo ao banco de dados para remover toda a lista
        bd_usuario.removeAll(usuarioRemove);

        return "Usuário "+user+" apagado com sucesso!";
    }
}
