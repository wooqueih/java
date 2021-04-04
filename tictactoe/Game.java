import java.util.Scanner;

public class Game {
    char[][] state;
    int size;
    boolean isCirclesTurn = false;
    Scanner input = new Scanner(System.in);

    public void nextTurn(){
        String tempString;
        isCirclesTurn = !isCirclesTurn;
        tempString = (isCirclesTurn) ? "\nO ist dran :\n" : "\nX ist dran :\n";
        System.out.println(tempString);
        printState();
        move();
        nextTurn();
    }

    public boolean isWin(){
        
    }

    public void move(){
        int move = input.nextInt();
        if(moveIsValid(move)){
            switch(move) {
                case 1:
                    state[2][0] = (isCirclesTurn) ? 'O' : 'X';
                    break;
                case 2:
                    state[2][1] = (isCirclesTurn) ? 'O' : 'X';
                    break;
                case 3:
                    state[2][2] = (isCirclesTurn) ? 'O' : 'X';
                    break;
                case 4:
                    state[1][0] = (isCirclesTurn) ? 'O' : 'X';
                    break;
                case 5:
                    state[1][1] = (isCirclesTurn) ? 'O' : 'X';
                    break;
                case 6:
                    state[1][2] = (isCirclesTurn) ? 'O' : 'X';
                    break;
                case 7:
                    state[0][0] = (isCirclesTurn) ? 'O' : 'X';
                    break;
                case 8:
                    state[0][1] = (isCirclesTurn) ? 'O' : 'X';
                    break;
                case 9:
                    state[0][2] = (isCirclesTurn) ? 'O' : 'X';
                    break;
            }
        } else {
            System.out.println("\ngeht nicht, versuch nochmal :\n");
            move();
        }
    }

    public boolean moveIsValid(int move){
        boolean tempBool = false;
        switch(move) {
            case 1:
                tempBool = (state[2][0] == ' ') ? true : false;
                break;
            case 2:
                tempBool = (state[2][1] == ' ') ? true : false;
                break;
            case 3:
                tempBool = (state[2][2] == ' ') ? true : false;
                break;
            case 4:
                tempBool = (state[1][0] == ' ') ? true : false;
                break;
            case 5:
                tempBool = (state[1][1] == ' ') ? true : false;
                break;
            case 6:
                tempBool = (state[1][2] == ' ') ? true : false;
                break;
            case 7:
                tempBool = (state[0][0] == ' ') ? true : false;
                break;
            case 8:
                tempBool = (state[0][1] == ' ') ? true : false;
                break;
            case 9:
                tempBool = (state[0][2] == ' ') ? true : false;
                break;
        }
        return tempBool;
    }

    public Game(int s){
        size = s;
        state = new char[size][size];
        for(int n = 0; n < size; n++){
            for(int m = 0; m < size; m++){
                state[n][m] = ' ';
                //System.out.println(state[n][m]);
            }
        }
    }

    public String line(){
        String tempString = "+";
        for(int n = 0; n < size; n++){
            tempString += "-+";
        }
        return tempString;
    }

    public void printState(){
        String tempString;
        System.out.println(line());
        for(int n = 0; n < size; n++){
        tempString = "";
            for(int m = 0; m < size; m++){
                tempString += state[n][m];
            }
        System.out.println(tempString.replace("","|"));
        System.out.println(line());
        }
        System.out.println("");
    }
}