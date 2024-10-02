import React from 'react';

import { Stack } from '@mui/material';

import { IconWithText } from '@/components/IconWithText';
import { palette } from '@/themes';

interface TabPanelProps {
    children: React.ReactNode;
    value: number;
    index: number;
    icon: React.ReactNode;
    content: string;
}
export const TabPanel: React.FC<TabPanelProps> = ({ children, value, index, icon, content }) => {
    return (
        <Stack
            role="tabpanel"
            hidden={value !== index}
            id={`full-width-tabpanel-${index}`}
            aria-labelledby={`full-width-tab-${index}`}
        >
            {value === index && (
                <Stack>
                    <Stack
                        direction="row"
                        alignItems="center"
                        sx={{
                            padding: '10px 0',
                            borderBottom: `1px solid ${palette.common.black}`,
                        }}
                    >
                        <IconWithText
                            icon={icon}
                            content={content}
                            fontSize={16}
                            fontWeight={700}
                            color={palette.text.main}
                        />
                    </Stack>
                    <Stack sx={{ pt: '24px' }}>{children}</Stack>
                </Stack>
            )}
        </Stack>
    );
};
