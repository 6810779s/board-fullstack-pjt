import { useLocation } from 'react-router-dom';

import { Stack } from '@mui/material';

import { PageLayout } from '@/components/PageLayout';

import { ActiveHistory } from './activeHistory';
import { FriendList } from './friendList';

export const MyPage = () => {
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const page = searchParams.get('page');
    return (
        <PageLayout alignItems="center">
            <Stack flex={1} sx={{ width: '770px' }}>
                {(page === null || page == 'active-history') && <ActiveHistory />}
                {page === 'friend-list' && <FriendList />}
            </Stack>
        </PageLayout>
    );
};
