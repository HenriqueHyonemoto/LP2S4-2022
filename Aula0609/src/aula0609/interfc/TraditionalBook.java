/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.interfc;

/**
 *
 * @author aluno
 */
public class TraditionalBook implements Transportable, Sellable{
    @Override
    public String description(){
        return "Livro PSSS";
    }
    
    @Override
    public int listPrice(){
        return 97;
    }
    
    @Override
    public int lowestPrice(){
        return 23;
    }
    
    @Override
    public int weight(){
        return 238;
    }
    
    @Override
    public boolean isHazardous(){
        return false;
    }
}
