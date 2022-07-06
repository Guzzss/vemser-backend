package br.com.vemser.pessoaapi.Repository;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.entity.TipoContato;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    Pessoa pessoa = new Pessoa();
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {

        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,1 , TipoContato.COMERCIAL, "99908089", "Whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,2 , TipoContato.RESIDENCIAL, "99908089", "Teste"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,3 , TipoContato.COMERCIAL, "99908089", "Whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,4 , TipoContato.RESIDENCIAL, "99908089", "teste"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,10 , TipoContato.COMERCIAL, "99908089", "Whatsapp"));
    }

    public Contato create(Contato contato, Integer idPessoa) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contato.setIdPessoa(idPessoa);
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
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
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listContatosByIdPessoa(Integer id) {
        return listaContatos.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}

