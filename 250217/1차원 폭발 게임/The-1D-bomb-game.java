import java.util.*;

public class Main {

    static int N, M;
    static int map[];

    public static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N];
        for(int i=0; i<N; i++){
            map[i] = sc.nextInt();
        }
    }

    public static void bomb(){
        while(true){
            // M연속 같은 수 0으로 초기화
            boolean isChange = checkContinue(M);
            if(!isChange)
                break;
            
            gravity();
        }
        
    }

    public static boolean checkContinue(int M){
        int i,j;
        boolean isChange = false;
        for(i=0; i<N; i++){
            for(j=i+1; j<N; j++){
                if(map[j] == 0)
                    break;
                // 연속적이지 않음
                if(map[i] != map[j]){
                    break;
                }
            }
            // 연속적임
            if(j- i >= M){
                isChange = true;
                for(int k=i; k<j; k++){
                    map[k] = 0;
                }
            }
            // output();
            // System.out.println("#####");
        }
        return isChange;
    }

    public static void gravity(){
        // 앞으로 밀기
        int [] temp = new int[N];

        int tempCount = 0;
        for(int i=0; i<N; i++){
            if(map[i] == 0)
                continue;

            temp[tempCount++] = map[i];
        }

        for(int i=0; i<N; i++){
            map[i] = temp[i];
        }

    }

    public static void output(){
        int size = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(map[i] == 0){
                continue;
            }
            size++;
            sb.append(map[i]).append("\n");
        }
        System.out.println(size);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
       input();
       bomb();
        output();
       
    }

}