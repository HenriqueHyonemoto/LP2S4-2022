/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author Rick
 */
public class View {
     public static void main(String[] args) {
         
    
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        while (JOptionPane.showConfirmDialog(null, "Deseja adicionar mais um aluno?", 
                "Aluno", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Aluno aluno = new Aluno();
                    aluno.setNome(JOptionPane.showInputDialog("Digite seu nome"));
                    int[] notas = new int[2];
                    for (int i = 0; 2 > i; i++) {
                    notas[i] = Integer.parseInt(JOptionPane.showInputDialog("Nota da " + (i + 1) + "° prova"));
            }
            aluno.setNotas(notas);
            alunos.add(aluno);
        }
        for (int i = 0; alunos.size() > i; i++) {
            Aluno alunoAtual = alunos.get(i);
            double media = 0;
            for (int j = 0; alunoAtual.getNotas().length > j; j++) {
                media += alunoAtual.getNotas()[j];
            }
            media = media / 2;
            JOptionPane.showMessageDialog(null, "Aluno: " + alunoAtual.getNome()
                                              + "\nMédia: " + media);
        }
}
}
