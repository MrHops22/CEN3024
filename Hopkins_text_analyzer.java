package hopkinsCEN3024;

/*Tyler Hopkins
10.27.2019
Text Analyzer
Counts the words at the URL supplied and stores in a HashMap
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Tyler Hopkins
 *
 */
public class Hopkins_text_analyzer {
/**main method creates new instance of Hopkins_text_analyzer
 * 
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		new Hopkins_text_analyzer();

	}

	// Create the hashmap that will contain the words and frequency
	HashMap<String, Integer> wordCounter = new HashMap();
/**
 * calls analyzeText method
 * @throws IOException
 */
	public Hopkins_text_analyzer() throws IOException {
		analyzeText();
	}
/**
 * reads url and counts occurrence of each word in the url. displays resuls to console
 * @throws IOException
 */
	public void analyzeText() throws IOException {

		// create readers for file and lines
		URL url = new URL("http://shakespeare.mit.edu/macbeth/full.html");
		Scanner input = new Scanner(url.openStream());

		// Scanner input = new Scanner(new File("inputfile.txt"));
		while (input.hasNext()) {
			String currentWordRaw = input.next();
			String currentWord = currentWordRaw.toLowerCase().replaceAll("\\p{Punct}", "");
			if (wordCounter.containsKey(currentWord)) {
				int freq = wordCounter.get(currentWord);
				freq++;
				wordCounter.put(currentWord, freq);
			} else
				wordCounter.put(currentWord, 1);
		}
		System.out.println(wordCounter.toString());
	}

	/*
	 * // create buttons JButton btnCalc = new JButton("Calculate"); JButton
	 * btnReset = new JButton("Reset"); JButton btnClose = new JButton("Close");
	 */

	/*
	 * public Hopkins_text_analyzer() { // create frame JFrame window = new
	 * JFrame("Tyler Hopkins Text Analyzer");
	 * window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); window.setSize(500,
	 * 500); window.getContentPane().setLayout(new FlowLayout());
	 * 
	 * // add buttons to frame window.getContentPane().add(btnCalc);
	 * btnCalc.addActionListener(this); window.getContentPane().add(btnReset);
	 * btnReset.addActionListener(this); window.getContentPane().add(btnClose);
	 * btnClose.addActionListener(this);
	 * 
	 * JTable output = new JTable(wordCounter.size(),2);
	 * 
	 * window.setVisible(true); }
	 */

	/*
	 * public void actionPerformed(ActionEvent e) {
	 * 
	 * if (e.getSource() == btnCalc) { try { analyzeText(); } catch (IOException e1)
	 * { // TODO Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * 
	 * } if (e.getSource() == btnReset) { wordCounter.clear(); } if (e.getSource()
	 * == btnClose) { System.exit(0); } }
	 */
}
