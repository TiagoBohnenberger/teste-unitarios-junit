package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    public void bonusShouldReturnZeroWhenSalaryBiggerThan10000() {
        BonusService service = new BonusService();
//        assertThrows(IllegalArgumentException.class, () ->
//                service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
        try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
            fail("Não lançou exceção!");
        } catch (Exception e) {
            assertEquals("Funcionário com salário acima de 10000 mil", e.getMessage());
        }
    }

    @Test
    public void bonusShouldReturnBonusCalcWhenSalaryEqualOrLessThan10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
