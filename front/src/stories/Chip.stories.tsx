import { Chip } from '@mui/material';
import { Meta, StoryObj } from '@storybook/react';

const meta = {
    title: 'Example/Chip',
    component: Chip,
    parameters: { layout: 'centered' },
    tags: ['autodocs'],
    argTypes: {},
    args: {},
} satisfies Meta<typeof Chip>;

export default meta;

type Story = StoryObj<typeof meta>;

export const SimpleChip: Story = {
    args: {
        label: 'simple chip',
    },
};
export const ChipWithButton: Story = {
    args: {
        label: 'chip with button',
        onDelete: () => console.log('delete'),
    },
};
