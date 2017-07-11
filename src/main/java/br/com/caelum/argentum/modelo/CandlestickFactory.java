package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import java.util.List;

public class CandlestickFactory {
	
	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes){
		
		//double maximo = negociacoes.get(0).getPreco();
		//double minimo = negociacoes.get(0).getPreco();
		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			if(negociacao.getPreco() > maximo){
				maximo = negociacao.getPreco();
			}
			if( negociacao.getPreco() < minimo){
				minimo = negociacao.getPreco();
			}	
		}
		//double abertura = negociacoes.get(0).getPreco();
		//double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 :
		negociacoes.get(negociacoes.size() - 1).getPreco();
		minimo = negociacoes.isEmpty() ? 0 : minimo;
		 
		
		
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);	
	}
}
