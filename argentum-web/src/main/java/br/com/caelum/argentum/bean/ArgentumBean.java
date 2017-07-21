package br.com.caelum.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorAbertura;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Negociacao> negociacoes;
	private ChartModel modeloGraficoFechamento;
	private String nomeMedia;
	private String indicadorBase;
	
	public ArgentumBean() {
	
		this.negociacoes = new ClienteWebService().getNegociacoes();
		
		geraGrafico();
	 
	}
	public void geraGrafico() {
		
		System.out.println("PLOTANDO: "+ nomeMedia +" de "+ indicadorBase);
		
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		
		int intervaloDeCalculo = 3;
		
		geradorGrafico.plotaIndicador(new MediaMovelSimples( intervaloDeCalculo, new IndicadorFechamento() ));
		
		this.modeloGraficoFechamento = geradorGrafico.getModeloGrafico();
	}
	public String getNomeMedia(){
		return nomeMedia;
	}
	
	public void setNomeMedia(String nomeMedia){
		this.nomeMedia = nomeMedia;
	}
	
	public String getIndicadorBase(){
		return indicadorBase;
	}
	
	public void setIndicadorBase(String indicadorBase){
		this.indicadorBase = indicadorBase;
	}
	
	
	
	public List<Negociacao> getNegociacoes(){
		return negociacoes;
	}
	
	public ChartModel getModeloGraficoFechamento(){
		return this.modeloGraficoFechamento;
	}
	
	
}
