package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.EnderecoMapper;
import br.com.vemser.pessoaapi.mapper.PessoaMapper;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.entity.Endereco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return enderecoRepository.list().stream().map(enderecoMapper::toDTO).toList();
    }

    public List<EnderecoDTO> listEnderecoByIdPessoa(Integer id) {
        List<Endereco> enderecoRecuperado = enderecoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id)).toList();
        return enderecoRecuperado.stream().map(enderecoMapper::toDTO).toList();
    }

    public List<EnderecoDTO> listEnderecoByIdEndereco(Integer id) {
        List<Endereco> enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id)).toList();
       return enderecoRecuperado.stream().map(enderecoMapper::toDTO).toList();
    }

    public EnderecoDTO create(EnderecoCreateDTO endereco, Integer idPessoa) throws RegraDeNegocioException {
        log.info("Endereco criado");
        pessoaService.findById(idPessoa);
        Endereco enderecoEntity = enderecoMapper.fromCreateDTO(endereco);
        EnderecoDTO enderecoDTO = enderecoMapper.toDTO(enderecoRepository.create(enderecoEntity, idPessoa));
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaService.findById(idPessoa));
        emailService.sendEnderecoEmail(pessoaDTO, enderecoDTO);
        return enderecoDTO;
    }
    public EnderecoDTO update(Integer id,
                           EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Endereco alterado");
        Endereco enderecoRecuperado = findById(id);
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdEndereco() != null ? enderecoAtualizar.getIdPessoa() : enderecoRecuperado.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo() != null ? enderecoAtualizar.getTipo() : enderecoRecuperado.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro() != null ? enderecoAtualizar.getLogradouro() : enderecoRecuperado.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero() != null ? enderecoAtualizar.getNumero() : enderecoRecuperado.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento() != null ? enderecoAtualizar.getComplemento() : enderecoRecuperado.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep() != null ? enderecoAtualizar.getCep() : enderecoRecuperado.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade() != null ? enderecoAtualizar.getCidade() : enderecoRecuperado.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado() != null ? enderecoAtualizar.getEstado() : enderecoRecuperado.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais() != null ? enderecoAtualizar.getPais() : enderecoRecuperado.getPais());
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaService.findById(id));
        EnderecoDTO enderecoDTO = enderecoMapper.toDTO(enderecoRecuperado);
        emailService.sendUpdateEnderecoEmail(pessoaDTO, enderecoDTO);
        return enderecoDTO;
    }


    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("Endereco deletado");
        Endereco enderecoRecuperado = findById(id);
        emailService.sendDeleteEnderecoEmail(pessoaMapper.toDTO(pessoaService.findById(id)), enderecoMapper.toDTO(enderecoRecuperado));
        enderecoRepository.delete(enderecoRecuperado);
    }

    public Endereco findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }
}
