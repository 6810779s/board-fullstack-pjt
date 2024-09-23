import { Meta, StoryObj } from '@storybook/react';

import { TextfieldWithBtn } from '@/components/TextfieldBtn';

const meta = {
    title: 'Example/TextfieldWithBtn',
    component: TextfieldWithBtn,
    parameters: { layout: 'centered' },
    tags: ['autodocs'],
    argTypes: {
        variant: {
            options: ['outlined'],
            control: {
                type: 'select',
            },
        },
    },
    args: { variant: 'outlined', placeholder: 'please write here..' },
} satisfies Meta<typeof TextfieldWithBtn>;

export default meta;

type Story = StoryObj<typeof meta>;
export const SimpleTextfieldWithBtn: Story = {
    args: { onClick: () => console.log('클릭') },
};
