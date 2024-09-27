import { Stack, Typography } from '@mui/material';
import { Heart } from '@phosphor-icons/react';

import { palette } from '@/themes';

export const LikeButtonForBoard = () => {
    return (
        <Stack
            sx={{
                width: '90px',
                height: '164px',
                position: 'fixed',
                padding: '30px 10px',
                borderRadius: '50px',
                border: `1px solid ${palette.grey[200]}`,
                background: palette.grey[100],
                justifyContent: 'center',
                alignItems: 'center',
                transform: 'translateX(-50%)',

                left: { xs: '8%', lg: '16%', xl: '23%' },
            }}
            gap="10px"
        >
            <Stack
                sx={{
                    width: '70px',
                    height: '70px',
                    background: palette.common.white,
                    borderRadius: '50%',
                    border: `1px solid ${palette.grey[200]}`,
                    justifyContent: 'center',
                    alignItems: 'center',
                }}
            >
                <Heart color={palette.error[500]} weight="fill" size={30} />
            </Stack>
            <Typography sx={{ fontSize: '20px', fontWeight: 500 }}>25</Typography>
        </Stack>
    );
};
