package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryComUmaNegociacaoApenas {
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(49.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(53.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1,negociacao2, negociacao3, negociacao4 );
		//List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());
	}
}

