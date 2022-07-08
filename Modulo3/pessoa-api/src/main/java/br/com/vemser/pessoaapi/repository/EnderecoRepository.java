package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private List<Endereco> listaEnderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository(){
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*1*/,1, TipoEndereco.COMERCIAL, "Rua São Paulo", 21, "Campo", "94100-233", "Porto Alegre", "Rio grande do Sul", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*2*/,2, TipoEndereco.RESIDENCIAL, "Rua Amazonas", 212, "Campo", "99705-244", "Gravataí", "Rio grande do Sul", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*3*/,3, TipoEndereco.COMERCIAL, "Rua Rio de Janeiro", 221, "Campo", "12280-238", "Canoas", "Rio grande do Sul", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*4*/,4, TipoEndereco.RESIDENCIAL, "Rua Minas Gerais", 345, "Campo", "66033-810", "Cachoeirinha", "Rio grande do Sul", "Brasil"));
        listaEnderecos.add(new Endereco(15,5, TipoEndereco.COMERCIAL, "Rua Santa Catarina", 46, "Campo", "79002-165", "Porto Alegre", "Rio grande do Sul", "Brasil"));
    }

    public Endereco create(Endereco endereco, Integer idPessoa) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list(){
        return listaEnderecos;
    }

    public void delete(Endereco endereco){
        listaEnderecos.remove(endereco);
    }
}
