package controller;
import repository.MatrixRepository;

public class GaussJordanController {
    public void doElimination(){
        int counter = 0;

        for(int i = 0; i< MatrixRepository.matrix.size(); i++){
            Double pivot = MatrixRepository.matrix.get(i).get(counter);

            if(pivot != 1){
                for(int j = 0; j< MatrixRepository.matrix.get(i).size(); j++){
                    MatrixRepository.matrix.get(i).set(j, MatrixRepository.matrix.get(i).get(j) / pivot);
                }
            }

            for(int k = 0; k<MatrixRepository.matrix.size(); k++){
                if(k == i) continue;

                double konstanta = MatrixRepository.matrix.get(k).get(counter);
                for(int j = 0; j< MatrixRepository.matrix.get(k).size(); j++){
                    double yangDikurang = MatrixRepository.matrix.get(k).get(j);
                    double patokanKurang = konstanta * MatrixRepository.matrix.get(i).get(j);
                    MatrixRepository.matrix.get(k).set(j,  yangDikurang - patokanKurang);
                }
            }
            counter++;
        }
    }
}
