package application;

import java.util.Random;

public class RandomWord {
	private String[] m_words = {"java", "dog", "cat", "coffee"};
	private String m_chosenWord;
	private char[] m_characters;
	private Random m_random = new Random();

	public String getWord(){
		return m_words[0];
	}

	public RandomWord() {
		m_chosenWord = m_words[(m_random.nextInt(m_words.length))];
		m_characters = new char[m_chosenWord.length()];
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(char c: m_characters) {
			sb.append(c == '\u0000' ? '_' : c).append(' ');
		}
		return sb.toString();
	}

	public boolean addGuess(char c){
		
		boolean correct = false;
		for(int i = 0; i < m_chosenWord.length(); i++){
			if(c == m_chosenWord.charAt(i)){
				m_characters[i] = c;
				correct = true;
			}
		}
		return correct;
	}

	public boolean isComplete(){

		for(char c: m_characters){
			if(c == '\u0000'){
				return false;
			}
		}
		return true;
	}
}
