# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

기능 요구사항 
- [ ] 참여할 사람의 이름을 입력받는다.
- [ ] 최대 사다리 높이를 입력받는다. 
- [ ] 각 높이별 사다리 라인은 연속으로 이어지지만 않는 조건만 충족하면 어떻게 연결되든 상관없다.
- [x] 입력으로 들어온 사람과 높이를 기반으로 Ladder 객체를 생성한다. 
- [x] 입력으로 들어온 높이를 기반으로 Line 객체를 생성한다. 
- [x] 각 Line 은 높이와 사용자(owner) 를 가진다. 
- [ ] 각 Line 의 높이별로 다른 Line 과 연결할 선을 가질 수 있다. 
- [ ] 사다리를 출력한다.

도메인 규칙 요구사항 
- [x] 사람의 이름은 5글자까지만 가능하다. 