package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco") // localhost:8090/endereco
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/endereco") // localhost:8090/endereco
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/endereco/{idEndereco}") // localhost:8090/endereco/1
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer id) {
        return enderecoService.listEnderecoByIdEndereco(id);
    }

    @GetMapping("/endereco/{idPessoa}/pessoa") // localhost:8090/endereco/1/pessoa
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer id) {
        return enderecoService.listEnderecoByIdPessoa(id);
    }

    @PostMapping("/endereco/{idPessoa}") // localhost:8090/endereco
    public Endereco create(@PathVariable("idPessoa") Integer id,
                           @RequestBody Endereco endereco) {
        return enderecoService.create(endereco, id);
    }

    @PutMapping("/endereco/{idEndereco}") // localhost:8090/endereco/1
    public Endereco update(@PathVariable("idEndereco") Integer id,
                           @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id, enderecoAtualizar);
    }

    @DeleteMapping("/endereco/{idEndereco}") // localhost:8090/endereco/10
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
