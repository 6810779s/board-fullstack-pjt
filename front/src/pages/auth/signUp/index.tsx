import { useNavigate } from 'react-router-dom';

import { Button, IconButton, Stack, TextField, Typography } from '@mui/material';
import { CalendarBlank } from '@phosphor-icons/react';

export const SignUp = () => {
    const navigate = useNavigate();
    return (
        <Stack flex={1} alignItems="center" justifyContent="center">
            <Stack gap="30px" sx={{ width: '523px' }}>
                <Typography
                    sx={{ textAlign: 'center', fontSize: '40px', fontWeight: 700, flex: 1 }}
                >
                    회원가입
                </Typography>
                <Stack gap="16px">
                    <Stack gap="4px">
                        <Typography>이메일</Typography>
                        <TextField placeholder="이메일을 입력해주세요." />
                    </Stack>
                    <Stack gap="4px">
                        <Typography>비밀번호</Typography>
                        <TextField placeholder="비밀번호를 입력해주세요." />
                    </Stack>
                    <Stack gap="4px">
                        <Typography>이름</Typography>
                        <TextField placeholder="실제 이름을 입력해주세요." />
                    </Stack>
                    <Stack gap="4px">
                        <Typography>생년월일</Typography>
                        <TextField
                            placeholder="1997-07-02"
                            slotProps={{
                                input: {
                                    endAdornment: (
                                        <IconButton onClick={() => {}}>
                                            <CalendarBlank size="16px" />
                                        </IconButton>
                                    ),
                                },
                            }}
                        />
                    </Stack>
                    <Stack gap="4px">
                        <Typography>이메일</Typography>
                        <TextField placeholder="이메일을 입력해주세요." />
                    </Stack>
                    <Stack direction="row" gap="18px">
                        <Button
                            variant="WhiteContainedBlackOutlined"
                            sx={{ flex: 1 }}
                            onClick={() => navigate('/login')}
                        >
                            이미 가입하셨나요? 로그인하기
                        </Button>
                        <Button sx={{ flex: 1 }} onClick={() => navigate('/sign-up')}>
                            가입하기
                        </Button>
                    </Stack>
                </Stack>
            </Stack>
        </Stack>
    );
};
