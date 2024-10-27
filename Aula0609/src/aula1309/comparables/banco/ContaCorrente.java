/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1309.comparables.banco;

/**
 *
 * @author aluno
 */
public class ContaCorrente implements Comparable<ContaCorrente> {
    String codigo;
    double saldo;
    
    public ContaCorrente(String codigo, double saldo) {
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int compareTo(ContaCorrente cc){
        if(this.saldo < cc.getSaldo()){
            return -1;
        }
        if(this.saldo > cc.getSaldo()){
            return 1;
        }else{
            return 0;
        }
    }
    
    public String toString() {
        return "ContaCorrente{" + "codigo=" + codigo + ", saldo=" + saldo + '}';
    }

    
    public static void main(String[] args){
        ContaCorrente cc1 = new ContaCorrente('123', 1000.0);
        //cc2
        //cc3
        //cc5
        
        List<ContaCorrente>contas = new ArrayList<>();
        contas.add(cc1);
    }


 

    
    
    
    
}
