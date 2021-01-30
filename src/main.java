import com.sun.deploy.util.ArrayUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class main {

    static boolean isnumeric(String s){
        try{
            int i = Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public static Integer findMin(int[] list)
    {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <list.length ; i++) {
            if (list[i] < min){
                min = list[i];
            }
        }
        return min;
    }

    static Graph shortestPathFinder(int[][] matrix, int pos){
        int x = matrix[0].length;
        int y = matrix.length;
        Graph g = new Graph(x*y);

        int k = 0;
        for (int i=0 ; i<y ; i++){
            for (int j=0 ; j<x ; j++){
                if (i-1 >= 0 && j-1>=0 && k-x-1>=0 && k-x-1 != pos){
                    g.graph[k][k-x-1] = matrix[i-1][j-1];
                }
                if (i-1 >= 0 && j>=0 && k-x>=0 && k-x != pos){
                    g.graph[k][k-x] = matrix[i-1][j];
                }
                if (i-1 >= 0 && j+1<x && k-x+1>=0 && k-x+1 != pos){
                    g.graph[k][k-x+1] = matrix[i-1][j+1];
                }

                if (i>= 0 && j-1>=0 && k-1>=0 && k-1 != pos){
                    g.graph[k][k-1] =  matrix[i][j-1];
                }
                if (i >= 0 && j+1<x && k+1>=0 && k+1 != pos){
                    g.graph[k][k+1] = matrix[i][j+1];
                }

                if (i+1 < y && j-1>=0 && k+x-1>=0 && k+x-1 != pos){
                    g.graph[k][k+x-1] = matrix[i+1][j-1];
                }
                if (i+1 < y && j>=0 && k+x>=0 && k+x != pos){
                    g.graph[k][k+x] = matrix[i+1][j];
                }
                if (i+1<y && j+1<x && k+x+1>=0 && k+x+1 != pos){
                    g.graph[k][k+x+1] = matrix[i+1][j+1];
                }
                k++;
            }
        }
        return g;
    }

    static int wallMaker(int[][] mat , int[] pos){
        int x = mat[0].length;
        int y = mat.length;
        int [][] upper_matrix = Arrays.copyOfRange(mat, 0, pos[0] + 1);;
        int [][] lower_matrix = Arrays.copyOfRange(mat, pos[0], y);


        Graph g1 = shortestPathFinder(upper_matrix , x*pos[0] + pos[1]);
        Graph g2 = shortestPathFinder(lower_matrix , pos[1]);

        int mini = Integer.MAX_VALUE;
        int[] selected_line = new int[x];
        selected_line = mat[pos[0]];

        for (int i=0 ; i<pos[1] ; i++){
            int [] r1 = g1.dijkstra(pos[0]*x + i);
            int [] rn1 = Arrays.copyOfRange(r1, r1.length - x, r1.length);;
            r1 = rn1;

            for (int j=0 ; j<r1.length ; j++){
                r1[j] += selected_line[i];
            }

            int[] r2 = g2.dijkstra(i);
            int[] rn2 = Arrays.copyOfRange(r2, 0, x);
            r2 = rn2;
            for (int j=0 ; j<r2.length ; j++){
                r2[j] -= selected_line[j];
            }

            int[] sum = new int[x - pos[1] -1];
            for (int j = 0; j <x - pos[1] -1 ; j++) {
                sum[j] = 0;
            }
            for (int k= pos[1] +1 ; k< x ; k++){
                sum[k - pos[1] -1] = r1[k] + r2[k];
            }
            int acMin = findMin(sum);
            if (acMin < mini){
                mini = acMin;
            }

        }
        //System.out.println(mini);
        return mini;
    }

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        try {
            File input = new File(args[0]);
            if (input.canRead()) {
                Scanner fileObject = new Scanner(input);
                while (fileObject.hasNextLine()) {
                    data.add(fileObject.nextLine());
                }
                fileObject.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] fieldDimensions = data.get(0).split(" ");
        int m = Integer.parseInt(fieldDimensions[0]);
        int n = Integer.parseInt(fieldDimensions[1]);

        int[][] mat = new int[m][n];

        for (int i = 1; i < m + 1; i++) {
            String[] row = data.get(i).split(" ");
            int[] tempRow = new int[n];
            int j = 0;
            for (String s : row
            ) {
                if(isnumeric(s)){
                    tempRow[j] = Integer.parseInt(s);
                    j++;
                }
            }
            mat[i-1] = tempRow;
        }
        String[] posString = data.get(m+1).split(" ");
        int[] pos = new int[2];
        for (int i = 0; i < posString.length; i++) {
            pos[i]  = Integer.parseInt(posString[i]) ;
        }

        int res = wallMaker(mat , pos);
        //System.out.println(res);
        try {
            File output = new File(args[1]);

            if (output.createNewFile() || output.canRead()) {
                FileWriter writer = new FileWriter(args[1]);
                //iteration here
                writer.write(Integer.toString(res));
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
