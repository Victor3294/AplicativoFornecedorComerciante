package guisoftware;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimiteeTipo extends PlainDocument{

	
	public enum TipoEntrada{
		INTEIRO,DECIMAL,TEXTO,EMAIL, DATA, TELEFONE,LOGRADOURO, CNPJ, CEP;
	};
	
	private int ncaracteres;
	private TipoEntrada tipoEntrada;
	
	public LimiteeTipo(int ncaracteres, TipoEntrada tipoEntrada) {
		
		this.ncaracteres = ncaracteres;
		this.tipoEntrada = tipoEntrada;
	}
	@Override
	public void insertString(int offs, String str, AttributeSet a) 
			throws BadLocationException {
		if(str==null || getLength()==ncaracteres) {
			return;
		}
		int totalCaracteres = getLength() + str.length();
		//filtro de caracteres
		
		String regex = "";
		switch(tipoEntrada) {
		case INTEIRO: regex = "[^0-9]"; break;
		case DECIMAL: regex = "[^0-9,.]"; break;
		case TEXTO: regex = "[^\\p{IsLatin} ]"; break;
		case EMAIL: regex = "[^\\p{IsLatin}@\\-_\\!\\?\\.\\+\\*0-9]"; break;
		case DATA: regex = "[^0-9/]"; break; 
		case TELEFONE: regex = "[^0-9\\()\\-]"; break; 
		case LOGRADOURO: regex = "[^\\p{IsLatin}\\.\\:\\;\\-_ 0-9]"; break;
		case CNPJ: regex = "[^0-9/.-]"; break; 
		case CEP: regex = "[^0-9-]"; break;
		
		}
		
		str = str.replaceAll(regex, "");
		
		if(totalCaracteres <= ncaracteres) {
		super.insertString(offs, str, a);
		
		}else {
			String nova = str.substring(0,ncaracteres);
			super.insertString(offs, nova, a);
		}
	}
	
	
}
