package br.com.urna.entidades;

public class Candidato {

	public Candidato(String nome, String partido,String tipo , String numero) {
		this.nome = nome;
		this.partido = partido;
		this.numero = numero;
		this.tipo = tipo;
	}

	private String nome;
	
	private String partido;
	
	private String tipo;
	
	private String numero;
	
	private int votos = 0;

	public String getNome() {
		return nome;
	}

	public String getPartido() {
		return partido;
	}
	
	public String getTipo() {
		return tipo;
	}

	public String getNumero() {
		return numero;
	}
	
	public int getVotos() {
		return votos;
	}
	
	public void addVoto() {
		votos++;
	}
	
}
