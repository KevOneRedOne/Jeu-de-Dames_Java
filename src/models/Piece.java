package models;

public class Piece {
	
	char typePiece ;
	int posX ; int posY ;
	boolean controlledbyUser; 

	public Piece(char typePiece, int posX, int posY, boolean controlledbyUser) {
		super();
		this.typePiece = typePiece;
		this.posX = posX;
		this.posY = posY;
		this.controlledbyUser = controlledbyUser;
	}

	public boolean isControlledbyUser() {
		return controlledbyUser;
	}

	public void setControlledbyUser(boolean controlledbyUser) {
		this.controlledbyUser = controlledbyUser;
	}

	public char getTypePiece() {
		return typePiece;
	}

	public void setTypePiece(char typePiece) {
		this.typePiece = typePiece;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	} 
	
	
	
}
