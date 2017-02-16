import java.util.ArrayList;

public class Board 
{
		int[][] BoardUI = new int[8][8];
		private final static int WPawn = 1;
		private final static int WCastle = 2;
		private final static int WKnight = 3;
		private final static int WBishop = 4;
		private final static int WQueen = 5;
		private final static int WKing = 6;
		private final static int BPawn = 7;
		private final static int BCastle = 8;
		private final static int BKnight = 9;
		private final static int BBishop = 10;
		private final static int BQueen = 11;
		private final static int BKing = 12;
		
		ArrayList<Piece> WhitePiecelist = new ArrayList<Piece>(); 	
		ArrayList<Piece> BlackPiecelist = new ArrayList<Piece>();
		
		Board()  // Starting configuration of the board
		{
			
			
			BoardUI[0][0] = WCastle;
			BoardUI[7][0] = WCastle;
			BoardUI[1][0] = WKnight;
			BoardUI[6][0] = WKnight;
			BoardUI[2][0] = WBishop;
			BoardUI[5][0] = WBishop;
			BoardUI[3][0] = WQueen;
			BoardUI[4][0] = WKing;
			
			BoardUI[0][7] = BCastle;
			BoardUI[7][7] = BCastle;
			BoardUI[1][7] = BKnight;
			BoardUI[6][7] = BKnight;
			BoardUI[2][7] = BBishop;
			BoardUI[5][7] = BBishop;
			BoardUI[3][7] = BQueen;
			BoardUI[4][7] = BKing;
			
			WhitePiecelist.add(new Castle(0,0,this,true));	//Adding all castles to piecelist
			WhitePiecelist.add(new Castle(7,0,this,true));
			BlackPiecelist.add(new Castle(0,7,this,false));
			BlackPiecelist.add(new Castle(7,7,this,false));
			
			WhitePiecelist.add(new Bishop(2,0,this,true));	//Adding all bishops to piecelist
			WhitePiecelist.add(new Bishop(5,0,this,true));
			BlackPiecelist.add(new Bishop(2,7,this,false));
			BlackPiecelist.add(new Bishop(5,7,this,false));
			
			WhitePiecelist.add(new Knight(1,0,this,true));	//Adding all knights to piecelist
			WhitePiecelist.add(new Knight(6,0,this,true));
			BlackPiecelist.add(new Knight(1,7,this,false));
			BlackPiecelist.add(new Knight(6,7,this,false));
			
			WhitePiecelist.add(new Queen(3,0,this,true));		//Adding queens to piecelist
			BlackPiecelist.add(new Queen(3,7,this,false));
			
			WhitePiecelist.add(new King(4,0,this,true));		//Adding kings to piecelist
			BlackPiecelist.add(new King(4,7,this,false));
						
			for(int i=0;i<8;i++)
			{
				BoardUI[i][1] = WPawn;
				BoardUI[i][6] = BPawn;
				WhitePiecelist.add(new WhitePawn(i,1,this,true)); //Adding white pawns to arraylist
				BlackPiecelist.add(new BlackPawn(i,6,this,false)); //Adding black pawns to arraylist
				
			}
			
		}
		
		void Display() //Converting numbers into piece characters for printing using UTF-8 codes
		{
			System.out.println("\n");
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					switch (BoardUI[j][i]) 
					{
						case 0: System.out.print("_" + "\t"); //Blank space
							break;
							
						case 1: System.out.print("\u2659" + "\t");  //White Pawn
		            				break;
		            			
						case 2: System.out.print("\u2656" + "\t");  //White Castle
		            				break;
		            			
						case 3: System.out.print("\u2658" + "\t");  //White Knight
								break;

						case 4: System.out.print("\u2657" + "\t");  //White Bishop
								break;

						case 5: System.out.print("\u2655" + "\t");  //White Queen
								break;

						case 6: System.out.print("\u2654" + "\t");  //White King
								break;

						case 7: System.out.print("\u265F" + "\t");  //Black Pawn
								break;

						case 8: System.out.print("\u265C" + "\t");  //Black Castle
								break;

						case 9: System.out.print("\u265E" + "\t");  //Black Knight
								break;

						case 10: System.out.print("\u265D" + "\t");  //Black Bishop
								break;

						case 11: System.out.print("\u265B" + "\t");  //Black Queen
								break;

						case 12: System.out.print("\u265A" + "\t");  //Black King
								break;
			                }		                 
									
				}
				System.out.println("\n");
				
			}
			System.out.println("\n");
		}
		
	
		
		void move(int a, int b, int c, int d)
		{
			switch (BoardUI[a][b])
			{
				case 0: System.out.println("No piece selected ");
						break;
				
				case WPawn: for(Piece A: WhitePiecelist)
							{
								if(A.x == a && A.y ==b)
								{
									if(A.PathCheck(c, d) == 1)
									{
										BoardUI[a][b] = 0;		//UI change
										BoardUI[c][d] = WPawn;	//UI change
										A.x = c;				//Logic change
										A.y = d;				//Logic change
									}
									else if(A.PathCheck(c, d) == 2)
									{
										for(Piece B: BlackPiecelist)			//Pawn kills enemy piece (remove from piecelist
										{
											if(B.x == c && B.y == d)
											{
												BlackPiecelist.remove(B);
												break;
											}
										}
										
										
										BoardUI[a][b] = 0;		//UI change
										BoardUI[c][d] = WPawn;	//UI change
										A.x = c;				//Logic change
										A.y = d;				//Logic change
									}
									else
									{
										System.out.println(A.PathCheck(c, d));
									}
								
								}
							
							}
							break;
				
				case WCastle: for(Piece A: WhitePiecelist)
							  {
							    	if(A.x == a && A.y ==b)
									{
										if(A.PathCheck(c, d) == 1)
										{
											BoardUI[a][b] = 0;			//UI change
											BoardUI[c][d] = WCastle;	//UI change
											A.x = c;					//Logic change
											A.y = d;					//Logic change
										}
										else if(A.PathCheck(c, d) == 2)		//Kill move
										{
											for(Piece B: BlackPiecelist)			
											{
												if(B.x == c && B.y == d)
												{
													BlackPiecelist.remove(B);
													break;
												}
											}
											
											
											BoardUI[a][b] = 0;		//UI change
											BoardUI[c][d] = WCastle;	//UI change
											A.x = c;				//Logic change
											A.y = d;				//Logic change
										}
										else
										{
											System.out.println(A.PathCheck(c, d));
										}
									
									}
								
								}
								break;
								
				case WBishop: for(Piece A: WhitePiecelist)
							  {
							    	if(A.x == a && A.y ==b)
									{
										if(A.PathCheck(c, d) == 1)
										{
											BoardUI[a][b] = 0;			//UI change
											BoardUI[c][d] = WBishop;	//UI change
											A.x = c;					//Logic change
											A.y = d;					//Logic change
										}
										else if(A.PathCheck(c, d) == 2)		//Kill move
										{
											for(Piece B: BlackPiecelist)			
											{
												if(B.x == c && B.y == d)
												{
													BlackPiecelist.remove(B);
													break;
												}
											}
											
											
											BoardUI[a][b] = 0;		//UI change
											BoardUI[c][d] = WBishop;	//UI change
											A.x = c;				//Logic change
											A.y = d;				//Logic change
										}
										else
										{
											System.out.println(A.PathCheck(c, d));
										}
									
									}
								
								}
								break;
								
				case WKnight: for(Piece A: WhitePiecelist)
							  {
							    	if(A.x == a && A.y ==b)
									{
										if(A.PathCheck(c, d) == 1)
										{
											BoardUI[a][b] = 0;			//UI change
											BoardUI[c][d] = WKnight;	//UI change
											A.x = c;					//Logic change
											A.y = d;					//Logic change
										}
										else if(A.PathCheck(c, d) == 2)		//Kill move
										{
											for(Piece B: BlackPiecelist)			
											{
												if(B.x == c && B.y == d)
												{
													BlackPiecelist.remove(B);
													break;
												}
											}
											
											
											BoardUI[a][b] = 0;		//UI change
											BoardUI[c][d] = WKnight;	//UI change
											A.x = c;				//Logic change
											A.y = d;				//Logic change
										}
										else
										{
											System.out.println(A.PathCheck(c, d));
										}
									
									}
								
								}
								break;
								
				case WQueen: for(Piece A: WhitePiecelist)
							  {
							    	if(A.x == a && A.y ==b)
									{
										if(A.PathCheck(c, d) == 1)
										{
											BoardUI[a][b] = 0;			//UI change
											BoardUI[c][d] = WQueen;		//UI change
											A.x = c;					//Logic change
											A.y = d;					//Logic change
										}
										else if(A.PathCheck(c, d) == 2)		//Kill move
										{
											for(Piece B: BlackPiecelist)			
											{
												if(B.x == c && B.y == d)
												{
													BlackPiecelist.remove(B);
													break;
												}
											}
											
											
											BoardUI[a][b] = 0;		//UI change
											BoardUI[c][d] = WQueen;	//UI change
											A.x = c;				//Logic change
											A.y = d;				//Logic change
										}
										else
										{
											System.out.println(A.PathCheck(c, d));
										}
									
									}
								
								}
								break;
								
				case WKing: for(Piece A: WhitePiecelist)
							{
								if(A.x == a && A.y ==b)
								{
									if(A.PathCheck(c, d) == 1)
									{
										BoardUI[a][b] = 0;			//UI change
										BoardUI[c][d] = WKing;		//UI change
										A.x = c;					//Logic change
										A.y = d;					//Logic change
									}
									else if(A.PathCheck(c, d) == 2)		//Kill move
									{
										for(Piece B: BlackPiecelist)			
										{
											if(B.x == c && B.y == d)
											{
												BlackPiecelist.remove(B);
												break;
											}
										}
										
										
										BoardUI[a][b] = 0;		//UI change
										BoardUI[c][d] = WKing;	//UI change
										A.x = c;				//Logic change
										A.y = d;				//Logic change
									}
									else
									{
										System.out.println(A.PathCheck(c, d));
									}
									
								}
								
							}
							break;
								
				case BPawn: for(Piece A: BlackPiecelist)
							{
								if(A.x == a && A.y ==b)
								{
									if(A.PathCheck(c, d) == 1)
									{
										BoardUI[a][b] = 0;		//UI change
										BoardUI[c][d] = BPawn;	//UI change
										A.x = c;				//Logic change
										A.y = d;				//Logic change
									}
									else if(A.PathCheck(c, d) == 2)		//Kill move
									{
										for(Piece B: WhitePiecelist)			
										{
											if(B.x == c && B.y == d)
											{
												WhitePiecelist.remove(B);
												break;
											}
										}
										
										
										BoardUI[a][b] = 0;		//UI change
										BoardUI[c][d] = BPawn;	//UI change
										A.x = c;				//Logic change
										A.y = d;				//Logic change
									}
									else
									{
										System.out.println(A.PathCheck(c, d));
									}
								
								}
							
							}
							break;
							
				case BCastle: for(Piece A: BlackPiecelist)
							  {
							    	if(A.x == a && A.y ==b)
									{
										if(A.PathCheck(c, d) == 1)
										{
											BoardUI[a][b] = 0;			//UI change
											BoardUI[c][d] = BCastle;	//UI change
											A.x = c;					//Logic change
											A.y = d;					//Logic change
										}
										else if(A.PathCheck(c, d) == 2)
										{
											for(Piece B: WhitePiecelist)			//Pawn kills enemy piece (remove from piecelist)
											{
												if(B.x == c && B.y == d)
												{
													WhitePiecelist.remove(B);
													break;
												}
											}
											
											
											BoardUI[a][b] = 0;		//UI change
											BoardUI[c][d] = BCastle;	//UI change
											A.x = c;				//Logic change
											A.y = d;				//Logic change
										}
										else
										{
											System.out.println(A.PathCheck(c, d));
										}
									
									}
								
								}
								break;
								
				case BBishop: for(Piece A: BlackPiecelist)
							  {
							    	if(A.x == a && A.y ==b)
									{
										if(A.PathCheck(c, d) == 1)
										{
											BoardUI[a][b] = 0;			//UI change
											BoardUI[c][d] = BBishop;	//UI change
											A.x = c;					//Logic change
											A.y = d;					//Logic change
										}
										else if(A.PathCheck(c, d) == 2)		//Kill move
										{
											for(Piece B: WhitePiecelist)			
											{
												if(B.x == c && B.y == d)
												{
													WhitePiecelist.remove(B);
													break;
												}
											}
											
											
											BoardUI[a][b] = 0;		//UI change
											BoardUI[c][d] = BBishop;	//UI change
											A.x = c;				//Logic change
											A.y = d;				//Logic change
										}
										else
										{
											System.out.println(A.PathCheck(c, d));
										}
									
									}
								
								}
								break;
								
				case BKnight: for(Piece A: BlackPiecelist)
							  {
							    	if(A.x == a && A.y ==b)
									{
										if(A.PathCheck(c, d) == 1)
										{
											BoardUI[a][b] = 0;			//UI change
											BoardUI[c][d] = BKnight;	//UI change
											A.x = c;					//Logic change
											A.y = d;					//Logic change
										}
										else if(A.PathCheck(c, d) == 2)		//Kill move
										{
											for(Piece B: WhitePiecelist)			
											{
												if(B.x == c && B.y == d)
												{
													WhitePiecelist.remove(B);
													break;
												}
											}
											
											
											BoardUI[a][b] = 0;		//UI change
											BoardUI[c][d] = BKnight;	//UI change
											A.x = c;				//Logic change
											A.y = d;				//Logic change
										}
										else
										{
											System.out.println(A.PathCheck(c, d));
										}
									
									}
								
								}
								break;
						
				case BQueen: for(Piece A: BlackPiecelist)
							  {
							    	if(A.x == a && A.y ==b)
									{
										if(A.PathCheck(c, d) == 1)
										{
											BoardUI[a][b] = 0;			//UI change
											BoardUI[c][d] = BQueen;		//UI change
											A.x = c;					//Logic change
											A.y = d;					//Logic change
										}
										else if(A.PathCheck(c, d) == 2)		//Kill move
										{
											for(Piece B: WhitePiecelist)			
											{
												if(B.x == c && B.y == d)
												{
													WhitePiecelist.remove(B);
													break;
												}
											}
											
											
											BoardUI[a][b] = 0;		//UI change
											BoardUI[c][d] = BQueen;	//UI change
											A.x = c;				//Logic change
											A.y = d;				//Logic change
										}
										else
										{
											System.out.println(A.PathCheck(c, d));
										}
									
									}
								
								}
								break;
								
				case BKing: for(Piece A: BlackPiecelist)
							{
								if(A.x == a && A.y ==b)
								{
									if(A.PathCheck(c, d) == 1)
									{
										BoardUI[a][b] = 0;			//UI change
										BoardUI[c][d] = BKing;		//UI change
										A.x = c;					//Logic change
										A.y = d;					//Logic change
									}
									else if(A.PathCheck(c, d) == 2)		//Kill move
									{
										for(Piece B: WhitePiecelist)			
										{
											if(B.x == c && B.y == d)
											{
												WhitePiecelist.remove(B);
												break;
											}
										}
										
										
										BoardUI[a][b] = 0;		//UI change
										BoardUI[c][d] = BKing;	//UI change
										A.x = c;				//Logic change
										A.y = d;				//Logic change
									}
									else
									{
										System.out.println(A.PathCheck(c, d));
									}
									
								}
								
							}
							break;
			
			}
		
		}
	
}
