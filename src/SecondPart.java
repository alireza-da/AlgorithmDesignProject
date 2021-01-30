import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SecondPart {
    private int[][] burningTable;
    ArrayList<int[]> queue = new ArrayList<>();

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

    public int findShortestPath(char[][] field, int firingTime) {

        findBurningTimes(field, firingTime);
        int m = field.length;
        int n = field[0].length;

        boolean[][] visited = new boolean[m][n];
        int[] poirotLocation = {-1, -1};
        int[] helicopterLocation = {-1, -1};
        int answer = -1;

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
        if (Math.abs(poirotLocation[0] - helicopterLocation[0]) + Math.abs(poirotLocation[1] - helicopterLocation[1]) >=
                burningTable[helicopterLocation[0]][helicopterLocation[1]]) {
            queue.clear();
            return answer;
        }
        int blocked = 0;
        if (poirotLocation[0] - 1 >= 0 && burningTable[poirotLocation[0] - 1][poirotLocation[1]] <= 1) {
            blocked++;
        }
        if (poirotLocation[1] - 1 >= 0 && burningTable[poirotLocation[0]][poirotLocation[1] - 1] <= 1) {
            blocked++;
        }
        if (poirotLocation[1] + 1 < n && burningTable[poirotLocation[0]][poirotLocation[1] + 1] <= 1) {
            blocked++;
        }
        if (poirotLocation[0] + 1 < m && burningTable[poirotLocation[0] + 1][poirotLocation[1]] <= 1) {
            blocked++;
        }
        if (blocked == 4) {
            queue.clear();
            return answer;
        }
        // DFS
        //System.out.println(Arrays.toString(helicopterLocation));
        int[] currentPosition, prevPosition = new int[]{-1, -1};
        int cost = 0;
        queue.add(poirotLocation);
        //System.out.println(m);
        //System.out.println(n);
        //System.out.println(firingTime);
        //printTable();
        while (true) {
            currentPosition = queue.get(queue.size() - 1);
            //printTable();
            //System.out.println("Queue");
            //printQueue();
            //System.out.println(Arrays.deepToString(visited));
            //System.out.println("burningTime:"+burningTable[currentPosition[0]][currentPosition[1]]);
            //System.out.println("curr:" + Arrays.toString(currentPosition));
            //System.out.println("prev:" + Arrays.toString(prevPosition));
            //System.out.println("cost;" + cost);


            if (currentPosition[0] < helicopterLocation[0]) {
                if (cost + 1 < burningTable[currentPosition[0] + 1][currentPosition[1]]) {
                    queue.add(new int[]{currentPosition[0] + 1, currentPosition[1]});
                    cost++;
                } else if (currentPosition[1] >= helicopterLocation[1]) {
                    if (currentPosition[1] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] - 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] - 1});
                        cost++;
                    } else if (currentPosition[1] + 1 < n && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] + 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] + 1});
                        cost++;
                    } else if (currentPosition[0] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0] - 1][currentPosition[1]]) {
                        queue.add(new int[]{currentPosition[0] - 1, currentPosition[1]});
                        cost++;
                    }
                } else {
                    if (currentPosition[1] + 1 < n && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] + 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] + 1});
                        cost++;
                    } else if (currentPosition[1] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] - 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] - 1});
                        cost++;
                    } else if (currentPosition[0] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0] - 1][currentPosition[1]]) {
                        queue.add(new int[]{currentPosition[0] - 1, currentPosition[1]});
                        cost++;
                    }
                }
            } else if (currentPosition[0] > helicopterLocation[0]) {

                if (cost + 1 < burningTable[currentPosition[0] - 1][currentPosition[1]]) {
                    queue.add(new int[]{currentPosition[0] - 1, currentPosition[1]});
                    cost++;
                } else if (currentPosition[1] >= helicopterLocation[1]) {
                    if (currentPosition[1] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] - 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] - 1});
                        cost++;
                    } else if (currentPosition[1] + 1 < n && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] + 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] + 1});
                        cost++;
                    } else if (currentPosition[0] + 1 < m && cost + 1 < burningTable[currentPosition[0] + 1][currentPosition[1]]) {
                        queue.add(new int[]{currentPosition[0] + 1, currentPosition[1]});
                        cost++;
                    }
                } else {
                    if (currentPosition[1] + 1 < n && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] + 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] + 1});
                        cost++;
                    } else if (currentPosition[1] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] - 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] - 1});
                        cost++;
                    } else if (currentPosition[0] + 1 < m && cost + 1 < burningTable[currentPosition[0] + 1][currentPosition[1]]) {
                        queue.add(new int[]{currentPosition[0] + 1, currentPosition[1]});
                        cost++;
                    }
                }
            } else if (currentPosition[0] == helicopterLocation[0]) {
                if (currentPosition[1] >= helicopterLocation[1]) {
                    if (currentPosition[1] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] - 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] - 1});
                        cost++;
                    } else if (currentPosition[1] + 1 < n && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] + 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] + 1});
                        cost++;
                    } else if (currentPosition[0] + 1 < m && cost + 1 < burningTable[currentPosition[0] + 1][currentPosition[1]]) {
                        queue.add(new int[]{currentPosition[0] + 1, currentPosition[1]});
                        cost++;
                    } else if (currentPosition[0] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0] - 1][currentPosition[1]]) {
                        queue.add(new int[]{currentPosition[0] - 1, currentPosition[1]});
                        cost++;
                    }

                } else {
                    if (currentPosition[1] + 1 < n && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] + 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] + 1});
                        cost++;
                    } else if (currentPosition[1] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0]][currentPosition[1] - 1]) {
                        queue.add(new int[]{currentPosition[0], currentPosition[1] - 1});
                        cost++;
                    } else if (currentPosition[0] + 1 < m && cost + 1 < burningTable[currentPosition[0] + 1][currentPosition[1]]) {
                        queue.add(new int[]{currentPosition[0] + 1, currentPosition[1]});
                        cost++;
                    } else if (currentPosition[0] - 1 >= 0 && cost + 1 < burningTable[currentPosition[0] - 1][currentPosition[1]]) {
                        queue.add(new int[]{currentPosition[0] - 1, currentPosition[1]});
                        cost++;
                    }
                }
            }
            //System.out.println("chosen" + Arrays.toString(queue.get(queue.size() - 1)));
            blocked = 0;
            if (queue.get(queue.size() - 1)[0] == currentPosition[0] && queue.get(queue.size() - 1)[1] == currentPosition[1]) {
                queue.remove(queue.size() - 1);
                burningTable[currentPosition[0]][currentPosition[1]] = -100;
                cost--;
            } else {
                if (queue.size() > 2 && prevPosition[0] != queue.get(queue.size() - 1)[0] && prevPosition[1] != queue.get(queue.size() - 1)[1]
                        && queueContain(queue.get(queue.size() - 1))) {
                    burningTable[queue.get(queue.size() - 1)[0]][queue.get(queue.size() - 1)[1]] = -100;
                    queue.remove(queue.size() - 1);
                    cost--;
                }
                if (queue.size() > 1 && prevPosition[0] == queue.get(queue.size() - 1)[0] && prevPosition[1] == queue.get(queue.size() - 1)[1]) {

                    if (currentPosition[0] - 1 >= 0 && cost > burningTable[currentPosition[0] - 1][currentPosition[1]]) {
                        blocked++;
                    }
                    if (currentPosition[0] + 1 < m && cost > burningTable[currentPosition[0] + 1][currentPosition[1]]) {
                        blocked++;
                    }
                    if (currentPosition[1] - 1 >= 0 && cost > burningTable[currentPosition[0]][currentPosition[1] - 1]) {
                        blocked++;
                    }
                    if (currentPosition[1] + 1 < n && cost > burningTable[currentPosition[0]][currentPosition[1] + 1]) {
                        blocked++;
                    }
                    if (blocked == 3) {
                        queue.remove(queue.size() - 2);
                        queue.remove(queue.size() - 1);
                        burningTable[currentPosition[0]][currentPosition[1]] = -100;
                    } else {
                        queue.remove(queue.size() - 1);
                        burningTable[prevPosition[0]][prevPosition[1]] = -100;
                    }
                    cost--;
                } else {
                    if (queue.size() > 2 && queueContain(new int[]{queue.get(queue.size() - 1)[0] - 1, queue.get(queue.size() - 1)[1]})) {
                        int[] chosen = queue.get(queue.size() - 1);
                        queue.remove(queue.size() - 1);
                        while (!(queue.get(queue.size() - 1)[0] == chosen[0] - 1 && queue.get(queue.size() - 1)[1] == chosen[1])) {
                            //burningTable[queue.get(queue.size() - 1)[0]][queue.get(queue.size() - 1)[1]] = -100;
                            queue.remove(queue.size() - 1);
                            cost--;
                        }
                        queue.add(chosen);
                    }
                    if (queue.size() > 2 && queueContain(new int[]{queue.get(queue.size() - 1)[0] + 1, queue.get(queue.size() - 1)[1]})) {
                        int[] chosen = queue.get(queue.size() - 1);
                        queue.remove(queue.size() - 1);
                        while (!(queue.get(queue.size() - 1)[0] == chosen[0] + 1 && queue.get(queue.size() - 1)[1] == chosen[1])) {
                            //burningTable[queue.get(queue.size() - 1)[0]][queue.get(queue.size() - 1)[1]] = -100;
                            queue.remove(queue.size() - 1);
                            cost--;
                        }
                        queue.add(chosen);
                    }
                    if (queue.size() > 2 && queueContain(new int[]{queue.get(queue.size() - 1)[0], queue.get(queue.size() - 1)[1] - 1})) {
                        int[] chosen = queue.get(queue.size() - 1);
                        queue.remove(queue.size() - 1);
                        while (!(queue.get(queue.size() - 1)[0] == chosen[0] && queue.get(queue.size() - 1)[1] == chosen[1] - 1)) {
                            //burningTable[queue.get(queue.size() - 1)[0]][queue.get(queue.size() - 1)[1]] = -100;
                            queue.remove(queue.size() - 1);
                            cost--;
                        }
                        queue.add(chosen);
                    }
                    if (queue.size() > 2 && queueContain(new int[]{queue.get(queue.size() - 1)[0], queue.get(queue.size() - 1)[1] + 1})) {
                        int[] chosen = queue.get(queue.size() - 1);
                        queue.remove(queue.size() - 1);
                        while (!(queue.get(queue.size() - 1)[0] == chosen[0] && queue.get(queue.size() - 1)[1] == chosen[1] + 1)) {
                            //burningTable[queue.get(queue.size() - 1)[0]][queue.get(queue.size() - 1)[1]] = -100;
                            queue.remove(queue.size() - 1);
                            cost--;
                        }
                        queue.add(chosen);
                    }
                }
            }

            if (queue.size() > 1) {
                prevPosition = queue.get(queue.size() - 2);
            }
            if (queue.size() > 0) {
                visited[queue.get(queue.size() - 1)[0]][queue.get(queue.size() - 1)[1]] = true;
            }
            if (queue.isEmpty()) {
                break;
            }
            if (visited[helicopterLocation[0]][helicopterLocation[1]]) {
                break;
            }
            /*if (m == 30 && n == 30 && firingTime == 10) {
                Scanner scanner = new Scanner(System.in);
                scanner.nextInt();
            }*/
        }
        answer = cost;
        queue.clear();
        return answer;
    }

    public static void main(String[] args) {
        FirstPart firstPart = new FirstPart();
        SecondPart secondPart = new SecondPart();
        Astar astar = new Astar();
        ArrayList<HashMap<char[][], Integer>> data = firstPart.getInput(args[0]); // first argument of program is input file
        try {
            File output = new File(args[1]);
            File output2 = new File(args[2]);
            if (output.createNewFile() || output.canRead()) {
                FileWriter writer = new FileWriter(args[1]);// second argument of program is output file
                for (HashMap<char[][], Integer> entry : data) {
                    int result = secondPart.findShortestPath(entry.keySet().iterator().next(), entry.get(entry.keySet().iterator().next()));
                    if (result == -1) {
                        writer.write("Impossible\n");
                    } else {
                        writer.write(result + "\n");
                    }
                }
                writer.close();
            }
            if(output2.createNewFile() || output2.canRead()){
                FileWriter writer = new FileWriter(args[2]);// second argument of program is output file
                for (HashMap<char[][], Integer> entry : data) {
                    int result = astar.aStarSearch(entry.keySet().iterator().next(), entry.get(entry.keySet().iterator().next()));
                    if (result == -1) {
                        writer.write("Impossible\n");
                    } else {
                        writer.write(result + "\n");
                    }
                }
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean queueContain(int[] pos) {
        for (int i = 0; i < queue.size() - 1; i++) {
            if (queue.get(i)[0] == pos[0] && queue.get(i)[1] == pos[1]) {
                return true;
            }
        }
        return false;
    }
    private void printTable() {
        for (int[] arr : burningTable
        ) {
            System.out.println(Arrays.toString(arr));
        }
    }
    private void printQueue() {
        for (int[] ints : queue) {
            System.out.println(Arrays.toString(ints));
        }
    }
}




