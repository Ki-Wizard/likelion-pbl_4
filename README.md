# Mission 04 - Java Collections & 설계 확장

작성자: 김민수

## 과제 소개

Java 컬렉션 프레임워크의 `List`, `Map`, 제네릭을 활용하여 멋쟁이사자처럼 멤버를 등록, 조회, 검색, 파트별로 분류하는 콘솔 기반 관리 프로그램입니다.

## 구현 기능

- 배열 대신 `ArrayList<Role>`로 멤버 관리
- `Map<String, List<Role>>`로 파트별 멤버 그룹화
- `List<Role>` 형태의 제네릭 사용
- 멤버 등록 시 이름 중복 확인
- 전체 멤버 조회
- 이름으로 멤버 검색
- 등록된 파트 목록 조회
- 파트별 멤버 필터링

## 패키지 구조

```text
src/class4
├── package1
│   └── Main.java
├── package2
│   └── Main.java
├── policy
│   ├── LionSubmissionPolicy.java
│   ├── StaffSubmissionPolicy.java
│   └── SubmissionPolicy.java
└── role
    ├── Lion.java
    ├── Role.java
    └── Staff.java
```

## 실행 방법

### 컴파일

```bash
javac -encoding UTF-8 -Xlint:unchecked -d out src/class4/policy/*.java src/class4/role/*.java src/class4/package1/*.java src/class4/package2/*.java
```

### Step 1 실행

```bash
java -cp out class4.package1.Main
```

### Step 2 실행

```bash
java -cp out class4.package2.Main
```

## 체크리스트

- [x] 배열 대신 `ArrayList`로 멤버 관리
- [x] `Map`을 사용하여 파트별 멤버 그룹화
- [x] 제네릭(`List<Role>`, `Map<String, List<Role>>`) 사용
- [x] 멤버 등록 시 중복 확인
- [x] 이름으로 멤버 검색
- [x] 파트별 멤버 필터링
- [x] README.md에 작성자 이름 포함
