import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int K = scanner.nextInt();	// K개의 줄에 정수 1개씩 입력

        for(int i = 0; i < K; i++) {
            int num = scanner.nextInt();

            if(num == 0) {
                stack.pop(); // 0일 경우 가장 최근에 쓴 수 지우기
                // (정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.)
            }
            else {
                stack.push(num); // 아닐 경우 쓰기
            }
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop(); // stack의 총합
        }

        System.out.println(sum);
    }
}