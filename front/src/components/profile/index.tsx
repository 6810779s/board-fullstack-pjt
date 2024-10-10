import React from 'react';

import { useNavigate, useParams } from 'react-router-dom';

import { Box, Button, Stack, Typography } from '@mui/material';

import { userEmailDummy } from '@/const';
import { palette } from '@/themes';

import Alert from '../Alert';
import { Tag } from '../Tag';

export const Profile = () => {
    const navigate = useNavigate();
    const [open, setOpen] = React.useState<boolean>(false);
    const { userNickname } = useParams();
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
            {userNickname === userEmailDummy ? (
                <Button variant="Error" onClick={() => setOpen(true)}>
                    회월 탈퇴
                </Button>
            ) : (
                <Button onClick={() => navigate(`/my-page/${userEmailDummy}`)}>View Profile</Button>
            )}
            <Alert
                open={open}
                variant="error"
                title="회원 탈퇴"
                content="회원 탈퇴시 아이디 복구가 불가능 합니다. "
                onClose={() => setOpen(false)}
                onConfirm={() => {
                    setOpen(false);
                }}
            />
        </Stack>
    );
};
