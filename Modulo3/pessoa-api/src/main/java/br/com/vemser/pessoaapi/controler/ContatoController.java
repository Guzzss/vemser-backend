package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.entity.Contato;
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
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}") // localhost:8080/contato/1
    public List<ContatoDTO> listByName(@PathVariable("idPessoa") Integer id) { //Falta esse
        return contatoService.listContatosByIdPessoa(id);
    }

    @PostMapping ("/{idPessoa}")// localhost:8080/contato
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer id,
                                         @RequestBody @Validated ContatoDTO contato) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.create(contato, id));
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                          @RequestBody @Validated ContatoDTO contatoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

}
