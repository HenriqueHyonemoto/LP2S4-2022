/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1309.collections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aluno
 */
public class MapsTest {

    public static void main(String[] args) {
        String texto = "orem ipsum dolor sit amet, "
                + "consectetur adipisci elit, consectetur adipisci elit, "
                + "sed eiusmod tempor incidunt ut labore et dolore magna aliqua. "
                + "Ut enim ad minim veniam ";

        Map<String, Integer> contaPalavras = new HashMap<>();
        String tx[] = texto.split(" ");
        for (String palavra : tx) {
            if (contaPalavras.get(palavra) == null) {
                contaPalavras.put(palavra, new Integer(1));
            } else {
                Integer vezes = contaPalavras.get(palavra);
                vezes = new Integer(vezes + 1);
                contaPalavras.put(palavra, vezes);
            }
        }
        System.out.println(contaPalavras);
    }
}
