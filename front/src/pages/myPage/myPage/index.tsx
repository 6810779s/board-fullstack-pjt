import { Outlet } from 'react-router-dom';

import { Stack } from '@mui/material';

import { PageLayout } from '@/components/PageLayout';

export const MyPage = () => {
    return (
        <PageLayout alignItems="center">
            <Stack flex={1} sx={{ width: '770px' }}>
                <Outlet />
            </Stack>
        </PageLayout>
    );
};
