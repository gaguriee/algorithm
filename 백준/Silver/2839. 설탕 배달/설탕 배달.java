import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); // input N

        int n = 0; // 3kg 봉지의 개수

        fun(num, n);

        // case 1. 5kg 봉지로만 배달할 수 있는 경우 (n%5 == 0)
        // case 2. 5kg 봉지 n개와 3kg 봉지 3개로 배달할 수 있는 경우 ( n%5 != 0 이라면, n에서 3을 뺀 후 다시 반복하는 형식)
        // case 3. 3kg 봉지 3개로만 배달할 수 있는 경우 (else -> n%3 == 0)

    }

    public static void fun(int num, int n)
    {
        if(num%5 == 0){
            System.out.println( n + num/5); // case 1
        }
        else {
            if (num < 3){
                System.out.println( -1 );
            }
            else {
                num = num-3;
                n += 1; // 3kg 봉지 개수 +1
                fun(num, n);
            }


        }
    }
}