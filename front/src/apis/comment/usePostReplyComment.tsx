import { useMutation } from '@tanstack/react-query';
import { AxiosResponse } from 'axios';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

const postReplyComment = async (parent_comment_id: number): Promise<AxiosResponse> => {
    return await api.post(`/comment/reply_comment/${parent_comment_id}`, {
        headers: {
            Authorization: '',
        },
    });
};

export const usePostReplyComment = () => {
    return useMutation({
        mutationKey: QUERY_KEYS.COMMENT.postCreateReplyComment(),
        mutationFn: (parent_comment_id: number) => postReplyComment(parent_comment_id),
    });
};
