
public class WhitePawn extends Piece
{
	WhitePawn(int x, int y, Board Gameboard, Boolean Playerside)
	{
		super(x, y, Gameboard, Playerside);
	}

	public int PathCheck(int x1, int y1)
	{
		int Delta_x = x1-x;
		int Delta_y = y1-y;
		if(Math.abs(Delta_x)>1 || Math.abs(Delta_y)>2)
		{
			return 0;
		}
		else if(Delta_y == 1 && Math.abs(Delta_x) == 1)
		{
			if(Delta_x == 1)
			{
				if(Gameboard.BoardUI[x+1][y+1] > 0)
				{
					if(Gameboard.BoardUI[x+1][y+1] > 6)
					{
						return 2;
					}
					else
					{
						return 0;
					}
				}
			}
			else
			{
				if(Gameboard.BoardUI[x-1][y+1] > 0)
				{
					if(Gameboard.BoardUI[x-1][y+1]>6)
					{
						return 2;
					}
					else
					{
						return 0;
					}
				}
			}
		}
		else if(Delta_x == 0 && Delta_y == 1)
		{
			if(Gameboard.BoardUI[x][y+1] == 0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else if(Delta_x == 0 && Delta_y == 2)
		{
			if(y == 1 && Gameboard.BoardUI[x1][y1] == 0 && Gameboard.BoardUI[x1][y1-1] == 0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else if(Delta_x == 0 && Delta_y == 0)
		{
			return 0;
		}
			
		return -1;
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
