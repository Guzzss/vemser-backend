package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PessoaDadosPessoaisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pessoa-dados-pessoais")
public class PessoaDadosPessoaisControler {

    @Autowired
    private PessoaDadosPessoaisService pessoaDadosPessoaisService;

    @Operation(summary = "listar pessoasComDados", description = "Lista todas as pessoasComDados do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna todas as pessoasComDados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<PessoaDadosPessoaisDTO>> getAll(){
        return new ResponseEntity<>(pessoaDadosPessoaisService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "listar pessoasComDados por cpf", description = "Lista todas as pessoasComDados do banco por cpf")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a pessoasComDados com o cpf digitado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byCPF") // localhost:8080/pessoa/byname?CPF=242425252
    public PessoaDadosPessoaisDTO listByCPF(@RequestParam("CPF") String cpf) throws RegraDeNegocioException {
        return pessoaDadosPessoaisService.findByCPF(cpf);
    }

    @Operation(summary = "criar PessoaComDados", description = "Cria uma nova pessoaComDados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "PessoaComDados criada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<PessoaDadosPessoaisDTO> post(@RequestBody PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
        return new ResponseEntity<>(pessoaDadosPessoaisService.post(pessoaDadosPessoaisDTO), HttpStatus.OK);
    }

    @Operation(summary = "atualizar PessoaComDados", description = "Atualiza uma pessoaComDados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "PessoaComDados atualizada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{cpf}")
    public ResponseEntity<PessoaDadosPessoaisDTO> put(@PathVariable("cpf") String cpf, @RequestBody PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
        return new ResponseEntity<>(pessoaDadosPessoaisService.put(cpf, pessoaDadosPessoaisDTO), HttpStatus.OK);
    }

    @Operation(summary = "deletar PessoaComDados", description = "Deleta uma pessoaComDados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "PessoaComDados deletada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) throws Exception {
        pessoaDadosPessoaisService.delete(cpf);
    }
}

