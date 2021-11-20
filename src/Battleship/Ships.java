package Battleship;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Ships {
    ONE("\uD83D\uDEE5"), EMPTY("⬜"), AREA("\uDBC0\uDC00"),
    MISS("\uD83C\uDF10"), HIT("\uDBC0\uDC00");

    String name;
    static Scanner scanner = new Scanner(System.in);

    Ships(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    public static void check4(Player player) {
        Pattern pattern = Pattern.compile("\\d,\\d;\\d,\\d;\\d,\\d;\\d,\\d");
        String string = scanner.nextLine();
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int[] ints = Arrays.stream(string.split("[,;]+")).mapToInt(Integer::parseInt).toArray();
            if (((ints[0] == ints[2]) && (ints[0] == ints[4]) && (ints[0] == ints[6])) ||
                    ((ints[1] == ints[3]) && (ints[1] == ints[5]) && (ints[1] == ints[7]))) {
                if ((((ints[7] - ints[5]) == 1) && ((ints[5] - ints[3]) == 1) && ((ints[3] - ints[1]) == 1)) ||
                        (((ints[6] - ints[4]) == 1) && ((ints[4] - ints[2]) == 1) && ((ints[2] - ints[0]) == 1))) {
                    if ((player.getBoard().getMap()[ints[0]][ints[1]]).equals(Ships.EMPTY) &&
                            (player.getBoard().getMap()[ints[2]][ints[3]]).equals(Ships.EMPTY) &&
                            (player.getBoard().getMap()[ints[4]][ints[5]]).equals(Ships.EMPTY) &&
                            (player.getBoard().getMap()[ints[6]][ints[7]]).equals(Ships.EMPTY)) {
                        player.getBoard().setMap(ints);
                    } else {
                        System.out.println("Повторите попытку!");
                        check4(player);
                    }
                } else {
                    System.out.println("Повторите попытку!");
                    check4(player);
                }
            } else {
                System.out.println("Повторите попытку!");
                check4(player);
            }
        } else {
            System.out.println("Повторите попытку!");
            check4(player);
        }
    }

    public static void check3(Player player) {
        Pattern pattern = Pattern.compile("\\d,\\d;\\d,\\d;\\d,\\d");
        String string = scanner.nextLine();
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int[] ints = Arrays.stream(string.split("[,;]+")).mapToInt(Integer::parseInt).toArray();
            if (((ints[0] == ints[2]) && (ints[0] == ints[4])) ||
                    ((ints[1] == ints[3]) && (ints[1] == ints[5]))) {
                if ((((ints[5] - ints[3]) == 1) && ((ints[3] - ints[1]) == 1)) ||
                        (((ints[4] - ints[2]) == 1) && ((ints[2] - ints[0]) == 1))) {
                    if ((player.getBoard().getMap()[ints[0]][ints[1]]).equals(Ships.EMPTY) &&
                            (player.getBoard().getMap()[ints[2]][ints[3]]).equals(Ships.EMPTY) &&
                            (player.getBoard().getMap()[ints[4]][ints[5]]).equals(Ships.EMPTY)) {
                        player.getBoard().setMap(ints);
                    } else {
                        System.out.println("Повторите попытку!");
                        check3(player);
                    }
                } else {
                    System.out.println("Повторите попытку!");
                    check3(player);
                }
            } else {
                System.out.println("Повторите попытку!");
                check3(player);
            }
        } else {
            System.out.println("Повторите попытку!");
            check3(player);
        }
    }

    public static void check2(Player player) {
        Pattern pattern = Pattern.compile("\\d,\\d;\\d,\\d");
        String string = scanner.nextLine();
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int[] ints = Arrays.stream(string.split("[,;]+")).mapToInt(Integer::parseInt).toArray();
            if (((ints[0] == ints[2])) ||
                    ((ints[1] == ints[3]))) {
                if ((((ints[3] - ints[1]) == 1)) ||
                        (((ints[2] - ints[0]) == 1))) {
                    if ((player.getBoard().getMap()[ints[0]][ints[1]]).equals(Ships.EMPTY) &&
                            (player.getBoard().getMap()[ints[2]][ints[3]]).equals(Ships.EMPTY)) {
                        player.getBoard().setMap(ints);
                    } else {
                        System.out.println("Повторите попытку!");
                        check2(player);
                    }
                } else {
                    System.out.println("Повторите попытку!");
                    check2(player);
                }
            } else {
                System.out.println("Повторите попытку!");
                check2(player);
            }
        } else {
            System.out.println("Повторите попытку!");
            check2(player);
        }

    }

    public static void check1(Player player) {
        Pattern pattern = Pattern.compile("\\d,\\d");
        String string = scanner.nextLine();
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            int[] ints = Arrays.stream(string.split("[,;]+")).mapToInt(Integer::parseInt).toArray();
            if ((player.getBoard().getMap()[ints[0]][ints[1]]).equals(Ships.EMPTY)) {
                player.getBoard().setMap(ints);
            } else {
                System.out.println("Повторите попытку!");
                check2(player);
            }
        } else {
            System.out.println("Повторите попытку!");
            check2(player);
        }
    }

    public static boolean checkContains(Player player) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (player.getBoard().getMap()[x][y].equals(Ships.ONE)) return true;
            }
        }
        return false;
    }
}


