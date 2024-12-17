import { useQuery } from '@tanstack/react-query';

import { QUERY_KEYS } from '@/apis/QueryKeys';
import { api } from '@/apis/axios';

interface GetBoardReq {
    limit: number;
}
interface GetBoardRes {
    board_id:number;
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
const getBoard = async (param: GetBoardReq): Promise<GetBoardRes[]> => {
    return await api
        .get('board/', {
            params: param,
        })
        .then((res) => {
            if (res?.data?.status === 'SUCCESS') {
                return res.data.body;
            }
            throw new Error('게시글을 불러오는데 오류가 발생했습니다.');
        });
};
export const useGetBoard = (param: GetBoardReq) => {
    return useQuery({
        queryKey: QUERY_KEYS.HOME.getBoard(JSON.stringify(param)),
        queryFn: () => getBoard(param),
    });
};
