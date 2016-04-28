package Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Juego.Jugador;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Perfil extends JPanel {
	
	//Elementos de texto del prefil
	private JTextField apellido1Text;
	private JTextField nombreText;
	private JTextField apellido2Text;
	private JTextField edadText;

	//Clase que almacena el Jugador
	private Jugador player;
	
	
	public Perfil() {
		setBounds(50, 50, 1000, 530);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Foto");
		//Imagen del perfil
		ImageIcon imageIcon = new ImageIcon(Perfil.class.getResource("/Ventanas/img/perfil.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = reescalar(image, 200, 200); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(10, 11, 200, 200);
		add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(271, 11, 46, 14);
		add(lblNombre);
		
		apellido1Text = new JTextField();
		apellido1Text.setBounds(271, 101, 270, 20);
		add(apellido1Text);
		apellido1Text.setColumns(10);
		
		JLabel lblApellidos = new JLabel("1er Apellido");
		lblApellidos.setBounds(271, 77, 134, 14);
		add(lblApellidos);
		
		nombreText = new JTextField();
		nombreText.setColumns(10);
		nombreText.setBounds(271, 36, 270, 20);
		add(nombreText);
		
		JLabel lbloApellido = new JLabel("2o Apellido");
		lbloApellido.setBounds(568, 77, 134, 14);
		add(lbloApellido);
		
		apellido2Text = new JTextField();
		apellido2Text.setColumns(10);
		apellido2Text.setBounds(568, 101, 270, 20);
		add(apellido2Text);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(271, 143, 46, 14);
		add(lblEdad);
		
		edadText = new JTextField();
		edadText.setColumns(10);
		edadText.setBounds(271, 168, 270, 20);
		add(edadText);
		

	}
	
	private Image reescalar(Image srcImg, int w, int h){
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
	public void setJugador(Jugador player){
		this.player=player;
		//Colocamos los datos del Jugador
		nombreText.setText(player.getNombre());
		apellido1Text.setText(player.getApellido1());
		apellido2Text.setText(player.getApellido2());
		edadText.setText(String.valueOf(player.getEdad()));
	}
}
