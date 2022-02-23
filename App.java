import java.util.Scanner;
public class App{
	public static void main(String[] args) {
		Board board = new Board();
		Scanner in = new Scanner(System.in);
		
		boolean flag = true;
		System.out.println("Para fazer uma jogada digite uma coordenada de '1 1' à '3 3' no formato linha seguido de coluna");
		while(flag){
			char jogador;

			//Alterna jogadores
			System.out.println("--------------------");
			if(Board.numOfMoves%2 == 0)
			{				
				System.out.println("Vez do jogador X");
				jogador = 'X';
			}else{
				System.out.println("Vez do jogador O.");
				jogador = 'O';
			}
			System.out.println("--------------------");
			System.out.println("Digite uma coordenada de '1 1' à '3 3' que ainda não foi usada!");
			board.showBoard();

			String coord = in.nextLine();
			coord = coord.trim().replace(" ","");
			int x = 0;
			int y = 0;
			
			if(coord.length() >= 2){
				x = Integer.parseInt(Character.toString(coord.charAt(0)))-1;
				y = Integer.parseInt(Character.toString(coord.charAt(1)))-1;;
			}
			
			if(x < 0 || x > 2 || y < 0 || y > 2){
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("Para fazer uma jogada digite uma coordenada de '1 1' à '3 3' no formato linha seguido de coluna");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				continue;
			}

			
			//Caso a jogada aconteça aumenta o contador.
			if(board.play(x, y, jogador)){
				Board.numOfMoves++;
			}else{
				continue;
			}
			
			//Verifica final da partida somente se houve mais de 4 jogadas.
			if(Board.numOfMoves > 4){
				if(board.verifyBoard()){
					System.out.println("\nJogador " +jogador + " venceu!\n");
					board.showBoard();
					flag = false;
				}	
			}
		}
		in.close();
	}
}