package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.PropertieReader;
import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.service.EmailService;
import br.com.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @Autowired
    private EmailService emailService;

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/ambiente")
    public String retornarPropertie() {
        return propertieReader.getAmbiente();
    }

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

//    @SneakyThrows
//    @GetMapping("/email")
//    public String email() {
//        //emailService.sendWithAttachment();
//        emailService.sendEmail();
//        return "Enviando E-mail..";
//    }

    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @Operation(summary = "listar pessoas por nome", description = "Lista todas as pessoas do banco por nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas com o nome digitado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @Operation(summary = "criar pessoas", description = "cria uma nova pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pessoa criada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Validated @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @Operation(summary = "atualizar pessoa", description = "Atualiza uma pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Validated PessoaDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @Operation(summary = "deletar pessoa", description = "deleta alguma pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa deletada com sucesso   "),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @GetMapping("/{byNome}")
    public List<PessoaEntity> findByNome(@RequestParam  ("byNome") String nome) {
        return pessoaRepository.findByNomeContainsIgnoreCase(nome);
    }

    @GetMapping("/{byCpf}")
    public List<PessoaEntity> findByCpf(@RequestParam("byCpf") String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    @GetMapping("/listar-pessoas-com-enderecos")
    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listarPessoasComEnderecos(idPessoa);
    }

    @GetMapping("/listar-pessoas-com-contatos")
    public List<PessoasDTOComContatos> listarPessoasComContatos(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listarPessoasComContatos(idPessoa);
    }

    @GetMapping("/Listar-pessoas-com-pets")
    public List<PessoaDTOComPets> listarPessoasComPets(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listarPessoasComPets(idPessoa);
    }

}