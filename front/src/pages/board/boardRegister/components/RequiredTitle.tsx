import React from 'react';

import { Stack, Typography } from '@mui/material';
import { DotOutline } from '@phosphor-icons/react';

import { palette } from '@/themes';

interface RequiredTitleProps {
    title: string;
    required: boolean;
}
export const RequiredTitle: React.FC<RequiredTitleProps> = ({ title, required }) => {
    return (
        <Stack
            direction="row"
            alignItems="center"
            alignSelf="flex-start"
            sx={{ minWidth: '86px', height: '40px' }}
        >
            <Typography sx={{ fontWeight: 600, fontSize: '14px' }}>{title}</Typography>
            {required && <DotOutline color={palette.error[500]} weight="fill" />}
        </Stack>
    );
};
