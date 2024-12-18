export const QUERY_KEYS = {
    ALL: ['board-fullstack-pjt'],
    TEST: {
        test: () => ['test'],
    },
    HOME: {
        getBoard: (param: string) => ['home', param],
    },
    BOARD: {
        all: () => [...QUERY_KEYS.ALL, 'board'],
        getBoardPagination: (param: string) => [...QUERY_KEYS.BOARD.all(), 'pagination', param],
        getBoardDetail: (param: string) => [...QUERY_KEYS.BOARD.all(), 'detail', param],
    },
    COMMENT: {
        all: () => [...QUERY_KEYS.ALL, 'comment'],
        getComment: (param: string) => [...QUERY_KEYS.COMMENT.all(), 'comment', param],
        getReplyComment: (param: string) => [...QUERY_KEYS.COMMENT.all(), 'replyComment', param],
        postCreateComment: () => [...QUERY_KEYS.COMMENT.all(), 'createComment'],
    },
};
