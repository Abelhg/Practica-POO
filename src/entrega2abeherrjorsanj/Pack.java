package entrega2abeherrjorsanj;

import java.util.ArrayList;

/** 
 * @author abeherr
 * @author jorsanj
 *
 */
/**
 * Da la posibilidad de generar conjuntos de bicicletas en concepto de grupo o de familia.<p>
 * De esta clase heredan GroupPack y FamilyPack, que establecen los dos tipos de pack que se pueden crear. 
 *
 */
public abstract class Pack implements Resource {
	
	protected ArrayList<Bike> alBicis; // Contenedor de bicis
	
	
	/**
	 * Genera un pack.<p>
	 * Conforma un Array con las bicicletas que pertenecen a el y verifica que reunan las caracteristicas para ser un pack del tipo deseado.
	 *  
	 * @param bicis[] Representa el conjunto de bicis que van a formar parte del pack
	 * @throws IllegalArgumentException En caso de que existan bicis repetidas en el pack.
	 */
	public Pack(Bike bicis[]){
		// Comprueba que el array de bicis pasado cumple las condiciones del pack
		this.alBicis = new ArrayList<Bike>();
		for(int i = 0; i < bicis.length; i++){
			if(!this.alBicis.contains(bicis[i])) this.alBicis.add(bicis[i]);
			else throw new IllegalArgumentException("No puede haber bicis repetidas.");
		}
		comprobarGrupoValido();
	}

	
	/**
	 * Anade una bici en un pack (solo si es valida su adicion).
	 * 
	 * @param bici Bici que se desea anadir al pack.
	 * @return true si se ha anadido, false si no
	 */
	public boolean anadirBici(Bike bici){
		boolean ret = false;
		
		if(!estaEnPack(bici)){
			this.alBicis.add(bici);
			ret = true;
		}
		
		return ret;
	}
	
	
	/**
	 * Comprueba si el grupo de bicis es valido.
	 * 
	 * @throws IllegalArgumentException si el grupo no es v�lido.
	 */
	public abstract void comprobarGrupoValido() throws IllegalArgumentException;

	
	/**
	 * Redefine el metodo equals.<p>
	 * Establece las nuevas caracteristicas que determinan si dos packs son iguales: han de tener las mismas bicicletas.
	 * 
	 * @param p1 El pack con el que comparar.
	 * @return true en caso de que ambos packs sean iguales, false en caso contrario.
	 */
	@Override
	public boolean equals (Object p1){
		boolean igual = false;
		
		if(p1 instanceof Pack){
			Pack auxp1 = (Pack) p1;
			// Comprueba que el numero de bicis sea el mismo
			if(this.getNumeroBicis() == auxp1.getNumeroBicis()){
				igual = true;
				// Comprueba que cada bici se encuentre en el pack
				for(int i = 0; i < this.getNumeroBicis() && igual; i++){
					if(!auxp1.estaEnPack(this.alBicis.get(i))) igual = false;
				}
			}
		}
		return igual;
	}
	
	
	/**
	 * Devuelve un true en caso de que la bici pertenezca a un pack. 
	 * 
	 * @param bici Bici que se quiere saber si pertenece al pack.
	 * @return true si pertenece a un pack, false si no
	 */
	public boolean estaEnPack (Bike bici){
		return this.alBicis.contains(bici);
	}
	
	
	/**
	 * Genera un array que contiene todas las bicis que conforman el pack.
	 * 
	 * @return Un array de Bike que contiene todas las bicis del pack.
	 */
	public Bike[] getBicis(){
		Bike[] ret = new Bike[getNumeroBicis()];
		for (int i = 0; i < getNumeroBicis(); i++){
			ret[i] = this.alBicis.get(i).clone();
		}
		return ret;
	
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see entrega2abeherrjorsanj.Resource#getDepositToPay(double)
	 */
	@Override
	public abstract double getDepositToPay(double deposit) throws IllegalArgumentException;
	
	
	/**
	 * Devuelve el numero de bicis que componen el pack.
	 * 
	 * @return Numero de bicis del pack.
	 */
	public int getNumeroBicis(){
		return this.alBicis.size();
	}
	
	
	/**
	 * Elimina una bici de un pack (solo si es posible su eliminacion).
	 *
	 * @param bici Bici que se quiere quitar del pack.
	 * @return true si se ha quitado, false si no
	 */
	public abstract boolean quitarBici(Bike bici);

	
	/**
	 * Redefine el metodo toString.<p>
	 * Permite obtener toda la informacion de un Pack.
	 * 
	 * @return Toda la informacion relativa a un Pack.
	 */
	@Override
	public String toString(){
		String ret = this.getClass().getSimpleName().toString() + "\n";

		for(int i = 0; i < getNumeroBicis(); i++){
			ret += (i+1) + ". " + this.alBicis.get(i).getClass().getSimpleName().toString() + ".\n";
		}

		return ret;
	}
	
}