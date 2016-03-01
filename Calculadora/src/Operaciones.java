
public class Operaciones {
	
	//Ultima operacion realizada
	private float ultimaOp=0;
	
	//Etiqueta para mi LOG
	private static String _NOMBRE="OPERACIONES";
	
	//Constructor de Operaciones
	public Operaciones() {
		System.out.println("Entro en "+_NOMBRE);
	}
	
	//Metodos de entrada salida
	public int suma(int op1,int op2){
		ultimaOp=op1+op2;
		return (int)ultimaOp;
	}
	//Metodo sobrecargado
	public int suma(int op1){
		ultimaOp=op1+ultimaOp;
		return (int)ultimaOp;
	}
	public int resta(int op1,int op2){
		ultimaOp=op1-op2;
		return (int)ultimaOp;
	}
	public int multiplica(int op1,int op2){
		ultimaOp=op1*op2;
		return (int)ultimaOp;
	}
	public float divide(int op1,int op2){
		ultimaOp=op1/op2;
		return ultimaOp;
	}
	
	//Método devolver última operación
	public float ultimaOp(){
		return ultimaOp;
	}
}
