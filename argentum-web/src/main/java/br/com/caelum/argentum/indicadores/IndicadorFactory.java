package br.com.caelum.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {
	
	private final String nomeMedia;
	private final String nomeIndicadorBase;
	
	public IndicadorFactory(String nomeMedia, String nomeIndicadorBase) {
		this.nomeMedia = nomeMedia;
		this.nomeIndicadorBase = nomeIndicadorBase;
	}
	
	public  Indicador defineIndicador() {
		
		if (nomeIndicadorBase.isEmpty() || nomeMedia.isEmpty())
			throw new IllegalArgumentException("A media e o indicador devem ser definidos");
		
		try{
			String pacote = "br.com.caelum.argentum.indicadores.";
			
			
			Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();
			
			Class<?> classeMedia = Class.forName(pacote + nomeMedia);
			Constructor<?> construtorMedia = classeMedia.getConstructor(Indicador.class);
			Indicador indicador = (Indicador) construtorMedia.newInstance(indicadorBase);
			return indicador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}	
