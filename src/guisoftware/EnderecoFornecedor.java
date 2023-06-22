package guisoftware;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnderecoFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField fornecedorLogradourotextField;
	private JTextField bairroFornecedorTextField;
	private JTextField cidadeFornecedorTextfield;
	private JTextField ufFornecedorTextfield;
	private JTextField cepFornecedorTextfield;
	private JTextPane fornecedorLogradouroTextPane;
	private JTextPane ufFornecedorTextPane;
	private JTextPane cepFornecedorTextPane;
	private JLabel ufFornecedorLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnderecoFornecedor frame = new EnderecoFornecedor();
					frame.setVisible(true);
					frame.setTitle("Cadastro Endereço");
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
	public EnderecoFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 182, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fornecedorEnderecoLabel = new JLabel("ENDEREÇO");
		fornecedorEnderecoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fornecedorEnderecoLabel.setForeground(new Color(80, 49, 49));
		fornecedorEnderecoLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		fornecedorEnderecoLabel.setBounds(235, 11, 214, 65);
		contentPane.add(fornecedorEnderecoLabel);
		
		fornecedorLogradourotextField = new JTextField();
		fornecedorLogradourotextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				fornecedorLogradouroTextPane = new JTextPane();
				fornecedorLogradouroTextPane.setBounds(380,151,250,30);
				fornecedorLogradouroTextPane.setText("Ex.: Rua:XXX, Nº:YYY; Complemento:ZZZ");
				fornecedorLogradouroTextPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
				contentPane.add(fornecedorLogradouroTextPane);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				fornecedorLogradouroTextPane.setVisible(false);
				fornecedorLogradouroTextPane.setForeground(new Color(000));
				fornecedorLogradouroTextPane.setBackground(new Color(255,255,255));
			}
		});
		fornecedorLogradourotextField.setColumns(10);
		fornecedorLogradourotextField.setBounds(180, 151, 200, 30);
		contentPane.add(fornecedorLogradourotextField);
		
		JLabel logradouroFornecedorLabel = new JLabel("LOGRADOURO:");
		logradouroFornecedorLabel.setForeground(new Color(80, 49, 49));
		logradouroFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logradouroFornecedorLabel.setBounds(35, 157, 135, 20);
		contentPane.add(logradouroFornecedorLabel);
		
		JLabel bairroFornecedorLabel = new JLabel("BAIRRO:");
		bairroFornecedorLabel.setForeground(new Color(80, 49, 49));
		bairroFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bairroFornecedorLabel.setBounds(93, 344, 77, 20);
		contentPane.add(bairroFornecedorLabel);
		
		bairroFornecedorTextField = new JTextField();
		bairroFornecedorTextField.setColumns(10);
		bairroFornecedorTextField.setBounds(180, 338, 200, 30);
		contentPane.add(bairroFornecedorTextField);
		
		JLabel cidadeFornecedorLabel = new JLabel("CIDADE:");
		cidadeFornecedorLabel.setForeground(new Color(80, 49, 49));
		cidadeFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cidadeFornecedorLabel.setBounds(93, 279, 77, 20);
		contentPane.add(cidadeFornecedorLabel);
		
		cidadeFornecedorTextfield = new JTextField();
		cidadeFornecedorTextfield.setColumns(10);
		cidadeFornecedorTextfield.setBounds(180, 273, 200, 30);
		contentPane.add(cidadeFornecedorTextfield);
		
		JLabel ufFornecedorLabel = new JLabel("UF:");
		ufFornecedorLabel.setForeground(new Color(80, 49, 49));
		ufFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ufFornecedorLabel.setBounds(140, 214, 30, 23);
		contentPane.add(ufFornecedorLabel);
		
		ufFornecedorTextfield = new JTextField();
		ufFornecedorTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				ufFornecedorTextPane = new JTextPane();
				ufFornecedorTextPane.setBounds(380,208,140,30);
				ufFornecedorTextPane.setText("Ex.: Santa Catarina");
				ufFornecedorTextPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
				contentPane.add(ufFornecedorTextPane);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ufFornecedorTextPane.setVisible(false);
				
			}
		});
		ufFornecedorTextfield.setColumns(10);
		ufFornecedorTextfield.setBounds(180, 208, 200, 30);
		contentPane.add(ufFornecedorTextfield);
		
		JLabel CepComercianteLabel = new JLabel("CEP:");
		CepComercianteLabel.setForeground(new Color(80, 49, 49));
		CepComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CepComercianteLabel.setBounds(110, 402, 60, 20);
		contentPane.add(CepComercianteLabel);
		
		cepFornecedorTextfield = new JTextField();
		cepFornecedorTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cepFornecedorTextPane = new JTextPane();
				cepFornecedorTextPane.setBounds(380,396,125,30);
				cepFornecedorTextPane.setText("Ex.: XXXXX-XXX");
				cepFornecedorTextPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
				contentPane.add(cepFornecedorTextPane);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cepFornecedorTextPane.setVisible(false);
			}
		});
		cepFornecedorTextfield.setColumns(10);
		cepFornecedorTextfield.setBounds(180, 396, 200, 30);
		contentPane.add(cepFornecedorTextfield);
		
		JButton voltarFornecedorButton = new JButton("VOLTAR");
		voltarFornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorCadastro enderecoFornecedor = new FornecedorCadastro();
				enderecoFornecedor.setVisible(true);
				dispose();
			}
		});
		voltarFornecedorButton.setForeground(new Color(198, 182, 155));
		voltarFornecedorButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		voltarFornecedorButton.setBackground(new Color(80, 49, 49));
		voltarFornecedorButton.setBounds(35, 550, 120, 30);
		contentPane.add(voltarFornecedorButton);
		
		JButton cadastrarEnderecoButton = new JButton("CADASTRAR");
		cadastrarEnderecoButton.setForeground(new Color(198, 182, 155));
		cadastrarEnderecoButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		cadastrarEnderecoButton.setBackground(new Color(80, 49, 49));
		cadastrarEnderecoButton.setBounds(527, 497, 120, 30);
		contentPane.add(cadastrarEnderecoButton);
		
		JButton inicioBotao = new JButton("INÍCIO");
		inicioBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial enderecoFornecedor = new PaginaInicial();
				enderecoFornecedor.setVisible(true);
				dispose();
			}
		});
		inicioBotao.setForeground(new Color(198, 182, 155));
		inicioBotao.setFont(new Font("Tahoma", Font.BOLD, 13));
		inicioBotao.setBackground(new Color(80, 49, 49));
		inicioBotao.setBounds(527, 550, 120, 30);
		contentPane.add(inicioBotao);
	}
}
