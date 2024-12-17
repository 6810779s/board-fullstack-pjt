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
    },
};
