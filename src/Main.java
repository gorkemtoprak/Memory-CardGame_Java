import java.util.Scanner;

public class Main {
	
	private static Card[][] cards = new Card[4][4];

	
	public static void main(String[] args) {
		
		
		cards [0][0] = new Card('E');
		cards [0][1] = new Card('A');
		cards [0][2] = new Card('B');
		cards [0][3] = new Card('F');
		cards [1][0] = new Card('G');
		cards [1][1] = new Card('A');
		cards [1][2] = new Card('D');
		cards [1][3] = new Card('H');
		cards [2][0] = new Card('F');
		cards [2][1] = new Card('C');
		cards [2][2] = new Card('D');
		cards [2][3] = new Card('H');
		cards [3][0] = new Card('E');
		cards [3][1] = new Card('G');
		cards [3][2] = new Card('B');
		cards [3][3] = new Card('C');
		
		while(gameOver()==false) {
			
			gameBoard();
			guessWhat();
		}
		
		
	}
	
	public static void guessWhat() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("First Guess: "); //i ve j degerlerini bir boslukta giriceksin.!
		int i1=sc.nextInt();
		int j1=sc.nextInt();
		
		cards[i1][j1].setGuess(true);
		
		gameBoard();
		
		System.out.print("Second Guess: "); //i ve j degerlerini bir boslukta giriceksin.!
		int i2=sc.nextInt();
		int j2=sc.nextInt();
		
		if(cards[i1][j1].getValue() == cards[i2][j2].getValue()) {			
			System.out.println("Congruculation!... ");
			cards[i2][j2].setGuess(true);
		}
		else {
			System.out.println("Wrong!...");
			cards[i1][j1].setGuess(false);
		}
		
	}
	
	
	public static boolean gameOver() {
		
		int i,j;
		
		for(i=0; i<4; i++) {
			
			for(j=0; j<4; j++) {
				
				if(cards[i][j].isGuess()==false) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public static void gameBoard() {
		
		int i,j;
		
		for(i=0; i<4; i++) {
			
			for(j=0; j<4; j++) {
				
				if(cards[i][j].isGuess()) {
					System.out.print(" | "+ cards[i][j].getValue()+ " | ");
				}
				
				else {
					System.out.print("| |");
				}
			
			}
			
			System.out.println(" ");
		}
		
	}

}
