/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.heranca;

import java.util.Objects;

/**
 *
 * @author aluno
 */
public class Pessoa {
    String nome;
    
    
    
    
    public Pessoa(){   
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }
    
    public static void main (String[] args){
        System.out.println("--------//--------");
        
        Pessoa p = new Pessoa("Pessoa1");
        System.out.println("Pessoa: "+p.getNome());
        
        Pessoa p2 = new Pessoa("Pessoa2");   
        System.out.println("Pessoa: "+p2.getNome());
        
        
        System.out.println("Pessoa1 hashcode: "+p.getNome().hashCode());
        System.out.println("Pessoa2 hashcode: "+p2.getNome().hashCode());
        
        System.out.println("Equals?: "+p.getNome().equals(p2.getNome()));
        
        
        System.out.println("--------//--------"); 
         
        /*Aluno a = new Aluno ("AL111",7,"Aluno1");
        System.out.println("Aluno: "+a.getNome());
        System.out.println("N. Disc: "+a.getNumDisciplnas() );
        System.out.println("RA: "+a.getRA());
        
        System.out.println("--------//--------");
        
        Funcionario f = new Funcionario(1,1500.00,"Funcionario1");
        System.out.println("Funcionario: "+f.getNome());
        System.out.println("Salario:  "+f.getSalario() );
        System.out.println("Matricula: "+f.getNumMatricula());
        
        System.out.println("--------//--------");
        
        Professor pf = new Professor("Mister",12345,1500.00,"Prof1");
        System.out.println("Professor: "+pf.getNome());
        System.out.println("Titulo: "+pf.getTitulo());
        System.out.println("Salario: "+pf.getSalario());
        
        System.out.println("--------//--------");*/


    }
    

    
    
}
