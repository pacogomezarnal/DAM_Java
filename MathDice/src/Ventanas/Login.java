package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	Jugador player=new Jugador();
	private JTextField textField_3;
	
	//Referencia a mi ventana
	Login l;
	
	//Ventana de juego
	Juego j=new Juego();


	public Login() {
		setTitle("LOGIN");
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDelJugador = new JLabel("DATOS DEL JUGADOR");
		lblDatosDelJugador.setFont(new Font("Arial", Font.BOLD, 11));
		lblDatosDelJugador.setHorizontalAlignment(SwingConstants.LEFT);
		lblDatosDelJugador.setBounds(10, 11, 143, 14);
		contentPane.add(lblDatosDelJugador);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 47, 78, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(98, 44, 201, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 87, 78, 14);
		contentPane.add(lblApellidos);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 84, 201, 20);
		contentPane.add(textField_1);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 131, 46, 14);
		contentPane.add(lblEdad);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(98, 128, 101, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("A JUGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Comprobaciones
				if((textField.getText().length()==0)||(textField_1.getText().length()==0)||(textField_2.getText().length()==0)){
					textField_3.setText("Falta algún campo por rellenar");
				}
				else if(Integer.valueOf(textField_2.getText())<0){
					textField_3.setText("Edad incorrecta");
				}else{
					player.setNombre(textField.getText());
					player.setApellidos(textField_1.getText());
					player.setEdad(Integer.valueOf(textField_2.getText()));
					
					//Lanzamos la ventana de Juego y hacemos invisible la de Login/Perfil
					j.setJugador(player);
					j.setVisible(true);
					l.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(10, 175, 289, 23);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 209, 289, 42);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		//Referencia a mi ventana
		l=this;
		j=new Juego();
	}
}
