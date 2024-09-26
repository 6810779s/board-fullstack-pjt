import React from 'react';

import { Stack, StackProps } from '@mui/material';

import { Footer } from './Footer';
import { Header } from './header';
import { Profile } from './profile';

interface PageLayoutProps extends StackProps {
    paddingSide?: number;
}
export const PageLayout: React.FC<PageLayoutProps> = ({
    children,
    paddingSide = 170,
    ...props
}) => {
    return (
        <Stack sx={{ height: '100vh', width: '100vw', overflow: 'scroll' }}>
            <Header />
            <Profile />
            <Stack flex={1} sx={{ padding: `${60}px ${paddingSide}px` }} {...props}>
                {children}
            </Stack>
            <Footer />
        </Stack>
    );
};
