package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.ContatoMapper;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.entity.Contato;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ContatoMapper contatoMapper;

    public ContatoDTO create(ContatoCreateDTO contato, Integer idPessoa) throws RegraDeNegocioException {
        log.info("Contato criado");
        pessoaService.findById(idPessoa);
        Contato contatoEntity = contatoMapper.fromCreateDTO(contato);
        ContatoDTO contatoDTO = contatoMapper.toDTO(contatoRepository.create(contatoEntity, idPessoa));
        return contatoDTO;
    }

    public List<ContatoDTO> list() {
        return contatoRepository.list().stream().map(contatoMapper::toDTO).toList();
    }

    public ContatoDTO update(Integer id,
                          ContatoDTO contatoAtualizar) throws RegraDeNegocioException {
        log.info("Contato alterado");
        Contato contatoRecuperado = findById(id);
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa() != null ? contatoAtualizar.getIdPessoa() : contatoRecuperado.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato() != null ? contatoAtualizar.getTipoContato() : contatoRecuperado.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero() != null ? contatoAtualizar.getNumero() : contatoRecuperado.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao() != null ? contatoAtualizar.getDescricao() : contatoRecuperado.getDescricao());
        return contatoMapper.toDTO(contatoRecuperado);
    }

    public void delete(Integer id) throws Exception {
        log.info("Contato deletado");
        Contato contatoRecuperado = findById(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public List<ContatoDTO> listContatosByIdPessoa(Integer id) {
       List<Contato> contatoRecuperado = contatoRepository.list().stream()
               .filter(pessoa -> pessoa.getIdPessoa().equals(id)).toList();
        return contatoRecuperado.stream().map(contatoMapper::toDTO).toList();
    }

    public Contato findById(Integer idContato) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoRecuperado;
    }
}
