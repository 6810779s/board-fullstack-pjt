import React from 'react';

import { Stack, Typography } from '@mui/material';
import { ArrowCircleLeft, ArrowCircleRight } from '@phosphor-icons/react';

import { palette } from '@/themes';

interface OtherBoardsProps {
    type: 'prev' | 'next';
    title: string;
}
export const OtherBoards: React.FC<OtherBoardsProps> = ({ type, title }) => {
    return (
        <Stack
            direction="row"
            flex={1}
            alignItems="center"
            gap="10px"
            sx={{
                height: '64px',
                padding: '0 15px',
                cursor: 'pointer',
                background: palette.grey[100],
                justifyContent: type === 'prev' ? 'start' : 'end',
            }}
        >
            {type === 'prev' && <ArrowCircleLeft size={32} color={palette.common.black} />}
            <Stack justifyContent={'space-between'}>
                <Typography
                    color={palette.grey[500]}
                    sx={{ fontSize: '12px', textAlign: type === 'prev' ? 'left' : 'right' }}
                >
                    {type === 'prev' ? '이전 게시물' : '다음 게시물'}
                </Typography>
                <Typography sx={{ fontWeight: 700 }}>{title}</Typography>
            </Stack>
            {type === 'next' && <ArrowCircleRight size={32} color={palette.common.black} />}
        </Stack>
    );
};
