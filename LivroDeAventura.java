package ufc.qxd.persistencia;

import java.math.BigInteger;
import java.util.ArrayList;

public class LivroDeAventura extends Livro {
	 private boolean ilustracao;
	public LivroDeAventura(String tipo, String nome, int qtd, String id) {
		super(tipo, nome, qtd, id);
		// TODO Auto-generated constructor stub
	}

	
	public LivroDeAventura() {
		// TODO Auto-generated constructor stub
	}

	public String isIlustracao() {
		String a = "Sim";
		return a;
	}

	public void setIlustracao() {
		this.ilustracao = true;
	}

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
