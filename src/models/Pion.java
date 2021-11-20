package models;

public class Pion extends Piece {
	
	String color;

	public Pion(char typePiece, int posX, int posY, boolean controlledbyUser, String color) {
		super(typePiece, posX, posY, controlledbyUser);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pion [color=" + color + ", typePiece=" + typePiece + ", posX=" + posX + ", posY=" + posY
				+ ", controlledbyUser=" + controlledbyUser + "]";
	}

	
	
	

}
