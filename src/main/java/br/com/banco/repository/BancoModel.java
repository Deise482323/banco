package br.com.banco.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BancoModel {

    private Long id;
    private String nome;
    private String cpf;
    private String status;
    private String endereço;
    private String agencia;
    private String conta;
    private String digito;
    private Double saldo;
}
