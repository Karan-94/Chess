
public class King extends Piece
{

	King(int x, int y, Board Gameboard, Boolean Playerside) {
		super(x, y, Gameboard, Playerside);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int PathCheck(int x1, int y1) 
	{
		int Delta_x = x1-x;
		int Delta_y = y1-y;
				
		if(Delta_x < 2 && Delta_y <2)
		{
			return MoveCheck(x1,y1);
		}
		
		else
		{
		return 0;
		}
	}
	
	public int MoveCheck(int x1, int y1)		//Destination checking algorithm
	{
			if(Gameboard.BoardUI[x1][y1] > 0)
			{
				if((this.Playerside == true && Gameboard.BoardUI[x1][y1] >6) || (this.Playerside == false && Gameboard.BoardUI[x1][y1] <7 && Gameboard.BoardUI[x1][y1] >0))
				{
					return 2;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return 1;
			}
	}

}
