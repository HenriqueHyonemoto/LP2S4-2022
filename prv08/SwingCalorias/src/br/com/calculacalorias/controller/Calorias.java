/**
@author Rick
 */
package br.com.calculacalorias.controller;

import br.com.calculacalorias.model.Biometria;

public class Calorias extends Biometria {

	float indice = 0;

	public Calorias(float peso, float altura, int idade) {
		super(peso, altura, idade);
	}

	public float calculaCalorias() {
		indice = (float) ((13.75 * peso) + (5*altura)-(6.76*idade)+66.5);

		return indice;
	}
}
