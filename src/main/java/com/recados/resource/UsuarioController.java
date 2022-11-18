package com.recados.resource;

import com.recados.entities.Dto.UsuarioDto;
import com.recados.entities.Usuario;
import com.recados.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="API REST Usuário")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @ApiOperation(value="Retorna uma lista de usuários")
    @GetMapping
    public ResponseEntity<List<Usuario>> read(){
        List<Usuario> listUser = service.buscarTodos();
        return ResponseEntity.ok().body(listUser);
    }


    @ApiOperation(value="Retorna um usuários específico pelo nome definido")
    @GetMapping("/{nome}")
    public ResponseEntity<UsuarioDto> findUser(@PathVariable("nome") String user){
        UsuarioDto role = service.buscarPorUser( user);
        return ResponseEntity.ok(role);
    }

    @ApiOperation(value="Atualiza um usuário")
    @PutMapping("/{nome}")
    public String update(@PathVariable("nome") String user1, @RequestBody Usuario user2){
        service.atualizar(user1, user2);
        return "Atualizado com sucesso";
    }

    @ApiOperation(value="Cadastra um usuários específico")
    @PostMapping
    public String insert(@RequestBody UsuarioDto user){
        return service.salvar(user);
    }

    @ApiOperation(value="Deleta um usuários específico pelo nome definido")
  @DeleteMapping("/{nome}")
  public String deleteById(@PathVariable("nome") @RequestBody String usr){
    service.deletar(usr);
    return "Apagado com sucesso";
  }
}
