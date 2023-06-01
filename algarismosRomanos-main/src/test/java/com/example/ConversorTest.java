package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConversorTest {
    Conversor c;

    @BeforeEach
    void setUp() {
        c = new Conversor();
    }
    
    @Test
    public void verificarConversaoParaInteiro() {
        assertEquals(1937, c.romanoParaInteiro("MCMXXXVII"), "O resultado esperado não é igual ao obtido!");
    }

    @Test
    public void verificarConversaoParaRomano() {
        assertEquals("XVIII", c.inteiroParaRomano(18), "O resultado esperado não é igual ao obtido!");
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "0",
        "4000",
        "5000",
        "-10",
        "-23958",
        "90000",
        "562364",
        "-28192",
        "100000000",
        "-1"
    })
    public void verificarValorValidoNaConveraoParaRomano(int valorx) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            c.inteiroParaRomano(valorx);
        });
        assertEquals("Não possível fazer a conversão, porque o valor adicionado é inválido! (Deve ser um número inteiro entre 1 e 3999)", exception.getMessage());
    }


}
