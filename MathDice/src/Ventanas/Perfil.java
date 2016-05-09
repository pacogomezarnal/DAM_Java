package Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Juego.Jugador;
import Juego.JugadorDB;
import Modelo.confDB;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Perfil extends JPanel {
	
	//Elementos de texto del prefil
	private JTextField apellido1Text;
	private JTextField nombreText;
	private JTextField apellido2Text;
	private JTextField edadText;

	//Clase que almacena el Jugador
	private Jugador player;
	//Tres paneles para organizar los controles
	JPanel pizquierda,pcentral,pdrcha;
	private JButton btnNewButton;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component rigidArea_4;
	private Component rigidArea_5;
	private Component rigidArea_6;
	private Component rigidArea_7;
	private JLabel lblPuntos;
	private Component rigidArea_8;
	private JTextField textPuntos;
	private Component rigidArea_9;
	
	private JugadorDB jdb;
	private JTextArea textResultado;
	private JLabel lblNewLabel_1;
	private Component rigidArea_10;
	
	
	public Perfil() {
		setBounds(50, 50, 1000, 530);
		//Imagen del perfil
		ImageIcon imageIcon = new ImageIcon(Perfil.class.getResource("/Ventanas/img/perfil.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = reescalar(image, 200, 200); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 99, 107, 0};
		gridBagLayout.rowHeights = new int[]{200, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Inicializamos el panel de la foto
		pizquierda=new JPanel();
		pizquierda.setLayout(new BoxLayout(pizquierda, BoxLayout.Y_AXIS));
		pizquierda.setPreferredSize(new Dimension(200,200));
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(imageIcon);
		//lblNewLabel.setBounds(10, 11, 200, 200);
		pizquierda.add(lblNewLabel);
		GridBagConstraints gbc_pizquierda = new GridBagConstraints();
		gbc_pizquierda.anchor = GridBagConstraints.NORTHWEST;
		gbc_pizquierda.insets = new Insets(0, 0, 0, 5);
		gbc_pizquierda.gridx = 0;
		gbc_pizquierda.gridy = 0;
		add(pizquierda, gbc_pizquierda);
		
		//Inicializamos el panel de los datos
		pcentral=new JPanel();
		pcentral.setLayout(new BoxLayout(pcentral, BoxLayout.Y_AXIS));		
				
				rigidArea_7 = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea_7);
		
				
				JLabel lblNombre = new JLabel("Nombre");
				//lblNombre.setBounds(271, 11, 46, 14);
				pcentral.add(lblNombre);
				pcentral.add(Box.createRigidArea(new Dimension(0,5)));
				
				nombreText = new JTextField();
				nombreText.setColumns(30);
				//nombreText.setBounds(271, 36, 270, 20);
				pcentral.add(nombreText);
				
				rigidArea = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea);
				
				JLabel lblApellidos = new JLabel("1er Apellido");
				//lblApellidos.setBounds(271, 77, 134, 14);
				pcentral.add(lblApellidos);
				
				rigidArea_1 = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea_1);
				apellido1Text = new JTextField();
				//apellido1Text.setBounds(271, 101, 270, 20);
				pcentral.add(apellido1Text);
				apellido1Text.setColumns(30);
				
				rigidArea_2 = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea_2);
				
				JLabel lbloApellido = new JLabel("2o Apellido");
				//lbloApellido.setBounds(568, 77, 134, 14);
				pcentral.add(lbloApellido);
				
				rigidArea_3 = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea_3);
				
				apellido2Text = new JTextField();
				apellido2Text.setColumns(30);
				//apellido2Text.setBounds(568, 101, 270, 20);
				pcentral.add(apellido2Text);
				
				rigidArea_4 = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea_4);
				
				JLabel lblEdad = new JLabel("Edad");
				//lblEdad.setBounds(271, 143, 46, 14);
				pcentral.add(lblEdad);
				
				rigidArea_5 = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea_5);
				
				edadText = new JTextField();
				edadText.setColumns(30);
				//edadText.setBounds(271, 168, 270, 20);
				pcentral.add(edadText);
				GridBagConstraints gbc_pcentral = new GridBagConstraints();
				gbc_pcentral.fill = GridBagConstraints.HORIZONTAL;
				gbc_pcentral.anchor = GridBagConstraints.NORTH;
				gbc_pcentral.insets = new Insets(0, 0, 0, 5);
				gbc_pcentral.gridx = 1;
				gbc_pcentral.gridy = 0;
				add(pcentral, gbc_pcentral);
				
				rigidArea_8 = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea_8);
				
				lblPuntos = new JLabel("Puntos");
				pcentral.add(lblPuntos);
				
				rigidArea_9 = Box.createRigidArea(new Dimension(0, 5));
				pcentral.add(rigidArea_9);
				
				textPuntos = new JTextField();
				textPuntos.setEnabled(false);
				textPuntos.setEditable(false);
				textPuntos.setColumns(30);
				pcentral.add(textPuntos);
				
				rigidArea_6 = Box.createRigidArea(new Dimension(0, 15));
				pcentral.add(rigidArea_6);
				btnNewButton = new JButton("Actualizar Perfil");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						player.setApellido1(apellido1Text.getText());
						player.setApellido2(apellido2Text.getText());
						player.setNombre(nombreText.getText());
						player.setEdad(Integer.valueOf(edadText.getText()));
						//En este punto actualizaremos el perfil del jugador
						jdb.actualizarUsuario(confDB.getConexion());
						textResultado.setText("Actualización realizada con éxito");
					}
				});
				btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
				pcentral.add(btnNewButton);
		
		//Inicializamos botones de actualización
		pdrcha=new JPanel();
		pdrcha.setLayout(new BoxLayout(pdrcha, BoxLayout.Y_AXIS));	
		GridBagConstraints gbc_pdrcha = new GridBagConstraints();
		gbc_pdrcha.insets = new Insets(5, 20, 0, 20);
		gbc_pdrcha.weightx = 0.2;
		gbc_pdrcha.fill = GridBagConstraints.HORIZONTAL;
		gbc_pdrcha.anchor = GridBagConstraints.NORTH;
		gbc_pdrcha.gridx = 2;
		gbc_pdrcha.gridy = 0;
		add(pdrcha, gbc_pdrcha);
		
		lblNewLabel_1 = new JLabel("Mensajes");
		pdrcha.add(lblNewLabel_1);
		
		rigidArea_10 = Box.createRigidArea(new Dimension(0, 15));
		pdrcha.add(rigidArea_10);
		
		textResultado = new JTextArea();
		textResultado.setEditable(false);
		textResultado.setRows(5);
		pdrcha.add(textResultado);
		

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
		textPuntos.setText(String.valueOf(player.getPuntos()));
		//Creamos el objeto JugaddorDB
		jdb=new JugadorDB(player);
	}
}
