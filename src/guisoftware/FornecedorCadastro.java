package guisoftware;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import guisoftware.LimiteeTipo.TipoEntrada;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import pacoteDTO.FornecedorDTO;
import pacote.conector.MetodoDAO;

public class FornecedorCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField nomeFantasiaFornecedorTextField;
	private JTextField cnpjFornecedorTextField;
	private JTextField telefoneFornecedorTextField;
	private JTextField celularFornecedorTextField;
	private JTextField emailFornecedorTextField;
	private JLabel celularFornecedorLabel;
	private JLabel emailFornecedorLabel;
	private JLabel perguntaSeEntregaLabel;
	private JButton continuarCadastroFornecedorButton;
	private JTextField senhaFornecedorTextField;
	private JLabel senhaFornecedorLabel;
	private JTextField razaoSocialFornecedorTextField;
	private JTextPane celularFornecedorTextPane;
	private JTextPane telefoneFornecedorTextPane;
	private JTextPane cnpjFornecedorTextPane;
	private JTextField fornecedorLogradourotextField;
	private JTextField ufFornecedorTextfield;
	private JTextField cidadeFornecedorTextField;
	private JTextField bairroFornecedorTextField;
	private JTextField cepFornecedorTextField;
	private JTextPane fornecedorLogradouroTextPane;
	private JLabel ufFornecedorLabel;
	private JLabel cepComercianteLabel;
	private JTextPane ufFornecedorTextPane;
	private JTextPane cepFornecedorTextPane;
	private JFormattedTextField cepFornecedorFormatted;
	private JFormattedTextField celularFornecedorFormatted;
	private JFormattedTextField telefoneFornecedorFormatted;
	private JFormattedTextField cnpjFornecedorFormatted;
	private MaskFormatter mascaraCep = null;
	private MaskFormatter mascaraCnpj = null;
	private MaskFormatter mascaraTelefone = null;
	private MaskFormatter mascaraCelular = null;
	private JPasswordField senhaFornecedorPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorCadastro frame = new FornecedorCadastro();
					frame.setVisible(true);
					frame.setTitle("Cadastro Fornecedor");
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param cepComercianteFormatted 
	 */
	public FornecedorCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 182, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JLabel nomeFantasiaFornecedorLabel = new JLabel("NOME FANTASIA:");
		nomeFantasiaFornecedorLabel.setBounds(6, 212, 120, 22);
		nomeFantasiaFornecedorLabel.setForeground(new Color(80, 49, 49));
		nomeFantasiaFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(nomeFantasiaFornecedorLabel);
		
		JLabel cnpjFornecedorLabel = new JLabel("CNPJ:");
		cnpjFornecedorLabel.setBounds(73, 262, 51, 22);
		cnpjFornecedorLabel.setForeground(new Color(80, 49, 49));
		cnpjFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(cnpjFornecedorLabel);
		
		JLabel fornecedorCadastroTituloLabel = new JLabel("FORNECEDOR");
		fornecedorCadastroTituloLabel.setBounds(244, 34, 214, 65);
		fornecedorCadastroTituloLabel.setForeground(new Color(80, 49, 49));
		fornecedorCadastroTituloLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(fornecedorCadastroTituloLabel);
		
		JLabel telefoneFornecedorLabel = new JLabel("TELEFONE:");
		telefoneFornecedorLabel.setBounds(26, 312, 100, 22);
		telefoneFornecedorLabel.setForeground(new Color(80, 49, 49));
		telefoneFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(telefoneFornecedorLabel);
		celularFornecedorLabel = new JLabel("CELULAR:");
		celularFornecedorLabel.setBounds(38, 362, 89, 22);
		celularFornecedorLabel.setForeground(new Color(80, 49, 49));
		celularFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(celularFornecedorLabel);
		
		emailFornecedorLabel = new JLabel("E-MAIL:");
		emailFornecedorLabel.setBounds(55, 412, 73, 22);
		emailFornecedorLabel.setForeground(new Color(80, 49, 49));
		emailFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(emailFornecedorLabel);
		
		perguntaSeEntregaLabel = new JLabel("Você faz a entrega dos produtos?");
		perguntaSeEntregaLabel.setBounds(244, 469, 227, 28);
		perguntaSeEntregaLabel.setForeground(new Color(80, 49, 49));
		perguntaSeEntregaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(perguntaSeEntregaLabel);
		
		senhaFornecedorLabel = new JLabel("SENHA:");
		senhaFornecedorLabel.setBounds(402, 412, 73, 22);
		senhaFornecedorLabel.setForeground(new Color(80, 49, 49));
		senhaFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(senhaFornecedorLabel);
		
		JLabel razaoSocialFornecedorLabel = new JLabel("RAZÃO SOCIAL:");
		razaoSocialFornecedorLabel.setBounds(19, 162, 109, 20);
		razaoSocialFornecedorLabel.setForeground(new Color(80, 49, 49));
		razaoSocialFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(razaoSocialFornecedorLabel);
		
		JLabel ufFornecedorLabel = new JLabel("UF:");
		ufFornecedorLabel.setForeground(new Color(80, 49, 49));
		ufFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ufFornecedorLabel.setBounds(443, 162, 30, 23);
		contentPane.add(ufFornecedorLabel);
		
		JLabel cidadeFornecedorLabel = new JLabel("CIDADE:");
		cidadeFornecedorLabel.setForeground(new Color(80, 49, 49));
		cidadeFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cidadeFornecedorLabel.setBounds(396, 212, 77, 20);
		contentPane.add(cidadeFornecedorLabel);
		
		JLabel bairroFornecedorLabel = new JLabel("BAIRRO:");
		bairroFornecedorLabel.setForeground(new Color(80, 49, 49));
		bairroFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bairroFornecedorLabel.setBounds(398, 262, 77, 20);
		contentPane.add(bairroFornecedorLabel);
		
		JLabel logradouroFornecedorLabel = new JLabel("LOGRADOURO:");
		logradouroFornecedorLabel.setForeground(new Color(80, 49, 49));
		logradouroFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logradouroFornecedorLabel.setBounds(336, 362, 135, 20);
		contentPane.add(logradouroFornecedorLabel);
		
		JLabel cepFornecedorLabel = new JLabel("CEP:");
		cepFornecedorLabel.setForeground(new Color(80, 49, 49));
		cepFornecedorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cepFornecedorLabel.setBounds(431, 312, 41, 20);
		contentPane.add(cepFornecedorLabel);
		
		
		
		
		
		
		nomeFantasiaFornecedorTextField = new JTextField();
		nomeFantasiaFornecedorTextField.setBounds(126, 208, 200, 30);
		contentPane.add(nomeFantasiaFornecedorTextField);
		nomeFantasiaFornecedorTextField.setDocument(new LimiteeTipo(50, LimiteeTipo.TipoEntrada.TEXTO));
		nomeFantasiaFornecedorTextField.setColumns(10);
		
		
		
		
		cnpjFornecedorFormatted = new JFormattedTextField();

		try{
            mascaraCnpj = new MaskFormatter("##.###.###/####-##");
            
            mascaraCnpj.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		cnpjFornecedorFormatted = new JFormattedTextField(mascaraCnpj);
		cnpjFornecedorFormatted.setColumns(10);
		cnpjFornecedorFormatted.setBounds(126, 258, 200, 30);
		
		contentPane.add(cnpjFornecedorFormatted);
		
		/*cnpjFornecedorTextField = new JTextField();
		cnpjFornecedorTextField.setBounds(126, 258, 200, 30);
		cnpjFornecedorTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cnpjFornecedorTextPane=new JTextPane();
				cnpjFornecedorTextPane.setText("Ex.: ##.###.###/####-##");
				cnpjFornecedorTextPane.setBounds(146,288,160,18);
				cnpjFornecedorTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
				contentPane.add(cnpjFornecedorTextPane);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cnpjFornecedorTextPane.setVisible(false);
			}
		});
		cnpjFornecedorTextField.setColumns(10);
		cnpjFornecedorTextField.setDocument(new LimiteeTipo(18,LimiteeTipo.TipoEntrada.CNPJ));
		contentPane.add(cnpjFornecedorTextField);*/
			
	
		
		telefoneFornecedorFormatted = new JFormattedTextField();

		try{
            mascaraTelefone = new MaskFormatter("(##)####-####");
            
            mascaraTelefone.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		telefoneFornecedorFormatted = new JFormattedTextField(mascaraTelefone);
		telefoneFornecedorFormatted.setColumns(10);
		telefoneFornecedorFormatted.setBounds(126, 308, 200, 30);
		
		contentPane.add(telefoneFornecedorFormatted);
		
		/*telefoneFornecedorTextField = new JTextField();
		telefoneFornecedorTextField.setBounds(126, 308, 200, 30);
		telefoneFornecedorTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				telefoneFornecedorTextPane=new JTextPane();
				telefoneFornecedorTextPane.setText("Ex.: (##) ####-####");
				telefoneFornecedorTextPane.setBounds(160,338,125,18);
				telefoneFornecedorTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
				contentPane.add(telefoneFornecedorTextPane);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				telefoneFornecedorTextPane.setVisible(false);
			}
		});
		telefoneFornecedorTextField.setColumns(10);
		telefoneFornecedorTextField.setDocument(new LimiteeTipo(15,LimiteeTipo.TipoEntrada.TELEFONE));
		contentPane.add(telefoneFornecedorTextField);*/
		
		
		
		 celularFornecedorFormatted = new JFormattedTextField();

		try{
            mascaraCelular = new MaskFormatter("(##) 9####-####");
            
            mascaraCelular.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		celularFornecedorFormatted = new JFormattedTextField(mascaraCelular);
		celularFornecedorFormatted.setColumns(10);
		celularFornecedorFormatted.setBounds(126, 358, 200, 30);
		
		contentPane.add(celularFornecedorFormatted);
		
		/*celularFornecedorTextField = new JTextField();
		celularFornecedorTextField.setBounds(126, 358, 200, 30);
		celularFornecedorTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				celularFornecedorTextPane=new JTextPane();
				celularFornecedorTextPane.setText("Ex.: (##) 9####-####"); 
				celularFornecedorTextPane.setBounds(160,388,132,18);
				celularFornecedorTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
				contentPane.add(celularFornecedorTextPane);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				celularFornecedorTextPane.setVisible(false);
			}
		});
		celularFornecedorTextField.setColumns(10);
		celularFornecedorTextField.setDocument(new LimiteeTipo(16,LimiteeTipo.TipoEntrada.TELEFONE));
		contentPane.add(celularFornecedorTextField);*/
		
		emailFornecedorTextField = new JTextField();
		emailFornecedorTextField.setBounds(126, 408, 200, 30);
		emailFornecedorTextField.setColumns(10);
		emailFornecedorTextField.setDocument(new LimiteeTipo(70, LimiteeTipo.TipoEntrada.EMAIL));
		contentPane.add(emailFornecedorTextField);
		
		
		
		
		
		senhaFornecedorPassword= new JPasswordField();
		senhaFornecedorPassword.setBounds(475, 408, 200, 30);
		senhaFornecedorPassword.setColumns(10);
		senhaFornecedorPassword.setDocument(new LimiteeTipo(10, LimiteeTipo.TipoEntrada.EMAIL));
		contentPane.add(senhaFornecedorPassword);
		
		
		/*senhaFornecedorTextField = new JTextField();
		senhaFornecedorTextField.setBounds(475, 408, 200, 30);
		senhaFornecedorTextField.setColumns(10);
		contentPane.add(senhaFornecedorTextField);
		*/
		
		
		razaoSocialFornecedorTextField = new JTextField();
		razaoSocialFornecedorTextField.setBounds(126, 158, 202, 30);
		razaoSocialFornecedorTextField.setColumns(10);
		razaoSocialFornecedorTextField.setDocument(new LimiteeTipo(50, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(razaoSocialFornecedorTextField);
		
		fornecedorLogradourotextField = new JTextField();
		fornecedorLogradourotextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				fornecedorLogradouroTextPane = new JTextPane();
				fornecedorLogradouroTextPane.setBounds(468,388,212,18);
				fornecedorLogradouroTextPane.setText("Ex.: Rua:XXX, Nº:###; Complemento:YYY");
				fornecedorLogradouroTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		fornecedorLogradourotextField.setBounds(475, 358, 200, 30);
		fornecedorLogradourotextField.setDocument(new LimiteeTipo(100,LimiteeTipo.TipoEntrada.LOGRADOURO));
		contentPane.add(fornecedorLogradourotextField);
		
		
		
		ufFornecedorTextfield = new JTextField();
		ufFornecedorTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				ufFornecedorTextPane = new JTextPane();
				ufFornecedorTextPane.setBounds(522,187,105,18);
				ufFornecedorTextPane.setText("Ex.: Santa Catarina");
				ufFornecedorTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
				contentPane.add(ufFornecedorTextPane);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ufFornecedorTextPane.setVisible(false);
				
			}
		});
		ufFornecedorTextfield.setColumns(10);
		ufFornecedorTextfield.setBounds(475, 158, 200, 30);
		ufFornecedorTextfield.setDocument(new LimiteeTipo(20, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(ufFornecedorTextfield);
		
		
		
		cidadeFornecedorTextField = new JTextField();
		cidadeFornecedorTextField.setColumns(10);
		cidadeFornecedorTextField.setBounds(475, 208, 200, 30);
		cidadeFornecedorTextField.setDocument(new LimiteeTipo(40, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(cidadeFornecedorTextField);
		
		
		
		bairroFornecedorTextField = new JTextField();
		bairroFornecedorTextField.setColumns(10);
		bairroFornecedorTextField.setBounds(475, 258, 200, 30);
		bairroFornecedorTextField.setDocument(new LimiteeTipo(40, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(bairroFornecedorTextField);
		
		
		
		cepFornecedorFormatted = new JFormattedTextField();

		try{
            mascaraCep = new MaskFormatter("#####-###");
            
            mascaraCep.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		cepFornecedorFormatted = new JFormattedTextField(mascaraCep);
		cepFornecedorFormatted.setColumns(10);
		cepFornecedorFormatted.setBounds(475, 308, 200, 30);
		
		contentPane.add(cepFornecedorFormatted);
		
		
	
		
		
		JButton voltarFornecedorButton = new JButton("VOLTAR");
		voltarFornecedorButton.setBounds(39, 555, 120, 40);
		voltarFornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial fornecedorCadastro = new PaginaInicial();
				fornecedorCadastro.setVisible(true);
				dispose();
			}
		});
		voltarFornecedorButton.setForeground(new Color(198, 182, 155));
		voltarFornecedorButton.setBackground(new Color(80, 49, 49));
		voltarFornecedorButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		voltarFornecedorButton.setFocusable(false);
		contentPane.add(voltarFornecedorButton);
		
		
		JRadioButton simFornecedorRadioButton = new JRadioButton("Sim");
		simFornecedorRadioButton.setBounds(250, 505, 60, 23);
		simFornecedorRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		simFornecedorRadioButton.setForeground(new Color(80, 49, 49));
		simFornecedorRadioButton.setBackground(new Color(198, 182, 155));
		simFornecedorRadioButton.setFocusable(false);
		contentPane.add(simFornecedorRadioButton);
		
		JRadioButton naoFornecedorRadioButton = new JRadioButton("Não");
		naoFornecedorRadioButton.setBounds(410, 505, 61, 23);
		naoFornecedorRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		naoFornecedorRadioButton.setForeground(new Color(80, 49, 49));
		naoFornecedorRadioButton.setBackground(new Color(198, 182, 155));
		naoFornecedorRadioButton.setFocusable(false);
		contentPane.add(naoFornecedorRadioButton);
		
		ButtonGroup grupoBotaoFornecedorCadastro = new ButtonGroup();
		grupoBotaoFornecedorCadastro.add(naoFornecedorRadioButton);
		grupoBotaoFornecedorCadastro.add(simFornecedorRadioButton);
		
		
		
		
		JButton continuarCadastroFornecedorButton = new JButton("CONTINUAR CADASTRO");
		continuarCadastroFornecedorButton.setBounds(474, 555, 180, 40);
		continuarCadastroFornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorDTO objFornecedor = new FornecedorDTO();
				objFornecedor.setRazaoSocialFornecedor(razaoSocialFornecedorTextField.getText());
				objFornecedor.setNomeFantasiaFornecedor(nomeFantasiaFornecedorTextField.getText());
				objFornecedor.setSenhaFornecedor(senhaFornecedorPassword.getPassword());
				objFornecedor.setCnpjFornecedor(cnpjFornecedorFormatted.getText());
				objFornecedor.setCelularFornecedor(celularFornecedorFormatted.getText());
				objFornecedor.setTelefoneFornecedor(telefoneFornecedorFormatted.getText());
				objFornecedor.setEmailFornecedor(emailFornecedorTextField.getText());
				objFornecedor.setUfFornecedor(ufFornecedorTextfield.getText());
				objFornecedor.setCepFornecedor(cepFornecedorFormatted.getText().replaceAll("-", ""));
				objFornecedor.setCidadeFornecedor(cidadeFornecedorTextField.getText());
				objFornecedor.setBairroFornecedor(bairroFornecedorTextField.getText());
				objFornecedor.setLogradouroFornecedor(fornecedorLogradourotextField.getText());
				
				if(simFornecedorRadioButton.isSelected()) {
					objFornecedor.setEntregaFornecedor(true);
				}
				else if(naoFornecedorRadioButton.isSelected()) {
					objFornecedor.setEntregaFornecedor(false);
				}
				MetodoDAO teste = new MetodoDAO();
				teste.Cadastrar(objFornecedor);
				
				
				
				
				Produtos fornecedorCadastro = new Produtos();
				fornecedorCadastro.setVisible(true);
				dispose();
			}
		});
		continuarCadastroFornecedorButton.setBackground(new Color(80, 49, 49));
		continuarCadastroFornecedorButton.setForeground(new Color(198, 182, 155));
		continuarCadastroFornecedorButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		continuarCadastroFornecedorButton.setFocusable(false);
		contentPane.add(continuarCadastroFornecedorButton);
		
		
		
	}
}
