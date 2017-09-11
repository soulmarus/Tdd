package br.com.caelum.leilao.servico.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {

	private static final double DELTA = 1e-15;
	
	public static Leilao leilao;
	
	@BeforeClass
	public static void setup() {
		leilao = new Leilao("Do coração");
		
		Lance lance = new Lance(new Usuario("Daniel"), 450.00);		
		leilao.propoe(lance);
		
		lance = new Lance(new Usuario("Milca"), 350.00);		
		leilao.propoe(lance);
		
		lance = new Lance(new Usuario("Renato"), 250.00);		
		leilao.propoe(lance);			
	}
	
	@Test
	public void verificaSeEstaRetornandoOMaiorValor() {
		Avaliador avaliador = new Avaliador();
		
		avaliador.avalia(leilao);
		
		Assert.assertEquals(450.00, avaliador.getMaiorValor(), DELTA);
		
	}
	
	
	@Test
	public void verificaSeEstaRetornandoOMenorValor() {
		Avaliador avaliador = new Avaliador();
		
		avaliador.avalia(leilao);
		
		Assert.assertEquals(250.00, avaliador.getMenorValor(), DELTA);
		
	}
	
	
	@Test
	
	public void verificarSeEstaCalculandoAMediaCorreta() {
		Avaliador avaliador = new Avaliador();
		
		double media = avaliador.retornaMediaLances(leilao);
		
		Assert.assertEquals(350.00, media, DELTA);
	}
}
