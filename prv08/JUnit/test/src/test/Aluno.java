package test;

public class Aluno {

	String nome, cf;
	double n1, n2, nf;

	public Aluno() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}

	public double getNf() {
		return nf;
	}

	public void setNf(double nf) {
		this.nf = nf;
	}

	public Aluno(String nome, String cf, double n1, double n2, double nf) {
		super();
		this.nome = nome;
		this.cf = cf;
		this.n1 = n1;
		this.n2 = n2;
		this.nf = nf;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", cf=" + cf + ", n1=" + n1 + ", n2=" + n2 + ", nf=" + nf + ", getNome()="
				+ getNome() + ", getCf()=" + getCf() + ", getN1()=" + getN1() + ", getN2()=" + getN2() + ", getNf()="
				+ getNf() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	


}
