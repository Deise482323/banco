package br.com.banco.controller;

import br.com.banco.repository.BancoModel;
import br.com.banco.service.BancoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class BancoController {

    @Autowired// injeção de dependencia
    private BancoService service;

    @GetMapping(path = "cpf/{cpf}")
    public BancoModel findByCpf(
            @PathVariable("cpf") String cpf
    ) throws Exception {
        log.info("controller-findByCpf");
        log.info(cpf);
        return service.findByCpf(cpf);
    }

    @GetMapping(path = "conta/{conta}")
    public BancoModel findByConta(
            @PathVariable("conta") String conta
    ) throws Exception {
        log.info("controller-findByConta");
        log.info(conta);
        return service.findByConta(conta);
    }
}
