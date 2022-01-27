package cen4010.pa4;

import java.awt.Color;

public class BlueMode extends Theme {
	private Color boardBackgroundColor = new Color(0, 37, 108);
	private Color backgroundColor = new Color(0, 37, 108);
	private Color elementColor = new Color(0,87,255);
	private Color textColor = new Color(0,0,0);
	private Color panelColor = new Color(0, 37, 108);
	
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
