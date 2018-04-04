package entrega2abeherrjorsanj;

/**
 * @author abeherr
 * @author jorsanj
 */

/**
 * Representa una bicicleta electrica.
 */

public class ElectricBike extends Bike {

	private final double parMotor;	// Par del motor (Newtons metro: Nm)
	private final double voltaje;	// Voltaje del motor
	private final double capacidad;	// Capacidad de la bici (Amperios hora: Ah)
	private double cargaActual;		// Carga de la bici (Amperios hora: Ah)
	
	/**
	 * Construye e inicializa una bicicleta de tipo electrica con las caracteristicas especificadas.<p>
	 * Utiliza el constructor del padre para los atributos comunes a todas las bicis, mas los especificos
	 * de las electricas (capacidad, parMotor, voltaje).
	 * 
	 * @param identificador Identificador de la bici.
	 * @param marca	Marca de la bici.
	 * @param modelo Modelo de la bici.
	 * @param nPlatos Numero de platos de la bici.
	 * @param nPinones Numero de pinones de la bici.
	 * @param peso Peso de la bici.
	 * @param talla	Talla de la bici.
	 * @param capacidad Carga maxima de la bicicleta, en Amperios hora ('Ah').
	 * @param parMotor Par motor de la bicicleta, en Newtons por metro('N*m').
	 * @param voltaje Voltaje de la bicicleta, en Voltios('V').
	 */
	public ElectricBike(int identificador, String marca, String modelo, int nPlatos, int nPinones, double peso, String talla, double capacidad, double parMotor, double voltaje){
		super(identificador, marca, modelo, nPlatos, nPinones, peso, talla);
		if(parMotor <= 0) throw new IllegalArgumentException("El par motor no puede ser negativo o nulo.");
		if(voltaje <= 0) throw new IllegalArgumentException("El voltaje no puede ser negativo o nulo.");
		if(capacidad <= 0) throw new IllegalArgumentException("La capacidad no puede ser negativa o nula.");
		this.parMotor = parMotor;
		this.voltaje = voltaje;
		this.capacidad = capacidad;
		this.cargaActual = capacidad;		// Carga actual al maximo
	}
	
	
	/**
	 * Devuelve una copia de un objeto ElectricBike.
	 * 
	 * @return Copia del objeto ElectricBike.
	 */
	@Override
	public ElectricBike clone(){
		ElectricBike clone = null;
		
		clone = (ElectricBike) super.clone();

		return clone;
	}
	
	/**
	 * Aporta el nuevo concepto de igualdad para dos ElectriBike.
	 * 
	 * @param b Objeto con el que se va a comparar.
	 * @return true en caso de que sean la misma bici electrica, false en caso contrario
	 */
	@Override
	public boolean equals(Object b){
		boolean igual = false;
		if (b instanceof ElectricBike){
			ElectricBike auxb =  (ElectricBike) b;
			if (this.getIdentificador() == auxb.getIdentificador() && this.getMarca() == auxb.getMarca() && this.getModelo()== auxb.getModelo() && this.getNumeroPinones() == auxb.getNumeroPinones()&& this.getNumeroPlatos() == auxb.getNumeroPlatos() && this.getTalla() == auxb.getTalla() && this.getCapacidad() == auxb.getCapacidad()){
				igual = true;
			}
		}
		return igual;
	}
	
	/**
	 * Devuelve la capacidad de la bici.
	 * 
	 * @return Capacidad de la bici (amperios hora 'Ah')
	 */
	public double getCapacidad(){
		return this.capacidad;
	}


	/**
	 * Devuelve la carga de la bici.
	 * 
	 * @return Carga de la bici (amperios hora 'Ah')
	 */
	public double getCargaActual(){
		return this.cargaActual;
	}

	/**
	 * La fianza para este tipo de bicicletas es proporcional al Voltaje que tenga.
	 * @see entrega2abeherrjorsanj.Bike#getDepositToPay(double)
	 */
	@Override
	public double getDepositToPay(double deposit) throws IllegalArgumentException{
		if (deposit <= 0.0) throw new IllegalArgumentException("La fianza ha de ser mayor estrictamente que 0.");
		return deposit + (getVoltaje()/100.0 * deposit);
	}


	/**
	 * Devuelve la energia maxima almacenada en la bicicleta.
	 *
	 * @return Energia almacenada de la bicicleta (kilovatios hora 'kWh')
	 */
	public double getEnergia(){
		return 1000*(getVoltaje() * getCapacidad());
	}


	/**
	 * Devuelve la energia almacenada actualmente en la bicicleta.
	 *
	 * @return Energia almacenada de la bicicleta (kilovatios hora 'kWh')
	 */
	public double getEnergiaActual(){
		return 1000*(getVoltaje() * getCargaActual());
	}
	
	
	/**
	 * Devuelve el par motor de la bici.
	 * 
	 * @return Par motor de la bici (Newtons metro 'Nm')
	 */
	public double getParMotor(){
		return this.parMotor;
	}
	

	/**
	 * Devuelve el voltaje de la bici.
	 * 
	 * @return Voltaje de la bici (voltios 'V')
	 */
	public double getVoltaje(){
		return this.voltaje;
	}
	
	/**
	 * Redefine el metodo toString.<p>
	 * Ademas de usar el metodo definido en Bike anade la informacion relativa a las caracteristicas exclusivas de una bicicleta electrica.
	 * 
	 * @return Toda la informacion relativa a la bicicleta.
	 */
	@Override
	public String toString(){
		String ret = super.toString();
		
		ret += "Par motor: "+ getParMotor() +"\n";
		ret += "Voltaje: "+ getVoltaje() +"\n";
		ret += "Capacidad: "+ getCapacidad() +"\n";
		ret += "Carga actual: "+ getCargaActual() +"\n";
		
		return ret;
	}
}