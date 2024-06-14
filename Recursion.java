import java.util.HashMap;

public class Recursion {
    HashMap<Integer, String> floors;
    int eggs;
    public Recursion(HashMap<Integer, String> floors, int eggs) {
        this.floors = floors;
        this.eggs = eggs;
    }

    public int recursionBruteForceAlgorithm(){
        return bruteForce(1, 1);
    }

    private int bruteForce(int floor,  int attempt){
        //base cases
        if(floors.get(floor).equals("BREAK")){
            return attempt;
        }
        //recursive case
        return bruteForce(floor+1, attempt+1);
    }

    public int recursionBinaryAlgorithm(){
        return binarySearch(1, floors.keySet().size(),  1);
    }

    private int binarySearch(int lowerfloor, int higherFloor,  int attempt) {
        int mid = (lowerfloor + higherFloor)/2;
        System.out.println("An egg has been dropped from floor "+ mid);
        //base cases
        if(eggs == 0){
            System.out.println("ran out of eggs!");
            return -1;
        }

        if(floors.get(mid).equals("BREAK") && floors.get(mid-1).equals("OK")){
            return attempt;
        }

        //recursive case
        if (floors.get(mid).equals("OK")) {
            return binarySearch(mid, higherFloor, attempt+1);
        }else{
            System.out.println("*** egg is broken ***");
            eggs--;
            return binarySearch(lowerfloor, mid, attempt+1);
        }
    }


}
