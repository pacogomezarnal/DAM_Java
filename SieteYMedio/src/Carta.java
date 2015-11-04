
/*
 * La definicion de la clase mediante la palabra reservada Cartas
 * 
 * public class NombreClase
 * */
public class Carta {
	
	//PROPIEDADES
	private int numero;
	private String palo;
	
	//CONSTANTES
	public static final String BASTOS="BASTOS";
	public static final String COPAS="COPAS";
	public static final String ESPADAS="ESPADAS";
	public static final String OROS="OROS";

	//Constructor
	//Punto de entrada que se ejecuta al crear un objeto de tipo Carta
	public Carta() {
		System.out.println("Creo un objeto de tipo Carta");
	}
	
	//FUNCIONES O METODOS
	//public/private OUT nombreMetodo(IN)
	public void setNumero(int numero){
		//SI PASA ALGO HAZ ...
		if(numero<1){
			this.numero=1;
		}else if(numero>12){
			this.numero=12;
		}else{
			this.numero=numero;
		}
	}
	
	public int getNumero(){
		return numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		switch (palo){
			case Carta.BASTOS:
				this.palo=Carta.BASTOS;
				break;
			case Carta.OROS:
				this.palo=Carta.OROS;
				break;
			case Carta.COPAS:
				this.palo=Carta.COPAS;
				break;
			case Carta.ESPADAS:
				this.palo=Carta.ESPADAS;
				break;
			default:
				this.palo="BASTOS";
		}
	}

}
