import { useNavigate } from 'react-router-dom';

import { Rating, Stack, Typography } from '@mui/material';

import { palette } from '@/themes';

export const ProjectReviewForm = () => {
    const navigate = useNavigate();
    return (
        <Stack
            gap="16px"
            sx={{
                'p': '16px',
                'borderBottom': `1px solid ${palette.grey[200]}`,
                '&:hover': { cursor: 'pointer' },
            }}
            onClick={() => navigate('/project-review/1')}
        >
            <Stack direction="row">
                <Typography variant="main/small" sx={{ flex: 1 }}>
                    자바 채팅 프로그램
                </Typography>
                <Rating readOnly value={3} size="small" />
            </Stack>
            <Stack flex={1} direction={'row'}>
                <Typography>
                    {`백엔드와 프론트엔드 기술력이 매우 뛰어나시고 풀스택 개발자로서의 자질이
                    훌륭합니다. 백엔드와 프론트엔드 기술력이 매우 뛰어나시고 풀스택 개발자로서의
                    자질이 훌륭합니다. 백엔드와 프론트엔드 기술력이 매우 뛰어나시고 풀스택
                    개발자로서의 자질이 훌륭합니다.`.slice(0, 100) + '...'}
                </Typography>
            </Stack>
            <Stack flex={1} direction="row" alignItems="center">
                <Stack direction="row" alignItems="center" gap="7px">
                    {Array.from({ length: 4 }).map(() => (
                        <Typography sx={{ color: palette.primary[700] }}>#JAVA</Typography>
                    ))}
                </Stack>
                <Typography flex={1} sx={{ textAlign: 'right', color: palette.grey[500] }}>
                    2024-09-01
                </Typography>
            </Stack>
        </Stack>
    );
};
