import { Meta, StoryObj } from '@storybook/react';

import { Tag } from '@/components/Tag';

const meta = {
    title: 'Example/Tag',
    component: Tag,
    parameters: { layout: 'centered' },
    tags: ['autodocs'],
    argTypes: {},
    args: {},
} satisfies Meta<typeof Tag>;

export default meta;

type Story = StoryObj<typeof meta>;

export const SimpleTag: Story = {
    args: {
        label: 'simpleTag',
    },
};
export const TagWithDeleteBtn: Story = {
    args: {
        label: 'tagWithDeleteBtn',
        onDelete: () => console.log('delete'),
    },
};
