# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 프로그래밍 요구사항
- Java 8의 스트림과 람다를 적용해 프로그래밍한다. 
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

## 기능 요구사항 
- Height 객체 
  - [x] 높이가 1보다 작을 경우 예외가 발생한다.
  - [x] 높이가 1 이상인 Height 객체를 생성할 수 있다.
- Player 객체 
  - [x] 사람의 이름은 5글자까지만 가능하다.
  - [x] 이름을 확인한다.
- Players 객체 
  - [x] 전체 플레이어의 인원을 구한다.
  - [x] 특정 플레이어에 대한 위치를 구한다.
- Line 객체 
  - [x] 높이를 기반으로 Line 객체를 생성할 수 있다.
  - [x] 이전 Line 객체의 동일 높이의 bridge 가 생성되었다면, 현재 Line 객체의 동일 높이 bridge 는 제거한다.
  - [x] 다리 (Bridge) 유무를 확인한다.
- Lines 객체 
  - [x] 갯수와 높이를 기반으로 Lines 객체를 생성한다.
  - [x] 입력으로 받은 높이에 다리 (Bridge) 가 있다면 이동한다.
- GameBoard 객체 
  - [x] 출력한다. 
  - [x] 특정 플레이어의 보상을 구한다.
  - [x] 최종 결과를 구한다.
- Bridge 객체 
  - [x] bridge 유무를 확인한다.
- Bridges 객체 
  - [x] 특정 높이에 다리 (Bridge) 를 생성한다.
  - [x] 특정 높이에 다리 (Bridge) 를 제거한다.
- Ladder 객체 
  - [x] 전체 플레이어 수와 높이를 입력받아 Ladder 객체를 생성한다.
  - [x] 시작 위치를 입력받아 끝 위치를 출력한다.