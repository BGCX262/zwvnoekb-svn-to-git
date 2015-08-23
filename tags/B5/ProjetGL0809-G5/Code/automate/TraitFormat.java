package automate;

public class TraitFormat {
	public static Format hexa(String chaine){
		String hexa = chaine;
		hexa += '\n';
		
		String H1 = "";
		String H2 = "";
		char c;
		int i = 0;
		int etat = 1;
		boolean erreur = false;
		Format unFormat = null;
		
		while(i<hexa.length() && erreur == false){
			int TabOctetB10[];
			c = hexa.charAt(i);
			TEvent event = carToEvent(c);

			switch(etat){
			case 1:
				switch(event){
				case Hexa:
						etat = 2;
						H1 += c;
						i++;
					break;
				
				default :
					erreur = true;
				}
				break;
			
			case 2:
				switch(event){
				
				case Hexa:
						etat = 3;
						H1 += c;
						i++;
					break;
				
				default :
					erreur = true;
				}
				break;
			
			case 3:
				switch(event){
				case Hexa:
						etat = 5;
						H2 += c;
						i++;
					break;
				
				case Esp:
					etat = 6;
					i++;
				break;
				
				case RC:
					TabOctetB10 = new int[1];
					TabOctetB10[0] = Integer.parseInt(H1,16);
					unFormat = new Format(H1,1,TabOctetB10);
					i++;
				break;
				
				default :
					erreur = true;
				}
				break;
				
			case 5:
				switch(event){
				case Hexa:
						etat = 7;
						H2 += c;
						i++;
					break;
				
				default :
					erreur = true;
				}
				break;
			
			case 6:
				switch(event){
				case Hexa:
						etat = 9;
						H2 += c;
						i++;
					break;
				
				default :
					erreur = true;
				}	
				break;
			
			case 7:
				switch(event){
				case RC:
					TabOctetB10 = new int[2];
					TabOctetB10[0] = Integer.parseInt(H1,16);
					TabOctetB10[1] = Integer.parseInt(H2,16);
					unFormat = new Format(H1+H2,2,TabOctetB10);
					i++;
					break;
				
				default :
					erreur = true;
				}
				break;

			case 9:
				switch(event){
				case Hexa:
						etat = 10;
						H2 += c;
						i++;
					break;
				
				default :
					erreur = true;
				}
				break;
			
			case 10:
				switch(event){
				case RC:
					TabOctetB10 = new int[2];
					TabOctetB10[0] = Integer.parseInt(H1,16);
					TabOctetB10[1] = Integer.parseInt(H2,16);
					unFormat = new Format(H1+" "+H2,3,TabOctetB10);
					i++;
					break;
				
				default :
					erreur = true;
				}
				break;		
			}
		}
		if(erreur){
			return new Format(chaine,0,null);
		}
		else
			return unFormat;
	}
	
	private static TEvent carToEvent(char c){
		if('A' <= c && c <= 'F' || '0' <= c && c <= '9')  
			return TEvent.Hexa;
		else{
			if(c == ' ')
				return TEvent.Esp;
			else{
				if(c == '\n'){
					return TEvent.RC;
				}
				else
					return TEvent.Autre;
			}
		}
	}
}
