import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    /**
     *      2x + 4y + 7z = 4
     *      3x + 3y + 2z = 8
     *      5x + 6y + 3z = 0
     */

    private final Scanner scan = new Scanner(System.in);
    private final List<List<Double>> matrix = new ArrayList<List<Double>>();

    private void cls(){ for(int i = 0; i< 25; i++) System.out.println(); }
    
    private void gaussJordanElimination(List<List<Double>> input){
        List<Double> output = new ArrayList<Double>();
        output.forEach(d -> System.out.println(d));
    }

    private void printList(){
        for(int i = 0; i< matrix.size(); i++){
            for(int j = 0; j< matrix.get(i).size(); j++){
                System.out.print(matrix.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }

    public App(){
        String input = "";

        int n = 0;

        while(true){
            System.out.print("Input the number of equations: ");

            try{
                n = scan.nextInt();

                if(n < 1) System.out.println("Invalid matrix size of "+ n+"\n\n");
                    else break;
            }catch(Exception e){
                System.out.println("The input must considered of positive integer!\n\n");
                scan.nextLine();
            }
        }

        double val = 0.0;


        for(int i = 0; i< n; i++){
            final List<Double> temp = new ArrayList<Double>();

            System.out.print("Input matrix row number "+ i +" (e.g: 1 2 3 4 (The \"4\" is considered as total. In this case: a + 2b + 3c = 4)): ");

            for(int j = 0; j< n+1; j++){
                while(true){
                    try{
                        val = scan.nextDouble();
                        temp.add(val);
                        break;
                    }catch(Exception e){
                        System.out.println("The input must considered of double!\n\n");
                        scan.nextLine();
                    }
                }
            }

            matrix.add(temp);
        }

        cls();
        
        printList();

        while(true){
            String x;

            System.out.print("\nThis is the matrix. Proceed to the gauss elimination? [Y/N] ");
            x = scan.nextLine();

            if(x == "Y" && x == "N") break;
                else System.out.println("Invalid input! Must Y or N \n\n");
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
