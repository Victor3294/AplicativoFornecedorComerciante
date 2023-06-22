package pacote.conector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import pacoteDTO.Comerciante_DTO;
import pacoteDTO.FornecedorDTO;


public class MetodoDAO {
	
	public Connection ConectaBD() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/banco_projeto?user=root&password=root";
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ConexaoDao" +  e.getMessage());
		}
		
		return conn;
	}
	
	public int retiraIDComerciante() {
		Connection conn = ConectaBD();
		int id = 0;
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select id_Comerciante from comerciante ORDER BY id_Comerciante DESC limit 1;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				id = rs.getInt("id_Comerciante");
			}
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Retira ID Comerciante " +  e.getMessage());
		}
		return id;
	}
	
	public int retiraIDFornecedor() {
		Connection conn = ConectaBD();
		int id = 0;
			try {
				Statement stmt = conn.createStatement();
				String sql = "Select id_Fornecedor from fornecedor ORDER BY id_Fornecedor DESC limit 1;";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					id = rs.getInt("id_Fornecedor");
				}
				
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Retira ID Fornecedor " +  e.getMessage());
			}
		return id;
	}
	
	
	public void Cadastrar(Comerciante_DTO objComerciante) {
		PreparedStatement pstmt;
		Connection conn = ConectaBD();
		try {
			
			System.out.println("Inserindo dados em tabela");
	        String sql = "INSERT INTO comerciante (id_Comerciante, nome_Fantasia_Comerciante, razao_Social_Comerciante, foco, cnpj_Comerciante, senha_Comerciante) VALUES (default, ?, ?, ?, ?, ?)";

	        
	        pstmt = conn.prepareStatement(sql);
	        String strPass = new String(objComerciante.getSenhaComerciante()).trim();
	        pstmt.setString(1, objComerciante.getNomeFantasiaComerciante() );
	        pstmt.setString(2, objComerciante.getRazaoSocialComerciante());
	        pstmt.setString(3, objComerciante.getFocoComerciante());
	        pstmt.setString(4, objComerciante.getCnpjComerciante());
	        pstmt.setString(5, strPass);
	   
	        pstmt.execute();
	        pstmt.close();
	        
	        int id = retiraIDComerciante();
	        
	        String sql2 = "INSERT INTO contatocomerciante(id_Comerciante, telefone_Comerciante, celular_Comerciante, email_Comerciante) VALUES (?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sql2);
	        pstmt.setInt(1, id);
	        pstmt.setString(2, objComerciante.getTelefoneComerciante());
	        pstmt.setString(3, objComerciante.getCelularComerciante());
	        pstmt.setString(4, objComerciante.getEmailComerciante());
	        
	        pstmt.execute();
	        pstmt.close();
	        
	        String sql3 = "INSERT INTO enderecocomerciante(id_Comerciante, uf_Comerciante, cidade_Comerciante, bairro_Comerciante, logradouro_Comerciante, cep_Comerciante) VALUES (?, ?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sql3);
	        pstmt.setInt(1, id);
	        pstmt.setString(2, objComerciante.getUfComerciante());
	        pstmt.setString(3, objComerciante.getCidadeComerciante());
	        pstmt.setString(4, objComerciante.getBairroComerciante());
	        pstmt.setString(5, objComerciante.getLogradouroComerciante());
	        pstmt.setString(6, objComerciante.getCepComerciante());
	        
	        pstmt.execute();
	        pstmt.close();
	         
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cadastrar Comerciante" +  e.getMessage());
		}
		
	}
	
	public void Cadastrar(FornecedorDTO objFornecedor) {
		PreparedStatement pstmt;
		Connection conn = ConectaBD();
		try {
			
			System.out.println("Inserindo dados em tabela");
	        String sql = "INSERT INTO fornecedor (id_Fornecedor, nome_Fantasia_Fornecedor, razao_Social_Fornecedor, cnpj_Fornecedor, senha_Fornecedor, entrega_Fornecedor) VALUES (default, ?, ?, ?, ?, ?)";
	        
	        pstmt = conn.prepareStatement(sql);
	        String strPass = new String(objFornecedor.getSenhaFornecedor()).trim();
	        pstmt.setString(1, objFornecedor.getNomeFantasiaFornecedor() );
	        pstmt.setString(2, objFornecedor.getRazaoSocialFornecedor());
	        pstmt.setString(3, objFornecedor.getCnpjFornecedor());
	        pstmt.setString(4, strPass);
	        pstmt.setBoolean(5, objFornecedor.getEntregaFornecedor());
	   
	        pstmt.execute();
	        pstmt.close();
	        
	        int id = retiraIDFornecedor();
	        String sql2 = "INSERT INTO contatofornecedor(id_Fornecedor, telefone_Fornecedor, celular_Fornecedor, email_Fornecedor) VALUES(?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sql2);
	        pstmt.setInt(1, id);
	        pstmt.setString(2, objFornecedor.getTelefoneFornecedor());
	        pstmt.setString(3, objFornecedor.getCelularFornecedor());
	        pstmt.setString(4, objFornecedor.getEmailFornecedor());
	        
	        pstmt.execute();
	        pstmt.close();
	        
	        String sql3 = "INSERT INTO enderecofornecedor(id_Fornecedor, uf_Fornecedor, cidade_Fornecedor, bairro_Fornecedor, logradouro_Fornecedor, cep_Fornecedor) VALUES(?, ?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sql3);
	        pstmt.setInt(1, id);
	        pstmt.setString(2, objFornecedor.getUfFornecedor());
	        pstmt.setString(3, objFornecedor.getCidadeFornecedor());
	        pstmt.setString(4, objFornecedor.getBairroFornecedor());
	        pstmt.setString(5, objFornecedor.getLogradouroFornecedor());
	        pstmt.setString(6, objFornecedor.getCepFornecedor());
	        pstmt.execute();
	        pstmt.close();
	        
	        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cadastrar Fornecedor" +  e.getMessage());
		}
		
	}
	
	
	
	public void CadastrarProdutos(FornecedorDTO objProdutos) {
		
		PreparedStatement pstmt;
		Connection conn = ConectaBD();
		
		try {
			System.out.println("Inserindo dados em tabela");
	        String sql = "INSERT INTO produtos (nome_Produto, id_Fornecedor, preco) VALUES ( ?, ?, ?)";
	        
	        int id = retiraIDFornecedor();
	        
	       pstmt=conn.prepareStatement(sql);
	       pstmt.setString(1, objProdutos.getNomeProduto());
	       pstmt.setInt(2, id);
	       pstmt.setDouble(3, objProdutos.getProdutoPreco());
	       
			
	       pstmt.execute();
	       pstmt.close();
	        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cadastrar Produtos " +  e.getMessage());
		}
		
	}
	
	
	
	
	
	public ResultSet autenticaUsuario(FornecedorDTO objFornecedor) {
		Connection conn = ConectaBD();
			try {
				String sql = "Select * from fornecedor where cnpj_Fornecedor = ? and senha_Fornecedor = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				String strPass = new String(objFornecedor.getSenhaFornecedor()).trim();
				pstmt.setString(1, objFornecedor.getCnpjFornecedor());
				pstmt.setString(2, strPass);
				ResultSet rs = pstmt.executeQuery();
				return rs;
				
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Cadastrar Fornecedor" +  erro.getMessage());
				return null;
			}
	}
	
	public ResultSet autenticaUsuario(Comerciante_DTO objComerciante) {
		Connection conn = ConectaBD();
			try {
				String sql = "Select * from comerciante where cnpj_Comerciante = ? and senha_Comerciante = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				String strPass = new String(objComerciante.getSenhaComerciante()).trim();
				pstmt.setString(1, objComerciante.getCnpjComerciante());
				pstmt.setString(2, strPass);
				ResultSet rs = pstmt.executeQuery();
				return rs;
				
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Autentica Usuario" +  erro.getMessage());
				return null;
			}
	}
	
	public ArrayList<FornecedorDTO> retiraIDFornecedorProduto( FornecedorDTO objFornecedor){
		Connection conn = ConectaBD();
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<FornecedorDTO> listaID = new ArrayList<>();
		String sql = "SELECT id_Fornecedor FROM produtos WHERE nome_Produto = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, objFornecedor.getNomeProduto());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FornecedorDTO objFornecedorId = new FornecedorDTO();
				objFornecedorId.setIdFornecedor(rs.getInt("id_Fornecedor"));
				listaID.add(objFornecedorId);
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "RetiraIDFornecedorProduto: " +  erro.getMessage());
			return null;
		}
		return listaID;
		
	}
	
	public ArrayList<FornecedorDTO> PesquisaFornecedor( FornecedorDTO objFornecedor){
		Connection conn = ConectaBD();
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<FornecedorDTO> lista = new ArrayList<>();
		String sql = "SELECT fornecedor.nome_Fantasia_Fornecedor, fornecedor.entrega_Fornecedor, produtos.nome_Produto, produtos.preco FROM fornecedor JOIN produtos ON fornecedor.id_Fornecedor = produtos.id_Fornecedor WHERE produtos.nome_Produto = ? ;";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, objFornecedor.getNomeProduto());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			FornecedorDTO objFornecedorLista = new FornecedorDTO();
			objFornecedorLista.setNomeFantasiaFornecedor(rs.getString("nome_Fantasia_Fornecedor"));
			objFornecedorLista.setEntregaFornecedor(rs.getBoolean("entrega_Fornecedor"));
			objFornecedorLista.setNomeProduto(rs.getString("nome_Produto"));
			objFornecedorLista.setProdutoPreco(rs.getDouble("preco"));
			lista.add(objFornecedorLista);
			}
				
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "PesquisaFornecedor: " +  erro.getMessage());
			return null;
		}
		return lista;
	}
	
}


