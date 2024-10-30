import java.util.Scanner; // importa la clase scanner para leer la entrada del usuario
 
public class ejercicio2 { // define la clase principal llamada ejercicio2
 
    private static char[][] board = { // crea un tablero 2d de 3x3 para el juego
        {' ', ' ', ' '}, // fila 1 del tablero, vacío al inicio
        {' ', ' ', ' '}, // fila 2 del tablero, vacío al inicio
        {' ', ' ', ' '}  // fila 3 del tablero, vacío al inicio
    };
 
    private static char currentPlayer = 'X'; // establece que el jugador actual es 'X'
 
    public static void main(String[] args) { // método principal que se ejecuta al iniciar el programa
        Scanner scanner = new Scanner(System.in); // crea un objeto scanner para leer la entrada del usuario
 
        while (true) { // bucle infinito para el juego
            printBoard(); // llama al método para imprimir el tablero
            playerMove(scanner); // llama al método para que el jugador haga un movimiento
            if (isWinner()) { // verifica si hay un ganador
                printBoard(); // imprime el tablero final
                System.out.println("El jugador " + currentPlayer + " ha ganado!"); // mensaje de ganador
                break; // sale del bucle
            }
            if (isBoardFull()) { // verifica si el tablero está lleno
                printBoard(); // imprime el tablero final
                System.out.println("Es un empate!"); // mensaje de empate
                break; // sale del bucle
            }
            switchPlayer(); // cambia el turno al otro jugador
        }
 
        scanner.close(); // cierra el scanner
    }
 
    private static void printBoard() { // método para imprimir el tablero
        System.out.println(" 0 1 2"); // imprime los números de las columnas
        for (int i = 0; i < 3; i++) { // recorre cada fila
            System.out.print(i + " "); // imprime el número de la fila
            for (int j = 0; j < 3; j++) { // recorre cada columna en la fila
                System.out.print(board[i][j]); // imprime el valor en la posición del tablero
                if (j < 2) System.out.print("|"); // imprime una barra vertical entre las columnas
            }
            System.out.println(); // nueva línea después de cada fila
            if (i < 2) System.out.println("  -----"); // imprime una línea separadora entre las filas
        }
    }
 
    private static void playerMove(Scanner scanner) { // método para realizar el movimiento del jugador
        int row, col; // variables para la fila y columna
        while (true) { // bucle hasta que el movimiento sea válido
            System.out.print("Jugador " + currentPlayer + ", ingresa tu movimiento (fila y columna): ");
            row = scanner.nextInt(); // lee la fila del jugador
            col = scanner.nextInt(); // lee la columna del jugador
 
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') { // verifica si el movimiento es válido
                board[row][col] = currentPlayer; // coloca el símbolo del jugador en el tablero
                break; // sale del bucle
            } else {
                System.out.println("Este movimiento no es válido."); // mensaje si el movimiento es inválido
            }
        }
    }
 
    private static void switchPlayer() { // método para cambiar de jugador
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // cambia entre 'X' y 'O'
    }
 
    private static boolean isWinner() { // método para verificar si hay un ganador
        for (int i = 0; i < 3; i++) { // recorre cada fila y columna
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) 
                return true; // verifica cada fila
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) 
                return true; // verifica cada columna
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) 
            return true; // verifica la diagonal principal
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) 
            return true; // verifica la diagonal secundaria
 
        return false; // si no hay ganador, retorna falso
    }
 
    private static boolean isBoardFull() { // método para verificar si el tablero está lleno
        for (int i = 0; i < 3; i++) { // recorre cada fila
            for (int j = 0; j < 3; j++) { // recorre cada columna
                if (board[i][j] == ' ') { // si hay un espacio vacío
                    return false; // retorna falso
                }
            }
        }
        return true; // si no hay espacios vacíos, retorna verdadero
    }
}
     
