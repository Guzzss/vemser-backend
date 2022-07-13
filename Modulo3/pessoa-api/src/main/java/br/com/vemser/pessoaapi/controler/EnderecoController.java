package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco") // localhost:8080/endereco
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "listar endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping// localhost:8080/endereco
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @Operation(summary = "recuperar endereço pelo id do endereço", description = "recupera o endereço selecionado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}") // localhost:8080/endereco/1
    public List<EnderecoDTO> listByIdEndereco(@PathVariable("idEndereco") Integer id) {
        return enderecoService.listEnderecoByIdEndereco(id);
    }

    @Operation(summary = "listar endereços pelo id da pessoa", description = "Lista todos os endereços da pessoas selecionada")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os endereços do id pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa") // localhost:8080/endereco/1/pessoa
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id) {
        return enderecoService.listEnderecoByIdPessoa(id);
    }

    @Operation(summary = "adicionar endereço", description = "Adiciona um endereço no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço adicionado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}") // localhost:8080/endereco
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id,
                                          @RequestBody @Validated EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.create(endereco, id));
    }

    @Operation(summary = "atualizar endereço", description = "Atualiza um endereço do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}") // localhost:8080/endereco/1
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                           @RequestBody @Validated EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));
    }

    @Operation(summary = "deletar endereço", description = "Deleta um endereço do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço deletado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}") // localhost:8080/endereco/10
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }
}
