package com.example;

import java.util.HashMap;

public class Conversor {

    String inteiroParaRomano(int valor) {
        String[] unidadeDeMilhar = { "", "M", "MM", "MMM" };
        String[] centenas = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] dezenas = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] unidades = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        if(valor <= 0 || valor > 3999){
            throw new IllegalArgumentException("Não possível fazer a conversão, porque o valor adicionado é inválido! (Deve ser um número inteiro entre 1 e 3999)");
        }
        else{
            return unidadeDeMilhar[valor / 1000] + centenas[(valor % 1000) / 100] + dezenas[(valor % 100) / 10]
                    + unidades[valor % 10];
        }
    }

    int romanoParaInteiro(String s) {
        // Cria um hash map vazio.
        HashMap<Character, Integer> map = new HashMap<>();

        // Inserindo os valores no map.
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Criando uma variavel para receber o valor da conversão
        int resultado = 0;
        int repeticao = 0;

        // Inicializa o loop para iterar a string que contem o numero romano
        for (int i = 0; i < s.length(); i++) {

            // VErificando se o valor atual
            // não é menor que o anterior
            if (i > 0
                    && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                resultado += map.get(s.charAt(i))
                        - 2 * map.get(s.charAt(i - 1));
            } else {
                resultado += map.get(s.charAt(i));
            }
        }
        // Retorna o inteiro que representa o numero romano informado.
        return resultado;
    }

}
