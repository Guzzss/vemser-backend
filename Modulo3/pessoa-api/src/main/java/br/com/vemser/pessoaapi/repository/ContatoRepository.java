package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContatoRepository {

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

    public void delete(Contato contato){
        listaContatos.remove(contato);
    }
}

