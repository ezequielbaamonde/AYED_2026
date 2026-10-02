package ar.edu.unlp.info.oo1.ejercicio11_oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class CajaDeAhorroTest {
	
	CajaDeAhorro uno, dos;
	
	@BeforeEach
	void setUp() throws Exception {
		uno = new CajaDeAhorro(0);
		dos = new CajaDeAhorro(100);
		//uno.depositar(100);
	}
	
	
    @Test
    public void testDepositar() {
    	uno.depositar(100);
    	assertEquals(98, uno.getSaldo());
    }
    
    @Test
    public void testExtraer() {
    	uno.depositar(100);
    	uno.extraer(50);
    	assertEquals(47, uno.getSaldo());
    }
}
