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

---

## S4
- 2491
- 2578

## S5
- 2628
- 2635

## B1
- 2309
- 2563
- 2669
- 10163
- 14696

## B2
- 2605
- 10250
- 13300
