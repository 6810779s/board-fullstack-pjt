import React from 'react';

import { Stack, Typography } from '@mui/material';

import { palette } from '@/themes';

interface IconWithTextProps {
    icon: React.ReactNode;
    content: string;
    fontSize?: number;
    color?: string;
    gap?: number;
    fontWeight?: number;
}

export const IconWithText: React.FC<IconWithTextProps> = ({
    icon,
    content,
    fontSize = 14,
    color = palette.grey[500],
    gap = 5,
    fontWeight,
}) => {
    return (
        <Stack direction="row" alignItems="center" gap={`${gap}px`}>
            {icon}
            <Typography
                sx={{
                    color,
                    fontSize: `${fontSize}px`,
                    fontWeight: fontWeight ? fontWeight : 'normal',
                }}
            >
                {content}
            </Typography>
        </Stack>
    );
};
