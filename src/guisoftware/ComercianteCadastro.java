package guisoftware;

import java.awt.EventQueue;





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import guisoftware.LimiteeTipo.TipoEntrada;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import pacote.conector.MetodoDAO;
import pacoteDTO.Comerciante_DTO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JCheckBox;


public class ComercianteCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField razaoSocialComercianteTextField;
	private JTextField nomeFantasiaComercianteTextField;
	private JTextField telefoneComerciantetextfield;
	private JTextField celularComercianteTextField;
	private JTextField emailComercianteTextfield;
	private JTextField ufComercianteTextfield;
	private JTextField cidadeComercianteTextfield;
	private JTextField bairroComercianteTextfield;
	private JTextField logradouroComercianteTextfield;
	private JTextField focoComercianteTextfield;
	private JTextField cnpjComercianteTextField;
	private JFormattedTextField cnpjComercianteFormatted;
	private JFormattedTextField telefoneComercianteFormatted;
	private JFormattedTextField celularComercianteFormatted;
	private JFormattedTextField cepComercianteFormatted;
	private JTextPane logradouroComercianteTextPane;
	private JTextPane focoComercianteTextPane;
	private JTextPane ufComercianteTextPane;
	private JTextPane razaoSocialComercianteTextPane;
	private JTextPane telefoneComercianteTextPane;
	private JTextPane celularComercianteTextPane;
	private JTextPane cnpjComercianteTextPane;
	private JTextField cepComercianteTextField;
	private JTextPane cepComercianteTextPane;
	private JTextField senhaComercianteTextField;
	private MaskFormatter mascaraCep = null;
	private MaskFormatter mascaraCnpj = null;
	private MaskFormatter mascaraTelefone = null;
	private MaskFormatter mascaraCelular = null;
	private JPasswordField senhaComerciantePassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComercianteCadastro frame = new ComercianteCadastro();
					frame.setVisible(true);
					frame.setTitle("Cadastro Comerciante");
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
	public ComercianteCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 185, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel comercianteTituloLabel = new JLabel("Comerciante");
		comercianteTituloLabel.setForeground(new Color(80, 49, 49));
		comercianteTituloLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		comercianteTituloLabel.setBounds(250, 25, 200, 43);
		contentPane.add(comercianteTituloLabel);
		
		JLabel razaoSocialComercianteLabel = new JLabel("RAZÃO SOCIAL:");
		razaoSocialComercianteLabel.setForeground(new Color(80, 49, 49));
		razaoSocialComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		razaoSocialComercianteLabel.setBounds(11, 141, 109, 20);
		contentPane.add(razaoSocialComercianteLabel);
		
		JLabel nomeFantasiaComercianteLabel = new JLabel("NOME FANTASIA:");
		nomeFantasiaComercianteLabel.setForeground(new Color(80, 49, 49));
		nomeFantasiaComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomeFantasiaComercianteLabel.setBounds(0, 191, 120, 20);
		contentPane.add(nomeFantasiaComercianteLabel);
		
		JLabel telefoneComercianteLabel = new JLabel("TELEFONE:");
		telefoneComercianteLabel.setForeground(new Color(80, 49, 49));
		telefoneComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefoneComercianteLabel.setBounds(13, 292, 99, 20);
		contentPane.add(telefoneComercianteLabel);
		
		JLabel celularComercianteLabel = new JLabel("CELULAR:");
		celularComercianteLabel.setForeground(new Color(80, 49, 49));
		celularComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		celularComercianteLabel.setBounds(24, 342, 87, 20);
		contentPane.add(celularComercianteLabel);
		
		JLabel emailComercianteLabel = new JLabel("E-MAIL:");
		emailComercianteLabel.setForeground(new Color(80, 49, 49));
		emailComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailComercianteLabel.setBounds(42, 392, 69, 20);
		contentPane.add(emailComercianteLabel);
		
		JLabel ufComercianteLabel = new JLabel("UF:");
		ufComercianteLabel.setForeground(new Color(80, 49, 49));
		ufComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ufComercianteLabel.setBounds(470, 141, 30, 23);
		contentPane.add(ufComercianteLabel);
		
		JLabel cidadeComercianteLabel = new JLabel("CIDADE:");
		cidadeComercianteLabel.setForeground(new Color(80, 49, 49));
		cidadeComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cidadeComercianteLabel.setBounds(423, 191, 77, 20);
		contentPane.add(cidadeComercianteLabel);
		
		JLabel bairroComercianteLabel = new JLabel("BAIRRO:");
		bairroComercianteLabel.setForeground(new Color(80, 49, 49));
		bairroComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bairroComercianteLabel.setBounds(423, 241, 77, 20);
		contentPane.add(bairroComercianteLabel);
		
		JLabel logradouroComercianteLabel = new JLabel("LOGRADOURO:");
		logradouroComercianteLabel.setForeground(new Color(80, 49, 49));
		logradouroComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logradouroComercianteLabel.setBounds(365, 291, 135, 20);
		contentPane.add(logradouroComercianteLabel);
		
		JLabel focoComercianteLabel = new JLabel("FOCO:");
		focoComercianteLabel.setForeground(new Color(80, 49, 49));
		focoComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		focoComercianteLabel.setBounds(50, 441, 60, 20);
		contentPane.add(focoComercianteLabel);
		
		JLabel cnpjComercianteLabel = new JLabel("CNPJ:");
		cnpjComercianteLabel.setForeground(new Color(80, 49, 49));
		cnpjComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cnpjComercianteLabel.setBounds(58, 241, 51, 20);
		contentPane.add(cnpjComercianteLabel);
		
		JLabel cepComercianteLabel = new JLabel("CEP:");
		cepComercianteLabel.setForeground(new Color(80, 49, 49));
		cepComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cepComercianteLabel.setBounds(461, 341, 51, 20);
		contentPane.add(cepComercianteLabel);
		
		JLabel senhaComercianteLabel = new JLabel("SENHA:");
		senhaComercianteLabel.setForeground(new Color(80, 49, 49));
		senhaComercianteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		senhaComercianteLabel.setBounds(433, 391, 79, 20);
		contentPane.add(senhaComercianteLabel);
		
		
		
		
		
		
		
		razaoSocialComercianteTextField = new JTextField();
		razaoSocialComercianteTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				razaoSocialComercianteTextPane = new JTextPane();
				razaoSocialComercianteTextPane.setBounds(142,117,105,18);
				razaoSocialComercianteTextPane.setText("Ex.: Minha Empresa S.A.");
				razaoSocialComercianteTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
				contentPane.add(razaoSocialComercianteTextPane);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				razaoSocialComercianteTextPane.setVisible(false);
				
			}
		});
		razaoSocialComercianteTextField.setBounds(119, 135, 150, 30);
		contentPane.add(razaoSocialComercianteTextField);
		razaoSocialComercianteTextField.setDocument(new LimiteeTipo(50, LimiteeTipo.TipoEntrada.TEXTO));
		razaoSocialComercianteTextField.setColumns(10);
		
		nomeFantasiaComercianteTextField = new JTextField();
		nomeFantasiaComercianteTextField.setColumns(10);
		nomeFantasiaComercianteTextField.setBounds(119, 185, 150, 30);
		nomeFantasiaComercianteTextField.setDocument(new LimiteeTipo(50, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(nomeFantasiaComercianteTextField);
		
		
		
		
		telefoneComercianteFormatted = new JFormattedTextField();

		try{
            mascaraTelefone = new MaskFormatter("(##)####-####");
            
            mascaraTelefone.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		telefoneComercianteFormatted = new JFormattedTextField(mascaraTelefone);
		telefoneComercianteFormatted.setColumns(10);
		telefoneComercianteFormatted.setBounds(119, 286, 150, 30);
		
		contentPane.add(telefoneComercianteFormatted);
		
		celularComercianteFormatted = new JFormattedTextField();

		try{
            mascaraCelular = new MaskFormatter("(##) 9####-####");
            
            mascaraCelular.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		celularComercianteFormatted = new JFormattedTextField(mascaraCelular);
		celularComercianteFormatted.setColumns(10);
		celularComercianteFormatted.setBounds(119, 336, 150, 30);
		
		contentPane.add(celularComercianteFormatted);
		
		emailComercianteTextfield = new JTextField();
		emailComercianteTextfield.setColumns(10);
		emailComercianteTextfield.setBounds(119, 386, 150, 30);
		emailComercianteTextfield.setDocument(new LimiteeTipo(70, LimiteeTipo.TipoEntrada.EMAIL));
		emailComercianteTextfield.setToolTipText("Espaço ( ) não é aceito como caracter");
		contentPane.add(emailComercianteTextfield);
		
		ufComercianteTextfield = new JTextField("São Paulo");
		ufComercianteTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				ufComercianteTextPane = new JTextPane();
				ufComercianteTextPane.setBounds(536,117,102,18);
				ufComercianteTextPane.setText("Ex.: Santa Catarina");
				ufComercianteTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
				contentPane.add(ufComercianteTextPane);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ufComercianteTextPane.setVisible(false);
				
			}
		});
		ufComercianteTextfield.setColumns(10);
		ufComercianteTextfield.setBounds(510, 135, 150, 30);
		ufComercianteTextfield.setDocument(new LimiteeTipo(20, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(ufComercianteTextfield);
		
		cidadeComercianteTextfield = new JTextField();
		cidadeComercianteTextfield.setColumns(10);
		cidadeComercianteTextfield.setBounds(510, 185, 150, 30);
		cidadeComercianteTextfield.setDocument(new LimiteeTipo(40, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(cidadeComercianteTextfield);
		
		bairroComercianteTextfield = new JTextField();
		bairroComercianteTextfield.setColumns(10);
		bairroComercianteTextfield.setBounds(510, 235, 150, 30);
		bairroComercianteTextfield.setDocument(new LimiteeTipo(40, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(bairroComercianteTextfield);
		
		logradouroComercianteTextfield = new JTextField();
		logradouroComercianteTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				logradouroComercianteTextPane = new JTextPane();
				logradouroComercianteTextPane.setBounds(491,267,190,18);
				logradouroComercianteTextPane.setText("Rua:XXX, Nº:###; Complemento:ZZZ");
				logradouroComercianteTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
				contentPane.add(logradouroComercianteTextPane);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logradouroComercianteTextPane.setVisible(false);
				
			}
		});
		
		logradouroComercianteTextfield.setColumns(10);
		logradouroComercianteTextfield.setBounds(510, 285, 150, 30);
		logradouroComercianteTextfield.setDocument(new LimiteeTipo(100,LimiteeTipo.TipoEntrada.LOGRADOURO));
		contentPane.add(logradouroComercianteTextfield);
		
		focoComercianteTextfield = new JTextField("Ex.: Produtos Naturais");
		
		focoComercianteTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				focoComercianteTextPane = new JTextPane();
				focoComercianteTextPane.setBounds(113,417,163,18);
				focoComercianteTextPane.setText("Foco de vendas de seu comercio");
				focoComercianteTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
				contentPane.add(focoComercianteTextPane);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				focoComercianteTextPane.setVisible(false);
					
			}
		});
		focoComercianteTextfield.setColumns(10);
		focoComercianteTextfield.setBounds(119, 435, 150, 30);
		focoComercianteTextfield.setDocument(new LimiteeTipo(70, LimiteeTipo.TipoEntrada.TEXTO));
		contentPane.add(focoComercianteTextfield);
		
		
		
		
	    cnpjComercianteFormatted = new JFormattedTextField();

		try{
            mascaraCnpj = new MaskFormatter("##.###.###/####-##");
            
            mascaraCnpj.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		cnpjComercianteFormatted = new JFormattedTextField(mascaraCnpj);
		cnpjComercianteFormatted.setColumns(10);
		cnpjComercianteFormatted.setBounds(119, 235, 150, 30);
		
		contentPane.add(cnpjComercianteFormatted);
		
		cepComercianteFormatted = new JFormattedTextField();

		try{
            mascaraCep = new MaskFormatter("#####-###");
            
            mascaraCep.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		cepComercianteFormatted = new JFormattedTextField(mascaraCep);
		cepComercianteFormatted.setColumns(10);
		cepComercianteFormatted.setBounds(510, 335, 150, 30);
		
		contentPane.add(cepComercianteFormatted);
		
				
		
		
		senhaComerciantePassword= new JPasswordField();
		senhaComerciantePassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				char[] password = senhaComerciantePassword.getPassword();
				String senha = new String (password);
				JOptionPane.showMessageDialog(null, "Grave sua senha: " +  senha);
			
				
			}
		});
		senhaComerciantePassword.setBounds(510, 385, 150, 30);
		senhaComerciantePassword.setColumns(10);
		senhaComerciantePassword.setDocument(new LimiteeTipo(10, LimiteeTipo.TipoEntrada.EMAIL));
		senhaComerciantePassword.setEchoChar('*');
		contentPane.add(senhaComerciantePassword);
		
		JCheckBox senhaCheckbox = new JCheckBox("Mostrar Senha");
		senhaCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(senhaCheckbox.isSelected()) {
					senhaComerciantePassword.setEchoChar((char)0);
				}else {
					senhaComerciantePassword.setEchoChar('*');
				}
			}
		});
		senhaCheckbox.setForeground(new Color(255, 255, 255));
		senhaCheckbox.setBackground(new Color(80, 49, 49));
		senhaCheckbox.setBounds(526, 425, 117, 23);
		contentPane.add(senhaCheckbox);
		
		/*senhaComercianteTextField = new JTextField();
		senhaComercianteTextField.setColumns(10);
		senhaComercianteTextField.setBounds(510, 385, 150, 30);
		contentPane.add(senhaComercianteTextField);
		*/
		
		
		
		
		
		
		JButton cadastrarComercianteButton = new JButton("CADASTRAR");
		cadastrarComercianteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String cnpj = cnpjComercianteFormatted.getText().replaceAll("-", "").replaceAll("/", "").replaceAll("\\.", "");
					String telefone = telefoneComercianteFormatted.getText().replaceAll("\\(","").replaceAll("\\)", "").replaceAll("-", "").replaceAll("\\s", "");
					String celular = celularComercianteFormatted.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").replaceAll("\\s", "");
					
					
					Comerciante_DTO comercianteobj = new Comerciante_DTO();
				    comercianteobj.setRazaoSocialComerciante(razaoSocialComercianteTextField.getText());
				    comercianteobj.setNomeFantasiaComerciante(nomeFantasiaComercianteTextField.getText().replaceAll("\\s", ""));
				    comercianteobj.setSenhaComerciante(senhaComerciantePassword.getPassword());
				    comercianteobj.setFocoComerciante(focoComercianteTextfield.getText());
				    comercianteobj.setCnpjComerciante(cnpj);
				    comercianteobj.setTelefoneComerciante(telefone);
				    comercianteobj.setCelularComerciante(celular);
				    comercianteobj.setEmailComerciante(emailComercianteTextfield.getText());
				    comercianteobj.setUfComerciante(ufComercianteTextfield.getText());
				    comercianteobj.setCidadeComerciante(cidadeComercianteTextfield.getText());
				    comercianteobj.setBairroComerciante(bairroComercianteTextfield.getText());
				    comercianteobj.setLogradouroComerciante(logradouroComercianteTextfield.getText());
				    comercianteobj.setCepComerciante(cepComercianteFormatted.getText().replaceAll("-", ""));
				    MetodoDAO teste = new MetodoDAO();
				    teste.Cadastrar(comercianteobj);
				
				
			    
			    
				LOGIN comercianteCadastro = new LOGIN();
				comercianteCadastro.setVisible(true);
				dispose();
			}
		});
		cadastrarComercianteButton.setForeground(new Color(198, 182, 155));
		cadastrarComercianteButton.setBackground(new Color(80, 49, 49));
		cadastrarComercianteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		cadastrarComercianteButton.setBounds(527, 539, 120, 30);
		cadastrarComercianteButton.setFocusable(true);
		contentPane.add(cadastrarComercianteButton);
		
		JButton voltarComercianteButton = new JButton("VOLTAR");
		voltarComercianteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial comercianteCadastro = new PaginaInicial();
				comercianteCadastro.setVisible(true);
				dispose();
			}
		});
		voltarComercianteButton.setBackground(new Color(80, 49, 49));
		voltarComercianteButton.setForeground(new Color(198, 182, 155));
		voltarComercianteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		voltarComercianteButton.setBounds(37, 539, 120, 30);
		voltarComercianteButton.setFocusable(false);
		contentPane.add(voltarComercianteButton);
		
		
		
		
	}
}
