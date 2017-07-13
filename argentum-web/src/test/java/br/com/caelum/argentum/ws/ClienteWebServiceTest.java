package br.com.caelum.argentum.ws;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class ClienteWebServiceTest {

	@Test
	public void temUmaUrlDefinidaParaOhWebService() {
		String url_webservice = ClienteWebService.URL_WEBSERVICE; 
		Assert.assertNotNull(url_webservice);
		Assert.assertFalse( url_webservice.length() == 0 );
	}
	
	@Test
	public void abreUmaConexao() throws IOException{
		HttpURLConnection connection = null;
		
		URL url = new URL( ClienteWebService.URL_WEBSERVICE );
		connection = (HttpURLConnection) url.openConnection();
		
		Assert.assertTrue( connection.getResponseCode() == 200 );
	}
	
	@Test
	public void retornaPeloMenosUmaNegociacaoBaseadoNoWebService() throws IOException{
		ClienteWebService cliente = new ClienteWebService();
		
		List<Negociacao> negociacoes = cliente.getNegociacoes();
		
		Assert.assertTrue( negociacoes.size() > 0 );
	}

}
