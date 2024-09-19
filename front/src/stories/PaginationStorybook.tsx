import React from 'react';

import { Pagination, Stack } from '@mui/material';

import { palette } from '../themes/index.ts';

export const PaginationStorybook = () => {
    const [page, setPage] = React.useState<number>(1);
    return (
        <Stack>
            <Pagination
                sx={{ color: palette.error[600] }}
                count={10}
                page={page}
                onChange={(_e, page) => setPage(page)}
            />
        </Stack>
    );
};
