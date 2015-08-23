package testULAutomate;

import java.io.*;
import java.util.Scanner;

import oracle.Oracle;
import autoTest.*;
import automate.*;

import comparateur.Comparateur;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		menuPrincipal();
	}
	
	private static void menuPrincipal(){
		Scanner sc = new Scanner(System.in);
		System.out.println("-- MENU --");
		System.out.println();
		System.out.println("[1] - AutoTest");
		System.out.println("[2] - Mode interactif");
		System.out.println("[3] - Mode Batch");
		System.out.println("[4] - Quitter");
		System.out.println();
		System.out.print("Choix : ");
		String str = sc.nextLine();
		if(str.equals("1")){
			System.out.println();
			System.out.println("Début de l'AutoTest");
			autoTest();
			System.out.println("Fin de l'AutoTest");
			System.out.println();
			menuPrincipal();
		}else{
			if(str.equals("2")){
				menuModeInteractif();
				System.out.println();
			}else{
				if(str.equals("3")){
					System.out.println();
					System.out.println("Début du batch");
					batch();
					System.out.println("Fin du batch");
					System.out.println();
					menuPrincipal();
				}
				else{
					if(str.equals("4")){
						System.out.println();
						System.out.println("Fermeture du programme");
					}else{
					System.out.println("Erreur veuillez choisir 1, 2 ou 3");
					System.out.println();
					menuPrincipal();
					}
				}
			}
		}
	}
	
	private static void autoTest(){
		AutoTest.testTraitFormat("Data Tests\\Recette2009_2.txt","Data Tests\\JDT.run");
		System.out.println("Auto OK");
		Oracle.oracleConversion("Data Tests\\JDT.run", "Data Tests\\Oracle.run");
		System.out.println("Oracle OK");
		Comparateur.fichier("Data Tests\\Oracle.run", "Data Tests\\Recette2009_2.txt", "Data Tests\\ResultatComparateur.txt");
	}
	
	private static void menuModeInteractif(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("[1] - Entrez une valeur hexadecimal");
		System.out.println("[2] - Retour");
		System.out.println();
		System.out.print("Choix : ");
		String str = sc.nextLine();
		if(str.equals("1")){
			interactif();
			menuModeInteractif();
		}else{
			if(str.equals("2")){
				menuPrincipal();
			}
			else{
				menuModeInteractif();
			}
		}
	}
	
	private static void batch(){
		System.out.print("Entrez le nom du fichier : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Data tests\\"+str)));
			String ligne;
			PrintWriter result = new PrintWriter(new FileWriter("Data tests\\AutoTest.run"));
			while((ligne = br.readLine())!=null){
				String numLigne = "";
				int indice = 0;
				while (ligne.charAt(indice)!=' ') {
					numLigne += ligne.charAt(indice);
					indice++;
				}
				String chaineHexadecimal = "";
				int j;
				for(j= indice +1;j<=ligne.length()-1;j++){
					chaineHexadecimal += ligne.charAt(j);
				}
				
				result.println(numLigne + " " + TraitFormat.hexa(chaineHexadecimal));
			}
			br.close();
			result.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	private static void interactif(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Valeur hexadécimal : ");
		String str = sc.nextLine();
		System.out.println(TraitFormat.hexa(str));
	}
}
