/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.heranca;

/**
 *
 * @author aluno
 */
public class Professor extends Funcionario{
    String titulo;
    
    public Professor(){
    }

    public Professor(String titulo, int numMatricula, double salario, String nome) {
        super(numMatricula, salario, nome);
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
        @Override
    public String toString() {
        return "Professor{" + "titulo=" + titulo + '}';
    }

    /*public static void main(String[] args){
        
        Professor p = new Professor("Nome Prof",12345,1500.00,"mestre");
        
        System.out.println(p);
    }*/
  



    
}
