package ufc.qxd.persistencia;

import java.math.BigInteger;
import java.util.ArrayList;

public class LivroDeComedia extends Livro {
	public String capaBrochura;
	public LivroDeComedia(String tipo, String nome, int qtd, String id, boolean capaBrochura) {
		super(tipo, nome, qtd, id);
		// TODO Auto-generated constructor stub
	}



	public LivroDeComedia() {
		// TODO Auto-generated constructor stub
	}



	private static final long serialVersionUID = 1L;

	public String getCapaBrochura() {
		
			return capaBrochura;
		}

	

	public void setCapaBrochura(String pyh) {
		this.capaBrochura = pyh;
	}

}
