package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.vemser.pessoaapi.service.PessoaDadosPessoaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pessoa-dados-pessoais")
public class PessoaDadosPessoaisControler {

    @Autowired
    private PessoaDadosPessoaisService pessoaDadosPessoaisService;

    @GetMapping
    public ResponseEntity<List<PessoaDadosPessoaisDTO>> getAll(){
        return new ResponseEntity<>(pessoaDadosPessoaisService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaDadosPessoaisDTO> post(@RequestBody PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
        return new ResponseEntity<>(pessoaDadosPessoaisService.post(pessoaDadosPessoaisDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) throws Exception {
        pessoaDadosPessoaisService.delete(cpf);
    }
}

