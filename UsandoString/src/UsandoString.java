
public class UsandoString {

	public static void main(String[] args) {
		// Generar dos variables String
		String s1="";
		String s2="Paco";
		
		//Imprimir los String
		System.out.println("El String s2:"+s2);
		
		//Igualar
		System.out.println("Longitud de s1:"+s1.length());
		if(s1.length()==0){
			System.out.println("El String s1 está vacio");
		}
		s1=s2;
		System.out.println("El String s1:"+s1);
		System.out.println("Longitud de s1:"+s1.length());
		
		//Modificar
		s1=s1+" es un campeon";
		System.out.println("El String s1:"+s1);
		System.out.println("El String s2:"+s2);
		
		//String literal frente String objeto
		String s3=new String("Nombre");
		String s4=new String("Nombre");
		
		s1="Paco";
		System.out.println("El String s1:"+s1);
		System.out.println("El String s2:"+s2);
		System.out.println("El String s3:"+s3);
		System.out.println("El String s4:"+s4);
		if(s1==s2){
			System.out.println("s1 = s2");
		}
		if(s3==s4){
			System.out.println("s3 = s4");
		}
		if(s3.compareTo(s4)==0) System.out.println("s3 y s4 sus contenidos son iguales");
		//Otros metodos
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
	}

}
