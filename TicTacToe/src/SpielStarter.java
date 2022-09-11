import java.util.Scanner;

/**
 * Die Klasse dient zum Start des Spiels TicTacToe.
 * 
 */
public class SpielStarter {

	/**
	 * In diesem Attribut wird abgelegt, ob das Spiel bereits beendet ist bzw. ob
	 * weiter gespielt werden soll.
	 */
	private boolean gameOver;

	/**
	 * Zum Spielen wird ein Objekt der Klasse TicTacToe benoetigt.
	 */
	private TicTacToe spielplan = new TicTacToe();

	/**
	 * Standard-Konstruktor der Klasse SpielStarter.
	 */
	SpielStarter() {
		gameOver = false;
	}

	/**
	 * Eigentliche Start-Methode des Spiels. Wird von <code>main</code> aufgerufen.
	 */
	public void start() {

		/* aeussere Schleife */
		do {
			System.out.println("Willkommen! Sie moechten gern eine Runde Tic-Tac-Toe spielen ?");
			System.out.println("Dann geht es jetzt los!");
			System.out.println();
			System.out.println("Ihr Zeichen lautet " + "X" + ". Das Zeichen des Computers lautet " + "O" + ".");
			System.out.println("Waehlen Sie ein Feld aus. Geben Sie eine Zahl zwischen 1 und 9 ein:");
			spielplan.clearFeld();
			spielplan.ausgeben();

			/* innere Schleife s */
			while (!gameOver) { // solange das Spiel nicht beendet ist
				System.out.println();
				spielplan.zugSpieler();

				if (spielplan.istGameOver()) {
					System.out.println();
					System.out.println("Sie haben gewonnen!!!");
					spielplan.ausgeben();
					System.out.println();

					break;
				}
				spielplan.zugComputer();
				if (spielplan.istGameOver()) {
					System.out.println();
					System.out.println("Der Computer hat gewonnen. Schade.");
					spielplan.ausgeben();
					System.out.println();

					break;
				}
			}

			System.out.println("Spiel beendet!");
			System.out.print("Moechten Sie noch einmal spielen (J/N)? ");

			Scanner sc = new Scanner(System.in);

			char answer = sc.next().charAt(0);
			if (answer == 'J' || answer == 'j') {
				spielplan.clearFeld();
				start();

			} else if (answer == 'N' || answer == 'n') {
				System.out.println("Spiel wurde endgültig beendet.");
			} else {
				System.out.println("Falsche Eingabe starten Sie das Programm neu.");
			}
		} while (gameOver);
	}

	/**
	 * Hauptprogramm.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpielStarter s = new SpielStarter();
		s.start();

	}
}
