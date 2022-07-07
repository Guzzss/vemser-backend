package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.PropertieReader;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @GetMapping("/ambiente")
    public String retornarPropertie() {
        return propertieReader.getAmbiente();
    }

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @PostMapping // localhost:8080/pessoa
    public Pessoa create(@RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }

    @GetMapping // localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}