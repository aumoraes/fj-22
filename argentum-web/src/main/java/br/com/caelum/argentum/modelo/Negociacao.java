package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("negociacao")
public class Negociacao implements Comparable<Negociacao>{
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("Data nao pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
		
	public double getVolume() {
		return preco * quantidade;
	}
	
	public double getPreco() {
		return preco;
	}
	

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}
	
	public String getFormatedDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = getData().getTime();
		return sdf.format(date);
	}

	public boolean isMesmoDia(Calendar agora) {

		return this.data.get(Calendar.DAY_OF_MONTH) == agora.get(Calendar.DAY_OF_MONTH) &&
			   this.data.get(Calendar.MONTH) == agora.get(Calendar.MONTH) &&
			   this.data.get(Calendar.YEAR) == agora.get(Calendar.YEAR);
	}
	
	@Override
	public String toString() {
		return "Negociacao [preco=" + preco + ", quantidade=" + quantidade + ", data=" + getFormatedDate() + "]";
	}

	@Override
	public int compareTo(Negociacao o) {
		
		return this.data.compareTo(o.getData());
	}
	
}
