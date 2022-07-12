package br.com.banco.service;

import br.com.banco.repository.BancoModel;
import br.com.banco.repository.BancoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BancoService {

    @Autowired// injeção de dependencia - inversão de controle
    private BancoRepository repository;

    public BancoModel findByCpf(String cpf) throws Exception {
        log.info("service-findByCpf");
        return repository.findByCpf(cpf);
    }

    public BancoModel findByConta(String conta) throws Exception{
        log.info("service-findByConta");
        return repository.findByConta(conta);
    }
}
