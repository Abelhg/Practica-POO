package entrega2abeherrjorsanj;

/**
 * @author abeherr
 * @author jorsanj
 */

/**
 * Representa una bicicleta de tipo nino.
 */
public class ChildBike extends Bike {

	private final int CHILD_DISCOUNT = 15; 	// Descuento a realizar (en %)
	
	/**
	 * Construye e inicializa una bicicleta de tipo nino con las caracteristicas especificadas.<p>
	 * Se utiliza el constructor de la clase padre Bike simplemente, ya que no tiene caracteristicas adicionales.
	 * 
	 * @param identificador Identificador de la bici.
	 * @param marca	Marca de la bici.
	 * @param modelo Modelo de la bici.
	 * @param nPlatos Numero de platos de la bici.
	 * @param nPinones Numero de pinones de la bici.
	 * @param peso Peso de la bici.
	 * @param talla	Talla de la bici.
	 */
	public ChildBike(int identificador, String marca, String modelo, int nPlatos, int nPinones, double peso, String talla){
		super(identificador, marca, modelo, nPlatos, nPinones, peso, talla);
	}
	
	
	/**
	 * Devuelve una copia de un objeto ChildBike.
	 * 
	 * @return Copia del objeto ChildBike.
	 */
	@Override
	public ChildBike clone(){
		ChildBike clone = null;
		
		clone = (ChildBike) super.clone();

		return clone;
	}
	/**
	 * La fianza de una bicicleta de nino tiene un descuento del 15%.
	 * @see entrega2abeherrjorsanj.Bike#getDepositToPay(double)
	 */
	@Override
	public double getDepositToPay(double deposit) throws IllegalArgumentException{
		if (deposit <= 0.0) throw new IllegalArgumentException("La fianza ha de ser mayor estrictamente que 0.");
		return (1 - CHILD_DISCOUNT/100.0) * deposit;
	}
	
	/**
	 * Todas las posibles tallas para este tipo de bicicleta son numeros pares del intervalo [12, 26].
	 * @see entrega2abeherrjorsanj.Bike#isValidTalla(java.lang.String)
	 */
	@Override
	public boolean isValidTalla(String talla) throws NumberFormatException {
		boolean valid = true;
		
		// Comprueba que la talla sea un numero valido (intervalo [12-26])
		int t = Integer.parseInt(talla);
		if((t < 12 || t > 26) && t % 2 != 0) valid = false;
		
		return valid;
	}
}