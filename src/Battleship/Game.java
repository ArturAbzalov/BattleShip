package Battleship;


import java.util.Scanner;

public class Game {

    public static void start() {
        System.out.println("Игра начинается!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя первого игрока: ");
        Player player1 = new Player(scanner.nextLine());
        System.out.println("Введите имя второго игрока: ");
        Player player2 = new Player(scanner.nextLine());
        placement(player1);
        placement(player2);
        if (Player.makePass(player1, player2)) {
            while (true) {
                player1.attack(scanner, player2);
                if (!Ships.checkContains(player1) || !Ships.checkContains(player2)) {
                    return;
                }
                player2.attack(scanner, player1);
                if (!Ships.checkContains(player1) || !Ships.checkContains(player2)) {
                    return;
                }
            }
        } else {
            while (true) {
                player2.attack(scanner, player1);
                if (!Ships.checkContains(player1) || !Ships.checkContains(player2)) {
                    return;
                }
                player2.attack(scanner, player1);
                if (!Ships.checkContains(player1) || !Ships.checkContains(player2)) {
                    return;
                }
            }

        }


    }

    public static void placement(Player player) {
        System.out.println(player.getName() + " Введи координаты четырехпалубного корабля в формате х,y;x,y;x,y;x,y");
        Ships.check4(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты первого трехпалубного корабля в формате х,y;x,y;x,y");
        Ships.check3(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты второго трехпалубного корабля в формате х,y;x,y;x,y");
        Ships.check3(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты первого двухпалубного корабля в формате х,y;x,y");
        Ships.check2(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты второго двухпалубного корабля в формате х,y;x,y");
        Ships.check2(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты третьего двухпалубного корабля в формате х,y;x,y");
        Ships.check2(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты первого однопалубного корабля в формате х,y");
        Ships.check1(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты второго однопалубного корабля в формате х,y");
        Ships.check1(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты третьего однопалубного корабля в формате х,y");
        Ships.check1(player);
        player.getBoard().printBoard();
        System.out.println(player.getName() + " Введи координаты четвертого однопалубного корабля в формате х,y");
        Ships.check1(player);
        player.getBoard().printBoard();
    }


}
