/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.abstratas;

/**
 *
 * @author aluno
 */
public class MySender extends AbstractEncodedMessageSender{
    @Override
    public String encode(String message){
            String ret = message;
    return ret;
 
    }
    
    public static void main(String[] args){
        AbstractEncodedMessageSender sender = new MySender();
        sender.sendMessage("HW!");
    
    
    //Classe anônima
    AbstractEncodedMessageSender otherSender = new AbstractEncodedMessageSender(){
        
        @Override
        public String encode(String message){
            String ret = message;
        return ret;
      
        }
        
        
    };
    
    
    otherSender.sendMessage("HW2!");
    
   System.out.println(sender.getClass());
   System.out.println(otherSender.getClass());
            
    }
}
