import React from 'react';

import { Stack, Typography } from '@mui/material';

interface IconWithTextProps {
    icon: React.ReactNode;
    content: string;
}
export const IconWithText: React.FC<IconWithTextProps> = ({ icon, content }) => {
    return (
        <Stack direction="row" alignItems="center" gap="10px">
            {icon}
            <Typography>{content}</Typography>
        </Stack>
    );
};
