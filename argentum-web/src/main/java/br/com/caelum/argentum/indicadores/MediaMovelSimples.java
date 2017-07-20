package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {
	
	/* (non-Javadoc)
	 * @see br.com.caelum.argentum.indicadores.Indicador#calcula(int, br.com.caelum.argentum.modelo.SerieTemporal)
	 */
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		
		int intervalo = 3;
		
		double media = 0;
		for (int i = 0; i < intervalo; i++) {
			media += serie.getCandle( posicao - i).getFechamento();
		}
		media = media / intervalo;
		return media;
		
	}
	
	public String toString() {
		return "MMS de Fechamento";
	}
}
