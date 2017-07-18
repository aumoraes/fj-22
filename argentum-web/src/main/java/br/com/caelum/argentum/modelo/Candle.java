package br.com.caelum.argentum.modelo;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candle {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;
	
	public Candle(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		if(minimo > maximo){
			throw new IllegalArgumentException("Valor mínimo não pode ser maior que o valor máximo");
		}
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}
	
	public boolean isAlta() {
		return this.abertura <= this.fechamento;
	}
	
	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}		
		
	public double getAbertura() {
		return abertura;
	}
	public double getFechamento() {
		return fechamento;
	}
	public double getMinimo() {
		return minimo;
	}
	public double getMaximo() {
		return maximo;
	}
	public double getVolume() {
		return volume;
	}
	public Calendar getData() {
		return data;
	}
	public String getFormatedDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = getData().getTime();
		return sdf.format(date);
	}
	
	@Override
	public String toString() {
		return "[Abertura "+getAbertura()+", Fechamento "+getFechamento()+", Mínimo "+getMinimo()+", Máximo "+getMaximo()+", Volume "+getVolume()+", Data "+getFormatedDate()+"]";
	}
	
}
