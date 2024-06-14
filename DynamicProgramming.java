import java.util.HashMap;

public class DynamicProgramming {

    public HashMap<Integer, String> floors;
    public int eggs;
    public int[][] dpTable;

    public DynamicProgramming(HashMap<Integer, String> floors, int eggs) {
        this.floors = floors;
        this.eggs = eggs;
        this.dpTable = new int[this.eggs+1][this.floors.keySet().size()+1];
    }

    void initializeDPtable(){
        //initalize dpTable for 1 and 0
        for(int i=0; i<eggs; i++){
            this.dpTable[i][1] = 1;
            this.dpTable[i][0] = 0;
        }

        for(int j=0; j< floors.keySet().size(); j++){
            this.dpTable[1][j] = j;
        }
    }

    int dynamicProgramming(){
        for(int n = 2; n <= eggs; n++){
            for(int m = 1; m <= floors.keySet().size(); m++){
                dpTable[n][m] = Integer.MAX_VALUE;
                for(int x=1; x<=m;x++){
                    if(n==2 && m==2){
                        System.out.println(" x is "+x);
                        int b =  n-1;
                        int c = x-1;
                        int d = m-x;
                        System.out.println("dpTable["+b+"]["+c+"] " + dpTable[n-1][x-1]);
                        System.out.println("dpTable["+n+"]["+d+"] " + dpTable[n][m-x]);
                    }
                    int maxDrops = 1 + Math.max(dpTable[n-1][x-1],dpTable[n][m-x]);
                    if(maxDrops < dpTable[n][m]){
                        dpTable[n][m] = maxDrops;
                    }
                }
            }
        }
        return dpTable[this.eggs][this.floors.keySet().size()];
    }

    public void displayTable(){
        for(int k=0; k<eggs+1; k++){
            for(int l=0; l <floors.keySet().size(); l++){
                System.out.print(this.dpTable[k][l]+ " ");
            }
            System.out.println("");
        }
    }



}
