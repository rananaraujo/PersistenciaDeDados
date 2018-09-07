package ufc.qxd.persistencia;

import java.io.OutputStream;
import java.math.BigInteger;

public class LivroDeDrama extends Livro {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String capadura;

	public String getCapadura() {
		
			return capadura;

	}

	public void setCapadura(String zi) {
		this.capadura = zi;
	}

	public LivroDeDrama(String tipo, String nome, int qtd, String id, boolean capadura) {
		super(tipo, nome, qtd, id);
		// TODO Auto-generated constructor stub

	}

	public LivroDeDrama() {
		// TODO Auto-generated constructor stub
	}

}
