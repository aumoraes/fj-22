package br.com.caelum.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	private String nomeMedia;
	private String nomeIndicadorBase;
	private String titulo;
	
	public ArgentumBean() {

		this.negociacoes = new ClienteWebService().getNegociacoes();
		this.nomeMedia = "MediaMovelSimples";
		this.nomeIndicadorBase = "IndicadorFechamento";
		
		geraGrafico();

	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
		
	
	public void geraGrafico(){
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico();

		
		geradorGrafico.setGrafico( this.negociacoes, titulo );
		
		IndicadorFactory indicadorFactory = new IndicadorFactory(this.nomeMedia, this.nomeIndicadorBase);
		
		geradorGrafico.plotaIndicador(indicadorFactory.defineIndicador());
		
		this.modeloGrafico = geradorGrafico.getModeloGrafico();
	}
	
	
	

	public String getNomeMedia(){
		return nomeMedia;
	}
	
	public void setNomeMedia(String nomeMedia){
		this.nomeMedia = nomeMedia;
	}
	
	public String getIndicadorBase(){
		return nomeIndicadorBase;
	}
	
	public void setIndicadorBase(String nomeIndicadorBase){
		this.nomeIndicadorBase = nomeIndicadorBase;
	}
	
	
	
	public List<Negociacao> getNegociacoes(){
		return negociacoes;
	}
	
	public ChartModel getModeloGraficoFechamento(){
		return this.modeloGrafico;
	}
	
	
}
