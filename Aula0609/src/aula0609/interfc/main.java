/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.interfc;

/**
 *
 * @author aluno
 */
public class main {
    
    public static void main (String[] args){
 EBook e1 = new EBook();
 e1.description();
 e1.listPrice();
 e1.lowestPrice();
 
        System.out.println(e1.description());
        System.out.println(e1.listPrice());
        System.out.println(e1.lowestPrice());
        
        TraditionalBook t1 = new TraditionalBook();
        t1.description();
        t1.listPrice();
        t1.lowestPrice();
        t1.weight();
        t1.isHazardous();
        
        System.out.println(t1.description());
        System.out.println(t1.listPrice());
        System.out.println(t1.lowestPrice());
        System.out.println(t1.weight());
        System.out.println(t1.isHazardous());

    
    }
    
}
