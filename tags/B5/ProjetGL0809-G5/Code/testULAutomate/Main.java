package testULAutomate;

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
		System.out.println(   "[1] - Mode batch");
		System.out.println(   "[2] - Mode intéractif");
		System.out.println(   "[3] - Quitter");
		System.out.println();
		System.out.print("Choix : ");
		String str = sc.nextLine();
		if(str.equals("1")){
			System.out.println();
			System.out.println("Début du batch");
			batch();
			System.out.println("Fin du batch");
			System.out.println();
			menuPrincipal();
		}else{
			if(str.equals("2")){
				menuModeInteractif();
				System.out.println();
			}else{
				if(str.equals("3")){
					System.out.println();
					System.out.println("Fermeture du programme");
				}
				else{
					System.out.println("Erreur veuillez choisir 1, 2 ou 3");
					System.out.println();
					menuPrincipal();
				}
			}
		}
	}
	
	private static void batch(){
		AutoTest.testTraitFormat("Data Tests\\TestTraitFormat.jdt","Data Tests\\JDT.run");
		Oracle.oracleConversion("Data Tests\\JDT.run", "Data Tests\\Oracle.run");
		Comparateur.fichier("Data Tests\\Oracle.run", "Data Tests\\TestTraitFormat.jdt", "Data Tests\\ResultatComparateur.txt");
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
	
	private static void interactif(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Valeur hexadécimal : ");
		String str = sc.nextLine();
		System.out.println(TraitFormat.hexa(str));
	}
}
