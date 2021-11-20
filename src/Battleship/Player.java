package Battleship;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    private final Board board;
    private final String name;
    private final Board boardEnemy;

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }


    public Player(String name) {
        this.name = name;
        board = new Board();
        boardEnemy = new Board();

    }

    public int wrest() {
        Random random = new Random();
        return 1 + (random.nextInt(6));
    }

    public static boolean makePass(Player player1, Player player2) {
        int countPlayer1 = player1.wrest();
        int countPlayer2 = player2.wrest();
        System.out.println("Первый игрок бросает кубик: " + countPlayer1);
        System.out.println("Второй игрок бросает кубик: " + countPlayer2);
        if (countPlayer1 > countPlayer2) {
            System.out.println("Игрок " + player1.getName() + " ходит первым.");
            return true;
        } else if (countPlayer2 > countPlayer1) {
            System.out.println("Игрок " + player2.getName() + " ходит первым. ");
            return false;

        } else {
            System.out.println("Одинаковые значения! Повтор жеребьевки!");

        }
        return makePass(player1, player2);

    }

    public void attack(Scanner scanner, Player player) {
        Pattern pattern = Pattern.compile("\\d,\\d");
        String string = scanner.nextLine();
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int[] ints = Arrays.stream(string.split("[,;]+")).mapToInt(Integer::parseInt).toArray();
            if (player.board.getMap()[ints[0]][ints[1]].equals(Ships.ONE)) {
                player.board.getMap()[ints[0]][ints[1]] = Ships.HIT;
                player.boardEnemy.getMap()[ints[0]][ints[1]] = Ships.HIT;
                if (Ships.checkContains(player)) {
                    System.out.println("Вы попали! Атакуйте ещё раз!");
                    player.boardEnemy.printBoard();
                    attack(scanner, player);
                } else {
                    System.out.println("Игра закончилась");
                }

            } else {
                player.board.getMap()[ints[0]][ints[1]] = Ships.MISS;
                player.boardEnemy.getMap()[ints[0]][ints[1]] = Ships.MISS;
                System.out.println("Промах, очередь другого игрока");
                player.boardEnemy.printBoard();
            }

        } else {
            System.out.println("Некорректный ввод, пробуй ещё раз");
            attack(scanner, player);
        }


    }


}
