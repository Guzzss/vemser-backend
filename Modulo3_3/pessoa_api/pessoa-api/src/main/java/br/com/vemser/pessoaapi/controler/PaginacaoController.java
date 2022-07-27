package br.com.vemser.pessoaapi.controler;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
public class PaginacaoController {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ContatoRepository contatoRepository;


    @GetMapping("/pais-paginado")
    public Page<EnderecoEntity> getRelatorioPaginado(Integer pagina, Integer quantidadeRegistros, String pais) {
        Sort ordenacao = Sort.by("pais");

        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return enderecoRepository.listEnderecoByPaisPaginacao(pais, pageable);
    }

    @GetMapping("/cep-paginado")
    public Page<EnderecoEntity> getCepPaginado(Integer pagina, Integer quantidadeRegistros) {
        Sort ordenacao = Sort.by("cep");

        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return enderecoRepository.listEnderecoPaginado(pageable);
    }

    @GetMapping("/descricao-paginado")
    public Page<ContatoEntity> getDescricaoPaginado(Integer pagina, Integer quantidadeRegistros){
        Sort ordenacao = Sort.by("descricao");

        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return contatoRepository.listContatoByDescricao(pageable);
    }
}
