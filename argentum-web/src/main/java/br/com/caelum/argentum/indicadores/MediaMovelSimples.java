package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {
	
	
	private int intervalo = 3;
	private final Indicador outroIndicador;

	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}
	
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		
		if(serie.size() < intervalo){
			throw new IllegalArgumentException("Não há candles suficiente para o interfalo escolhido");	
		}
		
		double soma = 0;
		for (int i = 0; i < intervalo; i++) {
			soma += outroIndicador.calcula(posicao - i, serie);
		}
		
		soma = soma / intervalo;
		return soma;
		
	}
	
	public String toString() {
		return "MMS de Fechamento " + outroIndicador.toString();
	}
}
