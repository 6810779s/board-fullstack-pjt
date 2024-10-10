import { Box, Rating, Stack, Typography } from '@mui/material';

import { palette } from '@/themes';

export const FeedbackForm = () => {
    return (
        <Stack gap="16px" sx={{ p: '16px', borderBottom: `1px solid ${palette.grey[200]}` }}>
            <Stack direction="row">
                <Box
                    sx={{
                        background: palette.grey[200],
                        width: '32px',
                        height: '32px',
                        borderRadius: '50%',
                    }}
                />
                <Typography sx={{ ml: '8px', flex: 1 }}>프론트 주니어</Typography>
                <Rating readOnly value={3} size="small" />
            </Stack>
            <Stack flex={1} direction={'row'}>
                <Typography>
                    백엔드와 프론트엔드 기술력이 매우 뛰어나시고 풀스택 개발자로서의 자질이
                    훌륭합니다. 백엔드와 프론트엔드 기술력이 매우 뛰어나시고 풀스택 개발자로서의
                    자질이 훌륭합니다. 백엔드와 프론트엔드 기술력이 매우 뛰어나시고 풀스택
                    개발자로서의 자질이 훌륭합니다.
                </Typography>
            </Stack>
            <Typography flex={1} sx={{ textAlign: 'right', color: palette.grey[500] }}>
                2024-09-01
            </Typography>
        </Stack>
    );
};
