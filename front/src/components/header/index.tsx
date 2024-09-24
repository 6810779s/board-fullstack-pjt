import React from 'react';

import { useNavigate } from 'react-router-dom';

import { Button, Stack, Typography, styled } from '@mui/material';

import { palette } from '@/themes';

const ButtonStyle = styled(Button)({
    width: '240px',
});
export const Header = () => {
    const navigate = useNavigate();
    const [dummyLogin, setDummyLogin] = React.useState<boolean>(false);
    return (
        <Stack
            justifyContent="center"
            alignItems="center"
            gap="24px"
            sx={{
                height: '288px',
                background: palette.grey[800],
                borderBottom: `1px solid ${palette.grey[700]}`,
            }}
        >
            <Typography sx={{ fontSize: '40px', color: palette.common.white, fontWeight: 700 }}>
                Welcome to Team up!
            </Typography>
            <Typography sx={{ color: palette.common.white }}>
                지금 바로 함께할 동료를 구하세요
            </Typography>
            {dummyLogin ? (
                <ButtonStyle onClick={() => setDummyLogin(false)}>로그아웃</ButtonStyle>
            ) : (
                <Stack direction="row" gap="12px">
                    <ButtonStyle variant="WhiteOutlined" onClick={() => setDummyLogin(true)}>
                        로그인
                    </ButtonStyle>
                    <ButtonStyle onClick={() => navigate('/sign-up')}>회원가입</ButtonStyle>
                </Stack>
            )}
        </Stack>
    );
};
