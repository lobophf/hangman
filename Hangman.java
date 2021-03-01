package application;

import java.util.Scanner;

public class Hangman{
	
	private boolean m_running = true;
	private RandomWord m_word = new RandomWord();
	private Scanner m_scanner = new Scanner(System.in);
	private int m_triesRemaining = 5;
	private char m_lastGuess;

	public Hangman(){}
	public void close(){
		m_scanner.close();
	}

	public void run(){

		do{
			displayWord();
			getUserInput();
			checkUserInput();
		}while(m_running);
	}

	private void displayWord(){
		System.out.println(m_word);
	};

	private void getUserInput(){
		System.out.println("Tries remaining: " + m_triesRemaining);
		System.out.print("Enter your guess: ");
		String m_guess = m_scanner.nextLine();
		m_lastGuess = m_guess.charAt(0);
	};

	private void checkUserInput(){

		boolean isCorrect = m_word.addGuess(m_lastGuess);
		if(isCorrect){
			if(m_word.isComplete()){
				System.out.println("You have won!");
				System.out.println("The word is: " + m_word);
				m_running = false;
			}
		}else{
			m_triesRemaining--;
			if(m_triesRemaining == 0){
				System.out.println("You have lost!");
				m_running = false;
			}
		}
	};
}
