package entrega2abeherrjorsanj;

/**
 * @author abeherr
 * @author jorsanj
 */

/**
 * Clase abstracta que representa un objeto bicicleta que implementa las interfaces Resource y Cloneable.<p> 
 * De ella heredan las clases AdultBike (bici para adultos), ChildBike (bici para ninos) y ElectricBike (bici electrica).<p>
 * Todas las bicicletas presentan unas caracteristicas comunes: identificador, marca, modelo, numero de platos y pinones, peso y talla.
 */
public abstract class Bike implements Resource, Cloneable {

	private final int identificador;	// Identificador de la bici
	private final String marca;			// Marca de la bici
	private final String modelo;		// Modelo de la bici
	private final int nPlatos;			// Numero de platos
	private final int nPinones;			// Numero de pinones
	private final double peso;			// Peso de la bici
	private final String talla;			// Talla de la bici (tallas de ni�os: int en String)
	
	/**
	 * Construye e inicializa una bicicleta con las caracteristicas especificadas.
	 *  
	 * @param identificador Identificador de la bici.
	 * @param marca	Marca de la bici.
	 * @param modelo Modelo de la bici.
	 * @param nPlatos Numero de platos de la bici.
	 * @param nPinones Numero de pinones de la bici.
	 * @param peso Peso de la bici.
	 * @param talla	Talla de la bici.
	 */
	public Bike(int identificador, String marca, String modelo, int nPlatos, int nPinones, double peso, String talla){	
		this.identificador = identificador;
		this.marca = marca;
		this.modelo = modelo;
		// Comprueba platos y pinones
		if(nPlatos < 1) throw new IllegalArgumentException("El numero de platos debe ser al menos 1");
		if(nPinones < 1) throw new IllegalArgumentException("El numero de pinones debe ser al menos 1");
		this.nPlatos = nPlatos;
		this.nPinones = nPinones;
		if(peso <= 0) throw new IllegalArgumentException("El peso debe ser mayor que 0"); // Comprueba peso
		this.peso = peso;
		if(!isValidTalla(talla)) throw new IllegalArgumentException("Talla no valida"); // Comprueba talla
		this.talla = talla;
	}

	/**
	 * Devuelve una copia de un objeto Bike.
	 * 
	 * @return Copia del objeto Bike.
	 */
	@Override
	public Bike clone(){
		Bike clone = null;
		
		try{
			clone = (Bike) super.clone();
		}catch(CloneNotSupportedException e){ /* No debería ocurrir */ }

		return clone;
	}

	/**
	 * Determina si dos Bikes son iguales o no.
	 * 
	 * @param b objeto a ser comparado con este Bike.
	 * @return true si ambos objetos son la misma bicicleta, false en cualquier otro caso.
	 */
	@Override
	public boolean equals(Object b){
		boolean igual = false;
		if (b instanceof Bike){
			Bike auxb =  (Bike) b;
			if (this.getIdentificador() == auxb.getIdentificador() && this.getMarca() == auxb.getMarca() && this.getModelo()== auxb.getModelo() && this.getNumeroPinones() == auxb.getNumeroPinones()&& this.getNumeroPlatos() == auxb.getNumeroPlatos() && this.getTalla() == auxb.getTalla()){
				igual = true;
			}
		}
		return igual;
	}
	
	/**
	 * Determina la fianza a pagar para usar la bicicleta.
	 * 
	 * @param deposit Fianza base del sistema.
	 * @throws IllegalArgumentException en caso de que el valor pasado como parametro es nulo o negativo.
	 * @return Fianza calculada a cobrar para la bicicleta.
	 */
	@Override
	public abstract double getDepositToPay(double deposit) throws IllegalArgumentException;

	
	/**
	 * Devuelve el identificador de la bici.
	 *
	 * @return Identificador de la bici.
	 */
	public int getIdentificador(){
		return this.identificador;
	}

	
	/**
	 * Devuelve la marca de la bici.
	 *
	 * @return Marca de la bici.
	 */
	public String getMarca(){
		return this.marca;
	}

	
	/**
	 * Devuelve el modelo de la bici.
	 *
	 * @return Modelo de la bici.
	 */
	public String getModelo(){
		return this.modelo;
	}

	
	/**
	 * Devuelve el numero de pinones de la bici.
	 *
	 * @return Numero de pinones de la bici.
	 */
	public int getNumeroPinones(){
		return this.nPinones;
	}
	
	
	/**
	 * Devuelve el numero de platos de la bici.
	 *
	 * @return Numero de platos de la bici.
	 */
	public int getNumeroPlatos(){
		return this.nPlatos;
	}

	
	/**
	 * Devuelve el peso de la bici.
	 *
	 * @return Peso de la bici.
	 */
	public double getPeso(){
		return this.peso;
	}

	
	/**
	 * Devuelve la talla de la bici.
	 *
	 * @return Talla de la bici.
	 */
	public String getTalla(){
		return this.talla;
	}

	
	/**
	 * Comprueba si la talla de la bici es un valor valido.
	 * 
	 * @param talla Talla de la bici a comprobar
	 * @return true si es valida, false si no.
	 */
	public boolean isValidTalla(String talla){
		boolean valid = false;
		
		if(talla.equals("S") || talla.equals("M") || talla.equals("L") || talla.equals("XL")){
			valid = true;
		}
		
		return valid;
	}
	

	/**
	 * Devuelve una cadena con los datos de la bici.
	 * 
	 * @return Una cadena con los datos de la bici.
	 */
	@Override
	public String toString(){
		String ret = this.getClass().getSimpleName().toString() + "\n";
		ret += "Identificador: "+ getIdentificador() + "\n";
		ret += "Marca: " + getMarca() + "\n";
		ret += "Modelo: " + getModelo() + "\n";
		ret += "Número de platos: " + getNumeroPlatos() + "\n";
		ret += "Número de piñones: " + getNumeroPinones() + "\n";
		ret += "Peso: " + getPeso() + "\n";
		ret += "Talla: " + getTalla() + "\n";
		
		return ret; 
	}	
}