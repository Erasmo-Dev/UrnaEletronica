package br.com.urna.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.urna.entidades.Candidato;

public class Controle {

	private List<Candidato> candidatos = new ArrayList<Candidato>() {
		{
			add(new Candidato("Roberto Santos", "PNC", "P", "28"));
			add(new Candidato("Julia Barra", "PCC", "P", "18"));
			add(new Candidato("Ymir Fritz", "PFY", "P", "90"));

			add(new Candidato("Julia Pão", "PNC", "V", "28289"));
			add(new Candidato("Maria do Morro", "PNC", "V", "90900"));
			add(new Candidato("Marilha do Carmo", "PNC", "V", "7070"));

			add(new Candidato("Mario Brother", "PCC", "V", "44444"));
			add(new Candidato("Ronaldo Fofomeno", "PCC", "V", "66655"));
			add(new Candidato("O bruxo Livre", "PCC", "V", "99909"));

			add(new Candidato("Eren Yeager", "PFY", "V", "33443"));
			add(new Candidato("Zeke Yeager", "PFY", "V", "33567"));
			add(new Candidato("Floch Forster", "PFY", "V", "00977"));
			add(new Candidato("Louise SeiLa", "PFY", "V", "11111"));
		}
	};

	private boolean bloquear = false;
	private int brancoP = 0;
	private int brancoV = 0;
	private int PNC = 0;
	private int PCC = 0;
	private int PFY = 0;
	private String rank = "Prefeito";
	private String numero = "";

	public void addDigito(String digito) {
		numero += digito;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public String getRank() {
		return rank;
	}

	public int getBrancoP() {
		return brancoP;
	}

	public void setBloquear(boolean bloquear) {
		this.bloquear = bloquear;
	}

	public boolean isBloquear() {
		return bloquear;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public int getPNC() {
		return PNC;
	}

	public int getPCC() {
		return PCC;
	}

	public int getPFY() {
		return PFY;
	}

	public int getBrancoV() {
		return brancoV;
	}

	public void mudarRank() {
		if (rank.equals("Prefeito")) {
			rank = "Vereador";
		} else {
			rank = "Prefeito";
		}
	}

	public Candidato buscar(String tipo) {
		for (Candidato candidato : candidatos) {
			if (candidato.getNumero().equals(numero) && candidato.getTipo().equals(tipo)) {
				return candidato;
			}
		}
		return null;
	}

	public void votar(Candidato candidato) {

		if (candidato == null) {
			if (rank.equals("Prefeito")) {
				brancoP++;
				mudarRank();
			} else if (rank.equals("Vereador")) {
				bloquear = true;
				brancoV++;
				mudarRank();
			}
		} else {
			for (Candidato candidatoVoto : candidatos) {
				if (candidatoVoto.equals(candidato)) {
					mudarRank();
					candidatoVoto.addVoto();
					if (candidato.getPartido().equals("PNC")) {
						PNC++;
					} else if (candidato.getPartido().equals("PCC")) {
						PCC++;
					} else {
						PFY++;
					}
				}
			}
		}
	}

}
