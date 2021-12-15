package Battleship;


import java.util.Arrays;

public class Board {

    public Ships[][] getMap() {
        return map;
    }

    private final Ships[][] map;

    public Board() {
        map = new Ships[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = Ships.EMPTY;
            }
        }
    }

    public void setMap(int[] ints) {
        for (int i = 0; i < ints.length; i+= 2) {
            map[ints[i]][ints[i + 1]] = Ships.ONE;
        }
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (map[x][y].equals(Ships.ONE) && y != 9 && !map[x][y + 1].equals(Ships.ONE)) {
                    map[x][y + 1] = Ships.AREA;
                }
                if (map[x][y].equals(Ships.ONE) && y != 0 && !map[x][y - 1].equals(Ships.ONE)) {
                    map[x][y - 1] = Ships.AREA;
                }
                if (map[x][y].equals(Ships.ONE) && x != 0 && !map[x - 1][y].equals(Ships.ONE)) {
                    map[x - 1][y] = Ships.AREA;
                }
                if (map[x][y].equals(Ships.ONE) && x != 0 && y != 0 && !map[x - 1][y - 1].equals(Ships.ONE)) {
                    map[x - 1][y - 1] = Ships.AREA;
                }
                if (map[x][y].equals(Ships.ONE) && x != 9 && y != 0 && !map[x + 1][y - 1].equals(Ships.ONE)) {
                    map[x + 1][y - 1] = Ships.AREA;
                }
                if (map[x][y].equals(Ships.ONE) && x != 9 && !map[x + 1][y].equals(Ships.ONE)) {
                    map[x + 1][y] = Ships.AREA;
                }
                if (map[x][y].equals(Ships.ONE) && x != 9 && y != 9 && !map[x + 1][y + 1].equals(Ships.ONE)) {
                    map[x + 1][y + 1] = Ships.AREA;
                }
                if (map[x][y].equals(Ships.ONE) && x != 0 && y != 9 && !map[x - 1][y + 1].equals(Ships.ONE)) {
                    map[x - 1][y + 1] = Ships.AREA;
                }
            }
        }


    }

    public void printBoard() {
        for (Ships[] ships : map) {
            System.out.println(Arrays.toString(ships));
        }
    }
}
