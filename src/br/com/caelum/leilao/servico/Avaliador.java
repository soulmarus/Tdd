package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {
	
	private double maiorValor = Double.MIN_VALUE;
	private double menorValor = Double.MAX_VALUE;
	
	
	public void avalia(Leilao leilao) {
		leilao.getLances().forEach(lance -> mapeiaValores(lance));
	}
	
	public Double retornaMediaLances(Leilao leilao) {
		double valorMedio = 0;

		valorMedio = leilao.getLances()
				.stream()
				.mapToDouble(Lance::getValor)
				.average()
				.getAsDouble();
		
		return valorMedio;
	}

	private void mapeiaValores(Lance lance) {
		if (lance.getValor() > maiorValor) {
			maiorValor = lance.getValor();			
		} else if (lance.getValor() < menorValor) {
			menorValor = lance.getValor();
		}
		
	}

	public double getMaiorValor() {
		return maiorValor;
	}

	public void setMaiorValor(double maiorValor) {
		this.maiorValor = maiorValor;
	}

	public double getMenorValor() {
		return menorValor;
	}

	public void setMenorValor(double menorValor) {
		this.menorValor = menorValor;
	}
	
	 
}
