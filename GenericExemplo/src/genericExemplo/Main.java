package genericExemplo;

public class Main {
	
	
public static void main(String[] args) {
	ImprimirInteger impressaoI1 = new ImprimirInteger(777);
	impressaoI1.imprimir();
	
	ImprimirDouble impressaoD1 = new ImprimirDouble(777.77);
	impressaoD1.imprimir();
	
	ImprimirString impressaoS1 = new ImprimirString("IFSP");
	impressaoS1.imprimir();
	
	ImprimirGeneric<Integer> impressaoIG1 = new ImprimirGeneric<>(777);
	impressaoIG1.imprimir();
	ImprimirGeneric<Double> impressaoDG1 = new ImprimirGeneric<>(777.77);
	impressaoDG1.imprimir();
	ImprimirGeneric<String> impressaoSG1 = new ImprimirGeneric<String>("IFSP");
	impressaoSG1.imprimir();
	
}

}
