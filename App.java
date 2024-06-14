import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class App {

    public static void main(String[] args){
        HashMap<Integer, String> floors = getData();

        Recursion recursion = new Recursion(floors, 5);;
        System.out.println("Number of attempts for brute force iteration is " + recursion.recursionBruteForceAlgorithm());
        System.out.println("Number of attempts for binary search is  " + recursion.recursionBinaryAlgorithm());


        DynamicProgramming dynamicProgramming = new DynamicProgramming(floors, 5);
        dynamicProgramming.initializeDPtable();
        dynamicProgramming.displayTable();
        System.out.println("Dynamic Programming gives minimum number of drops as "+dynamicProgramming.dynamicProgramming());
        dynamicProgramming.displayTable();

        DivideAndConquer divideAndConquer = new DivideAndConquer(floors, 2);
        divideAndConquer.divideAndConquer();
        System.out.println("divideAndConquer found pivtoal floor with " + divideAndConquer.getDrops()+ " drops.");
    }

    static HashMap<Integer, String> getData(){
        HashMap<Integer, String> map = new HashMap<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("floors.txt"))) {
            while ((line = reader.readLine()) != null) {
               map.put(Integer.parseInt(line.split(":")[0]),line.split(":")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
