import React from 'react';

import { Stack } from '@mui/material';

interface TabPanelProps {
    children: React.ReactNode;
    value: number;
    index: number;
}
export const TabPanel: React.FC<TabPanelProps> = ({ children, value, index }) => {
    return (
        <Stack
            role="tabpanel"
            hidden={value !== index}
            id={`full-width-tabpanel-${index}`}
            aria-labelledby={`full-width-tab-${index}`}
        >
            {value === index && <Stack sx={{ padding: '27px 0px' }}>{children}</Stack>}
        </Stack>
    );
};
