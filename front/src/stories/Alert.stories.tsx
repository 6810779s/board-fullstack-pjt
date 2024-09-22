import React from 'react';

import { Button, Dialog, Stack } from '@mui/material';
import { Meta, StoryFn } from '@storybook/react';

import Alert, { AlertProps } from '@/components/Alert';

const meta = {
    title: 'Example/Alert',
    component: Dialog,
    parameters: { backgrounds: { default: 'dark' }, layout: 'centered' },
    tags: ['autodocs'],
    argTypes: {
        variant: {
            options: ['confirm', 'error'],
            control: {
                type: 'select',
            },
        },
    },
    args: {},
} satisfies Meta<typeof Alert>;

export default meta;

type Story = StoryFn<typeof Alert>;
const Template = (props: AlertProps) => {
    const [open, setOpen] = React.useState<boolean>(false);

    return (
        <Stack>
            <Button onClick={() => setOpen(true)}>클릭</Button>
            <Alert
                {...props}
                open={open}
                onClose={() => setOpen(false)}
                onConfirm={() => {
                    console.log('확인을 눌렀어요!');
                    setOpen(false);
                }}
            />
        </Stack>
    );
};

export const ConfirmDialog: Story = Template.bind({});
export const ErrorDialog: Story = Template.bind({});

ConfirmDialog.args = {
    variant: 'confirm',
    title: 'title',
    content: 'content',
};
ErrorDialog.args = {
    variant: 'error',
    title: 'title',
    content: 'content',
};
