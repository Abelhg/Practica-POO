package entrega2abeherrjorsanj;
/**
 * @author abeherr
 * @author jorsanj
 *
 */
/**
 * Clase que provee servicios para el TAD FamilyPack.<p>
 * Genera un pack de tipo Familiar, siendo necesario la presencia de minimo 4 bicicletas siendo como poco dos de ellas infantiles.
 * Hereda de la clase Pack.
 *
 */
public class FamilyPack extends Pack{
	
	protected final int FAMILY_DISCOUNT = 50;
	
	
	/**
	 * Genera un FamilyPack.<p>
	 * Utiliza el constructor generico de la clase Pack, bajo las caracteristicas propias de un pack familiar.
	 * 
	 * @param bicis[] Contiene todas las bicicletas con las que se quiere conformar el pack.
	 */
	public FamilyPack(Bike bicis[]){
		super(bicis);
	}
	
	
	/**
	 * Establece una nueva definicion de comprobarGrupoValido.<p>
	 * Para que un pack sea del tipo familiar ha de contener como minimo 4 bicicletas y dos de ellas de tipo infantil.
	 * 
	 * @throws IllegalArgumentException en caso de que se este intentado generar un pack familiar con menos de 4 bicicletas.
	 * @throws IllegalArgumentException en caso de que el pack vaya a contener menos de dos bicicletas de tipo infantil. 
	 */
	@Override
	public void comprobarGrupoValido(){
		int numChild = 0;
		
		if(getNumeroBicis() < 4) throw new IllegalArgumentException("Un FamilyPack debe contener al menos 4 bicis.");
		
		for(int i = 0; i < getNumeroBicis(); i++){
			if(this.alBicis.get(i) instanceof ChildBike) numChild++;
		}
		
		if(numChild < 2) throw new IllegalArgumentException("Un FamilyPack debe contener al menos 2 ChildBike.");
	}	
	
	
	/*
	 * (non-Javadoc)
	 * @see entrega2abeherrjorsanj.Pack#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other){
		boolean igual = false;
		if (other instanceof FamilyPack){
			FamilyPack o = (FamilyPack) other;
			igual = super.equals(o);
		}

		return igual;
	}
	
	/**
	 * Se establece un descuente del 50% sobre la suma individual de las fianzas.
	 * @see entrega2abeherrjorsanj.Pack#getDepositToPay(double)
	 */
	@Override
	public double getDepositToPay(double deposit) throws IllegalArgumentException{
		double total = 0;
		if (deposit <= 0.0) throw new IllegalArgumentException("La fianza ha de ser mayor estrictamente que 0.");
		for(int i = 0; i < this.alBicis.size(); i++){
			// Suma las fianzas individuales
			total += this.alBicis.get(i).getDepositToPay(deposit);
		}
		
		return (1 - FAMILY_DISCOUNT/100.0) * total;
	}
	
	/**
	 * Solo se puede quitar una bici si se garantiza la presencia de mas de 4 bicicletas siendo al menos dos de nino.
	 * @see entrega2abeherrjorsanj.Pack#quitarBici(entrega2abeherrjorsanj.Bike)
	 */
	@Override
	public boolean quitarBici(Bike bici){
		boolean ret = false;
		
		// Comprueba numero de bicis (minimo 4)
		if(this.getNumeroBicis() > 4){
			int numChilds = 0;
			for(int i = 0; i < this.getNumeroBicis(); i++){
				if(this.alBicis.get(i) instanceof ChildBike) numChilds++;
			}

			if (numChilds > 2 || !(bici instanceof ChildBike)){
				ret = this.alBicis.remove(bici);
			}
		
		}
		
		return ret;
	}	
}
