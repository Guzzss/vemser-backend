package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.PessoaMapper;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.entity.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        log.info("Pessoa criada");
        Pessoa pessoaEntity = pessoaMapper.fromCreateDTO(pessoa);
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaRepository.create(pessoaEntity));
        emailService.sendEmail(pessoaDTO);
        log.warn("Pessoa " + pessoaDTO.getNome() + " criada!");
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list().stream().map(pessoaMapper::toDTO).toList();
    }

    public PessoaDTO update(Integer id,
                         PessoaDTO pessoaAtualizar) throws Exception {
        log.info("Pessoa alterada");
        Pessoa pessoaRecuperada = findById(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaRecuperada);
        emailService.sendUpdateEmail(pessoaDTO);
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        log.info("Pessoa deletada");
        Pessoa pessoaRecuperada = findById(id);
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaRecuperada);
        emailService.deleteSendEmail(pessoaDTO);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaDTO> listByName(String nome) {
        return this.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Pessoa findById(Integer idPessoa) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return pessoaRecuperada;
    }

}
