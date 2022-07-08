package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.Exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.Repository.PessoaRepository;
import br.com.vemser.pessoaapi.entity.Pessoa;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa) throws Exception {
        if (pessoa != null && ObjectUtils.isEmpty(pessoa)
                && StringUtils.isBlank(pessoa.getNome())
                && ObjectUtils.isEmpty(pessoa.getDataNascimento())
                && StringUtils.isBlank(pessoa.getCpf())
        ) {
            return pessoaRepository.create(pessoa);
        }
        throw new RegraDeNegocioException("Ocorreu um erro");
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = findById(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = findById(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Pessoa findById(Integer idPessoa) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        return pessoaRecuperada;
    }

}
