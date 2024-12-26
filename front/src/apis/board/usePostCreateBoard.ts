import { useMutation } from '@tanstack/react-query';
import { AxiosResponse } from 'axios';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

export interface PostCreateBoardReq {
    title: string;
    project_name: string;
    participant_limit: number;
    content: string;
    rating: number | null;
    category_id: number;
    thumbnail_file: File | null;
}

const postCreateBoard = async (param: FormData): Promise<AxiosResponse> => {
    return await api.post('/board/create', param, {
        headers: {
            'Content-Type': 'multipart/form-data',
        },
    });
};

export const usePostCreateBoard = () => {
    return useMutation({
        mutationKey: QUERY_KEYS.BOARD.postCreateBoard(),
        mutationFn: (param: FormData) => postCreateBoard(param),
    });
};
