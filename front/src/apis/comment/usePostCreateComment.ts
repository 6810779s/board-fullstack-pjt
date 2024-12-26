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
    return await api.post('/comment/create', param);
};

export const usePostCreateComment = () => {
    return useMutation({
        mutationKey: QUERY_KEYS.COMMENT.postCreateComment(),
        mutationFn: (param: PostCreateCommentReq) => postCreateComment(param),
    });
};
