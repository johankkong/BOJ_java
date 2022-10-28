# BOJ_java
백준 온라인 저지 문제풀이입니다.

현재 페이지에선
- 전반적으로 알아두면 좋을 것
- 해결한 문제번호

를 적어두겠습니다. 

문제별 자세한 풀이방법은 각 난이도별 README를 참고해주세요.

---

## 알아두면 좋을 것

ArrayList에서 `add()`메소드는 요소를 오른쪽에 추가하게 되고, `add(intdex, data)`를 통해 원하는 위치에 요소를 추가할 수 있다.

List에서 두 개이상을 `remove`해야하는 경우, 작은 인덱스의 요소를 먼저 `remove`하면 더 큰 쪽의 인덱스가 줄어들기 때문에, 인덱스가 큰 쪽을 먼저 `remove`해야한다. 

`List`를 오름차순으로 정렬하고 싶다면, `Collections.sort(List이름)`을 사용한다.

BufferReader를 선언할 땐, `BufferedReader in = new BufferedReader(new InputStreamReader(System.in));`을 활용한다.

이와 더불어 `StringTokenizer st;` 도 선언하여 같이 사용한다.

String을 정수로 바꾸고 싶다면, `Integer.parseInt("1")`를 이용한다.

델타이동을 할 때엔, 경계선을 넘어가지 않는지 항상 확인해야한다.

델타이동을 순환적으로 할때엔 `d = ++d % 4;`와 같이 나머지 연산자를 이용할 수 있다.

A부터 B까지의 거리를 구할 땐, 거리를 구하기 쉬운 기준점을 잡아 A와 B까지의 거리를 구해 그 차이를 구하면 된다.

`comparator`를사용시, 두가지 조건을 동시에 적용하고 싶다면 첫번째 조건에 속하는 경우를 조건문으로 먼저 정의하고, 다음 `else` 문을 통해 두번째 조건을 `return` 해주면 된다.

Bottom-up 방식의 DP : 배열을 만들어 각 진행상황의 결과를 기록해가며, 상위 결과를 도출해내는 방식

LinkedList를 구현할 때 Node클래스를 같이 선언을 해주어야한다.

Bottom Up 방식의 DP를 이용할 때, 현재 칸과 그 이전칸의 관계를 잘 파악하는 것이 중요하다.

Queue를 사용하고 싶다면, `Queue<Integer> queue = new LinkedList<>();`를 통해 선언하여 사용한다.

연속적으로 출력을 해야하는 경우, 시간 초과가 난다면 `StringBuilder`를 이용하여 한번에 출력해보자

원하는 길이 만큼만 문자열을 뒤집고 싶다면 stack을 이용해보자.

dp를 사용함에 있어서, 주의할 점
 - 무조건적으로 dp배열을 채우기 위해 바깥쪽 for문을 사용하기 보다, 여러 조건으로 dp배열을 여러번 채워야하는 경우가 있음에 주의하자.
 - 무조건적으로 dp배열을 앞에서부터 채우기 보다, 현재 시행이 중복으로 사용되는 것을 방지하고 싶다면 뒤쪽부터 채우는 것을 생각해보자. 

재귀함수를 이용하여 문제를 풀이할 때, 좌표를 저장할 일이 있다면, row와 col 혹은 x와 y 값을 가지는 클래스를 선언하여 풀이하는 것도 가능하다.

list.stream().distinct() 메소드를 통해 list에서 중복을 제거한다.

stream().forEach(System.out::println) 으로 출력이 가능하다.

int자료형을 이용하여 평균을 구할 떄, 그 합이 int자료형을 벗어나면, 오버플로우가 발생하여 나눈다고 할 지라도 정상적인 값이 나오지 않는다. 따라서, 각 요소의 자료형을 long으로 하여 구해주어야한다.

백트래킹 기법을 사용할 때, 해당 칸이 모든 경우에 대해서 유효하지 않을 때, 그 칸을 다시 원래 상태로 되돌려 놓는 것이 중요하다.

bfs 기법을 사용할 때, 아예 시작점을 모두 queue에 넣어 놓고 시작하는 것이 편리하다.

PriorityQueue 혹은 빠른 조회가 필요한 경우에는 TreeMap을 이용하면 유리할 수 있다.

중간값에 지속적으로 접근을 해야하는 경우, PriorityQueue 두 개를 이용하여, 하나는 역순으로 하면 중간값을 비교적 빠르게 접근할 수 있다. 

LCS는 DP를 통해서 구할 수 있다는 것을 알고 있어야한다.

BFS에서 위치별로 고려해야하는 경우의 수가 많을 경우, 그 경우의 수만큼 방문처리 배열을 만들어 줘야한다.

그래프 탐색시에, 탐색을 완료하고, 해당 정점에 도달할 수 없는 경우를 처리해주는 것을 잊지 말아야한다.

---

## G1
- 17472

## G2
- 1655
- 1918
- 12100
- 17143
- 19238

## G3
- 1600
- 2206
- 2655
- 16236
- 17135

## G4
- 1922
- 2116
- 2239
- 2580
- 3910
- 9663
- 9935
- 10282
- 14500
- 14502
- 16202
- 17069
- 17144
- 17281
- 17406
- 17471

## G5
- 1107
- 2096
- 2293
- 2294
- 5014
- 7576
- 7682
- 12865
- 14503
- 15686
- 16234
- 16927
- 17070
- 20055

## S1
- 1074
- 1149
- 1697
- 1743
- 1890
- 1991
- 2468
- 2527
- 2564
- 16926
- 16935 

## S2
- 1012
- 1654
- 1874
- 1912
- 1965
- 2075
- 2304
- 2615
- 2805
- 3987
- 4963
- 11053
- 11055
- 11084
- 14430
- 14889
- 18111
- 18353
- 23304

## S3
- 1003
- 1244
- 1463
- 2108
- 2477
- 2559
- 2579
- 9095
- 10972
- 11726
- 11727
- 14501
- 17413

## S4
- 1018
- 1158
- 1620
- 1764
- 2164
- 2491
- 2567
- 2578
- 10157
- 10158
- 10845
- 12789

## S5
- 1181
- 1436
- 1676
- 2628
- 2635

## B1
- 1157
- 1259
- 1546
- 2309
- 2563
- 2669
- 4344
- 10163
- 14696

## B2
- 1152
- 2292
- 2577
- 2605
- 2675
- 2798
- 2920
- 10250
- 13300

## B3
- 1085
- 2562
- 4153

## B4
- 2439
- 2741
- 2742

## B5
- 1001
- 1008
- 1330
- 2438
- 2475
- 2557
- 2739
- 10718
- 10809
- 10869
- 10872
- 10998
