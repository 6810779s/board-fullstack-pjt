import { useMutation } from '@tanstack/react-query';
import { AxiosResponse } from 'axios';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

interface PostLoginReq {
    email: string;
    password: string;
}
const postLogin = async (param: PostLoginReq): Promise<AxiosResponse> => {
    console.log({ param });
    return await api.post('/login', param);
};

export const usePostLogin = () => {
    return useMutation({
        mutationKey: QUERY_KEYS.USER.postLogin(),
        mutationFn: (param: PostLoginReq) => postLogin(param),
    });
};
