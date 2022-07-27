package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.TipoContato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/contato") // localhost:8080/contato
@Validated
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ContatoRepository contatoRepository;

    @Operation(summary = "listar contatos", description = "Lista todas os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/contato
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @Operation(summary = "listar contatos pelo Id da Pessoa", description = "Lista todos os contatos da pessoas selecionada")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os contatos do id escolhido"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}") // localhost:8080/contato/1
    public List<ContatoDTO> listByName(@PathVariable("idPessoa") Integer id) {
        return contatoService.listContatosByIdPessoa(id);
    }

    @Operation(summary = "adicionar Contato", description = "Adiciona um contato no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato adicionado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping ("/{idPessoa}")// localhost:8080/contato
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer id,
                                             @RequestBody @Validated ContatoCreateDTO contato) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.create(contato, id));
    }

    @Operation(summary = "atualizar Contato", description = "Atualiza um contato do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato atualizado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                          @RequestBody @Validated ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }

    @Operation(summary = "deletar Contato", description = "Deleta um contato do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato deletado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/contato-tipo") // localhost:8080/contato/1
    public List<ContatoEntity> listByTipo(TipoContato tipoContato) {
        return contatoRepository.listEnderecoByTipo(tipoContato);
    }
}
