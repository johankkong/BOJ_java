package G5._14891;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //톱니바퀴 클래스를 정의
    static class Gear {
        //각 톱니의 극을 표시할 배열
        boolean[] teeth;
        //9시 방향을 가르키는 인덱스
        int left;
        //3시 방향을 가르키는 인덱스
        int right;
        
        //문자열을 받아 Gear객체 생성하는 생성자
        public Gear(String info) {
            this.teeth = new boolean[8];
            for (int i = 0; i < 8; i++) {
                //false는 N극, true는 S극
                if(info.charAt(i) == '0') this.teeth[i] = false;
                else this.teeth[i] = true;
            }
            //초기 상태에서 right는 2, left는 6을 가르킨다.
            this.right = 2;
            this.left = 6;
        }

        //해당 Gear를 돌리는 메소드
        void turn(int direction) {
            //1인 경우 시계 방향
            if(direction == 1) {
                //right가 0이면 7로, 아니라면 1을 뺀다.
                this.right = this.right == 0 ? 7 : this.right - 1;
                //left가 0이면 7로, 아니라면 1을 뺀다.
                this.left = this.left == 0 ? 7 : this.left - 1;
            } else {
            //반시계방향
                //right가 7이면 0으로, 아니라면 1을 더한다.
                this.right = this.right == 7 ? 0 : this.right + 1;
                //left가 7이면 0로, 아니라면 1을 더한다.
                this.left = this.left == 7 ? 0 : this.left + 1;
            }
        }
    }
    public static void main(String[] args) {
        //스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        //gears 생성
        gears = new Gear[4];
        //문자열을 입력받아 gears에 저장
        for (int i = 0; i < 4; i++) {
            gears[i] = new Gear(sc.next());
        }
        //명령 횟수를 입력받는다.
        int numCom = sc.nextInt();
        //명령 횟수만큼 명령을 입력받아 시행한다.
        for (int i = 0; i < numCom; i++) {
            //처음에 돌려야하는 톱니바퀴 번호
            int firstGear = sc.nextInt() - 1;
            //돌리는 방향
            int direction= sc.nextInt();
            //돌려야하는 톱니바퀴 판단
            boolean[] mustTurn = new boolean[4];
            mustTurn[firstGear] = true;
            int temp = firstGear;
            while(isTurnLeft(temp)) {
                mustTurn[--temp] = true;
            }
            temp = firstGear;
            while(isTurnRight(temp)) {
                mustTurn[++temp] = true;
            }
            //돌려야하는 톱니바퀴를 돌린다.
            for (int j = 0; j < 4; j++) {
                if(mustTurn[j]) {
                    if((j - firstGear) % 2 == 0) gears[j].turn(direction);
                    else gears[j].turn(direction * -1);
                }
            }
        }
        //명령을 모두 수행했다면 12시 방향의 극을 읽어 점수를 합산한다.
        int point = 0;
        for (int i = 0; i < 4; i++) {
            Gear curr = gears[i];
            curr.turn(1);
            curr.turn(1);
            if(curr.teeth[curr.right]) {
                point += Math.pow(2, i);
            }
        }
        System.out.println(point);
    }
    //Gear 4개를 저장할 배열을 선언
    static Gear[] gears;
    //현재 상태에서 톱니바퀴를 돌렸을 때 옆 톱니도 함께 돌아가는지 판단
    static boolean isTurnLeft(int gearNum) {
        //가장 왼쪽이면 false
        if(gearNum == 0) return false;
        else {
            //현재 판단하는 gear
            Gear mid = gears[gearNum];
            //왼쪽 gear
            Gear left = gears[gearNum - 1];

            return mid.teeth[mid.left] != left.teeth[left.right];
        }
    }
    static boolean isTurnRight(int gearNum) {
        //가장 오른쪽이면 false
        if(gearNum == 3) return false;
        else {
            //현재 판단하는 gear
            Gear mid = gears[gearNum];
            //오른쪽 gear
            Gear right = gears[gearNum + 1];

            return mid.teeth[mid.right] != right.teeth[right.left];
        }
    }
}
