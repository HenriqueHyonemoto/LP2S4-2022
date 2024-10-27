package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import filaGeneric.Fila;

class test {

	@Test
	void test01() {
		Fila<String> fila = new Fila<String>();
		fila.insereFila("n1");
		fila.insereFila("n2");
		fila.insereFila("n3");
		fila.insereFila("n4");
		
		System.out.println("Fila: " + fila.getFila());
		
		fila.removeFila();
		System.out.println("Primeiro Sai:" + fila.getFila());
		
		
		fila.removeFila();
		System.out.println("Primeiro Sai:" + fila.getFila());
	}
	
	@Test
	void test02() {
		Fila<Double> fila = new Fila<Double>();
		fila.insereFila(1.1);
		fila.insereFila(2.2);
		fila.insereFila(3.3);
		fila.insereFila(4.4);
		
		System.out.println("Fila: " + fila.getFila());
		
		fila.removeFila();
		System.out.println("Primeiro Sai: " + fila.getFila());
		
		
		fila.removeFila();
		System.out.println("Primeiro Sai: " + fila.getFila());
	}

	
	@Test
	void test03() {
		Fila<Integer> fila = new Fila<Integer>();
		fila.insereFila(1);
		fila.insereFila(2);
		fila.insereFila(3);
		fila.insereFila(4);
		
		System.out.println("Fila: " + fila.getFila());
		
		fila.removeFila();
		System.out.println("Primeiro Sai: " + fila.getFila());
		
		
		fila.removeFila();
		System.out.println("Primeiro Sai: " + fila.getFila());
	}
	
}
