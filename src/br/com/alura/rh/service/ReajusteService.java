package br.com.alura.rh.service;

import br.com.alura.rh.model.Funcionario;
import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacao;

    public ReajusteService(List<ValidacaoReajuste> validacao) {
        this.validacao = validacao;
    }

    // SRP - Single Responsibility Principle
    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {

        this.validacao.forEach(v -> v.validar(funcionario, aumento));
        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
