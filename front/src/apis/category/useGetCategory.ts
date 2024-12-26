import { useQuery } from '@tanstack/react-query';

import { QUERY_KEYS } from '../QueryKeys';
import { api } from '../axios';

interface GetCategoryRes {
    category_id: number;
    name: string;
}
const getCategory = async (): Promise<GetCategoryRes[]> => {
    console.log('cookie', document.cookie);
    return await api.get('/category/').then((res) => {
        if (res?.data?.status === 'SUCCESS') {
            return res.data.body;
        }
        throw new Error('카테고리 불러오는데 에러가 발생했습니다.');
    });
};

export const useGetCategory = () => {
    return useQuery({
        queryKey: QUERY_KEYS.CATEGORY.getCategory(),
        queryFn: () => getCategory(),
    });
};
