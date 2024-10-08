import React from 'react';

import { Rating, Stack, TextField, Typography } from '@mui/material';

export const UserFeedback = () => {
    const [rating, setRating] = React.useState<number | null>(0);
    return (
        <Stack gap="27px">
            <Stack>
                <Typography variant="main/small">별점</Typography>
                <Rating value={rating} onChange={(_, value) => setRating(value)} />
            </Stack>
            <Stack>
                <Typography variant="main/small">프로젝트 설명</Typography>
                <TextField
                    multiline={true}
                    rows={5}
                    placeholder="프로젝트에 대한 설명을 작성해 주세요."
                />
            </Stack>
        </Stack>
    );
};
