import { useNavigate } from 'react-router-dom';

import { Box, Button, Stack, Typography } from '@mui/material';

import { userEmailDummy } from '@/const';
import { palette } from '@/themes';

import { Tag } from '../Tag';

export const Profile = () => {
    const navigate = useNavigate();
    return (
        <Stack
            direction="row"
            justifyContent="space-between"
            alignItems="center"
            sx={{ height: '180px', background: palette.grey[800], padding: '40px 170px' }}
        >
            <Stack direction="row" gap="40px">
                <Box
                    sx={{
                        width: '100px',
                        height: '100px',
                        borderRadius: '50%',
                        background: palette.grey[400],
                    }}
                ></Box>
                <Stack justifyContent="space-between">
                    <Typography
                        sx={{ fontSize: '24px', fontWeight: 700, color: palette.common.white }}
                    >
                        eun
                    </Typography>
                    <Stack direction="row" alignItems="center" gap="6px">
                        <Tag label="Backend Developer" />
                        <Tag label="Backend Developer" />
                    </Stack>
                    <Typography sx={{ color: palette.common.white }}>
                        풀스택 개발자 입니다. 디자이너 구합니다.
                    </Typography>
                </Stack>
            </Stack>
            <Button onClick={() => navigate(`/my-page/${userEmailDummy}`)}>View Profile</Button>
        </Stack>
    );
};
