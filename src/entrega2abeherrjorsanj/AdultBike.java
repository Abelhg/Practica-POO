package entrega2abeherrjorsanj;

/**
 * @author abeherr
 * @author jorsanj
 *
 */

/**
 * RepresentA una bicicleta de tipo adulto.
 */
public class AdultBike extends Bike {

	/**
	 * Construye e inicializa una bicicleta de tipo adulto con las caracteristicas especificadas.<p>
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
	public AdultBike(int identificador, String marca, String modelo, int nPlatos, int nPinones, double peso, String talla){
		super(identificador, marca, modelo, nPlatos, nPinones, peso, talla);
	}
	
	
	/**
	 * Devuelve una copia de un objeto AdultBike.
	 * 
	 * @return Copia del objeto AdultBike.
	 */
	@Override
	public AdultBike clone(){
		AdultBike clone = null;
		
		clone = (AdultBike) super.clone();

		return clone;
	}
	
	/*
	 * 
	 * @see entrega2abeherrjorsanj.Bike#getDepositToPay(double)
	 */
	@Override
	public double getDepositToPay(double deposit) throws IllegalArgumentException{
		if(deposit <= 0.0) throw new IllegalArgumentException ("La fianza ha de ser positiva.");
		return deposit; // Sin descuento
	}
	
}