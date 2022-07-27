package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.ContatoMapper;
import br.com.vemser.pessoaapi.mapper.EnderecoMapper;
import br.com.vemser.pessoaapi.mapper.PessoaMapper;
import br.com.vemser.pessoaapi.mapper.PetMapper;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ContatoMapper contatoMapper;

    @Autowired
    private EnderecoMapper enderecoMapper;
    @Autowired
    private PetMapper petMapper;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        log.info("Pessoa criada");
        PessoaEntity pessoaEntity = pessoaMapper.fromCreateDTO(pessoa);
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaRepository.save(pessoaEntity));
        emailService.sendEmail(pessoaDTO);
        log.warn("Pessoa " + pessoaDTO.getNome() + " criada!");
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream().map(pessoaMapper::toDTO).toList();
    }

    public PessoaDTO update(Integer id,
                         PessoaDTO pessoaAtualizar) throws Exception {
        log.info("Pessoa alterada");
        PessoaEntity pessoaEntityRecuperada = findById(id);
        pessoaEntityRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaEntityRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaEntityRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaEntityRecuperada);
        emailService.sendUpdateEmail(pessoaDTO);
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        log.info("Pessoa deletada");
        PessoaEntity pessoaEntityRecuperada = findById(id);
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoaEntityRecuperada);
        emailService.deleteSendEmail(pessoaDTO);
        pessoaRepository.delete(pessoaEntityRecuperada);
    }

    public List<PessoaDTO> listByName(String nome) {
        return this.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public PessoaEntity findById(Integer idPessoa) throws RegraDeNegocioException {
       return pessoaRepository.findById(idPessoa).orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<PessoasDTOComContatos> listarPessoasComContatos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoasDTOComContatos> listaPessoasComContatos = new ArrayList<>();
        if (idPessoa == null) {
            listaPessoasComContatos.addAll(pessoaRepository.findAll().stream().map(pessoa -> {
                PessoasDTOComContatos pessoaComContatos = objectMapper.convertValue(pessoa, PessoasDTOComContatos.class);
                pessoaComContatos.setContatos(pessoa.getContatos().stream().map(contatos -> objectMapper.convertValue(contatos, ContatoDTO.class)).collect(Collectors.toList()));
                return pessoaComContatos;
            }).toList());
        } else {
            PessoaEntity pessoa = findById(idPessoa);
            PessoasDTOComContatos pessoaComContatos = objectMapper.convertValue(pessoa, PessoasDTOComContatos.class);
            pessoaComContatos.setContatos(pessoa.getContatos().stream().map(contato -> objectMapper.convertValue(contato, ContatoDTO.class)).collect(Collectors.toList()));
            listaPessoasComContatos.add(pessoaComContatos);
        }
        return listaPessoasComContatos;
    }

    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComEnderecos> listaPessoasComEnderecos = new ArrayList<>();
        if (idPessoa == null) {
            listaPessoasComEnderecos.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecos pessoaComEnderecos = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                        pessoaComEnderecos.setEnderecos(pessoa.getEnderecos().stream().map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class)).collect(Collectors.toList()));
                        return pessoaComEnderecos;
                    }).toList());
        }else {
            PessoaEntity pessoa = findById(idPessoa);
            PessoaDTOComEnderecos pessoaComEnderecos = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
            pessoaComEnderecos.setEnderecos(pessoa.getEnderecos().stream().map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class)).collect(Collectors.toList()));
            listaPessoasComEnderecos.add(pessoaComEnderecos);
        }
        return listaPessoasComEnderecos;
    }

    public List<PessoaDTOComPets> listarPessoasComPets(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComPets> listaPessoasComPets = new ArrayList<>();
        if (idPessoa == null) {
            listaPessoasComPets.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComPets pessoaComPets = objectMapper.convertValue(pessoa, PessoaDTOComPets.class);
                         pessoaComPets.setPet(petMapper.toDTO(pessoa.getPet()));
                        return pessoaComPets;
                    }).toList());
        } else {
            PessoaEntity pessoa = findById(idPessoa);
            PessoaDTOComPets pessoaComPets = objectMapper.convertValue(pessoa, PessoaDTOComPets.class);
            pessoaComPets.setPet(petMapper.toDTO(pessoa.getPet()));
            listaPessoasComPets.add(pessoaComPets);
        }
        return listaPessoasComPets;
    }

    public PessoaEntity salvar(PessoaEntity pessoaEntity) {
        return this.pessoaRepository.save(pessoaEntity);
    }

    public List<PessoaComTudoDTO> pessoaComTudo(Integer id) {
        List<PessoaEntity> lista = id == null ? pessoaRepository.findAll() : List.of(pessoaRepository.findById(id).get());
        return lista.stream().map(pessoa -> {
            PessoaComTudoDTO pessoaComTudoDTO =  objectMapper.convertValue(pessoa, PessoaComTudoDTO.class);;
            pessoaComTudoDTO.setContatoDTOS(pessoa.getContatos().stream().map(contato -> contatoMapper.toDTO(contato)).toList());
            pessoaComTudoDTO.setEnderecoDTOS(pessoa.getEnderecos().stream().map(endereco -> enderecoMapper.toDTO(endereco)).toList());
            pessoaComTudoDTO.setPetDTO(petMapper.toDTO(pessoa.getPet()));
            return pessoaComTudoDTO;
        }).collect(Collectors.toList());
    }

    public List<PessoaCompostaDTO> listaCompostaDTO(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.listaCompostaDTO(idPessoa);

    }
}
