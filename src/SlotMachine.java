import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random ran = new Random();
        int Fpoint = 100000;
        int userTotal = Fpoint;
        int bet;
        String ulang;

        String[][] spin1 = {
                {"\uD83C\uDF4C", "\uD83C\uDF4E", "\uD83C\uDF4A", "\uD83C\uDF4B"},
                {"\uD83C\uDF47", "\uD83C\uDF53", "\uD83C\uDF52", "\uD83C\uDF51"}
        };
        String[][] spin2 = {
                {"\uD83C\uDF4C", "\uD83C\uDF4E", "\uD83C\uDF4A", "\uD83C\uDF4B"},
                {"\uD83C\uDF47", "\uD83C\uDF53", "\uD83C\uDF52", "\uD83C\uDF51"},
        };
        String[][] spin3 = {
                {"\uD83C\uDF4C", "\uD83C\uDF4E", "\uD83C\uDF4A", "\uD83C\uDF4B"},
                {"\uD83C\uDF47", "\uD83C\uDF53", "\uD83C\uDF52", "\uD83C\uDF51"}
        };

        System.out.println("FRUITS SLOTS");

        do {
            System.out.println("Fruits Poin : " + userTotal);

            do {
                System.out.print("Masukkan bet : ");
                bet = input.nextInt();
                if (bet >= userTotal) {
                    System.out.println("Fpoint kurang");
                }

            } while (bet >= userTotal);

            userTotal = userTotal - bet;

            if (userTotal >= 0) {
                int ranf1 = ran.nextInt(2);
                int ranf2 = ran.nextInt(2);
                int ranf3 = ran.nextInt(2);
                int ranl1 = ran.nextInt(4);
                int ranl2 = ran.nextInt(4);
                int ranl3 = ran.nextInt(4);

                String[][] random1 = new String[2][4];
                String[][] random2 = new String[2][4];
                String[][] random3 = new String[2][4];

                random1[ranf1][ranl1] = spin1[ranf1][ranl1];
                random2[ranf2][ranl2] = spin2[ranf2][ranl2];
                random3[ranf3][ranl3] = spin3[ranf3][ranl3];

                System.out.printf("%n------------%n");
                System.out.printf(" %-3s%-3s%3s%n", random1[ranf1][ranl1], random2[ranf2][ranl2], random3[ranf3][ranl3]);
                System.out.printf("------------%n");

                if (random1[ranf1][ranl1] == random2[ranf2][ranl2] && random2[ranf2][ranl2] == random3[ranf3][ranl3]) {
                    System.out.printf("%nTriple Fruits");
                    int tripleReward = (bet * 3);
                    userTotal = (userTotal + tripleReward);
                    System.out.printf("%nAnda menang: %s", tripleReward);
                    System.out.printf("%nFpoint: %s", userTotal);
                } else if (random1[ranf1][ranl1] != random2[ranf2][ranl2] && random2[ranf2][ranl2] !=
                        random3[ranf3][ranl3] && random1[ranf1][ranl1] != random3[ranf3][ranl3]) {
                    System.out.printf("%nZERO");
                    System.out.printf("%nAnda menang: 0");
                    System.out.printf("%nFpoint: %s", userTotal);
                } else if (random1[ranf1][ranl1] == random2[ranf2][ranl2] || random2[ranf2][ranl2] ==
                        random3[ranf3][ranl3] || random1[ranf1][ranl1] == random3[ranf3][ranl3]) {
                    System.out.printf("%nDouble Fruits");
                    int doubleReward = (bet * 2);
                    userTotal = (userTotal + doubleReward);
                    System.out.printf("%nAnda menang : %s", doubleReward);
                    System.out.printf("%nFpoint : %s", userTotal);
                }

            } else {
                System.out.println("Maaf Fruits point mu habis");
                System.exit(0);
            }

            System.out.println();
            System.out.printf("%nIngin coba lagi? y/n%n");
            ulang = input.next();

            System.out.println();

        } while (ulang.equalsIgnoreCase("y"));
    }
}
