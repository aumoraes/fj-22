package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
	
	private double abertura;
	private boolean aberturaSetted = false;
	private double fechamento;
	private boolean fechamentoSetted = false;
	private double minimo;
	private boolean minimoSetted = false;
	private double maximo;
	private boolean maximoSetted = false;
	private double volume;
	private boolean volumeSetted = false;
	private Calendar data;
	private boolean dataSetted = false;
	
	
	public Candle geraCandle() {
		if (data == null) {
			throw new IllegalStateException("Data nao pode ser nula");
		}
		
		return new Candle(abertura, fechamento, minimo, maximo,
		volume, data);
	}
	
	public boolean wasAllItensSetted(){
		if( !aberturaSetted || !fechamentoSetted || !minimoSetted || !maximoSetted || !volumeSetted || !dataSetted){
			throw new IllegalStateException("Todos os itens devem ser definidos");	
		}
		return true;
	}
		
	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		this.aberturaSetted = true;
		return this;
	}
	
	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		this.fechamentoSetted = true;
		return this;
	}
	
	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		this.minimoSetted = true;
		return this;
	}
	
	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		this.maximoSetted = true;
		return this;
	}
	
	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		this.volumeSetted = true;
		return this;
	}
	
	public CandleBuilder comData(Calendar data) {
		this.data = data;
		this.dataSetted = true;
		return this;
	}
	
}
