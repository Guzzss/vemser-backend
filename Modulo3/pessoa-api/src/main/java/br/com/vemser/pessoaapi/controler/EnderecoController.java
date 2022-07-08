package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco") // localhost:8090/endereco
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping// localhost:8090/endereco
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}") // localhost:8090/endereco/1
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer id) {
        return enderecoService.listEnderecoByIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa") // localhost:8090/endereco/1/pessoa
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer id) {
        return enderecoService.listEnderecoByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}") // localhost:8090/endereco
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer id,
                                          @RequestBody @Validated Endereco endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.create(endereco, id));
    }

    @PutMapping("/{idEndereco}") // localhost:8090/endereco/1
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco") Integer id,
                           @RequestBody @Validated Endereco enderecoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));
    }

    @DeleteMapping("/{idEndereco}") // localhost:8090/endereco/10
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }
}
