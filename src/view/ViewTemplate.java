package view;
import java.util.Scanner;

public abstract class ViewTemplate {
    protected final Scanner scan = new Scanner(System.in);
    protected void cls(){ for(int i = 0; i< 25; i++) System.out.println(); }
}
