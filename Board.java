public class Board{
	private char[][] board;
	public static int numOfMoves;

	public Board(){
		board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = '-';
			}
		}
		numOfMoves = 0;
	}

	public boolean verifyBoard(){
		//Verifica as linhas
		for (int i = 0; i < board.length; i++) {
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] != '-'){
				return true;
			}
		}

		//Verifica as colunas
		for (int i = 0; i < board.length; i++) {
			if(board[0][i] == board[1][i] && board[i][1] == board[2][i] && board[2][i] != '-'){
				return true;
			}
		}

		//Diagonais
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != '-'){
			return true;
		}

		if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] != '-'){
			return true;
		}

		return false;
	}

	public void showBoard(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {				
				if(j!=2){
					System.out.printf("%c . ", board[i][j]);
				}else{
					System.out.printf("%c\n", board[i][j]);
				}
			}
		}		
	}

	public boolean play(int X, int Y, char jogador){
		if(board[X][Y]=='-'){
			board[X][Y] = jogador;
			return true;
		}			
		return false;	
	}
}