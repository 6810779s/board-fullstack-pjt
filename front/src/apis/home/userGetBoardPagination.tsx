import { useQuery } from '@tanstack/react-query';

import { TPagination } from '@/types/pagination';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

interface GetBoardPaginationReq {
    page: number;
    pageSize: number;
}

interface GetBoardPaginationRes {
    board_id: number;
    title: string;
    category_name: string;
    project_name: string;
    content: string;
    participant_cnt: number;
    participant_limit: number;
    created_at: string;
    like_cnt: number;
    comment_cnt: number;
    main_image_path: string;
}
const getBoardPagination = async (
    param: GetBoardPaginationReq
): Promise<TPagination<GetBoardPaginationRes>> => {
    return await api
        .get('board/pagination', {
            params: param,
        })
        .then((res) => {
            if (res?.data?.status === 'SUCCESS') {
                return res.data.body;
            }
            throw new Error('게시글을 불러오는데 오류가 발생했습니다.');
        });
};

export const useGetBoardPagination = (param: GetBoardPaginationReq) => {
    return useQuery({
        queryKey: QUERY_KEYS.BOARD.getBoardPagination(JSON.stringify(param)),
        queryFn: () => getBoardPagination(param),
    });
};
