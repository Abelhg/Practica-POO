package entrega2abeherrjorsanj;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResourceTest {
	
	private final double FIANZA_VALIDA = 0.1;
	private final double FIANZA_LIMITE = 0.0;
	private final double FIANZA_NOVALIDA = -0.1;
	private final double ERROR_ADMISIBLE = 0.01;

	
	@Test
	public void testAdultBikeFianzaCorrecta(){
		Resource r = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "M");	
		assertEquals(r.getDepositToPay(FIANZA_VALIDA), 0.1, ERROR_ADMISIBLE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAdultBikeFianzaIncorrectaValorLimite(){
		Resource r = new AdultBike(1, "Marca", "Modelo", 1, 1, 6.75, "XL");
		r.getDepositToPay(FIANZA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAdultBikeFianzaIncorrectaValorLimiteInferior(){
		Resource r = new ChildBike(1, "Marca", "Modelo", 1, 1, 6.75, "M");
		r.getDepositToPay(FIANZA_NOVALIDA);
	}
	
	@Test
	public void testChildBikeFianzaCorrecta(){
		Resource r = new ChildBike(1, "Marca", "Modelo", 1, 1, 6.75, "24");	
		assertEquals(r.getDepositToPay(FIANZA_VALIDA), 0.09, ERROR_ADMISIBLE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testChildBikeFianzaIncorrectaValorLimite(){
		Resource r = new ChildBike(1, "Marca", "Modelo", 1, 1, 6.75, "20");
		r.getDepositToPay(FIANZA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testChildBikeFianzaIncorrectaValorLimiteInferior(){
		Resource r = new ChildBike(1, "Marca", "Modelo", 1, 1, 6.75, "20");
		r.getDepositToPay(FIANZA_NOVALIDA);
	}
	
	
	@Test
	public void testElectricBikeFianzaCorrecta(){
		Resource r = new ElectricBike(1, "Marca", "Modelo", 1, 1, 6.75, "M", 1.5, 1.5, 24);	
		assertEquals(r.getDepositToPay(FIANZA_VALIDA), 0.12, ERROR_ADMISIBLE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testElectricBikeFianzaIncorrectaValorLimite(){
		Resource r = new ElectricBike(1, "Marca", "Modelo", 1, 1, 6.75, "M", 1.5, 1.5, 24);
		r.getDepositToPay(FIANZA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testElectricBikeFianzaIncorrectaValorLimiteInferior(){
		Resource r = new ElectricBike(1, "Marca", "Modelo", 1, 1, 6.75, "M", 1.5, 1.5, 24);
		r.getDepositToPay(FIANZA_NOVALIDA);
	}
	
	
	@Test
	public void testFamilyPackFianzaCorrecta(){
		Resource r01 = new ChildBike(01, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r02 = new ChildBike(02, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r03 = new AdultBike(03, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r04 = new AdultBike(04, "Marca", "Modelo", 1, 1, 6.75, "M");
		
		Bike bicis [] = { (Bike)r01, (Bike)r02, (Bike)r03, (Bike)r04 };
		Resource r = new FamilyPack(bicis);
		assertEquals(r.getDepositToPay(FIANZA_VALIDA), 0.19, ERROR_ADMISIBLE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFamilyPackFianzaIncorrectaValorLimite(){
		Resource r01 = new ChildBike(01, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r02 = new ChildBike(02, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r03 = new AdultBike(03, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r04 = new AdultBike(04, "Marca", "Modelo", 1, 1, 6.75, "M");
		
		Bike bicis [] = { (Bike)r01, (Bike)r02, (Bike)r03, (Bike)r04 };
		Resource r = new FamilyPack(bicis);
		r.getDepositToPay(FIANZA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFamilyPackFianzaIncorrectaValorLimiteInferior(){
		Resource r01 = new ChildBike(01, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r02 = new ChildBike(02, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r03 = new AdultBike(03, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r04 = new AdultBike(04, "Marca", "Modelo", 1, 1, 6.75, "M");
		
		Bike bicis [] = { (Bike)r01, (Bike)r02, (Bike)r03, (Bike)r04 };
		Resource r = new FamilyPack(bicis);
		r.getDepositToPay(FIANZA_NOVALIDA);
	}
	
	
	@Test 
	public void testGroupPackFianzaCorrecta(){
		Resource r01 = new ChildBike(01, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r02 = new ChildBike(02, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r03 = new AdultBike(03, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r04 = new AdultBike(04, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r05 = new ChildBike(05, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r06 = new ChildBike(06, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r07 = new AdultBike(07, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r08 = new AdultBike(8, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r09 = new ChildBike(9, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r10 = new ElectricBike(10, "Marca", "Modelo", 1, 1, 6.75, "XL", 1.5,1.5,24);
		
		Bike bicis [] = { (Bike)r01, (Bike)r02, (Bike)r03, (Bike)r04, (Bike)r05, (Bike)r06, (Bike)r07, (Bike)r08, (Bike)r09, (Bike)r10 };
		Resource r = new GroupPack(bicis);
		assertEquals(r.getDepositToPay(FIANZA_VALIDA), 0.76, ERROR_ADMISIBLE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGroupPackFianzaIncorrectaValorLimite(){
		Resource r01 = new ChildBike(01, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r02 = new ChildBike(02, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r03 = new AdultBike(03, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r04 = new AdultBike(04, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r05 = new ChildBike(05, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r06 = new ChildBike(06, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r07 = new AdultBike(07, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r08 = new AdultBike(8, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r09 = new ChildBike(9, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r10 = new ElectricBike(10, "Marca", "Modelo", 1, 1, 6.75, "XL", 1.5,1.5,24);
		
		Bike bicis [] = { (Bike)r01, (Bike)r02, (Bike)r03, (Bike)r04, (Bike)r05, (Bike)r06, (Bike)r07, (Bike)r08, (Bike)r09, (Bike)r10 };
		Resource r = new GroupPack(bicis);
		r.getDepositToPay(FIANZA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGroupPackFianzaIncorrectaValorLimiteInferior(){
		Resource r01 = new ChildBike(01, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r02 = new ChildBike(02, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r03 = new AdultBike(03, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r04 = new AdultBike(04, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r05 = new ChildBike(05, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r06 = new ChildBike(06, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r07 = new AdultBike(07, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r08 = new AdultBike(8, "Marca", "Modelo", 1, 1, 6.75, "M");
		Resource r09 = new ChildBike(9, "Marca", "Modelo", 1, 1, 6.75, "24");
		Resource r10 = new ElectricBike(10, "Marca", "Modelo", 1, 1, 6.75, "XL", 1.5,1.5,24);
		
		Bike bicis [] = { (Bike)r01, (Bike)r02, (Bike)r03, (Bike)r04, (Bike)r05, (Bike)r06, (Bike)r07, (Bike)r08, (Bike)r09, (Bike)r10 };
		Resource r = new GroupPack(bicis);
		r.getDepositToPay(FIANZA_NOVALIDA);
	}
	
}