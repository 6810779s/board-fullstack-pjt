import { Outlet } from 'react-router-dom';

import { Stack } from '@mui/material';

import { GNB } from '.';

export const GnbLayout = () => {
    return (
        <Stack width="100vw" height="100vh" overflow="hidden">
            <GNB />
            <Outlet />
        </Stack>
    );
};
