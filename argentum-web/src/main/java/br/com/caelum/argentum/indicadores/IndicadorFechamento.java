package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador{

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getFechamento();
		//media += serie.getCandle( posicao - i).getFechamento();
	}
	public String toString() {
		return "Fechamento";
	}

}
