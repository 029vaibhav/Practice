import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFs {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int noofn = s.nextInt();

        int[][] am = new int[noofn][noofn];

        for (int i = 0; i < noofn; i++) {

            for (int j = 0; j < noofn; j++) {

                am[i][j] = s.nextInt();
            }
        }


    }

    void bfs(int[][] am) {

        int[] visited = new int[am.length];
        Queue<Integer> queue = new LinkedList();
        visited[0] = 1;
        int i,e;
        queue.add(0);
        while (!queue.isEmpty()){
             e = queue.remove();
            i=e;
            while (i<=am.length){

                if(am[e][i]==1 &&visited[i]==0){
                    queue.add(i);
                    visited[i]=1;
                }
                i++;
            }
        }


    }
}
