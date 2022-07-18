package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.EnderecoMapper;
import br.com.vemser.pessoaapi.mapper.PessoaMapper;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        pessoaService.findById(idPessoa);
        EnderecoEntity enderecoEntity = enderecoMapper.fromCreateDTO(endereco);
//        enderecoEntity.setIdPessoa(idPessoa);
        EnderecoDTO enderecoDTO = enderecoMapper.toDTO(enderecoRepository.save(enderecoEntity));
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaService.findById(idPessoa));
        emailService.sendEnderecoEmail(pessoaDTO, enderecoDTO);
        return enderecoDTO;
    }
    public EnderecoDTO update(Integer id,
                           EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Endereco alterado");
        EnderecoEntity enderecoEntityRecuperado = findById(id);
//        enderecoEntityRecuperado.setIdPessoa(enderecoAtualizar.getIdEndereco());
        enderecoEntityRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEntityRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoEntityRecuperado.setPais(enderecoAtualizar.getPais());
//        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaService.findById(id));
        enderecoRepository.save(enderecoEntityRecuperado);
        EnderecoDTO enderecoDTO = enderecoMapper.toDTO(enderecoEntityRecuperado);
//        emailService.sendUpdateEnderecoEmail(pessoaDTO, enderecoDTO);
        return enderecoDTO;
    }


    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("Endereco deletado");
        EnderecoEntity enderecoEntityRecuperado = findById(id);
        emailService.sendDeleteEnderecoEmail(pessoaMapper.toDTO(pessoaService.findById(id)), enderecoMapper.toDTO(enderecoEntityRecuperado));
        enderecoRepository.delete(enderecoEntityRecuperado);
    }

    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }
}
