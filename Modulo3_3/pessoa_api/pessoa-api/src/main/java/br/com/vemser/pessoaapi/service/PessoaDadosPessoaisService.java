package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.mapper.PessoaDadosPessoaisMapper;
import br.com.vemser.pessoaapi.repository.PessoaComDadosPessoaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaDadosPessoaisService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    @Autowired
    private PessoaComDadosPessoaisRepository pessoaComDadosPessoaisRepository;

    @Autowired
    PessoaDadosPessoaisMapper pessoaDadosPessoaisMapper;
    public List<PessoaDadosPessoaisDTO> getAll() {
        return pessoaComDadosPessoaisRepository.list();
    }

    public PessoaDadosPessoaisDTO post(PessoaDadosPessoaisDTO pessoaComDadosPessoais) throws Exception {
        PessoaDTO pessoaDTO = pessoaDadosPessoaisMapper.fromCreateDTOPessoa(pessoaComDadosPessoais);
        pessoaDTO = pessoaService.create(pessoaDTO);
        pessoaDadosPessoaisMapper.toDTO(pessoaDTO);

        DadosPessoaisDTO dadosPessoaisDTO = pessoaDadosPessoaisMapper.fromCreateDTODados(pessoaComDadosPessoais);
        dadosPessoaisDTO = dadosPessoaisService.post(dadosPessoaisDTO);
        pessoaDadosPessoaisMapper.toDTO(dadosPessoaisDTO);
        pessoaComDadosPessoaisRepository.post(pessoaComDadosPessoais);
       return pessoaComDadosPessoais;
    }

    public PessoaDadosPessoaisDTO put(String cpf, PessoaDadosPessoaisDTO pessoaAtualizar) throws RegraDeNegocioException {
            PessoaDadosPessoaisDTO pessoaRecuperada = findByCPF(cpf);
            pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
            pessoaRecuperada.setNome(pessoaAtualizar.getNome());
            pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
            pessoaRecuperada.setSexo(pessoaAtualizar.getSexo());
            pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
            pessoaRecuperada.setCnh(pessoaAtualizar.getCnh());
            pessoaRecuperada.setNomeMae(pessoaAtualizar.getNomeMae());
            pessoaRecuperada.setNomePai(pessoaAtualizar.getNomePai());
            pessoaRecuperada.setRg(pessoaAtualizar.getRg());
            pessoaRecuperada.setTituloEleitor(pessoaAtualizar.getTituloEleitor());

            return pessoaRecuperada;
        }


    public void delete(String cpf) throws Exception {
        PessoaDadosPessoaisDTO pessoaRecuperada = findByCPF(cpf);
        pessoaComDadosPessoaisRepository.delete(pessoaRecuperada);
    }

    public PessoaDadosPessoaisDTO findByCPF(String cpf) throws RegraDeNegocioException {
        PessoaDadosPessoaisDTO pessoaRecuperada = pessoaComDadosPessoaisRepository.list().stream()
                .filter(pessoa -> pessoa.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("cpf não encontrado"));
        return pessoaRecuperada;
    }

}
