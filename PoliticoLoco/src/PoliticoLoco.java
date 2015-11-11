import java.util.Random;
import java.util.Scanner;

public class PoliticoLoco {
	static String respuestas[]={
			"Tienes toda la razón, y está totalmente planteado en nuestro proyecto",
			"Si",
			"No",
			"Si,si",
			"Por supuesto",
			"Debemos revirsarlo",
			"La culpa es edel anterior gobierno",
			"Hemos sido los únicos en revisarlo",
			"El anterior gobierno hizo todos esos cambios",
			"Si se vota a otro partido, habrá una recesión",
			"Por supuesto",
			"De acuerdo",
	};
	static Random rn = new Random(); //Generador de numeros aleatorios
	static int numeroMinimo=0; //El número mínimo en el array es el 0
	static int numeroMaximo=respuestas.length;
	//Esta función devolverá una rrespuesta aleatoria de nuestro político loco
	public static String devolverRespuesta(){
		int numeroDentroDelArray = rn.nextInt(numeroMaximo - numeroMinimo + 1) + numeroMinimo;
		
		return respuestas[numeroDentroDelArray];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // Creamos un objeto de la clase Scanner
		System.out.println("--------------------------------");
		System.out.println("---------- POLÍTICO LOCO--------");
		while(true){
			System.out.print("¿Cual es tu pregunta?: ");
			//Pregunta
			String pregunta;
			pregunta= in.nextLine();
			System.out.println(devolverRespuesta());
		}

	}

}
