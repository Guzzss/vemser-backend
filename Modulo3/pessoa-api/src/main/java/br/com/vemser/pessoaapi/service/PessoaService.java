package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.Repository.PessoaRepository;
import br.com.vemser.pessoaapi.entity.Pessoa;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa) throws Exception{
        if (pessoa != null && ObjectUtils.isEmpty(pessoa)
                && StringUtils.isBlank(pessoa.getNome())
                && ObjectUtils.isEmpty(pessoa.getDataNascimento())
                && StringUtils.isBlank(pessoa.getCpf())
                && (pessoa.getCpf().length() == 11)
        ) {
            return pessoaRepository.create(pessoa);
        }
        throw new Exception();
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
