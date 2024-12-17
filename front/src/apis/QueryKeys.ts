export const QUERY_KEYS = {
    TEST: {
        test: () => ['test'],
    },
    HOME: {
        getBoard: (param: string) => ['home', param],
    },
};
