export interface TPagination<T> {
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
