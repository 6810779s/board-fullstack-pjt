import { Stack, Typography } from '@mui/material';

import { palette } from '@/themes';

export const Footer = () => {
    return (
        <Stack
            justifyContent="center"
            alignItems="center"
            sx={{ height: '220px', background: palette.common.white }}
        >
            <Typography sx={{ fontSize: '20px', padding: '60px 170px' }}>
                © 2024 Eunhee’s PJT reviewer. All Rights Reserved.
            </Typography>
        </Stack>
    );
};
