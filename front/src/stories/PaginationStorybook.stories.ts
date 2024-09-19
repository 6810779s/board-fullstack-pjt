import type { Meta, StoryFn } from '@storybook/react';

import { PaginationStorybook } from './PaginationStorybook';

const meta = {
    title: 'Example/Pagination',
    component: PaginationStorybook,
    parameters: {
        layout: 'centered',
    },
    tags: ['autodocs'],
    argTypes: {},
    args: {},
} satisfies Meta<typeof PaginationStorybook>;

export default meta;
type Story = StoryFn<typeof meta>;

export const CommonPagination: Story = PaginationStorybook.bind({});
