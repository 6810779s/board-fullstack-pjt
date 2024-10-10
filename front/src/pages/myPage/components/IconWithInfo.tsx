import React from 'react';

import { Stack, Typography } from '@mui/material';

import { palette } from '@/themes';

interface IconWithInfoProps {
    icon: React.ReactNode;
    content: string;
    num: number;
}
export const IconWithInfo: React.FC<IconWithInfoProps> = ({ icon, content, num }) => {
    return (
        <Stack justifyContent="center" alignItems="center" gap="5px">
            <Stack
                alignItems="center"
                justifyContent="center"
                sx={{
                    width: '150px',
                    height: '150px',
                    borderRadius: '50%',
                    background: palette.grey[100],
                }}
            >
                {icon}
            </Stack>
            <Typography sx={{ fontWeight: 700, fontSize: '20px' }}>
                {content}
                <Typography component="span" color={palette.error[500]}>
                    {` ${num}`}
                </Typography>
            </Typography>
        </Stack>
    );
};
