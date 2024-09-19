import React from 'react';

import { CssBaseline, ThemeProvider } from '@mui/material';
import type { Preview } from '@storybook/react';

import { theme } from '../src/themes/index.ts';

const preview: Preview = {
    parameters: {
        controls: {
            matchers: {
                color: /(background|color)$/i,
                date: /Date$/i,
            },
        },
    },
    decorators: [
        (Story) => (
            <ThemeProvider theme={theme}>
                <CssBaseline>
                    <Story />
                </CssBaseline>
            </ThemeProvider>
        ),
    ],
};

export default preview;
