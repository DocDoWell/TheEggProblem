import java.util.HashMap;

public class DivideAndConquer {

    HashMap<Integer, String> floors;
    int eggs;
    int drops;

    public DivideAndConquer(HashMap<Integer, String> floors, int eggs) {
        this.floors = floors;
        this.eggs = eggs;
        this.drops = 0;
    }

    public int divideAndConquer(){
        //divide
        for(int i =10; i <= 100; i=i+10){
            this.drops++;
            int subproblem = i/10;
            System.out.println("subproblem " +subproblem+ ": drop  number " + drops+ " from floor " + i);
            if(floors.get(i).equals("BREAK")){
                System.out.println("** Egg broken from drop " + drops+ " at floor " + i+" ***");
                return conquer(i-9, subproblem);
            }
        }
        return -1;
    }

    public int conquer(int floor, int subproblem){
        for(int i = floor; i < floor+10; i++){
          //  System.out.println("floor is " + i);
            drops++;
            System.out.println("subproblem " +subproblem+ ": drop  number " + drops+ " from floor " + i);
            if(floors.get(i).equals("BREAK")){
                System.out.println("Pivotal floor is " + i);
                return i;
            }
        }
        return -1;
    }

    public int getDrops() {
        return drops;
    }
}
