import React from 'react';

import { IconButton, Stack, Typography } from '@mui/material';
import { XCircle } from '@phosphor-icons/react';

import { palette } from '@/themes';

interface TagProps {
    onDelete?: () => void;
    label: string;
}
export const Tag: React.FC<TagProps> = ({ label, onDelete }) => {
    return (
        <Stack
            direction={'row'}
            alignItems={'center'}
            gap={'10px'}
            sx={{
                background: palette.grey[200],
                padding: '0px 6px',
                color: palette.text.main,
                borderRadius: '2px',
                border: `1px solid ${palette.grey[300]}`,
            }}
            onClick={onDelete ? onDelete : () => {}}
        >
            <Typography fontSize={'14px'}> {label}</Typography>
            {onDelete && (
                <IconButton>
                    <XCircle weight="fill" color={palette.grey[500]} height={'100%'} />
                </IconButton>
            )}
        </Stack>
    );
};
