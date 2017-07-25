package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	public int intervalo = 3;
	private Indicador outroIndicador;

	public MediaMovelPonderada(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}

	public double calcula(int posicao, SerieTemporal serie) {

		if (serie.size() < intervalo) {
			throw new IllegalArgumentException("Não há candles suficiente para o interfalo escolhido");
		}
		

		int pesoMaximo = 3;
		// divisor é a soma de todos os pesos
		int divisor = 0;

		double soma = 0;
		for (int i = 0; i < intervalo; i++) {
			soma += outroIndicador.calcula(posicao - i, serie) * pesoMaximo;

			divisor += pesoMaximo;
			if (pesoMaximo != 0) {
				pesoMaximo--;
			}

		}

		soma = soma / divisor;
		return soma;

	}

	public String toString() {
		return "MMP de Fechamento " + outroIndicador.toString();
	}

}
