
public class UsandoArrays_1 {

	public static void main(String[] args) {
		//Las diez calificaciones
		int nota1=0,nota2=4,nota3=6,nota4=9;
		//Array de calificaciones
		//0,4,6,9,4,5,6,7
		//tipo[] nombreArray=new tipo[numero de elementos]
		int[] calificacion=new int[10];
		float media;
		
		//Metodo largo insufrible
		media=(nota1+nota2+nota3+nota4)/4;
		
		//REllenar los elementos de un array
		calificacion[0]=0;
		calificacion[1]=4;
		calificacion[2]=6;
		calificacion[3]=7;
		calificacion[4]=8;
		calificacion[9]=4;
		calificacion[8]=5;
		calificacion[7]=5;
		calificacion[6]=5;
		calificacion[5]=9;
		
		//Calcular la media de un array de calificaciones
		media=0;
		for(int pos=0;pos<calificacion.length;pos++){
			media=media+calificacion[pos];
			System.out.println("media: "+media);
		}
		
		media=media/calificacion.length;
		System.out.println("media: "+media);
	}
		

}

