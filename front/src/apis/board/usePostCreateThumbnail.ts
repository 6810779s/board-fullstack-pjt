import { useMutation } from '@tanstack/react-query';
import axios, { AxiosResponse } from 'axios';

import { QUERY_KEYS } from '../QueryKeys';

interface PostCreateThumbnailReq {
    file: File;
}

const postCreateThumbnail = async (param: PostCreateThumbnailReq): Promise<AxiosResponse> => {
    return await axios.post('/thumbnail/create', param, {
        headers: {
            'Content-Type': 'multipart/form-data',
        },
    });
};

export const usePostCreateThumbnail = () => {
    return useMutation({
        mutationKey: QUERY_KEYS.BOARD.postThumbnail(),
        mutationFn: (param: PostCreateThumbnailReq) => postCreateThumbnail(param),
    });
};
