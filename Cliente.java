package ufc.qxd.persistencia;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Cliente  {
	private String nome;
	private String cpf;
	private String dantaNascimento;
	private String endereco;
	
	public Cliente(String nome, String cpf, String dantaNascimento, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dantaNascimento = dantaNascimento;
		this.endereco = endereco;

	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf2) {
		this.cpf = cpf2;
	}

	public String getDantaNascimento() {
		return dantaNascimento;
	}

	public void setDantaNascimento(String dantaNascimento) {
		this.dantaNascimento = dantaNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String sc) {
		this.nome = sc;
	}
	
	
}
