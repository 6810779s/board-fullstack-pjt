## start

1. project clone

   ```
   $ git clone https://github.com/6810779s/board-fullstack-pjt.git
   $ cd front
   or
   $ cd back
   ```

2. 실행
   ```
   $ npm i
   $ npm start
   ```

## branch policy

### branch name

- \`${name}/${level}/${role}/${keyword}\`

### examples

- ex) jeh/f/front/cart
- ex) jeh/config/back/docker-file

#### name

- ex) 장은희 → jeh

#### level

| branch level | description                       |
| ------------ | --------------------------------- |
| add (a)      | 패키지 추가                       |
| config       | config 파일 수정                  |
| chore        | 기능에 영향을 주지 않는 파일 수정 |
| docs (d)     | 문서 작성/수정                    |
| feat (f)     | 새로운 기능 추가                  |
| bugfix (b)   | 버그 수정                         |
| refactor (r) | 코드 리팩터링                     |
| style (s)    | CSS 코드 수정                     |

#### keyword

- kebab-case

## commit policy

### commit name

- \`[${level}] ${description}\`

### examples

- ex) [doc] README.md 작성
- ex) [feat] 공통 SNB 구현

#### level

| commit level | description                       |
| ------------ | --------------------------------- |
| add          | 패키지 추가                       |
| config       | config 파일 수정                  |
| chore        | 기능에 영향을 주지 않는 파일 수정 |
| docs         | 문서 작성/수정                    |
| feat         | 새로운 기능 추가                  |
| bugfix       | 버그 수정                         |
| refactor     | 코드 리팩터링                     |
| style        | CSS 코드 수정                     |

## comment policy

### comment

- \`${level}: ${description} ${date} ${name}\`

### examples

- ex) // TODO: 장바구니 조회 API 연동 2023.08.09 kbc
- ex) // FIXME: 주문 생성 API가 2번 호출되는 문제 2023.08.09 kbc

#### level

| comment level | description                                                           |
| ------------- | --------------------------------------------------------------------- |
| TODO          | 아직 해결하지 않은, 앞으로 추가해야 할 내용을 기술함.                 |
| HACK          | 임시로 문제를 해결한 코드. 왜 이렇게 해결했는지에 대한 정보 있어야함. |
| FIXME         | 오작동을 일으킨다고 알려진 코드. 당장 수정할 필요 없음.               |
| XXX           | 당장 수정이 필요한 코드.                                              |
