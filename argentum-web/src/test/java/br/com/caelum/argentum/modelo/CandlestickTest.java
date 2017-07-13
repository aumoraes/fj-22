package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());	
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta(){
		Candlestick candle = new Candlestick(10, 10, 5, 30, 10, Calendar.getInstance());
		
		
		assertEquals( true, candle.isAlta() );
	}

}
