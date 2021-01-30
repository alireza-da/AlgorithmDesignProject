import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Astar {
    private static final double FLT_MAX = Float.MAX_VALUE;
    private int[][] burningTable;
    private int m,n;
    private Cell[][] cells;
    private Stack<int[]> pathStack = new Stack<>();

    private class Cell{
        int parentI;
        int parentJ;
        double f,g,h;
    }

    private class pPair{
        double f;
        int[] pos;
    }

    private boolean isValid(int row, int col){
        return (row >= 0) && (row < m) &&
                (col >= 0) && (col < n);
    }

    private boolean isUnblocked(int row, int col){
        return burningTable[row][col] > cells[row][col].g + 1;
    }

    private boolean isDestination(int row, int col, int[] dest){
        return row == dest[0] && col == dest[1];
    }

    private double calculateH(int row, int col, int[] dest){
        return Math.sqrt((row-dest[0])*(row-dest[0])
                + (col-dest[1])*(col-dest[1]));
    }

    private int tracePath(Cell[][] cells, int[] dest){
        int row = dest[0];
        int col = dest[1];

        while (cells[row][col].parentI == row && cells[row][col].parentJ == col){
            pathStack.push(new int[]{row,col});
            int tempRow = cells[row][col].parentI;
            int tempCol = cells[row][col].parentJ;
            row = tempRow;
            col = tempCol;
        }
        pathStack.push(new int[]{row,col});
        int size = pathStack.size();
        while (!pathStack.empty()){
            int[] p = pathStack.pop();
            System.out.println("Path:"+Arrays.toString(p));
        }
        return size;
    }
    public void findBurningTimes(char[][] field, int firingTime) {
        int m = field.length;
        int n = field[0].length;
        burningTable = new int[m][n];
        ArrayList<ArrayList<Integer>> clearSections = new ArrayList<>();
        ArrayList<ArrayList<Integer>> burningSections = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                ArrayList<Integer> position = new ArrayList<>();
                position.add(i);
                position.add(j);
                clearSections.add(position);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 'f') {
                    ArrayList<Integer> position = new ArrayList<>();
                    position.add(i);
                    position.add(j);
                    clearSections.remove(position);
                    position.add(0);
                    burningSections.add(position);
                    burningTable[i][j] = 0;
                }
            }
        }
        if (burningSections.isEmpty()) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    burningTable[i][j] = Integer.MAX_VALUE;
                }
            }
            return;
        }
        while (clearSections.size() > 0) {
            for (int i = 0; i < burningSections.size(); i++) {
                ArrayList<Integer> position = new ArrayList<>();
                position.add(burningSections.get(i).get(0));
                position.add(burningSections.get(i).get(1));
                position.set(0, position.get(0) - 1);
                position.set(1, position.get(1) - 1);
                if (clearSections.contains(position)) {
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2, burningPosition.get(2) + firingTime);
                        burningTable[position.get(0)][position.get(1)] = burningPosition.get(2);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1, position.get(1) + 1);
                if (clearSections.contains(position)) {
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2, burningPosition.get(2) + firingTime);
                        burningTable[position.get(0)][position.get(1)] = burningPosition.get(2);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1, position.get(1) + 1);
                if (clearSections.contains(position)) {
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2, burningPosition.get(2) + firingTime);
                        burningTable[position.get(0)][position.get(1)] = burningPosition.get(2);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(0, position.get(0) + 1);
                position.set(1, position.get(1) - 2);
                if (clearSections.contains(position)) {
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2, burningPosition.get(2) + firingTime);
                        burningTable[position.get(0)][position.get(1)] = burningPosition.get(2);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1, position.get(1) + 2);
                if (clearSections.contains(position)) {
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2, burningPosition.get(2) + firingTime);
                        burningTable[position.get(0)][position.get(1)] = burningPosition.get(2);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(0, position.get(0) + 1);
                position.set(1, position.get(1) - 2);
                if (clearSections.contains(position)) {
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2, burningPosition.get(2) + firingTime);
                        burningTable[position.get(0)][position.get(1)] = burningPosition.get(2);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1, position.get(1) + 1);
                if (clearSections.contains(position)) {
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2, burningPosition.get(2) + firingTime);
                        burningTable[position.get(0)][position.get(1)] = burningPosition.get(2);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
                position.set(1, position.get(1) + 1);
                if (clearSections.contains(position)) {
                    ArrayList<Integer> burningPosition = new ArrayList<>();
                    burningPosition.add(position.get(0));
                    burningPosition.add(position.get(1));
                    burningPosition.add(burningSections.get(i).get(2));
                    if (!burningSections.contains(burningPosition)) {
                        burningPosition.set(2, burningPosition.get(2) + firingTime);
                        burningTable[position.get(0)][position.get(1)] = burningPosition.get(2);
                        burningSections.add(burningPosition);
                        clearSections.remove(position);
                    }
                }
            }
        }
    }

    public int aStarSearch(char[][] field, int firingTime ){
        m = field.length;
        n = field[0].length;
        cells = new Cell[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell();
            }
        }
        findBurningTimes(field,firingTime);

        SecondPart secondPart = new SecondPart();
        secondPart.findBurningTimes(field, firingTime);
        int[] poirotLocation = new int[2];
        int[] helicopterLocation = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 's') {
                    poirotLocation[0] = i;
                    poirotLocation[1] = j;
                } else if (field[i][j] == 't') {
                    helicopterLocation[0] = i;
                    helicopterLocation[1] = j;
                }
            }
        }
        if(isDestination(poirotLocation[0], poirotLocation[1], helicopterLocation)){

            return 0;
        }
        boolean[][] closedList = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j].f = FLT_MAX;
                cells[i][j].g = FLT_MAX;
                cells[i][j].h = FLT_MAX;
                cells[i][j].parentI = -1;
                cells[i][j].parentJ = -1;
            }
            
        }
        cells[poirotLocation[0]][poirotLocation[1]].f = 0.0;
        cells[poirotLocation[0]][poirotLocation[1]].g = 0.0;
        cells[poirotLocation[0]][poirotLocation[1]].h = 0.0;
        cells[poirotLocation[0]][poirotLocation[1]].parentI = poirotLocation[0];
        cells[poirotLocation[0]][poirotLocation[1]].parentJ = poirotLocation[1];

        ArrayList<pPair> openList = new ArrayList<>();
        pPair p = new pPair();
        p.f = 0.0;
        p.pos = poirotLocation;
        openList.add(p);
        while (!openList.isEmpty()){
            pPair pPair = openList.get(openList.size()-1);
            openList.remove(openList.size()-1);
            int i = pPair.pos[0];
            int j = pPair.pos[1];
            closedList[i][j] = true;
            double tempG, tempH, tempF;
            if (isValid(i-1,j)){
                if (isDestination(i-1, j, helicopterLocation)){
                    cells[i-1][j].parentI = i;
                    cells[i-1][j].parentJ = j;
                    return (int) cells[i][j].g+1;
                }
                else if (!closedList[i - 1][j] && isUnblocked(i,j)){
                    tempG = cells[i][j].g + 1.0;
                    tempH = calculateH(i-1, j, helicopterLocation);
                    tempF = tempG + tempH;
                    if (cells[i-1][j].f == FLT_MAX ||
                            cells[i-1][j].f > tempF){
                        pPair temp = new pPair();
                        temp.f = tempF;
                        temp.pos = new int[]{i-1,j};
                        openList.add(temp);
                        cells[i-1][j].f = tempF;
                        cells[i-1][j].g = tempG;
                        cells[i-1][j].h = tempH;
                        cells[i-1][j].parentI = i;
                        cells[i-1][j].parentJ = j;
                    }
                }
            }
            if (isValid(i+1,j)){
                if (isDestination(i+1, j, helicopterLocation)){
                    cells[i+1][j].parentI = i;
                    cells[i+1][j].parentJ = j;
                    return (int) cells[i][j].g+1;
                }
                else if (!closedList[i + 1][j] && isUnblocked(i,j)){
                    tempG = cells[i][j].g + 1.0;
                    tempH = calculateH(i+1, j, helicopterLocation);
                    tempF = tempG + tempH;
                    if (cells[i+1][j].f == FLT_MAX ||
                            cells[i+1][j].f > tempF){
                        pPair temp = new pPair();
                        temp.f = tempF;
                        temp.pos = new int[]{i+1,j};
                        openList.add(temp);
                        cells[i+1][j].f = tempF;
                        cells[i+1][j].g = tempG;
                        cells[i+1][j].h = tempH;
                        cells[i+1][j].parentI = i;
                        cells[i+1][j].parentJ = j;
                    }
                }
            }
            if (isValid(i,j+1)){
                if (isDestination(i, j+1, helicopterLocation)){
                    cells[i][j+1].parentI = i;
                    cells[i][j+1].parentJ = j;
                    return (int) cells[i][j].g+1;
                }
                else if (!closedList[i][j+1] && isUnblocked(i,j)){
                    tempG = cells[i][j].g + 1.0;
                    tempH = calculateH(i, j+1, helicopterLocation);
                    tempF = tempG + tempH;
                    if (cells[i][j+1].f == FLT_MAX ||
                            cells[i][j+1].f > tempF){
                        pPair temp = new pPair();
                        temp.f = tempF;
                        temp.pos = new int[]{i,j+1};
                        openList.add(temp);
                        cells[i][j+1].f = tempF;
                        cells[i][j+1].g = tempG;
                        cells[i][j+1].h = tempH;
                        cells[i][j+1].parentI = i;
                        cells[i][j+1].parentJ = j;
                    }
                }
            }
            if (isValid(i,j-1)){
                if (isDestination(i, j-1, helicopterLocation)){
                    cells[i][j-1].parentI = i;
                    cells[i][j-1].parentJ = j;
                    return (int) cells[i][j].g+1;
                }
                else if (!closedList[i][j-1] && isUnblocked(i,j)){
                    tempG = cells[i][j].g + 1.0;
                    tempH = calculateH(i, j-1, helicopterLocation);
                    tempF = tempG + tempH;
                    if (cells[i][j-1].f == FLT_MAX ||
                            cells[i][j-1].f > tempF){
                        pPair temp = new pPair();
                        temp.f = tempF;
                        temp.pos = new int[]{i,j-1};
                        openList.add(temp);
                        cells[i][j-1].f = tempF;
                        cells[i][j-1].g = tempG;
                        cells[i][j-1].h = tempH;
                        cells[i][j-1].parentI = i;
                        cells[i][j-1].parentJ = j;
                    }
                }
            }
        }
        return -1;
    }



}
