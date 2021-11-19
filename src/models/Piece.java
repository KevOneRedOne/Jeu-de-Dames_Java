package models;

public class Piece {
	
	char typePiece ;
	int posX ; int posY ;

	public Piece(char typePiece, int posX, int posY) {
		super();
		this.typePiece = typePiece;
		this.posX = posX;
		this.posY = posY;
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
