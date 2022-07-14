package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.vemser.pessoaapi.service.DadosPessoaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController implements DadosPessoaisClient {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    @Override
    @GetMapping
    public List<DadosPessoaisDTO> getAll() {
        return  dadosPessoaisService.getAll();
    }


    @Override
    @GetMapping("/{cpf}")
    public DadosPessoaisDTO get(String cpf) {
        return dadosPessoaisService.get(cpf);
    }

    @Override
    @PostMapping
    public DadosPessoaisDTO post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.post(dadosPessoaisDTO);
    }

    @Override
    @PutMapping("/{cpf}")
    public  DadosPessoaisDTO put(@PathVariable("cpf") String cpf,
                                                @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.put(cpf, dadosPessoaisDTO);
    }

    @Override
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisService.delete(cpf);
    }

}
