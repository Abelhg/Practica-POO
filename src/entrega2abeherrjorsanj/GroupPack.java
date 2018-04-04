package entrega2abeherrjorsanj;
/**
 * 
 * @author abeherr
 * @author jorsanj
 *
 */
/**
 * Clase que provee servicios para el TAD GroupPack.<p>
 * Genera un pack de tipo grupo, siendo necesario un minimo de 10 bicicletas para su creacion.
 * Hereda de la clase Pack.
 *
 */

public class GroupPack extends Pack{

	protected final int GROUP_DISCOUNT = 20;
	
	/**
	 * Genera un GroupPack.<p>
	 * Utiliza el constructor generico de la clase Pack, bajo las caracteristicas propias de un pack de grupo.
	 * 
	 * @param bicis[] Conjunto de bicis que van a conformar el GroupPack.
	 */
	public GroupPack(Bike[] bicis) {
		super(bicis);
	}
	
	/**
	 * Se aplica un descuento del 20% sobre el total de la suma de las fianzas individuales.
	 * @see entrega2abeherrjorsanj.Pack#getDepositToPay(double)
	 */
	@Override
	public double getDepositToPay(double deposit) throws IllegalArgumentException{
		double total = 0;
		if (deposit <= 0.0) throw new IllegalArgumentException("La fianza ha de ser mayor estrictamente que 0");
		for(int i = 0; i < this.alBicis.size(); i++){
			// Suma las fianzas individuales
			total += this.alBicis.get(i).getDepositToPay(deposit);
		}
		return (1 - GROUP_DISCOUNT/100.0) * total;
	}
	
	
	/**
	 * Establece una nueva definicion de comprobarGrupoValido.<p>
	 * Un pack de grupo es valido si contiene al menos 10 bicicletas.
	 * 
	 * @throws IllegalArgumentException en caso de que se intente generar un pack con menos de 10 bicicletas.
	 */
	@Override
	public void comprobarGrupoValido() throws IllegalArgumentException {
		if(getNumeroBicis() < 10) throw new IllegalArgumentException("El pack debe contener al menos 10 bicis.");
	}
	
	/*
	 * (non-Javadoc)
	 * @see entrega2abeherrjorsanj.Pack#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object p1){
		boolean igual = false;
		if (p1 instanceof GroupPack){
			GroupPack auxp1 = (GroupPack) p1;
			igual = super.equals(auxp1);
		}
		return igual;
	}
	
	
	/**
	 * Solo puede quitarse una bici si hay mas de 10.
	 * @see entrega2abeherrjorsanj.Pack#quitarBici(entrega2abeherrjorsanj.Bike)
	 */
	@Override
	public boolean quitarBici(Bike bici) {
		boolean ret = false;
		
		if(getNumeroBicis() > 10) ret = this.alBicis.remove(bici); 
		
		return ret;
	}

}
