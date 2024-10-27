package genericExemplo;

public class ImprimirGeneric<T> {
	T algoParaImprimir;

	public ImprimirGeneric(T algoParaImprimir) {
		this.algoParaImprimir = algoParaImprimir;
	}

	public void imprimir() {
		System.out.println(algoParaImprimir);
		}
}
