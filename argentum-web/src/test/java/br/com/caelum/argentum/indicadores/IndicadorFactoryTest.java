package br.com.caelum.argentum.indicadores;

import org.junit.Test;

public class IndicadorFactoryTest {

	@Test(expected=IllegalArgumentException.class)
	public void tentaCriarUmIndicadorSemMediaOuBase() {
		String nomeMedia = "";
		String nomeIndicadorBase = "";
		IndicadorFactory indicadorFactory = new IndicadorFactory(nomeMedia, nomeIndicadorBase);
		indicadorFactory.defineIndicador();
		
	}

}
