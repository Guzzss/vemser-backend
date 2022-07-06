package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping // localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}") // localhost:8080/contato/1
    public List<Contato> listByName(@PathVariable("idPessoa") Integer id) {
        return contatoService.listContatosByIdPessoa(id);
    }

    @PostMapping ("/{idPessoa}")// localhost:8080/contato
    public Contato create(@PathVariable("idPessoa") Integer id,
                          @RequestBody Contato contato) {
        return contatoService.create(contato, id);
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

}
