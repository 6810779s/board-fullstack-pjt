import { Box, Button, Stack, TextField } from '@mui/material';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { Gear } from '@phosphor-icons/react';

import { IconWithText } from '@/components/IconWithText';
import { Tag } from '@/components/Tag';
import { palette } from '@/themes';

import { SettingContainer } from './components/SettingContainer';

export const Setting = () => {
    return (
        <Stack flex={1}>
            <Stack
                direction="row"
                alignItems="center"
                gap="6px"
                sx={{
                    borderBottom: `1px solid ${palette.common.black}`,
                    padding: '10px 0',
                }}
            >
                <IconWithText
                    icon={<Gear size={20} color={palette.grey[500]} />}
                    content="Profile Settings"
                    fontSize={20}
                    fontWeight={700}
                    color={palette.text.main}
                />
            </Stack>
            <Stack sx={{ padding: '20px 0' }} gap="30px">
                <SettingContainer title="프로필 사진">
                    <Stack
                        justifyContent="center"
                        alignItems="center"
                        sx={{ width: 'fit-content' }}
                        gap="10px"
                    >
                        <Box
                            sx={{
                                background: palette.grey[300],
                                width: '100px',
                                height: '100px',
                                borderRadius: '50%',
                            }}
                        />
                        <Button sx={{ width: '73px', height: '23px', fontSize: '12px', p: 0 }}>
                            사진 편집
                        </Button>
                    </Stack>
                </SettingContainer>
                <SettingContainer title="Name">
                    <TextField disabled placeholder="홍길동" />
                </SettingContainer>
                <SettingContainer title="Nickname">
                    <TextField disabled placeholder="eunhee" />
                </SettingContainer>
                <SettingContainer title="Email">
                    <TextField disabled placeholder="eunhee@naver.com" />
                </SettingContainer>
                <SettingContainer title="Status Message">
                    <TextField placeholder="상태 메시지를 입력해주세요." multiline rows={5} />
                </SettingContainer>
                <SettingContainer title="Birth">
                    <DatePicker format="YYYY/MM/DD" />
                </SettingContainer>
                <SettingContainer title="Position" childrenGap={4}>
                    <Stack direction="row" gap="5px">
                        <Tag
                            label="frontend"
                            onDelete={() => {
                                console.log('delete');
                            }}
                        />
                        <Tag
                            label="backend"
                            onDelete={() => {
                                console.log('delete');
                            }}
                        />
                    </Stack>
                    <TextField placeholder="개발 포지션을 입력해주세요. ex) Frontend" />
                </SettingContainer>
                <Stack direction="row" gap="22px">
                    <Button variant="WhiteContainedBlackOutlined" sx={{ flex: 1 }}>
                        초기화
                    </Button>
                    <Button sx={{ flex: 1 }}>저장</Button>
                </Stack>
            </Stack>
        </Stack>
    );
};
