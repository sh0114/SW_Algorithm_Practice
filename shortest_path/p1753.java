package sp;

import java.util.*;
import java.io.*;
 
// https://www.acmicpc.net/problem/1753
 
class p1753 {
    static int stoi(String s) { return Integer.parseInt(s);}
 
    static final int INF = 987654321;
    static int v, e;
    static int[] dist;
    static List<List<Node>> list;
 
    static class Node implements Comparable<Node> {
        int index, distance;
 
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
 
        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        // Input
        st = new StringTokenizer(br.readLine());
        v = stoi(st.nextToken());
        e = stoi(st.nextToken());
        dist = new int[v+1];
        list = new ArrayList<List<Node>>();
 
        int start = stoi(br.readLine());
 
        list.add(new ArrayList<Node>());
        // init array
        Arrays.fill(dist, INF);
        for(int i=1; i<=v; i++) {
            list.add(new ArrayList<Node>());
        }
        
        // input
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
 
            int v1 = stoi(st.nextToken());
            int v2 = stoi(st.nextToken());
            int cost = stoi(st.nextToken());
 
            list.get(v1).add(new Node(v2, cost));
        }
 
        // algorithm
        dijkstra(list, dist, start);
 
        // output
        for(int i=1; i<=v; i++) {
            if(dist[i] == INF)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
 
    static void dijkstra(List<List<Node>> list, int[] distance, int start) {
        boolean[] visited = new boolean[v+1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
 
        distance[start] = 0;
        pq.add(new Node(start, 0));
 
        while(!pq.isEmpty()) {
            int now = pq.poll().index;
 
            if(visited[now]) continue;
            visited[now] = true;
 
            for(Node node : list.get(now)) {
                if(distance[node.index] > distance[now] + node.distance) {
                    distance[node.index] = distance[now] + node.distance;
                    pq.add(new Node(node.index, distance[node.index]));
                }
            }
        }
    }
 
}