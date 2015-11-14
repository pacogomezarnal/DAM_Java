import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{
	//Layout
	private JPanel contentPane;
	private JTextField txtForm;
	private JTextField textMsg;
	private JTextArea textArea;
	private JButton btnComprobacion;
	
	public VentanaPrincipal() {
		setTitle("Mi ventana");

		//Propiedades necesarias para lanzar nuestra ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//DDimensiones de la ventana
		setBounds(100, 100, 500, 300);
		//Añadimos un Layout
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//Lo añadimos al JFrame
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Nuestra primera etiqueta
		JLabel etiquetaNombre = new JLabel("Nombr");
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 11));
		etiquetaNombre.setBounds(10, 11, 464, 14);
		etiquetaNombre.setText("Paco");
		contentPane.add(etiquetaNombre);
		
		//Nuevo JTextField
		txtForm = new JTextField();
		txtForm.setText("Escribe algo");
		txtForm.setBounds(20, 36, 442, 20);
		contentPane.add(txtForm);
		txtForm.setColumns(10);
		
		//Nuevo TExto Mensaje
		textMsg = new JTextField();
		textMsg.setEnabled(false);
		textMsg.setColumns(10);
		textMsg.setBounds(20, 231, 442, 20);
		textMsg.setText("Nuevo mensage de texto");
		textMsg.setEnabled(true);
		contentPane.add(textMsg);
		
		//Nuevo Boton
		btnComprobacion = new JButton("Comprobar");
		//Evento addActionListener
		btnComprobacion.addActionListener(new ActionListener() {
			//Qupe hacemos cuando nos llega un evento
			public void actionPerformed(ActionEvent arg0) {
				String texto=txtForm.getText();
				if(texto.length()==0){
					textMsg.setText("NO HAY CONTENIDO");
				}else{
					textMsg.setText("HAY CONTENIDO");
				}
			}
		});
		btnComprobacion.setBounds(22, 84, 167, 23);
		contentPane.add(btnComprobacion);
		
		//Text Area
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(20, 118, 442, 102);
		contentPane.add(textArea);
	}
	
	public void cambiarMsg(String msg){
		textMsg.setText(msg);
	}
}
