export interface TBoardListTopThreeDummyData {
    id: number;
    imgSrc: string;
    title: string;
    subTitle: string;
    member: {
        total: number;
        participants: number;
    };
    createdAt: string;
    commentCnt: number;
    like: number;
    content: string;
}
export const boardListTopThreeDummyData: TBoardListTopThreeDummyData[] = [
    {
        id: 0,
        imgSrc: '/src/assets/sky.svg',
        title: '브루마블 게임 프로젝트1',
        subTitle: '경력자 3명 있는 프로젝트, 함께하실 웹디자이너 구함',
        member: {
            total: 5,
            participants: 3,
        },
        createdAt: '2024.08.25 17:35',
        commentCnt: 5,
        like: 5,
        content:
            '게시판 프로젝트에서는 이런 저런 기능을 넣을 것이고, 토요일 일요일에 만나서 프로젝트를 하던지 말던지 할것인데요~이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.',
    },
    {
        id: 1,
        imgSrc: '/src/assets/computer_img.svg',
        title: '브루마블 게임 프로젝트2',
        subTitle: '경력자 3명 있는 프로젝트, 함께하실 웹디자이너 구함',
        member: {
            total: 5,
            participants: 3,
        },
        createdAt: '2024.08.25 17:35',
        commentCnt: 5,
        like: 5,
        content:
            '게시판 프로젝트에서는 이런 저런 기능을 넣을 것이고, 토요일 일요일에 만나서 프로젝트를 하던지 말던지 할것인데요~이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.이하 생략할게요.',
    },
    {
        id: 2,
        imgSrc: '/src/assets/teaAndComputer_img.svg',
        title: '브루마블 게임 프로젝트3',
        subTitle: '경력자 3명 있는 프로젝트, 함께하실 웹디자이너 구함',
        member: {
            total: 5,
            participants: 3,
        },
        createdAt: '2024.08.25 17:35',
        commentCnt: 5,
        like: 5,
        content:
            '게시판 프로젝트에서는 이런 저런 기능을 넣을 것이고, 토요일 일요일에 만나서 프로젝트를 하던지 말던지 할것인데요~',
    },
];
export interface TBoardListDummyData {
    id: number;
    category: string;
    like: number;
    title: string;
    member: {
        total: number;
        participants: number;
    };
    createdAt: string;
    commentCnt: number;
    content: string;
    projectName: string;
}
export const boardListDummyData: TBoardListDummyData[] = [
    {
        id: 0,
        category: '팀원 구함',
        like: 5,
        title: '함께하실 프론트엔드 개발자 구합니다',
        member: {
            total: 5,
            participants: 3,
        },
        createdAt: '2024.08.25 17:36',
        commentCnt: 5,
        content: 'JAVA Spring 잘 몰라~~ 같이 공부할 사람 구함~~~ ',
        projectName: '게시판 프로젝트',
    },
    {
        id: 1,
        category: '스터디원 구함',
        like: 5,
        title: '함께하실 프론트엔드 개발자 구합니다',
        member: {
            total: 5,
            participants: 3,
        },
        createdAt: '2024.08.25 17:36',
        commentCnt: 5,
        content: 'JAVA Spring 잘 몰라~~ 같이 공부할 사람 구함~~~ ',
        projectName: '게시판 프로젝트',
    },
    {
        id: 2,
        category: '팀원 구함',
        like: 5,
        title: '함께하실 프론트엔드 개발자 구합니다',
        member: {
            total: 5,
            participants: 3,
        },
        createdAt: '2024.08.25 17:36',
        commentCnt: 5,
        content: 'JAVA Spring 잘 몰라~~ 같이 공부할 사람 구함~~~ ',
        projectName: '게시판 프로젝트',
    },
];
