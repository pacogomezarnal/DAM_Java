public class SwingObjects  {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("BIENVENIDOS A MI PROGRAMA DE VENTANAS");
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.cambiarMsg("PAco probando");
		ventana.setVisible(true);
		//ventana.setBounds(100, 100, 800, 300);
	}

	public SwingObjects() {
		
	}

}
