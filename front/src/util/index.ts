import { formatDistance } from 'date-fns';
import { ko } from 'date-fns/locale';

export const calcTime = (createdAt: string) => {
    return formatDistance(new Date(createdAt), new Date(), {
        includeSeconds: true,
        addSuffix: true,
        locale: ko,
    });
};
