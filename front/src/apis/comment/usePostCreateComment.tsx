import { useMutation } from '@tanstack/react-query';
import { AxiosResponse } from 'axios';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

interface PostCreateCommentReq {
    board_id: number;
    parent_comment_id: number | null;
    content: string;
}
const postCreateComment = async (param: PostCreateCommentReq): Promise<AxiosResponse> => {
    return await api.post('/comment/create', param, {
        headers: {
            Authorization:
                'Bearer eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InRlc3QzQGRhdW0ubmV0Iiwicm9sZSI6IlJPTEVfQURNSU4iLCJpYXQiOjE3MzQ1MjU3OTAsImV4cCI6MTczNDg4NTc5MH0.fM5TdmAwLhgB_NUCeJbB69nYcAke9oKVLqWty-omP_4',
        },
    });
};

export const usePostCreateComment = () => {
    return useMutation({
        mutationKey: QUERY_KEYS.COMMENT.postCreateComment(),
        mutationFn: (param: PostCreateCommentReq) => postCreateComment(param),
    });
};
