package cen4010.pa4;

import java.awt.Color;


public class DarkMode extends Theme {
	private Color boardBackgroundColor = new Color(30, 30, 30);
	private Color backgroundColor = new Color(116, 116, 116);
	private Color elementColor = new Color(0,0,0);
	private Color textColor = new Color(250,250,250);
	private Color panelColor = new Color(30, 30, 30);
	
	public Color getTextColor() {
		return this.textColor;
	}
	
	public Color getBoardBackgroundColor() {
		return this.boardBackgroundColor;
	}
	
	public Color getBackgroundColor() {
		return this.backgroundColor;
	}
	
	public Color getElementColor() {
		return this.elementColor;
	}
	public Color getPanelBackgroundColor() {
		return this.panelColor;
	}
}
