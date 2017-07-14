package br.com.caelum.argentum.modelo;

import org.junit.Test;

public class SerieTemporalTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoAceitaCandleNula() {
		
		new SerieTemporal(null);
		
	}

}
