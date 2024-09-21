import React from 'react';

import { Pagination, PaginationProps } from '@mui/material';
import type { Meta, StoryFn } from '@storybook/react';

const meta = {
    title: 'Example/Pagination',
    component: Pagination,
    parameters: {
        layout: 'centered',
    },
    tags: ['autodocs'],
    argTypes: {},
    args: { count: 10 },
} satisfies Meta<typeof Pagination>;

export default meta;

type Story = StoryFn<typeof meta>;

const Template: StoryFn<PaginationProps> = (props) => {
    const [page, setPage] = React.useState<number>(1);
    return <Pagination page={page} onChange={(_e, page) => setPage(page)} {...props} />;
};

export const CommonPagination: Story = Template.bind({});
