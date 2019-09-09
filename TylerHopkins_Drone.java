//Author Name: Tyler Hopkins
//Submission Date: 9/1/2019
//Program Name: TylerHopkins_Drone
//Purpose: Simulation using button, drone movement in x, y,z location

package hopkinsCEN3024;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TylerHopkins_Drone extends JFrame implements ActionListener {
	public static void main(String args[]) {
		new TylerHopkins_Drone();
	}

	// create position value variables
	private int xPos = 0;
	private int yPos = 0;
	private int zPos = 0;

	// create buttons
	JButton btnLeft = new JButton("Left");
	JButton btnRight = new JButton("Right");
	JButton btnFwd = new JButton("Fwd");
	JButton btnBack = new JButton("Back");
	JButton btnUp = new JButton("Up");
	JButton btnDown = new JButton("Down");
	JButton btnReset = new JButton("Reset");
	JButton btnClose = new JButton("Close");

	// create labels for position values
	JLabel lblXText = new JLabel("X:");
	JLabel lblYText = new JLabel("Y:");
	JLabel lblZText = new JLabel("Z:");
	JLabel lblXVal = new JLabel("0");
	JLabel lblYVal = new JLabel("0");
	JLabel lblZVal = new JLabel("0");
	JLabel lblMsg = new JLabel("Press a button to move!");

	/*
	 * method to get x position
	 * 
	 * @return x position from variable
	 */
	public int getxPos() {
		return this.xPos;
	}

	/*
	 * method to get y position
	 * 
	 * @return y position from variable
	 */
	public int getyPos() {
		return this.yPos;
	}

	/*
	 * method to get z position
	 * 
	 * @return z position from variable
	 */
	public int getzPos() {
		return this.zPos;
	}

	/*
	 * method to set x position
	 */
	public void setxPos(int newVal) {
		this.xPos = newVal;
	}

	/*
	 * method to set y position
	 */
	public void setyPos(int newVal) {
		this.yPos = newVal;
	}

	/*
	 * method to set z position
	 */
	public void setzPos(int newVal) {
		this.zPos = newVal;
	}

	public TylerHopkins_Drone() {
		// create frame
		JFrame window = new JFrame("Tyler Hopkins Drone");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(240, 240);
		window.getContentPane().setLayout(new FlowLayout());

		// add labels to frame
		window.getContentPane().add(lblXText);
		window.getContentPane().add(lblXVal);
		window.getContentPane().add(lblYText);
		window.getContentPane().add(lblYVal);
		window.getContentPane().add(lblZText);
		window.getContentPane().add(lblZVal);
		window.getContentPane().add(lblMsg);

		// add buttons to frame
		window.getContentPane().add(btnLeft);
		btnLeft.addActionListener(this);
		window.getContentPane().add(btnRight);
		btnRight.addActionListener(this);
		window.getContentPane().add(btnFwd);
		btnFwd.addActionListener(this);
		window.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		window.getContentPane().add(btnUp);
		btnUp.addActionListener(this);
		window.getContentPane().add(btnDown);
		btnDown.addActionListener(this);
		window.getContentPane().add(btnReset);
		btnReset.addActionListener(this);
		window.getContentPane().add(btnClose);
		btnClose.addActionListener(this);

		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLeft) {
			int currentVal = getxPos();
			int newVal = currentVal - 1;
			setxPos(newVal);
			lblXVal.setText(Integer.toString(getxPos()));
			lblMsg.setText("You moved left.");
		}
		if (e.getSource() == btnRight) {
			int currentVal = getxPos();
			int newVal = currentVal + 1;
			setxPos(newVal);
			lblXVal.setText(Integer.toString(getxPos()));
			lblMsg.setText("You moved right.");
		}
		if (e.getSource() == btnFwd) {
			int currentVal = getyPos();
			int newVal = currentVal + 1;
			setyPos(newVal);
			lblYVal.setText(Integer.toString(getyPos()));
			lblMsg.setText("You moved forward.");
		}
		if (e.getSource() == btnBack) {
			int currentVal = getyPos();
			int newVal = currentVal - 1;
			setyPos(newVal);
			lblYVal.setText(Integer.toString(getyPos()));
			lblMsg.setText("You moved back.");
		}
		if (e.getSource() == btnUp) {
			int currentVal = getzPos();
			int newVal = currentVal + 1;
			setzPos(newVal);
			lblZVal.setText(Integer.toString(getzPos()));
			lblMsg.setText("You moved up.");
		}
		if (e.getSource() == btnDown) {
			int currentVal = getzPos();
			int newVal = currentVal - 1;
			setzPos(newVal);
			lblZVal.setText(Integer.toString(getzPos()));
			lblMsg.setText("You moved down.");
		}
		if (e.getSource() == btnReset) {
			int newVal = 0;
			setxPos(newVal);
			setyPos(newVal);
			setzPos(newVal);
			lblXVal.setText(Integer.toString(getxPos()));
			lblYVal.setText(Integer.toString(getyPos()));
			lblZVal.setText(Integer.toString(getzPos()));
			lblMsg.setText("You reset position.");
		}
		if (e.getSource() == btnClose) {
			lblMsg.setText("Goodbye!");
			System.exit(0);
		}
	}
}
