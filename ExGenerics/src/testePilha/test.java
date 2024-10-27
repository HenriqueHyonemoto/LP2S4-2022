package testePilha;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import genericPilha.Pilha;

class test {

	@Test
	void test01() {
		Pilha<String> pilha = new Pilha<String>();
		pilha.empilhar("n1");
		pilha.empilhar("n2");
		pilha.empilhar("n3");
		pilha.empilhar("n4");
		
		System.out.println("Pilha: " + pilha.getpilha());
		
		pilha.desempilhar();
		System.out.println("Dsp Ultimo" + pilha.getpilha());
		
		
		pilha.desempilhar();
		System.out.println("Dsp Ultimo" + pilha.getpilha());
	}
	
	@Test
	void test02() {
		Pilha<Integer> pilha = new Pilha<Integer>();
		pilha.empilhar(1);
		pilha.empilhar(2);
		pilha.empilhar(3);
		pilha.empilhar(4);
		
		System.out.println("Pilha: " + pilha.getpilha());
		
		pilha.desempilhar();
		System.out.println("Dsp Ultimo" + pilha.getpilha());
		
		
		pilha.desempilhar();
		System.out.println("Dsp Ultimo" + pilha.getpilha());
	}

	
	@Test
	void test03() {
		Pilha<Double> pilha = new Pilha<Double>();
		pilha.empilhar(1.1);
		pilha.empilhar(2.2);
		pilha.empilhar(3.3);
		pilha.empilhar(4.4);
		
		System.out.println("Pilha: " + pilha.getpilha());
		
		pilha.desempilhar();
		System.out.println("Dsp Ultimo" + pilha.getpilha());
		
		
		pilha.desempilhar();
		System.out.println("Dsp Ultimo" + pilha.getpilha());
	}
	
}
