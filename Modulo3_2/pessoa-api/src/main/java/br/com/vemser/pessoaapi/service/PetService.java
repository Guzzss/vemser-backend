package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.PetMapper;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired private PetRepository petRepository;

    @Autowired private PetMapper petMapper;

    @Autowired private PessoaService pessoaService;

    public PetDTO create(PetCreateDTO pet, Integer idPessoa) throws RegraDeNegocioException {
        PessoaEntity pessoa = pessoaService.findById(idPessoa);
        if (pessoa.getPet() != null) {
            throw new RegraDeNegocioException("Já existe um pet nessa pessoa");
        }

        PetEntity petEntity = petMapper.fromCreateDTO(pet);
        petEntity.setPessoa(pessoaService.findById(idPessoa));
        petEntity.setIdPessoa(idPessoa);
        pessoa.setPet(petEntity);
        pessoaRepository.save(pessoa);
        PetDTO petDTO = petMapper.toDTO(petRepository.save(petEntity));
        return petDTO;
    }

    public PetDTO update(PetCreateDTO pet, Integer id) throws RegraDeNegocioException {
        PetEntity petRecuperado = findById(id);
        petRecuperado.setNome(pet.getNome());
        petRecuperado.setTipo(pet.getTipo());
        petRepository.save(petRecuperado);
        return petMapper.toDTO(petRecuperado);
    }

    public List<PetDTO> list() {
        return petRepository.findAll().stream().map(petMapper::toDTO).toList();
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        petRepository.delete(findById(id));
    }

    private PetEntity findById(Integer id) throws RegraDeNegocioException {
        return petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }
}
