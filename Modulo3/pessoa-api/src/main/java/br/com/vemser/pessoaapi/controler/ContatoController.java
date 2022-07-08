package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.Exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.service.ContatoService;
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

    @GetMapping // localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}") // localhost:8080/contato/1
    public List<Contato> listByName(@PathVariable("idPessoa") Integer id) {
        return contatoService.listContatosByIdPessoa(id);
    }

    @PostMapping ("/{idPessoa}")// localhost:8080/contato
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer id,
                                         @RequestBody @Validated Contato contato) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.create(contato, id));
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                          @RequestBody @Validated Contato contatoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

}
