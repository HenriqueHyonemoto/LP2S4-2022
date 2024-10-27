/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1309.collections.filme;

/**
 *
 * @author aluno
 */
public class Genero {
    String genero;

    public Genero(String genero) {
        this.genero = genero;
    }

    public Genero() {
    }

    

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Genero{" + "genero=" + genero + '}';
    }
    
    
    
}
