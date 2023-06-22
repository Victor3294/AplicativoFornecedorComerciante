package guisoftware;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Produtos2 extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField precoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos2 frame = new Produtos2();
					frame.setVisible(true);
					frame.setTitle("Cadastrar Produto");
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Produtos2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 182, 155));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel tituloLabel = new JLabel("PRODUTOS");
		tituloLabel.setForeground(new Color(80, 49, 49));
		tituloLabel.setBounds(248, 46, 175, 44);
		tituloLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(tituloLabel);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setForeground(new Color(80, 49, 49));
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeLabel.setBounds(10, 226, 59, 25);
		contentPane.add(nomeLabel);
		
		JLabel precoLabel = new JLabel("Preço:");
		precoLabel.setForeground(new Color(80, 49, 49));
		precoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		precoLabel.setBounds(10, 339, 59, 30);
		contentPane.add(precoLabel);
		
		
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(79, 221, 319, 30);
		contentPane.add(nomeTextField);
				
		
		precoTextField = new JTextField();
		precoTextField.setColumns(10);
		precoTextField.setBounds(79, 339, 165, 30);
		contentPane.add(precoTextField);
		
		
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBackground(new Color(80, 49, 49));
		btnCadastrar.setForeground(new Color(198, 182, 155));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrar.setBounds(512, 558, 120, 30);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AreaFornecedor produtos = new AreaFornecedor();
				produtos.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(new Color(80, 49, 49));
		btnVoltar.setForeground(new Color(198, 182, 155));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltar.setBounds(30, 558, 120, 30);
		btnVoltar.setFocusable(false);
		contentPane.add(btnVoltar);
	}

}
