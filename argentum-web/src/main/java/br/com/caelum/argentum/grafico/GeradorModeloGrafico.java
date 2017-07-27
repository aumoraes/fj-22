package br.com.caelum.argentum.grafico;



import java.util.List;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorFactory;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico {
	//atributos: serie, comeco, fim e grafico
	//(todos gerados com ctrl + 1, conforme você criar o construtor)
	//importe as classes com ctrl + shift + O
	
	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;
	private String titulo;
	
	public GeradorModeloGrafico() {
		this.modeloGrafico = new LineChartModel();
	}
	
	public void setGrafico(List<Negociacao> negociacoes, String titulo) {
		
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		
		serie = new SerieTemporal(candles);
		comeco = 2;
		fim = serie.getUltimaPosicao();
		this.titulo = titulo;
	}

	public void plotaIndicador(Indicador indicador) {
		
		LineChartSeries chartSerie = new LineChartSeries(indicador.toString());
		for (int i = comeco; i <= fim; i++) {
			double valor = indicador.calcula(i, serie);
			chartSerie.set(i, valor);
		}
		this.modeloGrafico.addSeries(chartSerie);
		this.modeloGrafico.setLegendPosition("w");
		this.modeloGrafico.setTitle(titulo);
		
	}
	
	
	
	public ChartModel getModeloGrafico() {
		return this.modeloGrafico;
	}
	
	
	
}
