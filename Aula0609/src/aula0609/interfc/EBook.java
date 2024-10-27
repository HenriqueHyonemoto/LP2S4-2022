/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.interfc;

/**
 *
 * @author aluno
 */
public class EBook implements Sellable{
    
    @Override
            public String description(){
               return "Ebook-ESSS"; 
            }
    @Override
            public int listPrice(){
                return 290;
            }   
    @Override
        public int lowestPrice(){
            return 188;
        }
    
    

    
}
