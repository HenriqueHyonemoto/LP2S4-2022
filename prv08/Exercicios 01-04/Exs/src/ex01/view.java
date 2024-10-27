/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex01;
import javax.swing.JOptionPane;
/**
 *
 * @author Rick
 */
public class view {
      public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setNome(JOptionPane.showInputDialog("Digite seu Nome"));
        int[] notas = new int[2];
        double media = 0;
        for (int i = 0; 2 > i; i++) {
            notas[i] = Integer.parseInt(JOptionPane.showInputDialog("Nota da " + (i + 1) + "° prova"));
            media += notas[i];
        }
        aluno.setNotas(notas);
        JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNome()
                                          + "\nMédia: " + (media/2));
    }
}
