package com.recados.service;

import com.recados.entities.Dto.UsuarioDto;
import com.recados.entities.Recados;
import com.recados.entities.Dto.RecadosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class RecadosService {
//List<Roles> bd_roles = new ArrayList<>();

    @Autowired
    private UsuarioService service;

    Random aux= new Random();

    List<Recados> bd_recados = new ArrayList<>();

    public List<Recados> salvar(RecadosDto recadosDto) {
        Recados recad = new Recados();

        if (Objects.nonNull(recadosDto)) {
            long num = aux.nextInt(500);
            recad.setId(num);
            recad.setRecados(recadosDto.getRecados());

            UsuarioDto user = service.buscarPorUser(recadosDto.getUsuarioNome());

            recad.setUsuario(user.getNome());
            bd_recados.add(recad);
        } else {
            bd_recados = new ArrayList<>();
        }
        return bd_recados;
    }

    public List<Recados> buscarTodos() {

        return bd_recados;
    }

    public RecadosDto buscarPorId(Long id) {
        RecadosDto recadoDto = new RecadosDto();
        for (Recados r : bd_recados) {

                if (r.getId().equals(id)) {
                    recadoDto.setId(r.getId());
                    recadoDto.setRecados(r.getRecados());
                    recadoDto.setUsuarioNome(r.getUsuario());

                }
            }
        return recadoDto;
    }

    public RecadosDto buscarPorUser(String usr) {
        RecadosDto recadoDto2 = new RecadosDto();
        for (Recados r : bd_recados) {

            if (r.getUsuario().equals(usr)) {
                recadoDto2.setId(r.getId());
                recadoDto2.setRecados(r.getRecados());
                recadoDto2.setUsuarioNome(r.getUsuario());
            }
        }
        return recadoDto2;
    }

    public void deletar(Long id) {

        List<Recados> recadoToRemove = new ArrayList<>(); //criar uma lista

        for (Recados r : bd_recados) {

                if (r.getId().equals(id)) {
                    recadoToRemove.add(r);//capturo que tem o id tal e coloco na lista
                }
            }
            bd_recados.removeAll(recadoToRemove);
        }

    public void atualizar(Long id, RecadosDto recadoDto) {

        for (Recados r : bd_recados) {
            if (r.getUsuario().equals(recadoDto.getUsuarioNome())) {
                if (r.getId().equals(id)) {
                    r.setRecados(recadoDto.getRecados());
                }
            }
        }

    }

}
