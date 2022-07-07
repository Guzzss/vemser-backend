package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.Repository.ContatoRepository;
import br.com.vemser.pessoaapi.entity.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato create(Contato contato, Integer idPessoa){
        return  contatoRepository.create(contato, idPessoa);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id,
                          Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa() != null ? contatoAtualizar.getIdPessoa() : contatoRecuperado.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato() != null ? contatoAtualizar.getTipoContato() : contatoRecuperado.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero() != null ? contatoAtualizar.getNumero() : contatoRecuperado.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao() != null ? contatoAtualizar.getDescricao() : contatoRecuperado.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        contatoRepository.delete(contatoRecuperado);
    }

    public List<Contato> listContatosByIdPessoa(Integer id) {
        return contatoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}
