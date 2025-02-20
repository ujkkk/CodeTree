import java.util.*;
import java.io.*;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> lines = new ArrayList();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines.add(new Line(start, end));
        }

        Collections.sort(lines);

        int [] dp = new int[1001];
    
        for(Line line : lines){

            for(int i=0; i<line.start; i++){
                
                for(int j=line.start; j<=line.end; j++){
                    dp[j] = Math.max(dp[j], dp[i] +1);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<1001; i++){
            //System.out.print(dp[i] +" ");
            ans = Math.max(ans, dp[i]);
        }
        //System.out.println();
        System.out.println(ans);
    }
}

class Line implements Comparable<Line>{
    int start;
    int end;

    public Line(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int compareTo(Line o){
        if(this.start == o.start){
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}