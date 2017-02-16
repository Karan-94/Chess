
public class Queen extends Piece
{

	Queen(int x, int y, Board Gameboard, Boolean Playerside) {
		super(x, y, Gameboard, Playerside);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int PathCheck(int x1, int y1) 
	{
		int Delta_x = x1-x;
		int Delta_y = y1-y;
		
		if(Delta_x == 0 && Math.abs(Delta_y) >0)
		{
				for(int i=y; i<y1;)		//Checking path
				{
					if(Gameboard.BoardUI[x][i] > 0)
					{
						return 0;
					}
				}
				
				return MoveCheck(x1,y1);		//Checking destination
		}
			
			
		else if(Math.abs(Delta_x) >0 && Delta_y == 0)
		{
				for(int i=x; i<x1;)		//Checking path
				{
					if(Gameboard.BoardUI[i][y] > 0)
					{
						return 0;
					}
				}
				
				return MoveCheck(x1,y1);		//Checking destination
				
		}
		
			
		else if(Math.abs(Delta_x) == Math.abs(Delta_y))
		{
			if(Delta_x == 0)
			{
				return 0;
			}
			
			else
			{
				if(Delta_x>0 && Delta_y>0)
				{
					for(int i=1; i<(Delta_x); i++)		//Checking path
					{
						if(Gameboard.BoardUI[x+i][y+i] > 0)
						{
							return 0;
						}
					}
					
					return MoveCheck(x1, y1);		//Checking destination
				}
				
				else if(Delta_x>0 && Delta_y<0)
				{
					for(int i=1; i<Delta_x; i++)		//Checking path
					{
						if(Gameboard.BoardUI[x+i][y-i] > 0)
						{
							return 0;
						}
					}
					
					return MoveCheck(x1,y1);		//Checking destination
					
				}
				
				else if(Delta_x<0 && Delta_y>0)
				{
					for(int i=1; i< Math.abs(Delta_x); i++)		//Checking path
					{
						if(Gameboard.BoardUI[x-i][y+i] > 0)
						{
							return 0;
						}
					}
					
					return MoveCheck(x1,y1);		//Checking destination
					
				}
				
				else if(Delta_x<0 && Delta_y<0)
				{
					for(int i=1; i< Math.abs(Delta_x); i++)		//Checking path
					{
						if(Gameboard.BoardUI[x-i][y-i] > 0)
						{
							return 0;
						}
					}
					
					return MoveCheck(x1,y1);		//Checking destination
					
				}
			}
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


