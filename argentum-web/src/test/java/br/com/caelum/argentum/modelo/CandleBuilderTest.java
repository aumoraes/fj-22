package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class CandleBuilderTest {
	
	@Test
	public void sequenciaSimplesDeNegociacoes() {
				
		CandleBuilder builder = new CandleBuilder();
		
		builder.comAbertura(40.5);
		builder.comFechamento(42.3);
		builder.comMinimo(39.8);
		builder.comMaximo(45.0);
		builder.comVolume(145234.20);
		builder.comData(new GregorianCalendar(2012, 8, 12, 0, 0, 0));
		
		Candlestick candle = builder.geraCandle();
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(145234.20, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void semNegociacoesGeraCandleComZeros() {
		Calendar hoje = Calendar.getInstance();
		
		CandleBuilder builder = new CandleBuilder();
		
		builder.comData(hoje);
		
		Candlestick candle = builder.geraCandle();
		
		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
	}
	
	@Test(expected=IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		CandleBuilder builder = new CandleBuilder();		
		builder.wasAllItensSetted();
	}	
	

}
