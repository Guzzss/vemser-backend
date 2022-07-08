package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.Exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.Repository.ContatoRepository;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Contato create(Contato contato, Integer idPessoa) throws RegraDeNegocioException {
        pessoaService.findById(idPessoa);
        return contatoRepository.create(contato, idPessoa);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id,
                          Contato contatoAtualizar) throws RegraDeNegocioException {
        Contato contatoRecuperado = findById(id);
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa() != null ? contatoAtualizar.getIdPessoa() : contatoRecuperado.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato() != null ? contatoAtualizar.getTipoContato() : contatoRecuperado.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero() != null ? contatoAtualizar.getNumero() : contatoRecuperado.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao() != null ? contatoAtualizar.getDescricao() : contatoRecuperado.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = findById(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public List<Contato> listContatosByIdPessoa(Integer id) {
        return contatoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Contato findById(Integer idContato) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não econtrado"));
        return contatoRecuperado;
    }
}
