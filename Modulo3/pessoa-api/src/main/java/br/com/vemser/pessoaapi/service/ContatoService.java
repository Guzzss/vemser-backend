package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.Repository.ContatoRepository;
import br.com.vemser.pessoaapi.entity.Contato;

import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public Contato create(Contato contato, Integer idPessoa){
        return  contatoRepository.create(contato, idPessoa);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id,
                          Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(id, contatoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listContatosByIdPessoa(Integer id) {
        return contatoRepository.listContatosByIdPessoa(id);
    }
}
