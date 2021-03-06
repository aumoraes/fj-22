package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimplesTest {

	@Test
	public void sequenciaSimplesDeCandles(){
		
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
		Indicador mms = new MediaMovelSimples(new IndicadorFechamento());
	
		assertEquals(2.0, mms.calcula(2, serie), 0.00001);
		assertEquals(3.0, mms.calcula(3, serie), 0.00001);
		assertEquals(10.0/3, mms.calcula(4, serie), 0.00001);
		assertEquals(11.0/3, mms.calcula(5, serie), 0.00001);
		assertEquals(4.0, mms.calcula(6, serie), 0.00001);
		assertEquals(13.0/3, mms.calcula(7, serie), 0.00001);
		assertEquals(4.0, mms.calcula(8, serie), 0.00001);
		
	}
	
	
	@Test
	public void sequenciaSimplesDeCandlesComIndicadorDeAbertura(){
		
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
		Indicador mms = new MediaMovelSimples( new IndicadorAbertura());
	
		assertEquals(2.0, mms.calcula(2, serie), 0.00001);
		assertEquals(3.0, mms.calcula(3, serie), 0.00001);
		assertEquals(10.0/3, mms.calcula(4, serie), 0.00001);
		assertEquals(11.0/3, mms.calcula(5, serie), 0.00001);
		assertEquals(4.0, mms.calcula(6, serie), 0.00001);
		assertEquals(13.0/3, mms.calcula(7, serie), 0.00001);
		assertEquals(4.0, mms.calcula(8, serie), 0.00001);
		
	}
	
	@Test
	public void sequenciaSimplesDeCandlesComIndicadorDeMaximo(){
		
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
		Indicador mms = new MediaMovelSimples( new IndicadorMaximo());
	
		assertEquals(2.0, mms.calcula(2, serie), 0.00001);
		assertEquals(3.0, mms.calcula(3, serie), 0.00001);
		assertEquals(10.0/3, mms.calcula(4, serie), 0.00001);
		assertEquals(11.0/3, mms.calcula(5, serie), 0.00001);
		assertEquals(4.0, mms.calcula(6, serie), 0.00001);
		assertEquals(13.0/3, mms.calcula(7, serie), 0.00001);
		assertEquals(4.0, mms.calcula(8, serie), 0.00001);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sequenciaDeCandlesOndeOIntervaloEhMaiorQueONumeroDeCandles() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(7);
		
		Indicador mms = new MediaMovelSimples(new IndicadorFechamento());
		
		assertEquals(2.0, mms.calcula(2, serie), 0.00001);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void consultandoUmIndiceQueNaoExisteNaSerieTemporal() {
		
		SerieTemporal serie = GeradorDeSerie.criaSerie(3, 2, 1);
		
		int posicao = serie.getUltimaPosicao() + 1;
		
		Indicador mms = new MediaMovelSimples( new IndicadorFechamento());
		
		assertEquals(14.0/6, mms.calcula(posicao, serie), 0.00001);
	}
	
	

}
