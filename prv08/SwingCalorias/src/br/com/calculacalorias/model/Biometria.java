/**
@author Rick
 */
package br.com.calculacalorias.model;

public class Biometria {

	protected float peso = 0;
	protected float altura = 0;
	protected int idade = 0;

	public Biometria(float peso, float altura, int idade) {
		super();
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
	}

	public Biometria() {
		super();
	}

	public float getPeso() {
		return peso;
	}

	
	public void setPeso(float peso) {
		this.peso = peso;
	}



	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getAltura() {
		return altura;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return "Biometria [peso=" + peso + ", altura=" + altura + ", idade=" + idade + "]";
	}



}
