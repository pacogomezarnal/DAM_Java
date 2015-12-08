
public class UsandoArrays_3 {

	public static void main(String[] args) {
		//tipo nombre = inicializacion/new
		Figura[] conjunto=new Figura[10];
		//Elemento figura temporal
		Figura f;
		
		//Nueva Figura en la posicion 0
		//conjunto[0]=new Figura();
		//f=conjunto[0];
		//f.setAlto(5);
		//System.out.println("El alto de la Figura es "+f.getAlto());
		
		//Inicialización
		for(int i=0;i<conjunto.length;i++){
			conjunto[i]=new Figura();
		}
		
		

	}

}
