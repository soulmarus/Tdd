package br.com.caelum.palindromo.servico.test;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.palindromo.servico.Palindromo;
import org.junit.Assert;

public class PalindromoTest {
	
	@BeforeClass
	public static void setup() {	
	}
	
	@Test
	public void testaSeFraseEUmPalindromo() {
		Palindromo palindromo = new Palindromo();
		
		Assert.assertEquals(Boolean.TRUE, palindromo.ehPalindromo("Eu ue"));
		
	}
	
	@Test
	public void testaSePalavraEUmPalindromo(){
		Palindromo palindromo = new Palindromo();
		
		Assert.assertEquals(Boolean.TRUE, palindromo.ehPalindromo("MarraM"));
	}
	
	@Test
	public void testaSePalavraQueNaoEUmPalindromo(){
		Palindromo palindromo = new Palindromo();
		
		Assert.assertEquals(Boolean.FALSE, palindromo.ehPalindromo("Maria"));
	}
	
    @Test
    public void deveIdentificarPalindromoEFiltrarCaracteresInvalidos() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
            "Socorram-me subi no onibus em Marrocos");
        Assert.assertTrue(resultado);
    }

    @Test
    public void deveIdentificarPalindromo() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
            "Anotaram a data da maratona");
        Assert.assertTrue(resultado);
    }

    @Test
    public void deveIdentificarSeNaoEhPalindromo() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
            "E preciso amar as pessoas como se nao houvesse amanha");
        Assert.assertFalse(resultado);
    }	
	
}
