package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandleFactory {
	
	public Candle constroiCandleParaData(Calendar data, List<Negociacao> negociacoes){
		
		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			double preco = negociacao.getPreco();
			if(preco > maximo){
				maximo = preco;
			}
			if( preco < minimo){
				minimo = preco;
			}	
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 :
		negociacoes.get(negociacoes.size() - 1).getPreco();
		minimo = negociacoes.isEmpty() ? 0 : minimo;
		
		return new Candle(abertura, fechamento, minimo, maximo, volume, data);	
	}

	public List<Candle> constroiCandles(List<Negociacao> todasNegociacoes) {
		
		Collections.sort(todasNegociacoes);
		
		List<Candle> candles = new ArrayList<Candle>();
		
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		
		Calendar dataAtual = todasNegociacoes.get(0).getData();
		
		for (Negociacao negociacao : todasNegociacoes) {
			// se não for mesmo dia, fecha candle e reinicia variáveis
			if ( !negociacao.isMesmoDia( dataAtual ) ) {
				
				criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
				
			}
			negociacoesDoDia.add(negociacao);
		}
		
		// adiciona último candle
		criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);

		
		return candles;
	}

	private void criaEGuardaCandle(List<Candle> candles, List<Negociacao> negociacoesDoDia, Calendar dataAtual) {
//		Candle candleDoDia = constroiCandleParaData(dataAtual,
//		negociacoesDoDia);
		CandleBuilder cb = new CandleBuilder();
		
		cb.comAbertura(negociacoesDoDia.get(0).getPreco());
		cb.comFechamento( negociacoesDoDia.get( negociacoesDoDia.size() - 1 ).getPreco());
		cb.comData(dataAtual);
		
		double volume = 0;
		double maximo = 0;
		double minimo = 0;
		for (Negociacao negociacao : negociacoesDoDia) {
			volume += negociacao.getVolume();
			
			double preco = negociacao.getPreco();
			if(preco > maximo){
				maximo = preco;
			}
			if( preco < minimo){
				minimo = preco;
			}	
		}
		
		cb.comMaximo(maximo);
		cb.comMinimo(minimo);
		cb.comVolume(volume);
		
		Candle candleDoDia = cb.geraCandle();
		candles.add(candleDoDia);
	}
}
