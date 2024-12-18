import { useQuery } from '@tanstack/react-query';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

interface GetCommentRes {
    comment_id: string;
    content: string;
    nickname: string;
    created_at: string;
    comment_reply_cnt: number;
    like_cnt: number;
}

const getComment = async (param: number): Promise<GetCommentRes[]> => {
    return await api.get(`/comment/board/${param}`).then((res) => {
        if (res?.data?.status === 'SUCCESS') {
            return res.data.body;
        }
        throw new Error('댓글을 불러오는데 오류가 발생했습니다.');
    });
};

export const useGetComment = (param: number) => {
    return useQuery({
        queryKey: QUERY_KEYS.COMMENT.getComment(JSON.stringify(param)),
        queryFn: () => getComment(param),
    });
};
