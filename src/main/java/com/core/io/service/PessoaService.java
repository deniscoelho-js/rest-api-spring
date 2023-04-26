package com.core.io.service;

import com.core.io.exception.EntidadeNaoEncontradaException;
import com.core.io.model.Pessoa;
import com.core.io.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoa(Long id){
        return findOrFail(id);
    }

    private Pessoa findOrFail(Long id){
        return pessoaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Pessoa não localizada"));
    }
}
