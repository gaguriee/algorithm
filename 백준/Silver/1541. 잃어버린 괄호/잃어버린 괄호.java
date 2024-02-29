import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while(st.hasMoreTokens()){
            StringTokenizer stt = new StringTokenizer(st.nextToken(), "+");

            int sum = 0;

            while(stt.hasMoreTokens()){
                sum += Integer.parseInt(stt.nextToken());
            }

            if (ans == Integer.MAX_VALUE){
                ans = sum;
            }
            else {
                ans -= sum;
            }

        }

        System.out.println(ans);

    }
}