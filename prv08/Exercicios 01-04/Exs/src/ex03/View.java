/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
/**
 *
 * @author Rick
 */
public class View {
     public static void main(String[] args) {
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        File file = new File("./Alunos.csv");
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bf.readLine()) != null) {
                Aluno aluno = new Aluno();
                String[] DivLn = line.split(",");
                aluno.setNome(DivLn[0]);
                int[] notas = new int[2];
                for (int i = 0; 2 > i; i++) {
                    notas[i] = Integer.parseInt(DivLn[i + 1]);
                }
                aluno.setNotas(notas);
                alunos.add(aluno);
            }
            bf.close();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
