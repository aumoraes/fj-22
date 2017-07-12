package br.com.caelum.argentum.reader;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.xstream.converters.ConversionException;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() throws FileNotFoundException, IOException {
		String xmlDeTeste = "<list>" +
								"<negociacao>" +
									"<preco>43.5</preco>" +
									"<quantidade>1000</quantidade>" +
									"<data>" +
										"<time>1322233344455</time>" +
									"</data>" +
								"</negociacao>" +
							"</list>";
		
		
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals( 1 , negociacoes.size() );
		Assert.assertEquals( 43.5 , negociacoes.get(0).getPreco(), 0.00001);
		Assert.assertEquals( 1000 , negociacoes.get(0).getQuantidade(), 0.00001);
		
	}
	
	@Test
	public void carregaArquivoXmlComUmaNegociacaoEmListaUnitaria() throws FileNotFoundException, IOException {

		String content = "";
		try (BufferedReader br = new BufferedReader(new FileReader("negociacao.xml"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	content += line+"\n";
		    }
		}
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(content.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals( 350 , negociacoes.size() );
		Assert.assertEquals( 50.0 , negociacoes.get(0).getPreco(), 0.00001);
		Assert.assertEquals( 1176 , negociacoes.get(0).getQuantidade(), 0.00001);
		
	}
	
	@Test
	public void carregaXmlComZeroNegociacoes() {
		String xmlDeTesteVazio = "<list></list>";	
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTesteVazio.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		
		Assert.assertEquals( 0 , negociacoes.size() );
		
	}
	
	@Test
	public void carregaXmlComPrecoNaoDefinido() {
		String xmlDeTeste = "<list>" +
								"<negociacao>" +
									//"<preco></preco>" +
									"<quantidade>1000</quantidade>" +
									"<data>" +
										"<time>1322233344455</time>" +
									"</data>" +
								"</negociacao>" +
							"</list>";
		
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);

		Assert.assertEquals( 0.0 , negociacoes.get(0).getPreco(), 0.00001 );
			
	}
	
	@Test(expected=ConversionException.class)
	public void carregaXmlComPrecoVazio() {
		String xmlDeTeste = "<list>" +
								"<negociacao>" +
									"<preco></preco>" +
									"<quantidade>1000</quantidade>" +
									"<data>" +
										"<time>1322233344455</time>" +
									"</data>" +
								"</negociacao>" +
							"</list>";
		
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

		leitor.carrega(xml);
			
	}
	
	@Test
	public void carregaXmlComVariasNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
								"<negociacao>" +
									"<preco>50.0</preco>" +
									"<quantidade>10</quantidade>" +
									"<data>" +
										"<time>1322233344455</time>" +
									"</data>" +
								"</negociacao>" +
								"<negociacao>" +
									"<preco>60.0</preco>" +
									"<quantidade>10</quantidade>" +
									"<data>" +
										"<time>1322233344455</time>" +
									"</data>" +
								"</negociacao>" +
								"<negociacao>" +
									"<preco>70.5</preco>" +
									"<quantidade>10</quantidade>" +
									"<data>" +
										"<time>1322233344455</time>" +
									"</data>" +
								"</negociacao>" +									
							"</list>";
		
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals( 3 , negociacoes.size() );
		Assert.assertEquals( 50.0 , negociacoes.get(0).getPreco(), 0.00001);
		Assert.assertEquals( 10 , negociacoes.get(0).getQuantidade(), 0.00001);
		Assert.assertEquals( 500.0 , negociacoes.get(0).getVolume(), 0.00001);
		Assert.assertEquals( 60.0 , negociacoes.get(1).getPreco(), 0.00001);
		Assert.assertEquals( 10 , negociacoes.get(1).getQuantidade(), 0.00001);
		Assert.assertEquals( 600.0 , negociacoes.get(1).getVolume(), 0.00001);		
		Assert.assertEquals( 70.5 , negociacoes.get(2).getPreco(), 0.00001);
		Assert.assertEquals( 10 , negociacoes.get(2).getQuantidade(), 0.00001);
		Assert.assertEquals( 705.0 , negociacoes.get(2).getVolume(), 0.00001);
		
	}

}
