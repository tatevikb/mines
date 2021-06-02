package driver;

import engine.Field;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var f = new Field(6, 8);
        f.show(true);

        while(!f.isOver()) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            String st = scan.nextLine();
        }
    }
}