/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1309.collections;


import static java.lang.reflect.Array.set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author aluno
 */

public class SetsTest {
    public static void main(String[] args){ 
        //Set<String> set = new HashSet<>();       // comandos para testar
        //Set<String> set = new TreeSet<>();       // ordena pelo metodo compareTo()
        Set<String> set = new LinkedHashSet<>(); //ordem de inserção
        
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        set.add("Andre");
        set.add("Marcos");
        set.add("Patricia");
        set.add("Juliana");
        set.add("Geovana");
        set.add("Geraldo");
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set);
        System.out.println(set.add("Andres"));
        System.out.println(set);
        System.out.println(set.contains("Geraldo"));
        set.remove("Andre");
        System.out.println(set);
        
        
        
    }
}
