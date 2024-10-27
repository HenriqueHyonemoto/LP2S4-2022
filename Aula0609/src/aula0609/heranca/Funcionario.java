/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.heranca;

/**
 *
 * @author aluno
 */
public class Funcionario extends Pessoa{
    int numMatricula;
    double salario;
    
    public Funcionario(){
    }

    public Funcionario(int numMatricula, double salario, String nome) {
        super(nome);
        this.numMatricula = numMatricula;
        this.salario = salario;
    }
    
    

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
    return "Funcionario{" + "numMatricula=" + numMatricula + ", salario=" + salario + '}';
    }
    
    
 
    
}
