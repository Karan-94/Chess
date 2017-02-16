
public class Main 
{

	public static void main(String[] args) 
	{						//TEST MOVES
		Board Gameboard = new Board();		
		Gameboard.Display();
		Gameboard.move(1, 1, 1, 3);		//White Pawn moves from B2 to B4
		Gameboard.Display();
		Gameboard.move(2, 1, 2, 2);		//White Pawn moves from C2 to C3 
		Gameboard.Display();
		Gameboard.move(0, 6, 0, 4);		//Black Pawn moves from A7 to A5
		Gameboard.Display();
		Gameboard.move(0, 7, 0, 5);		//Black Castle moves from A8 to A6
		Gameboard.Display();
		Gameboard.move(2, 0, 0, 2);		//White Bishop moves from C1 to A3
		Gameboard.Display();
		Gameboard.move(6, 0, 7, 2);		//White Knight moves from G1 to H3
		Gameboard.Display();
		Gameboard.move(3, 0, 2, 1);		//White Queen moves from D1 to C2
		Gameboard.Display();
		Gameboard.move(2, 1, 1, 1);		//White Queen moves from C2 to B2
		Gameboard.Display();
		Gameboard.move(1, 1, 2, 0);		//White Queen moves from B2 to C1
		Gameboard.Display();
		Gameboard.move(1, 3, 0, 4);		//White Pawn moves from B4 to A5
		Gameboard.Display();
		Gameboard.move(0, 5, 0, 4);		//Black Castle moves from A6 to A5
		Gameboard.Display();
		Gameboard.move(0, 4, 0, 2);		//Black Castle moves from A5 to A3
		Gameboard.Display();
		Gameboard.move(2, 0, 0, 2);		//White Queen moves from C1 to A3
		Gameboard.Display();
		//Gameboard.move(0, 2, 0, 4);
		//Gameboard.Display();
		System.out.println(Gameboard.WhitePiecelist);
		for(Piece A:Gameboard.WhitePiecelist)
		{
			System.out.println("x: " + A.x + " y: " + A.y);
		}
		System.out.println(Gameboard.BlackPiecelist);
		for(Piece B:Gameboard.BlackPiecelist)
		{
			System.out.println("x: " + B.x + " y: " + B.y);
		}
	}

}
