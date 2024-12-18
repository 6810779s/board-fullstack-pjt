export interface TPaginationRes<T> {
    contents: T[];
    totalItems: number;
    totalPages: number;
    pageSize: number;
    page: number;
    numberOfElements: number;
    hasPrevious: boolean;
    hasNext: boolean;
    first: boolean;
    last: boolean;
}

export type TSearchType = 'ALL' | 'TITLE' | 'CONTENT' | 'SKILL' | 'PROJECT_NAME';
export interface TSearchFilter {
    searchType: TSearchType;
    keyword: string;
}
export interface TPaginationReq {
    page: number;
    pageSize: number;
    searchType: TSearchType;
    keyword: string;
}
