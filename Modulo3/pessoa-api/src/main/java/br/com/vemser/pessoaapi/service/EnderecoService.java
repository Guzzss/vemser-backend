package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.Repository.EnderecoRepository;
import br.com.vemser.pessoaapi.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public List<Endereco> listEnderecoByIdPessoa(Integer id) {
        //exception para id nulo
        return enderecoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listEnderecoByIdEndereco(Integer id) {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco create(Endereco endereco, Integer idPessoa){
        return  enderecoRepository.create(endereco, idPessoa);
    }

    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdEndereco() != null ? enderecoAtualizar.getIdPessoa() : enderecoRecuperado.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo() != null ? enderecoAtualizar.getTipo() : enderecoRecuperado.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro() != null ? enderecoAtualizar.getLogradouro() : enderecoRecuperado.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero() != null ? enderecoAtualizar.getNumero() : enderecoRecuperado.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento() != null ? enderecoAtualizar.getComplemento() : enderecoRecuperado.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep() != null ? enderecoAtualizar.getCep() : enderecoRecuperado.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade() != null ? enderecoAtualizar.getCidade() : enderecoRecuperado.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado() != null ? enderecoAtualizar.getEstado() : enderecoRecuperado.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais() != null ? enderecoAtualizar.getPais() : enderecoRecuperado.getPais());
        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não econtrado"));
        enderecoRepository.delete(enderecoRecuperado);
    }

}
