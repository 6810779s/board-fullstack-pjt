import { useQuery } from '@tanstack/react-query';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

interface GetReplyCommentRes {
    comment_id: string;
    content: string;
    nickname: string;
    created_at: string;
    updated_at: string;
    like_cnt: number;
}

const getReplyComment = async (param: number): Promise<GetReplyCommentRes[]> => {
    return await api.get(`/comment/reply_comment/${param}`).then((res) => {
        if (res?.data?.status === 'SUCCESS') {
            return res.data.body;
        }
        throw new Error('대댓글을 불러오는데 오류가 발생했습니다.');
    });
};

export const useGetReplyComment = (param: number) => {
    return useQuery({
        queryKey: QUERY_KEYS.COMMENT.getReplyComment(JSON.stringify(param)),
        queryFn: () => getReplyComment(param),
    });
};
