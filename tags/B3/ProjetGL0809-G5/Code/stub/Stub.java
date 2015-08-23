package stub;
import stub.Format;


public class Stub {
	
	// M�thode TraitdeFormat prend en param�tre une ligne du fichier JDT qui permet par la suite
	// de traduire les lignes en Hexa pr�sente dans le fichier jdt.ref

	public static Format TraitdeFormat(String ligne){

		//String valeur;	
		Format Res = null;
		int TabOctetB10[];
		
		
		// Creation d'autant de if que de ligne dans les fichiers TestTraiFormat.jdt et jdt.ref
		
		try {			
			if (ligne.equals("00")){
				TabOctetB10 = new int[1];
				TabOctetB10[0] = 0;
				Res = new Format("00",1,TabOctetB10);
			}
			
			if (ligne.equals("0000")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 0;
				TabOctetB10[1] = 0;
				Res = new Format("0000",2,TabOctetB10);	
			}
			
			if (ligne.equals("00 00")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 0;
				TabOctetB10[1] = 0;
				Res = new Format("00 00",3,TabOctetB10);
			}
			
			if (ligne.equals("99")){
				TabOctetB10 = new int[1];
				TabOctetB10[0] = 153;
				Res = new Format("99",1,TabOctetB10);
			}
			
			if (ligne.equals("9999")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 153;
				TabOctetB10[1] = 153;
				Res = new Format("9999",2,TabOctetB10);
			}
			
			if (ligne.equals("99 99")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 153;
				TabOctetB10[1] = 153;
				Res = new Format("99 99",3,TabOctetB10);
			}
			
			if (ligne.equals("AA")){
				TabOctetB10 = new int[1];
				TabOctetB10[0] = 170;
				Res = new Format("AA",1,TabOctetB10);
			}
			
			if (ligne.equals("AAAA")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 170;
				TabOctetB10[1] = 170;
				Res = new Format("AAAA",2,TabOctetB10);
			}
			
			if (ligne.equals("AA AA")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 170;
				TabOctetB10[1] = 170;
				Res = new Format("AA AA",3,TabOctetB10);
			}
			
			if (ligne.equals("FF")){
				TabOctetB10 = new int[1];
				TabOctetB10[0] = 255;
				Res = new Format("FF",1,TabOctetB10);
			}
			
			if (ligne.equals("FFFF")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 255;
				TabOctetB10[1] = 255;
				Res = new Format("FFFF",2,TabOctetB10);
			}
			
			if (ligne.equals("FF FF")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 255;
				TabOctetB10[1] = 255;
				Res = new Format("FF FF",3,TabOctetB10);
			}
			
			if (ligne.equals("23")){
				TabOctetB10 = new int[1];
				TabOctetB10[0] = 35;
				Res = new Format("23",1,TabOctetB10);
			}
			
			if (ligne.equals("5891")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 88;
				TabOctetB10[1] = 145;
				Res = new Format("5891",2,TabOctetB10);
			}
			
			if (ligne.equals("13 76")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 19;
				TabOctetB10[1] = 118;
				Res = new Format("13 76",3,TabOctetB10);
			}
			
			if (ligne.equals("A2")){
				TabOctetB10 = new int[1];
				TabOctetB10[0] = 162;
				Res = new Format("A2",1,TabOctetB10);
			}
			
			if (ligne.equals("B1F3")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 177;
				TabOctetB10[1] = 243;
				Res = new Format("B1F3",2,TabOctetB10);
			}
			
			if (ligne.equals("1F C2")){
				TabOctetB10 = new int[2];
				TabOctetB10[0] = 31;
				TabOctetB10[1] = 194;
				Res = new Format("1F C2",3,TabOctetB10);
			}
			
			if (ligne.equals("5")){
				Res = new Format("5",0,null);
			}
			
			if (ligne.equals("D")){
				Res = new Format("D",0,null);
			}
			
			if (ligne.equals("0 0")){
				Res = new Format("0 0",0,null);
			}
			
			if (ligne.equals("B B")){
				Res = new Format("B B",0,null);
			}
			
			if (ligne.equals("000 000")){
				Res = new Format("000 000",0,null);
			}
			
			if (ligne.equals("ABF FFF")){
				Res = new Format("ABF FFF",0,null);
			}
			
			if (ligne.equals("0AC15")){
				Res = new Format("0AC15",0,null);
			}
			
			if (ligne.equals("0AC")){
				Res = new Format("0AC",0,null);
			}
			
			if (ligne.equals("AG")){
				Res = new Format("AG",0,null);
			}
			
			if (ligne.equals("7E")){
				TabOctetB10 = new int[1];
				TabOctetB10[0] = 126;
				Res = new Format("A2",1,TabOctetB10);
			}
			
			if (ligne.equals("S2 A3")){
				Res = new Format("S2 A3",0,null);
			}
			
			if (ligne.equals("02DZ")){
				Res = new Format("02DZ",0,null);
			}
			
			if (ligne.equals(" ")){
				Res = new Format(" ",0,null);
			}
			
			if (ligne.equals("bb")){
				Res = new Format("bb",0,null);
			}
			
			if (ligne.equals("3f")){
				Res = new Format("3f",0,null);
			}
			
			if (ligne.equals("a2 09")){
				Res = new Format("a2 09",0,null);
			}
			
			if (ligne.equals("A2cC")){
				Res = new Format("A2cC",0,null);
			}
			
			if (ligne.equals("d001")){
				Res = new Format("d001",0,null);
			}
			
			if (ligne.equals("bbbb")){
				Res = new Format("bbbb",0,null);
			}
			
			if (ligne.equals("a")){
				Res = new Format("a",0,null);
			}
			
			if (ligne.equals("bcd")){
				Res = new Format("bcd",0,null);
			}
			
			if (ligne.equals("Ad231")){
				Res = new Format("Ad231",0,null);
			}
			
			if (ligne.equals("(2A)")){
				Res = new Format("(2A)",0,null);
			}
			
			if (ligne.equals("[FF]")){
				Res = new Format("[FF]",0,null);
			}
			
			if (ligne.equals("{24}")){
				Res = new Format("{24}",0,null);
			}
			
			if (ligne.equals("(A3 32)")){
				Res = new Format("(A3 32)",0,null);
			}
			
			if (ligne.equals("[0A 3F]")){
				Res = new Format("[0A 3F]",0,null);
			}
			
			if (ligne.equals("{2F C1}")){
				Res = new Format("{2F C1}",0,null);
			}
			
			if (ligne.equals("(A2C6)")){
				Res = new Format("(A2C6)",0,null);
			}
			
			if (ligne.equals("[1F20]")){
				Res = new Format("[1F20]",0,null);
			}
			
			if (ligne.equals("@2")){
				Res = new Format("@2",0,null);
			}
			
			if (ligne.equals("A;")){
				Res = new Format("A;",0,null);
			}
			
			if (ligne.equals("1A;")){
				Res = new Format("1A;",0,null);
			}
			
			if (ligne.equals("11 23;")){
				Res = new Format("11 23;",0,null);
			}
			
			if (ligne.equals("A2 3B")){
				Res = new Format("A2 3B",0,null);
			}
			
			if (ligne.equals("2A:11")){
				Res = new Format("2A:11",0,null);
			}
			
			if (ligne.equals("19/2B")){
				Res = new Format("19/2B",0,null);
			}
			
			if (ligne.equals("AB+01")){
				Res = new Format("AB+01",0,null);
			}
			
			if (ligne.equals("A2-0A")){
				Res = new Format("A2-0A",0,null);
			}
			
			if (ligne.equals("FF*2C")){
				Res = new Format("FF*2C",0,null);
			}
			
			if(ligne.equals("")){
				Res = new Format("",0,null);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return Res;
	}
	
}
