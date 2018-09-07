package ufc.qxd.persistencia;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;

public class Livro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String tipo;
	public String nome;
	protected int qtd;
	protected String id;
	
	public Livro(String tipo, String nome, int qtd, String id) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.qtd = qtd;
		this.id = id;

	}
	
	

	public Livro() {
		super();
		
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int hb) {
		this.qtd = hb;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

}
