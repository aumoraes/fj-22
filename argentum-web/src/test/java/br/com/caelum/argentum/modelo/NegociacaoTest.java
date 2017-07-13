package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;



public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoEhImutavel() {
		
		// se criar um negocio no dia 15...
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.DAY_OF_MONTH, 15);
		
		Negociacao n = new Negociacao(10, 5, c);
		
		// ainda que eu tente mudar a data para 20...
		// Retorna um clone.
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		// ele continua no dia 15.
		assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula(){
		new Negociacao(10, 5, null);
	}
	
	@Test
	public void mesmoMilissegundoEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorasDiferentesEhNoMesmoDia() {
		Calendar manha = new GregorianCalendar(2017, 07, 12, 8, 30);
		Calendar tarde = new GregorianCalendar(2017, 07, 12, 15, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, manha);	
		assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		Calendar maio = new GregorianCalendar(2017, 05, 12, 8, 30);
		Calendar junho = new GregorianCalendar(2017, 07, 12, 15, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, maio);
		assertFalse(negociacao.isMesmoDia(junho));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
		Calendar anoAnterior = new GregorianCalendar(2016, 07, 12, 8, 30);
		Calendar anoAtual = new GregorianCalendar(2017, 07, 12, 15, 30);
		Negociacao negociacao = new Negociacao(40.0, 100, anoAnterior);
		assertFalse(negociacao.isMesmoDia(anoAtual));
	}
	

}
