package br.com.caelum.argentum.reader;

import java.io.InputStream;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXML {
	
	@SuppressWarnings("unchecked")
	public List<Negociacao> carrega(InputStream inputStream){
		XStream stream = new XStream(new DomDriver());
		List<Negociacao> negociacoes = null;
		try {
			stream.autodetectAnnotations(true);
			stream.alias("negociacao", Negociacao.class);
			negociacoes = (List<Negociacao>) stream.fromXML(inputStream);	
		} catch (   ConversionException ce ) {
			throw ce;
		}
		
		
		
		return negociacoes;
	}
	
}
