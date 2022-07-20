package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<ProfessorEntity> getAll() {
        return professorRepository.findAll();
    }

    @PostMapping
    public ProfessorEntity create(@RequestBody ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }
}
//    public ResponseEntity<PessoaDTO> create(@Validated @RequestBody PessoaCreateDTO pessoa) throws Exception {
//        return ResponseEntity.ok(pessoaService.create(pessoa));
//    }