package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class CandleTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candle(10, 20, 20, 10, 10000, Calendar.getInstance());	
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta(){
		Candle candle = new Candle(10, 10, 5, 30, 10, Calendar.getInstance());
		
		
		assertEquals( true, candle.isAlta() );
	}

}
