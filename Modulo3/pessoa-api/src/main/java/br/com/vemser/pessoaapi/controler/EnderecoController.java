package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
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

    @GetMapping// localhost:8080/endereco
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}") // localhost:8080/endereco/1
    public List<EnderecoDTO> listByIdEndereco(@PathVariable("idEndereco") Integer id) {
        return enderecoService.listEnderecoByIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa") // localhost:8080/endereco/1/pessoa
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id) {
        return enderecoService.listEnderecoByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}") // localhost:8080/endereco
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id,
                                          @RequestBody @Validated EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.create(endereco, id));
    }

    @PutMapping("/{idEndereco}") // localhost:8080/endereco/1
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                           @RequestBody @Validated EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));
    }

    @DeleteMapping("/{idEndereco}") // localhost:8080/endereco/10
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }
}
