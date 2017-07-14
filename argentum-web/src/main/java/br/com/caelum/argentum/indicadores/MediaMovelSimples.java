package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples {
	
	public double calcula(int posicao, SerieTemporal serie) {
		
		int intervalo = 3;
		
		double media = 0;
		for (int i = 0; i < intervalo; i++) {
			media += serie.getCandle( posicao - i).getFechamento();
		}
		media = media / intervalo;
		return media;
		
	}
}
