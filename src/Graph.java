import java.util.ArrayList;

public class Graph {
    int V;
    int [][] graph;

    public Graph(int i) {
        this.V = i;
        graph = new int[V][V];
        for (int j=0 ; j<this.V ; j++){
            for(int k=0 ; k<this.V ; k++){
                graph[j][k] = -1;
            }

        }
    }

    int minDistance(int[] dist ,boolean[] sptSet){
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int i=0 ; i<V ; i++){
         if (( dist[i] < min) && (sptSet[i] == false)){
            min = (int)dist[i];
            min_index   = i;
         }
        }
        return min_index;
    }
    int[] dijkstra(int src){
        int[] dist = new int[V];
        for (int i = 0; i <V ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        boolean[] sptSet = new boolean[V];
        for (int i = 0; i <V ; i++) {
            sptSet[i] = false;
        }
        for (int i=0 ; i<V ; i++){
            int u = minDistance(dist , sptSet);
            sptSet[u] = true;
            for (int v=0 ; v<V ; v++){
                if (graph[u][v] >= 0 && sptSet[v] == false && dist[v] > dist[u] + graph[u][v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }



}
