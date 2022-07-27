package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.ContatoMapper;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        ContatoEntity contatoEntity = contatoMapper.fromCreateDTO(contato);
        contatoEntity.setIdPessoa(idPessoa);
        ContatoDTO contatoDTO = contatoMapper.toDTO(contatoRepository.save(contatoEntity));
        return contatoDTO;
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll().stream().map(contatoMapper::toDTO).toList();
    }

    public ContatoDTO update(Integer id,
                          ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        log.info("Contato alterado");
        ContatoEntity contatoEntityRecuperado = findById(id);
        contatoEntityRecuperado.setIdPessoa(id);
        contatoEntityRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoMapper.toDTO(contatoRepository.save(contatoEntityRecuperado));
    }

    public void delete(Integer id) throws Exception {
        log.info("Contato deletado");
        ContatoEntity contatoEntityRecuperado = findById(id);
        contatoRepository.delete(contatoEntityRecuperado);
    }

    public List<ContatoDTO> listContatosByIdPessoa(Integer id) {
       List<ContatoEntity> contatoEntityRecuperado = contatoRepository.findAll().stream()
               .filter(pessoa -> pessoa.getIdPessoa().equals(id)).toList();
        return contatoEntityRecuperado.stream().map(contatoMapper::toDTO).toList();
    }

//    public ContatoEntity findById(Integer idContato) throws RegraDeNegocioException {
//        ContatoEntity contatoEntityRecuperado = contatoRepositoryJPA.findAll().stream()
//                .filter(contatoEntity -> contatoEntity.getIdContato().equals(idContato))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
//        return contatoEntityRecuperado;

    public ContatoEntity findById(Integer id) throws RegraDeNegocioException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }
}
