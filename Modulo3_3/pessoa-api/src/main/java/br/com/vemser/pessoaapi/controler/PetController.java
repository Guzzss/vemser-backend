package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Valid
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<PetDTO> list() {
        return petService.list();
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<PetDTO> create(@PathVariable("idPessoa") Integer idPessoa,
            @RequestBody @Validated PetCreateDTO pet) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.create(pet, idPessoa));
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") Integer idPet,
            @RequestBody @Validated PetCreateDTO pet) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.update(pet, idPet));
    }

    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer idPet) throws RegraDeNegocioException {
         petService.delete(idPet);
    }
}
