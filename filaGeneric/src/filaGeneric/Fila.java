package filaGeneric;

import java.util.ArrayList;

public class Fila<T> {

	private ArrayList<T> fila = new ArrayList<T>();

	public void insereFila(T t) {
		fila.add(t);
	}



	public void removeFila() {
		fila.remove(0);
	}

public boolean vazia() {
	return fila.size()==0;
}

public ArrayList<T> getFila(){
	return fila;
}

}