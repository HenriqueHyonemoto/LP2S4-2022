/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.heranca;

/**
 *
 * @author aluno
 */
public class Aluno extends Pessoa{
    
    String RA;
    int numDisciplnas;
    
    public Aluno(){
}

    public Aluno(String RA, int numDisciplnas, String nome) {
        super(nome);
        this.RA = RA;
        this.numDisciplnas = numDisciplnas;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public int getNumDisciplnas() {
        return numDisciplnas;
    }

    public void setNumDisciplnas(int numDisciplnas) {
        this.numDisciplnas = numDisciplnas;
    } 

    @Override
    public String toString() {
        return "Aluno{" + "RA=" + RA + ", numDisciplnas=" + numDisciplnas + '}';
    }
    
    
    
}
