import { Outlet } from 'react-router-dom';

import { Stack } from '@mui/material';

export const SnbLayout = () => {
    return (
        <Stack>
            Snb
            <Outlet />
        </Stack>
    );
};
