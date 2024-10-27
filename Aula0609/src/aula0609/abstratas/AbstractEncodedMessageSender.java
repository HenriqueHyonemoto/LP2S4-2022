/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0609.abstratas;

/**
 *
 * @author aluno
 */
public abstract class AbstractEncodedMessageSender {
    
    public abstract String encode(String message);
    
    public void sendMessage(String message){
        System.out.println("encode message first");
        String encoded = encode(message);
        System.out.println("sending message...");
        System.out.println(encoded);
        System.out.println("message sent");
    }
    
    
    
}
