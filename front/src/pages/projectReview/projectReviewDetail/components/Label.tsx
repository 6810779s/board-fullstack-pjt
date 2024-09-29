import React from 'react';

import { Stack, Typography } from '@mui/material';

interface LabelProps {
    title: string;
    children?: React.ReactNode;
}
export const Label: React.FC<LabelProps> = ({ children, title }) => {
    return (
        <Stack gap="4px">
            <Typography variant="main/small">{title}</Typography>
            {children}
        </Stack>
    );
};
