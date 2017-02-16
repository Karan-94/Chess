
public abstract class Piece 
{
	int x,y; //Position of piece
	Board Gameboard; 	//Piece can read & modify board
	Boolean Playerside;		//True for white, false for black
	
	Piece(int x, int y, Board Gameboard, Boolean Playerside)
	{
		this.x = x;
		this.y = y;
		this.Gameboard = Gameboard;
		this.Playerside = Playerside;						
	}
	
	public abstract int PathCheck(int x1, int y1);
	
	public abstract int MoveCheck(int x1, int y1);
	
		
}
