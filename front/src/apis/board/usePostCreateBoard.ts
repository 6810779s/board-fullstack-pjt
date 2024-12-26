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
    main_image_path: string;
    category_id: number;
}

const postCreateBoard = async (param: PostCreateBoardReq): Promise<AxiosResponse> => {
    return await api.post('/board/create', param);
};

export const usePostCreateBoard = () => {
    return useMutation({
        mutationKey: QUERY_KEYS.BOARD.postCreateBoard(),
        mutationFn: (param: PostCreateBoardReq) => postCreateBoard(param),
    });
};
