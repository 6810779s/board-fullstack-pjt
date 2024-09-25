import React from 'react';

import { Stack, Typography, styled } from '@mui/material';

import { palette } from '@/themes';

interface IconWithTextProps {
    icon: React.ReactNode;
    content: string;
}
export const TypographyStyle = styled(Typography)({
    color: palette.grey[500],
    fontSize: '14px',
});
export const IconWithText: React.FC<IconWithTextProps> = ({ icon, content }) => {
    return (
        <Stack direction="row" alignItems="center" gap="5px">
            {icon}
            <TypographyStyle color={palette.grey[500]}>{content}</TypographyStyle>
        </Stack>
    );
};
