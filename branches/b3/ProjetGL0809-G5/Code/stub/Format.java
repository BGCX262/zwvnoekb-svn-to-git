package stub;

public class Format {
	
	// Declarations de variables
	private String hexa;
	private int noFormat;
	private int tabOctetB10[];

	
	public Format(String hexa, int numFormat, int[] tabOctetB10){
		this.hexa = hexa;
		this.noFormat = numFormat;
		this.tabOctetB10 = tabOctetB10;	
	}
	
	// GETTER
	public String getHexa(){
		return this.hexa;
	}
	
	public int getNoFormat(){
		return noFormat;
	}
	
	public int[] getTabOctet(){
		return this.tabOctetB10;
	}
	
	public String toString(){
		String valeur;
		if(tabOctetB10!=null){
			valeur = "F" + noFormat + " " + tabOctetB10[0];
			if(tabOctetB10.length == 2)
				valeur +=" "+tabOctetB10[1];
		}else
			valeur = "F" + noFormat + " " + hexa;
		return valeur;
	}		
}
