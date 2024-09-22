import React from 'react';

import { Tab, Tabs, TabsProps } from '@mui/material';
import { Meta, StoryFn } from '@storybook/react';

import { palette } from '@/themes';

const meta = {
    title: 'Example/Tabs',
    component: Tabs,
    parameters: {
        backgrounds: { values: [{ name: 'dark', value: palette.grey[500] }], default: 'dark' },
        layout: 'centered',
    },
    tags: ['autodocs'],
    argTypes: {},
    args: {},
} satisfies Meta<typeof Tabs>;

export default meta;

type Story = StoryFn<TabsProps>;

const Template = (props: TabsProps) => {
    const [value, setValue] = React.useState<0 | 1 | 2>(0);
    return (
        <Tabs {...props} value={value} onChange={(_e, newValue) => setValue(newValue)}>
            <Tab label="Tab1" value={0} />
            <Tab label="Tab2" value={1} />
            <Tab label="Tab3" value={2} />
        </Tabs>
    );
};
export const SimpleTabs: Story = Template.bind({});
