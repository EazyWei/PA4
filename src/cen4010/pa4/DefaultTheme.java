package cen4010.pa4;

import java.awt.Color;

public class DefaultTheme extends Theme{
	private Color boardBackgroundColor = new Color(0,0,0);
	private Color elementColor = Color.white;
	private Color textColor = new Color(0,0,0);
	private Color panelColor = null;
	
	public Color getTextColor() {
		return this.textColor;
	}
	
	public Color getBoardBackgroundColor() {
		return this.boardBackgroundColor;
	}
	
	public Color getElementColor() {
		return this.elementColor;
	}
	
	public Color getPanelBackgroundColor() {
		return this.panelColor;
	}
}

