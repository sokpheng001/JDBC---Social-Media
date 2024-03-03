package view;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Locale;
import java.util.Scanner;

public class UI {
    private static final Table table = new Table(1, BorderStyle.UNICODE_BOX);
    public static int homePage(){
        System.out.println("-".repeat(90));
        System.out.println("1/ list all users".toUpperCase(Locale.ROOT));
        System.out.println("2/ search user".toUpperCase(Locale.ROOT));
        System.out.println("3/ delete user by uuid".toUpperCase(Locale.ROOT));
        System.out.println("---");
        System.out.print(">/ option: ");
        return new Scanner(System.in).nextInt();
    }
}
