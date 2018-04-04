package entrega2abeherrjorsanj;

/**
 * @author abeherr
 * @author jorsanj
 *
 */
/**
 * 
 * Interfaz de operaciones comunes a los distintos tipos de bicicletas y packs que estas pueden conformar. 
 *
 */
public interface Resource {

	/**
	 * Devuelve la fianza a cobrar asociado al recurso.
	 *
	 * @param deposit Indica la fianza base a cobrar por bicicleta.
	 * @throws IllegalArgumentException en caso de que la fianza sea menor o igual que 0.
	 * @return Fianza a cobrar
	 */
	public double getDepositToPay(double deposit) throws IllegalArgumentException;
}