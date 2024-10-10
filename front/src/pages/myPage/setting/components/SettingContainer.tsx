import React from 'react';

import { Stack, Typography } from '@mui/material';

interface SettingContainerProps {
    title: string;
    children: React.ReactNode;
    childrenGap?: number;
}
export const SettingContainer: React.FC<SettingContainerProps> = ({
    title,
    children,
    childrenGap = 0,
}) => {
    return (
        <Stack direction="row" gap="70px">
            <Stack sx={{ width: '120px' }}>
                <Typography variant="main/small" sx={{ fontWeight: 700 }}>
                    {title}
                </Typography>
            </Stack>
            <Stack flex={1} gap={`${childrenGap}px`}>
                {children}
            </Stack>
        </Stack>
    );
};
