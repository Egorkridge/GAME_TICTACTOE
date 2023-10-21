import java.util.Scanner;

public class TicTacToe {
    static char[][] map;
    static final int MAP_SIZE = 3;
    static final char EMPTY_FIELD = '*';
    static final char X = 'X';
    static final char O = 'O';

    public static void main(String[] args) {
        InitMap();
        paintMap();
        while (true) {
            humanTurn();
            paintMap();
            if (checkWin(X)) {
                System.out.println("Поздравляю чемпион, ты победил беспомощную машину.");
                break;
            }
            if (checkDraw()) {
                System.out.println("Hичья.");
                break;
            }
            aiTurn();
            paintMap();
            if (checkWin(O)) {
                System.out.println("Ты проиграл боту;( , ну и позорище.");
                break;
            }
            if (checkDraw()) {
                System.out.println("Ничья.");
                break;
            }
        }
    }

    public static void InitMap() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_FIELD;
            }
        }
    }

    public static void paintMap() {
        for (int i = 0; i < MAP_SIZE + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) {
            return false;
        }
        if (map[y][x] != EMPTY_FIELD) {
            return false;
        }
        return true;
    }

    public static void humanTurn() {
        Scanner scan = new Scanner(System.in);
        int x, y;
        do {
            System.out.println("Твой ход: выбери куда поставить крестик. Правила таковы: напиши не более двух чисел от 1 до 3,сначала укажи номер стобца, а затем через пробел номер строки ");
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = X;
    }

    public static void aiTurn() {
        int x, y;
        System.out.println("Ход компуктера.");
        do {
            x = (int) (Math.random() * MAP_SIZE);
            y = (int) (Math.random() * MAP_SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = O;
    }

    public static boolean checkDraw() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkWin(char playerField) {
        if (map[0][0] == playerField && map[0][1] == playerField && map[0][2] == playerField) return true;
        if (map[1][0] == playerField && map[1][1] == playerField && map[1][2] == playerField) return true;
        if (map[2][0] == playerField && map[2][1] == playerField && map[2][2] == playerField) return true;
        if (map[0][0] == playerField && map[1][0] == playerField && map[2][0] == playerField) return true;
        if (map[0][1] == playerField && map[1][1] == playerField && map[2][1] == playerField) return true;
        if (map[0][2] == playerField && map[1][2] == playerField && map[2][2] == playerField) return true;
        if (map[0][0] == playerField && map[1][1] == playerField && map[2][2] == playerField) return true;
        if (map[2][0] == playerField && map[1][1] == playerField && map[0][2] == playerField) return true;
        return false;
    }
}
