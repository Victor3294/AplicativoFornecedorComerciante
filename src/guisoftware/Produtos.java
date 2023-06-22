package guisoftware;
import java.awt.BorderLayout;





import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import pacote.conector.MetodoDAO;
import pacoteDTO.FornecedorDTO;


import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;


public class Produtos extends JFrame {

	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	
	private JList list;
	private JLabel figuras;
	private JTextField precoTextField;
	private JFormattedTextField precoProdutoFormatted;
	private DecimalFormat FORMAT;
	private JTextPane precoTextPane;
	
	private String[] produtos = {"carne bovina", "carne suína", "aves", "pescados",
			"água mineral","sucos","néctar","refresco","refrigerantes","café","chá",
			"cerveja","vinho","destilados","leite", "queijo","manteiga","iogurte",
			"requeijão","bebida láctea","maçã", "banana","laranja", "pêssego","uva",
			"mamão","alface", "tomate",	"rúcula","pimentão","mandioca",	"batata","batata doce",
			"inhame","castanhas", "amendoim", "noz","avelã","feijão", "soja","lentilha", "ervilha", "grão-de-bico", 
			"trigo", "arroz", "milho", "cevada", "aveia","centeio", "sorgo", "quinoa","pães", "bolos",
			"doces","salgados","embutidos", "enlatados","biscoitos","salgadinhos"};

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos frame = new Produtos();
					frame.setVisible(true);
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
	public Produtos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		setTitle("Cadastro de Produtos");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 182, 155));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel produtosLabel = new JLabel("PRODUTOS");
		produtosLabel.setForeground(new Color(80, 49, 49));
		produtosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		produtosLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		produtosLabel.setBounds(93, 153, 112, 20);
		
		JLabel cadastroDeProdutosLabel = new JLabel("CADASTRO DE PRODUTOS");
		cadastroDeProdutosLabel.setForeground(new Color(80, 49, 49));
		cadastroDeProdutosLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		cadastroDeProdutosLabel.setBounds(136, 41, 396, 51);
		contentPane.add(cadastroDeProdutosLabel);
		contentPane.add(produtosLabel);
		
		JLabel precoLabel = new JLabel("PREÇO");
		precoLabel.setForeground(new Color(80, 49, 49));
		precoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		precoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		precoLabel.setBounds(473, 148, 98, 30);
		contentPane.add(precoLabel);
		
		JLabel reaisLabel = new JLabel("R$");
		reaisLabel.setForeground(new Color(80, 49, 49));
		reaisLabel.setToolTipText("");
		reaisLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reaisLabel.setBounds(424, 214, 32, 18);
		contentPane.add(reaisLabel);
		
		JLabel unikilogramaLabel = new JLabel("Un/Kg");
		unikilogramaLabel.setToolTipText("");
		unikilogramaLabel.setForeground(new Color(80, 49, 49));
		unikilogramaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		unikilogramaLabel.setBounds(617, 214, 55, 18);
		contentPane.add(unikilogramaLabel);
		
		
		
                 
            	
		precoTextField = new JTextField();
		precoTextField.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		precoTextPane = new JTextPane();
		precoTextPane.setBounds(432,240,193,18);
		precoTextPane.setText("Use 2 casas após a vírgula. Ex.: 80,00");
		precoTextPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(precoTextPane);
		}
		@Override
		public void focusLost(FocusEvent e) {
		precoTextPane.setVisible(false);
		}
		});
		precoTextField.setColumns(10);
		precoTextField.setBounds(449, 204, 160, 30);
		precoTextField.setDocument(new LimiteeTipo(8, LimiteeTipo.TipoEntrada.DECIMAL));
		contentPane.add(precoTextField);
		
		
		JButton voltarFornecedorButton = new JButton("VOLTAR");
		voltarFornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorCadastro voltaFornCad = new FornecedorCadastro();
				voltaFornCad.setVisible(true);
				dispose();
			}
		});
		voltarFornecedorButton.setForeground(new Color(198, 182, 155));
		voltarFornecedorButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		voltarFornecedorButton.setBackground(new Color(80, 49, 49));
		voltarFornecedorButton.setBounds(24, 559, 120, 30);
		voltarFornecedorButton.setFocusable(false);
		contentPane.add(voltarFornecedorButton);
		
		
		
		

		JButton cadastrarEnderecoButton = new JButton("CADASTRAR");
		cadastrarEnderecoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String text = precoTextField.getText().replaceAll(",", ".");
				Double value = Double.parseDouble(text);
				
				FornecedorDTO objProduto = new FornecedorDTO();
				Object nome= list.getSelectedValue(); 
				String nomeText = nome.toString();
				System.out.println(nomeText);
				objProduto.setNomeProduto(nomeText);
				objProduto.setProdutoPreco(value);
				
				MetodoDAO objProdutosDao = new MetodoDAO();
				
				objProdutosDao.CadastrarProdutos(objProduto);
				
				System.out.println(list.getSelectedIndex()); 
				
				/*
				try {
					double value = FORMAT.parse(precoProdutoFormatted.getText()).doubleValue();
					System.out.println(value);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			*/	
			}
		});
		cadastrarEnderecoButton.setForeground(new Color(198, 182, 155));
		cadastrarEnderecoButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		cadastrarEnderecoButton.setBackground(new Color(80, 49, 49));
		cadastrarEnderecoButton.setBounds(541, 559, 120, 30);
		cadastrarEnderecoButton.setFocusable(false);
		
		contentPane.add(cadastrarEnderecoButton);
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 204, 215, 227);
		//scrollPane.setLayout(FlowLayout);
		
		contentPane.add(scrollPane);
		//contentPane.add(figuras);
		
		
		figuras = new JLabel();
		figuras.setBounds(310, 245, 120, 110);
		contentPane.add(figuras);
	
		list = new JList(produtos);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tahoma", Font.PLAIN, 17));
		//list.add(figuras);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			/*public void valueChanged(ListSelectionEvent e) {
				System.out.println(list.getSelectedIndex()); 
				System.out.println(list.getSelectedValue());
			
			}
		});
	
		list.addListSelectionListener(new ListSelectionListener() {*/
		
		@Override
		public void valueChanged(ListSelectionEvent e){
			System.out.println(list.getSelectedIndex()); 
			System.out.println(list.getSelectedValue());
			
			int index = list.getSelectedIndex();
			String figurinha = produtos[index];
			figuras.setIcon(new ImageIcon(getClass().getResource("/pastaImagemProdutos/"+figurinha+".png")));
			///pastaImagemProdutos/
																
		}
		});
		list.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(list);
	
	}
}
