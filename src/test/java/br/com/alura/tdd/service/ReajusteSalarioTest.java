package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteSalarioTest {

    private ReajusteSalario reajuste;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializa() {
        System.out.println("Início do teste unitário");
        System.out.println("...");
        reajuste = new ReajusteSalario();
        funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void depoisDeCada() {
        System.out.println("Fim do teste unitário\n");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("------TESTANDO A CLASSE------" );
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("------FIM DOS TESTES DA CLASSE------");
    }

    @Test
    public void reajusteDeveSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        reajuste.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        reajuste.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        reajuste.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
