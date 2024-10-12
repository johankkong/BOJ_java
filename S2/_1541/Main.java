package S2._1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int inputLength = input.length();
        answer = 0;
        char currentSign = '+';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= inputLength; i++) {
            if (i == inputLength) {
                handleNumber(sb.toString(), currentSign);
            } else {
                char letter = input.charAt(i);
                switch (letter) {
                    case '-':
                    case '+':
                        handleNumber(sb.toString(), currentSign);
                        if (currentSign == '+' && letter == '-') {
                            currentSign = '-';
                        }
                        sb = new StringBuilder();
                        break;
                    default:
                        // 숫자면 sb에 append
                        sb.append(letter);
                        break;
                }
            }
        }
        System.out.println(answer);
    }
    private static void handleNumber(String number, char currentSign) {
        int currentNumber = Integer.parseInt(number);
        if (currentSign == '+') {
            answer += currentNumber;
        } else if (currentSign == '-') {
            answer -= currentNumber;
        }
    }
}
