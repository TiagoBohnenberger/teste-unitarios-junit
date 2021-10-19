package br.com.alura.tdd.enums;

import br.com.alura.tdd.interfaces.Strategy;

import java.math.BigDecimal;

public enum Desempenho implements Strategy {
    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    }, BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    }, OTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.20");
        }
    }
}
