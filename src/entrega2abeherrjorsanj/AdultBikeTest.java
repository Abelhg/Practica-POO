package entrega2abeherrjorsanj;

import static org.junit.Assert.*;
import org.junit.Test;

public class AdultBikeTest {

	private final static double ERROR_ADMISIBLE = 0.00001; 
	
	@Test
	public void testInicializarCorrectamente() {
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "M");
		assertNotNull(b);
		assertEquals(b.getIdentificador(), 1);
		assertEquals(b.getMarca(), "Marca");
		assertEquals(b.getModelo(), "Modelo");
		assertEquals(b.getNumeroPlatos(), 1);
		assertEquals(b.getNumeroPinones(), 1);
		assertEquals(b.getPeso(), 6.75, ERROR_ADMISIBLE);
		assertEquals(b.getTalla(), "M");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarNumeroPlatosNulo(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 0, 1, 6.75, "M");	
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarNumeroPlatosNegativo(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", -3, 1, 6.75, "M");	
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarNumeroPinonesNulo(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 0, 6.75, "M");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarNumeroPinonesNegativo(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, -5, 6.75, "M");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarPesoNulo(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 0.0, "M");		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarPesoNegativo(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, -4.2, "M");		
	}
	
	
	@Test
	public void testInicializarSinMarca(){
		AdultBike b = new AdultBike(1, "", "Modelo", 1, 1, 6.75, "M");
		assertNotNull(b);
		assertEquals(b.getIdentificador(), 1);
		assertEquals(b.getMarca(), "");
		assertEquals(b.getModelo(), "Modelo");
		assertEquals(b.getNumeroPlatos(), 1);
		assertEquals(b.getNumeroPinones(), 1);
		assertEquals(b.getPeso(),6.75, ERROR_ADMISIBLE);
		assertEquals(b.getTalla(), "M");
	}
	
	
	@Test
	public void testInicializarSinModelo(){
		AdultBike b = new AdultBike(1, "Marca", "", 1, 1, 6.75, "M");
		assertNotNull(b);
		assertEquals(b.getIdentificador(), 1);
		assertEquals(b.getMarca(), "Marca");
		assertEquals(b.getModelo(), "");
		assertEquals(b.getNumeroPlatos(), 1);
		assertEquals(b.getNumeroPinones(), 1);
		assertEquals(b.getPeso(),6.75, ERROR_ADMISIBLE);
		assertEquals(b.getTalla(), "M");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarSinTalla(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarTallaIncorrecta1(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "XS");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializarTallaIncorrecta2(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "24");
	}
	

	@Test
	
	public void testGetDepositToPayCorrecto(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "XL");
		assertNotNull(b);
		assertEquals(b.getDepositToPay(5.0), 5.0, ERROR_ADMISIBLE);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDepositToPayValorInsuficiente(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		b.getDepositToPay(0.0);
	}
	
	
	@Test
	public void testEquals(){
		AdultBike b = new AdultBike(123, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = new AdultBike(123, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b2);
		assertTrue(b.equals(b2));
	}
	
	
	@Test
	public void testEqualsDistintoIdentificador(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = new AdultBike(2, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b2);
		assertFalse(b.equals(b2));
	}
	
	@Test
	public void testEqualsDistintaMarca(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = new AdultBike(2, "Marca2", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b2);
		assertFalse(b.equals(b2));
	}
	
	
	@Test
	public void testEqualsDistintoModelo(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = new AdultBike(2, "Marca", "Modelo2", 1, 1, 6.75, "S");
		assertNotNull(b2);
		assertFalse(b.equals(b2));
	}

	
	@Test
	public void testEqualsDistintoNumeroPlatos(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = new AdultBike(2, "Marca", "Modelo", 3, 1, 6.75, "S");
		assertNotNull(b2);
		assertFalse(b.equals(b2));
	}
	
	
	@Test
	public void testEqualsDistintoNumeroPinones(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = new AdultBike(2, "Marca", "Modelo", 1, 3, 6.75, "S");
		assertNotNull(b2);
		assertFalse(b.equals(b2));
	}
	
	
	@Test
	public void testEqualsDistintoPeso(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = new AdultBike(2, "Marca", "Modelo", 1, 1, 5.75, "S");
		assertNotNull(b2);
		assertFalse(b.equals(b2));
	}
	
	
	@Test
	public void testEqualsDistintaTalla(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = new AdultBike(2, "Marca", "Modelo", 1, 1, 6.75, "L");
		assertNotNull(b2);
		assertFalse(b.equals(b2));
	}
	
	
	@Test
	public void testEqualsClone(){
		AdultBike b = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "S");
		assertNotNull(b);
		AdultBike b2 = b.clone();
		assertNotNull(b2);
		assertTrue(b.equals(b2));
	}
}
