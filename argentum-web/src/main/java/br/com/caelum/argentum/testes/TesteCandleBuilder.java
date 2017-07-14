package br.com.caelum.argentum.testes;

import java.util.GregorianCalendar;

import br.com.caelum.argentum.modelo.CandleBuilder;
import br.com.caelum.argentum.modelo.Candle;

public class TesteCandleBuilder {

	public static void main(String[] args) {
		
		
		CandleBuilder builder = new CandleBuilder();
		builder.comAbertura(40.5);
		builder.comFechamento(42.3);
		builder.comMinimo(39.8);
		builder.comMaximo(45.0);
		builder.comVolume(145234.20);
		builder.comData(new GregorianCalendar(2012, 8, 12, 0, 0, 0));
		
		Candle candle = builder.geraCandle();
		
		System.out.println( candle.toString() );
		
		

	}

}
