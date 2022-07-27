package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.EnderecoMapper;
import br.com.vemser.pessoaapi.mapper.PessoaMapper;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PessoaMapper pessoaMapper;


    @Autowired
    PessoaRepository pessoaRepository;
    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream().map(enderecoMapper::toDTO).toList();
    }

//    public List<EnderecoDTO> listEnderecoByIdPessoa(Integer id) {
//        List<EnderecoEntity> enderecoEntityRecuperado = enderecoRepositoryJPA.findAll().stream()
//                .filter(pessoa -> pessoa.getIdPessoa().equals(id)).toList();
//        return enderecoEntityRecuperado.stream().map(enderecoMapper::toDTO).toList();
//    }

    public List<EnderecoDTO> listEnderecoByIdEndereco(Integer id) {
        List<EnderecoEntity> enderecoEntityRecuperado = enderecoRepository.findAll().stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(id)).toList();
       return enderecoEntityRecuperado.stream().map(enderecoMapper::toDTO).toList();
    }

    public EnderecoDTO create(EnderecoCreateDTO endereco, Integer idPessoa) throws RegraDeNegocioException {
        log.info("Endereco criado");
        PessoaEntity pessoa = pessoaService.findById(idPessoa);
        EnderecoEntity enderecoEntity = enderecoMapper.fromCreateDTO(endereco);
        enderecoEntity.setPessoas(Set.of(pessoa));
        EnderecoDTO enderecoDTO = enderecoMapper.toDTO(enderecoRepository.save(enderecoEntity));
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaService.findById(idPessoa));
        emailService.sendEnderecoEmail(pessoaDTO, enderecoDTO);
        return enderecoDTO;
    }
    public EnderecoDTO update(Integer id,
                           EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Endereco alterado");
        EnderecoEntity enderecoEntityRecuperado = findById(id);
        enderecoEntityRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEntityRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoEntityRecuperado.setPais(enderecoAtualizar.getPais());
        enderecoRepository.save(enderecoEntityRecuperado);
        EnderecoDTO enderecoDTO = enderecoMapper.toDTO(enderecoEntityRecuperado);
        return enderecoDTO;
    }


    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityRecuperado = findById(id);
        enderecoRepository.delete(enderecoEntityRecuperado);
        log.info("Endereco deletado");
    }

    public void deletee(Integer id, Integer idEndereco) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.findById(id);
        findById(idEndereco);
        enderecoRepository.delete(pessoaEntity.getEnderecos().stream().filter(endereco -> endereco.getIdEndereco().equals(idEndereco)).findFirst().get());
            log.info("Endereco deletado");
    }

    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }
}
