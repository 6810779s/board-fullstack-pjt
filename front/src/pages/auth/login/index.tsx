import { useNavigate } from 'react-router-dom';

import { Button, Checkbox, Stack, TextField, Typography } from '@mui/material';

import { palette } from '@/themes';

export const Login = () => {
    const navigate = useNavigate();
    return (
        <Stack flex={1} alignItems="center" justifyContent="center">
            <Stack gap="30px" sx={{ width: '523px' }}>
                <Typography sx={{ fontSize: '40px', fontWeight: 700, textAlign: 'center' }}>
                    로그인
                </Typography>
                <Stack gap="16px">
                    <Stack gap="4px">
                        <Typography sx={{ fontSize: '14px' }}>이메일</Typography>
                        <TextField placeholder="이메일을 입력해주세요." />
                    </Stack>
                    <Stack gap="4px">
                        <Typography sx={{ fontSize: '14px' }}>비밀번호</Typography>
                        <TextField placeholder="비밀번호를 입력해 주세요." />
                        <Stack direction="row" alignItems="center">
                            <Checkbox />
                            <Typography sx={{ fontSize: '14px', color: palette.grey[500] }}>
                                로그인 상태 유지
                            </Typography>
                        </Stack>
                    </Stack>
                    <Stack direction="row" gap="18px">
                        <Button variant="WhiteContainedBlackOutlined" sx={{ flex: 1 }}>
                            로그인
                        </Button>
                        <Button sx={{ flex: 1 }} onClick={() => navigate('/sign-up')}>
                            회원가입
                        </Button>
                    </Stack>
                    <Button variant="text" sx={{ width: 'fit-content' }}>
                        ID/PW 찾기
                    </Button>
                </Stack>
            </Stack>
        </Stack>
    );
};
