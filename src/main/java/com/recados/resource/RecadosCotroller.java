package com.recados.resource;

import com.recados.entities.Dto.RecadosDto;
import com.recados.entities.Recados;
import com.recados.entities.Usuario;
import com.recados.service.RecadosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Api(value="API REST recados")
@RestController
@RequestMapping("/recados")
public class RecadosCotroller {

    @Autowired
    private RecadosService service;

    @ApiOperation(value="Retorna uma lista de recados")
    @GetMapping
    public ResponseEntity<List<Recados>> read(){
        List<Recados> listRecados = service.buscarTodos();
        return ResponseEntity.ok(listRecados);
    }

    @ApiOperation(value="Retorna um recado específico pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<RecadosDto> findId(@PathVariable("id") Long id){
        RecadosDto recadosDto = service.buscarPorId(id);
        return ResponseEntity.ok(recadosDto);
    }

//    @GetMapping("/{usuario}")
//    public ResponseEntity<RecadosDto> findUser(@PathVariable("usuario") String user){
//        RecadosDto recadosDto = service.buscarPorUser(user);
//        return ResponseEntity.ok(recadosDto);
//    }

    @ApiOperation(value="Deleta um recado específico pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        service.deletar(id);
        return ResponseEntity.ok().body("Apagado com sucesso");
    }

    @ApiOperation(value="Cadastra um recado")
    @PostMapping
    public String insert(@RequestBody RecadosDto recadosDto){
        service.salvar(recadosDto);
        return "REcado salvo com sucesso";
    }

    @ApiOperation(value="Atualiza um recado específico pelo id")
    @PutMapping("/{id}")
    public String update(@PathVariable("id") @RequestBody Long id, @RequestBody RecadosDto recadosDto){
        service.atualizar(id, recadosDto);
        return "Atualizado com sucesso";
    }

}
