import java.util.Scanner;

public class TicTacToe {
	private int spielzuege = 0;
	private char[] feld = new char[10];
	private static final char LEER = '-';
	
	
	public TicTacToe() {
		this.spielzuege = 0;
		for(int i = 1; i<feld.length;i++) {
			feld[i] = LEER;
		}
	}

	public char getFeld(int nummer) {
		return feld[nummer];
	}

	public void setFeld(int nummer, char zeichen){
		 for(int i = 1; i<feld.length; i++) {
			 if(feld[i]==LEER) {
				 feld[nummer] = zeichen;
			 }
			 
			 else System.out.println("Feld ist bereits belegt!");
		 }
	}
	
	public boolean istFrei(int nummer) {
		if(feld[nummer] != LEER) {
			return false;
		}
		else return true;
	}
	
	public void ausgeben() {
		for(int i = 1; i<feld.length;i++) {
			if(i==4 || i==7) {
				System.out.println();
				System.out.print("["+feld[i]+"]");
			}
			
			else System.out.print("["+feld[i]+"]");;
			
		}
	}
	
	public void clearFeld() {
		for(int i = 1; i<feld.length;i++) {
			feld[i] = LEER;
		}
	}
	
	public boolean istGameOver() {
			 if((feld[1]!=LEER)&& (feld[1] == feld[2]) && (feld[2] == feld[3])) return true;
		else if((feld[4]!=LEER)&& (feld[4] == feld[5]) && (feld[5] == feld[6])) return true;
		else if((feld[7]!=LEER)&& (feld[7] == feld[8]) && (feld[8] == feld[9])) return true;
			 //alle waagerechten
		
		else if((feld[1]!=LEER)&& (feld[1] == feld[4]) && (feld[4] == feld[7])) return true;
		else if((feld[2]!=LEER)&& (feld[2] == feld[5]) && (feld[5] == feld[8])) return true;
		else if((feld[3]!=LEER)&& (feld[3] == feld[6]) && (feld[6] == feld[9])) return true;
			 //alle senkrechten
			 
		else if((feld[1]!=LEER)&& (feld[1] == feld[5]) && (feld[5] == feld[9])) return true;
		else if((feld[3]!=LEER)&& (feld[3] == feld[5]) && (feld[5] == feld[7])) return true;
			 //diagonalen
		else return false;
	}
	
	public void zugSpieler(){
			 int eingabe = -1;
			 spielzuege++;
			 Scanner sc = new Scanner(System.in);
			 eingabe = sc.nextInt();
		
			if(istFrei(eingabe)==false) {
				System.out.println("Feld ist belegt!");
				System.out.println("Bitte wählen Sie ein anderes Feld");
				zugSpieler();
			}
			else {
				setFeld(eingabe, 'X');
				System.out.println("Der Spieler hat seinen Zug beendet.");
				System.out.println();
				ausgeben();
			}
			 
	}
	

	public void zugComputer()
	{
	 int eingabe = -1;
	 spielzuege++;

	 do
	 {
	 /* die folgende Anweisung erzeugt eine Pseudo-Zufallszahl zwischen 1 und 9 */
	 eingabe = (int)(Math.random() * 9) + 1;
	 System.out.println("Computer hat das Feld " + (eingabe) + " gewählt.");
	 }
	 /* fuer die zufaellig bestimme Feldnummer wird anschliessend geprueft, ob diese nicht
	vielleicht bereits besetzt ist.
	 Sonst muss eine neue Zahl ermittelt werden */
	 while(!istFrei(eingabe));

	 /* das Feld ist noch frei und wird nun markiert */
	 setFeld(eingabe, 'O');
	 System.out.println("Der Computer hat seinen Zug beendet.");
	 /* geaendertes Spielfeld anzeigen */
	 ausgeben();
	}
	
}
