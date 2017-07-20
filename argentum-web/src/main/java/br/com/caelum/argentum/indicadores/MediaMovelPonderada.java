package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador{
	
	public double calcula(int posicao, SerieTemporal serie) {
		
		int intervalo = 3;
		int pesoMaximo = 3;
		//divisor é a  soma de todos os pesos
		int divisor = 0;
		
		double media = 0;
		for (int i = 0; i < intervalo; i++) {
			media += serie.getCandle( posicao - i).getFechamento()*pesoMaximo;
			divisor += pesoMaximo;
			pesoMaximo--;
		}
		
		media = media / divisor;
		return media;
		
	}
	
	public String toString() {
		return "MMP de Fechamento";
	}
	
}
