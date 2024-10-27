package genericTestes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import genericExemplo.ImprimirDouble;
import genericExemplo.ImprimirGeneric;
import genericExemplo.ImprimirGenericJoker;
import genericExemplo.ImprimirInteger;
import genericExemplo.ImprimirString;

class ExemploTeste {
	
	
	@Test
	void test01() {
		ImprimirInteger impressaoI1 = new ImprimirInteger(777);
		impressaoI1.imprimir();
	}
	@Test
	void test02() {
		ImprimirDouble impressaoD1 = new ImprimirDouble(777.77);
		impressaoD1.imprimir();
	}
	@Test 
	void test03() {
		ImprimirString impressaoS1 = new ImprimirString("IFSP");
		impressaoS1.imprimir();
	}
	@Test
	void test04() {
		ImprimirGeneric<Integer> impressaoIG1 = new ImprimirGeneric<>(777);
		impressaoIG1.imprimir();
	}
	
	@Test
	void test05() {
		ImprimirGeneric<Double> impressaoDG1 = new ImprimirGeneric<>(777.77);
		impressaoDG1.imprimir();
	}
	
	@Test 
	void test06() {
		ImprimirGeneric<String> impressaoSG1 = new ImprimirGeneric<String>("IFSP");
		impressaoSG1.imprimir();
	}
	
	@Test 
	void test07() {
		List<Integer> intList = new ArrayList<>();
		intList.add(2022);
		ImprimirGenericJoker.imprimir(intList);
	}
	@Test
	void test08() {
		List<Double> intList = new ArrayList<>();
		intList.add(2022.10);
		ImprimirGenericJoker.imprimir(intList);
	}
	@Test
	void test09() {
		List<String> intList = new ArrayList<>();
		intList.add("test message 09");
		ImprimirGenericJoker.imprimir(intList);
	}
	
}
