package view;

import java.util.List;

import controller.GaussJordanController;
import repository.MatrixRepository;

import java.util.ArrayList;

public class GaussJordanView extends ViewTemplate{
    private void printList(){
        for(int i = 0; i< MatrixRepository.matrix.size(); i++){
            for(int j = 0; j< MatrixRepository.matrix.get(i).size(); j++){
                System.out.print(MatrixRepository.matrix.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }

    public GaussJordanView(){
        int n = 0;

        while(true){
            System.out.print("Input the number of equations: ");

            try{
                n = scan.nextInt();

                if(n < 1) System.out.println("Invalid MatrixRepository.matrix size of "+ n+"\n\n");
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

            MatrixRepository.matrix.add(temp);
        }

        cls();
        
        printList();

        System.out.println("\nThis is the matrix. Proceed to the gauss elimination\n");

        GaussJordanController controller = new GaussJordanController();
        controller.doElimination();

        printList();
    }
}
