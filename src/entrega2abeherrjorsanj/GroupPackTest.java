package entrega2abeherrjorsanj;

import static org.junit.Assert.*;

import org.junit.Test;

public class GroupPackTest {
	
public static final double ERROR_ADMISIBLE = 0.01;

ChildBike b1 = new ChildBike(1, "marca", "modelo", 1, 1, 1, "24");
ChildBike b2 = new ChildBike(2, "marca", "modelo", 1, 1, 1, "24");
AdultBike b3 = new AdultBike(3, "marca", "modelo", 1, 1, 1, "S");
AdultBike b4 = new AdultBike(4, "marca", "modelo", 1, 1, 1, "M");
ElectricBike b5 = new ElectricBike( 5, "marca", "modelo", 1, 1, 1, "XL", 1.0, 1.0, 1.0);
ChildBike b6 = new ChildBike(6, "marca", "modelo", 1, 1, 1, "24");
ChildBike b7 = new ChildBike(7, "marca", "modelo", 1, 1, 1, "24");
AdultBike b8 = new AdultBike(8, "marca", "modelo", 1, 1, 1, "S");
AdultBike b9 = new AdultBike(9, "marca", "modelo", 1, 1, 1, "M");
ElectricBike b10 = new ElectricBike(10, "marca", "modelo", 1, 1, 1, "XL", 1.0, 1.0, 1.0);
AdultBike b11 = new AdultBike(11, "marca", "modelo", 1, 1, 1, "S");

	
	@Test
	public void testAnadirBiciCorrecta(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10 };
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(pack);
		assertTrue(pack.anadirBici(b11));
	}
	
	@Test
	public void testAnadirBiciRepetida(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10 };
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(pack);
		assertFalse(pack.anadirBici(b4));
	}
	
	@Test
	public void testGetBicis(){

		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10 };
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(pack);
		Bike bicis2 [] = pack.getBicis();
		assertArrayEquals(bicis, bicis2);
	}
	
	@Test
	public void testInicializacionCorrectaGroupPack(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10 };
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(pack);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testInicializacionIncorrectaGroupPackBicisRepetidas(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b1};
		GroupPack pack = new GroupPack (bicis);
	}
	
	
	@Test
	public void testComprobarGrupoValidoCorrecto(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10 };
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(pack);
	}
	

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testComprobarGrupoValidoIncorrectoBicisInsuficientes(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9};
		GroupPack pack = new GroupPack (bicis);
	}

	
	@Test
	public void testGetDepositToPayCalculoFianzaCorrecta(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(bicis);
		assertEquals(pack.getDepositToPay(5.0), 37.68, ERROR_ADMISIBLE);
	}
	
	
	@Test
	public void testGetDepositToPayCalculoFianzaIncorrectaSuperior(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(bicis);
		assertNotEquals(pack.getDepositToPay(5.0),37.7, ERROR_ADMISIBLE);
	}
	
	
	@Test
	public void testGetDepositToPayCalculoFianzaIncorrectaInferior(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(bicis);
		assertNotEquals(pack.getDepositToPay(5.0),37.6, ERROR_ADMISIBLE);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDepositToPayPasoParametroIncorrectoFianzaNegativa(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(pack);
		pack.getDepositToPay(-5.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDepositToPayPasoParametroIncorrectoFianzaNula(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(pack);
		pack.getDepositToPay(0.0);
	}
	
	
	@Test
	public void testQuitarBiciPertenecePackNoPosible(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(bicis);
		assertFalse(pack.quitarBici(b1));
	}
	
	
	@Test
	public void testQuitarBiciPertenecePackPosible(){
		Bike bicis[] = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11};
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(bicis);
		assertTrue(pack.quitarBici(b1));
	}
	
	
	@Test
	public void testQuitarBiciNoPertenecePack(){
		Bike bicis[] = { b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
		GroupPack pack = new GroupPack (bicis);
		assertNotNull(bicis);
		assertFalse(pack.quitarBici(b11));
	}
	
}
