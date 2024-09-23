import { IconButton, TextField } from '@mui/material';
import { CalendarBlank } from '@phosphor-icons/react';
import { Meta, StoryObj } from '@storybook/react';

const meta = {
    title: 'Example/Textfield',
    component: TextField,
    parameters: { layout: 'centered' },
    tags: ['autodocs'],
    argTypes: {
        variant: {
            options: ['filled', 'standard', 'outlined'],
            control: {
                type: 'select',
            },
        },
    },
    args: {
        placeholder: 'please write here..',
        variant: 'outlined',
    },
} satisfies Meta<typeof TextField>;

export default meta;

type Story = StoryObj<typeof meta>;
export const SimpleTextfield: Story = {
    args: {},
};
export const DisabledTextfield: Story = {
    args: { disabled: true, value: 'this is disabled area' },
};
export const EndAdornmentWithTextfield: Story = {
    args: {
        slotProps: {
            input: {
                endAdornment: (
                    <IconButton onClick={() => {}}>
                        <CalendarBlank size={'16px'} />
                    </IconButton>
                ),
            },
        },
    },
};
