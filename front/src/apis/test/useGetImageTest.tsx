import { useQuery } from '@tanstack/react-query';

import { QUERY_KEYS } from '@apis/QueryKeys';
import { api } from '@apis/axios';

const getTest = async () => {
    return await api
        .get('profile-image/', {
            headers: {
                Authorization: `Bearer eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InRlc3QzQGRhdW0ubmV0Iiwicm9sZSI6IlJPTEVfQURNSU4iLCJpYXQiOjE3Mjk3NTE4MTAsImV4cCI6MTczMDExMTgxMH0.mvwVkGERyg9NcRJlJ9yYvEGIKKcwshk9BRX20NSQJoE`,
                // 'Content-Type': 'multipart/form-data',
            },
        })
        .then((res) => {
            if (res.data && res.data.body) {
                return res.data.body;
            }
            return null;
        });
};

export const useGetImageTest = () => {
    return useQuery({
        queryKey: QUERY_KEYS.TEST.test(),
        queryFn: () => getTest(),
    });
};
