import React from 'react';

import { Stack, StackProps } from '@mui/material';

import { Footer } from './Footer';
import { Header } from './header';
import { Profile } from './profile';

interface PageLayoutProps extends StackProps {}
export const PageLayout: React.FC<PageLayoutProps> = ({ children, ...props }) => {
    return (
        <Stack sx={{ height: '100vh', width: '100vw' }} {...props}>
            <Header />
            <Profile />
            <Stack flex={1} sx={{ height: '100%', overflow: 'scroll' }}>
                {children}
            </Stack>
            <Footer />
        </Stack>
    );
};
