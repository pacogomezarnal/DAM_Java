import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ProbandoBLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoBLayout frame = new ProbandoBLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProbandoBLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnNorte = new JButton("Norte");
		contentPane.add(btnNorte, BorderLayout.NORTH);
		JButton btnNorte2 = new JButton("Norte2");
		contentPane.add(btnNorte2, BorderLayout.NORTH);
		
		JButton btnCentro = new JButton("CENTRO");
		contentPane.add(btnCentro, BorderLayout.CENTER);
		
		JButton btnSur = new JButton("Sur");
		contentPane.add(btnSur, BorderLayout.SOUTH);
		
	}

}
