package dijkstra;
import java.io.*;
import java.util.*;

public class B11909 {

    static int n;
    static int[][] graph;
    static int[][] dist;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static class Node implements Comparable<Node>{
        int x, y, cost;

        Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    static void dijkstra(){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,1,0));
        dist[1][1] = 0;
        
        while(!pq.isEmpty()){

            Node now = pq.poll();
         
            if(now.cost > dist[now.y][now.x]) continue;

            for(int i = 0; i < 2; i++){

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 1 || ny < 1 || nx > n || ny > n) continue;

                int cost = Math.max(0, graph[ny][nx] - graph[now.y][now.x] + 1);

                if(dist[ny][nx] > dist[now.y][now.x] + cost){
                    dist[ny][nx] = dist[now.y][now.x] + cost;
                    pq.offer(new Node(nx, ny, dist[ny][nx]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        dist = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dijkstra();

        System.out.println(dist[n][n]);
    }
}