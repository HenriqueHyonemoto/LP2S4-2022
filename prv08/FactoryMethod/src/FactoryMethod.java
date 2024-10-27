public class FactoryMethod {
	
	public static void main(String[] args) {
		FactoryMethod fm = new FactoryMethod();
		
		fm.getCarro("Fiesta");   //Ford
		fm.getCarro("Ka");       //Ford
		fm.getCarro("EcoSport"); //Ford
		
		
		fm.getCarro("Palio"); //Fiat
		fm.getCarro("Uno");   //Fiat
		fm.getCarro("Argo");  //Fiat
		
		fm.getCarro("Civic");  //Honda
		fm.getCarro("City");   //Honda
		fm.getCarro("Accord"); //Honda
		
		fm.getCarro("Erro"); //Not Found test
	}
	public Carro getCarro(String Modelo) {
	if (Modelo == "Fiesta" || Modelo == "Ka" || Modelo == "EcoSport") {
		return new Ford();
	}else if(Modelo == "Palio" || Modelo == "Uno" || Modelo == "Argo"){
		return new Fiat();
	}else if(Modelo == "Civic" || Modelo == "City" || Modelo == "Accord"){
		return new Honda();
	}else {
		System.out.println("Marca NÃO encontrada");
	}
	return new Carro();
	}	
}


