/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1309.collections.filme;





import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Filme {
    String nomeFilme;
    Genero genero;
    List<Ator>atores; //arraylist



    
    public Filme() {
        atores = new ArrayList<Ator>();
    }
    

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
    
    
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    @Override
    public String toString() {
        String ret = nomeFilme + "," + genero.getGenero();
        for(Ator a : atores){
            ret += ", " + a.getAtor();
        }
        return ret;
    }   
    
    public static void main(String[] args){
        Filme filme = new Filme();
        filme.setNomeFilme("Peaky Blinders");
        Genero genero = new Genero();
        genero.setGenero("Ação");
        filme.setGenero(genero);
        
        Ator at1 = new Ator("Arthur");
        Ator at2 = new Ator("Thomas");
        
        filme.getAtores().add(at1);
        filme.getAtores().add(at2);
        System.out.println(filme);
        
        Filme filme2 = new Filme();
        filme2.setNomeFilme("Breaking Bad");
        Genero genero2 = new Genero();
        genero2.setGenero("Drama");
        filme2.setGenero(genero2);
        
        Ator at3 = new Ator("Walter");
        Ator at4 = new Ator("Jesse");
        
        filme2.getAtores().add(at3);
        filme2.getAtores().add(at4);
        System.out.println(filme2);
        
        
        
            
        
    }
    
}
