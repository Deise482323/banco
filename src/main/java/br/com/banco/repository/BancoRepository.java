package br.com.banco.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BancoRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public BancoModel findByCpf(String cpf) throws Exception {
        log.info("repository-findByCpf");
        String sql = "SELECT * FROM dados_conta WHERE cpf = '" + cpf + "';";
        return process(sql);
    }


    public BancoModel findByConta(String conta) throws Exception {
        log.info("repository-findByConta");
        String sql = "SELECT * FROM dados_conta WHERE conta = '" + conta + "';";
        return process(sql);
    }

    private BancoModel process(String sql) throws Exception {
        log.info(sql);
        try {
            return template
                    .query(
                            sql,
                            (resultado, i) -> BancoModel
                                    .builder()
                                    .id(resultado.getLong("id"))
                                    .nome(resultado.getString("nome"))
                                    .cpf(resultado.getString("cpf"))
                                    .status(resultado.getString("status"))
                                    .endereço(resultado.getString("endereço"))
                                    .agencia(resultado.getString("agencia"))
                                    .conta(resultado.getString("conta"))
                                    .digito(resultado.getString("digito"))
                                    .saldo(resultado.getDouble("saldo"))
                                    .build()
                    )
                    .get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("CPF NÃO ENCONTRADO");
        }
    }


}
