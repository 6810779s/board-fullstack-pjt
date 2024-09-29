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

export interface TBoardDetailDummyData {
    category: string;
    title: string;
    member: { total: number; participants: number };
    content: string;
    createdAt: string;
    writer: {
        nickname: string;
        tags: string[];
        message: string;
        friend: false;
    };
    prevBoard: {
        title: string;
    };
    nextBoard: {
        title: string;
    };
    comment: {
        commentCnt: number;
        commentsArr: CommentProps[];
    };
}

export const boardDetailDummyData: TBoardDetailDummyData = {
    category: 'category',
    title: '[Title입니다] 프로젝트에 대한 제목을 써보겠습니다',
    member: { total: 6, participants: 3 },
    createdAt: '2024.09.25 17:35',
    content: '컨텐트 입니데이~',
    writer: {
        nickname: 'eun',
        tags: ['Frontend Developer', 'Backend Developer'],
        message: '풀스택 개발자 입니다. 디자이너 구합니다.',
        friend: false,
    },
    prevBoard: {
        title: 'Prev board Title',
    },
    nextBoard: {
        title: 'Next Board Title',
    },
    comment: {
        commentCnt: 2,
        commentsArr: [
            {
                id: 0,
                nickname: 'eun1',
                content: '이것에 대한 댓글',
                createdAt: '2024.09.10 13:09',
                like: 6,
                replyComment: {
                    replyCommentCnt: 2,
                    replyCommentArr: [
                        {
                            id: 100,
                            createdAt: '2024.02.12 14:09',
                            nickname: 'eun1-1',
                            content: '댓글에 대한 답글1',
                        },
                        {
                            id: 101,
                            createdAt: '2024.02.12 14:29',
                            nickname: 'eun1-1',
                            content: '댓글에 대한 답글2',
                        },
                    ],
                },
            },
            {
                id: 1,
                nickname: 'eun123',
                content: '이것에 대한 댓글33',
                createdAt: '2024.09.10 13:09',
                like: 100,
                replyComment: {
                    replyCommentCnt: 1,
                    replyCommentArr: [
                        {
                            id: 101,
                            createdAt: '2024.02.12 14:29',
                            nickname: 'eun1-1',
                            content: '댓글에 대한 답글2',
                        },
                    ],
                },
            },
        ],
    },
};

export interface CommentProps {
    id: number;
    nickname: string;
    content: string;
    replyComment: {
        replyCommentCnt: number;
        replyCommentArr: {
            id: number;
            createdAt: string;
            nickname: string;
            content: string;
        }[];
    };
    like: number;
    createdAt: string;
}

export const projectReview = [
    {
        imgSrc: '/src/assets/book_img.svg',
        title: '자바 실시간 채팅 프로그램',
        starCnt: 3,
        member: 3,
        startDate: '2024.05.02',
        endDate: '2024.06.07',
        commentCnt: 5,
        hashTags: ['JAVA', 'Spring', 'React'],
    },
    {
        imgSrc: '/src/assets/code_img.svg',
        title: '자바 실시간 채팅 프로그램',
        starCnt: 3,
        member: 3,
        startDate: '2024.05.02',
        endDate: '2024.06.07',
        commentCnt: 5,
        hashTags: ['JAVA', 'Spring', 'React'],
    },
    {
        imgSrc: '/src/assets/code2_img.svg',
        title: '자바 실시간 채팅 프로그램',
        starCnt: 3,
        member: 3,
        startDate: '2024.05.02',
        endDate: '2024.06.07',
        commentCnt: 5,
        hashTags: ['JAVA', 'Spring', 'React'],
    },
    {
        imgSrc: '/src/assets/computer_img.svg',
        title: '자바 실시간 채팅 프로그램',
        starCnt: 3,
        member: 3,
        startDate: '2024.05.02',
        endDate: '2024.06.07',
        commentCnt: 5,
        hashTags: ['JAVA', 'Spring', 'React'],
    },
];
