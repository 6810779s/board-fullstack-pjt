import { useQuery } from '@tanstack/react-query';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

interface TBoardInfo {
    board_id: number;
    title: string;
}
interface GetBoardDetailRes {
    project_name: string;
    title: string;
    content: string;
    category: {
        category_id: number;
        name: string;
    };
    rating: number;
    main_image_path: string;
    prevBoard: null | TBoardInfo;
    nextBoard: null | TBoardInfo;
    created_by: string;
    created_at: string;
    participant_cnt: number;
    participant_limit: number;
    like_cnt: number;
    comment_cnt: number;
    // like cnt, participant_cnt, participant_limit,
}

const getBoardDetail = async (param: number): Promise<GetBoardDetailRes> => {
    return await api.get(`board/${param}`).then((res) => {
        if (res?.data?.status === 'SUCCESS') {
            return res.data.body;
        }
        throw new Error('게시글 상세페이지를 불러오는데 오류가 발생했습니다.');
    });
};

export const useGetBoardDetail = (param: number) => {
    return useQuery({
        queryKey: QUERY_KEYS.BOARD.getBoardDetail(JSON.stringify(param)),
        queryFn: () => getBoardDetail(param),
    });
};
