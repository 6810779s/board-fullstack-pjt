import React from 'react';

import { Stack, Typography } from '@mui/material';
import { Empty } from '@phosphor-icons/react';

import { palette } from '@/themes';

interface NoBoardProps {
    content: string;
}
export const NoBoard: React.FC<NoBoardProps> = ({ content }) => {
    return (
        <Stack flex={1} justifyContent="center" alignItems="center">
            <Empty size={80} weight="fill" color={palette.grey[500]} />
            <Typography sx={{ fontSize: '20px' }}>{content}</Typography>
        </Stack>
    );
};
