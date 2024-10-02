import { Box, Button, Stack, Typography } from '@mui/material';
import { UsersThree } from '@phosphor-icons/react';

import { IconWithText } from '@/components/IconWithText';
import { MenuItemProfile } from '@/pages/projectReview/projectReviewRegister/components/MenuItemProfile';
import { palette } from '@/themes';

export const FriendList = () => {
    return (
        <Stack flex={1} gap="100px">
            <Box>
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
                        icon={<UsersThree size={20} color={palette.grey[500]} />}
                        content="친구 요청"
                        fontSize={20}
                        fontWeight={700}
                        color={palette.text.main}
                    />
                    <Typography
                        variant="main/small"
                        sx={{ fontWeight: 700, color: palette.primary[600] }}
                    >{`(5)`}</Typography>
                </Stack>
                <Stack sx={{ maxHeight: '360px', overflowY: 'scroll' }}>
                    {Array.from({ length: 5 }).map(() => (
                        <MenuItemProfile>
                            <Stack direction="row" gap="10px">
                                <Button
                                    variant="WhiteContainedBlackOutlined"
                                    sx={{ height: '28px', width: '79px' }}
                                >
                                    수락
                                </Button>
                                <Button variant="Error" sx={{ height: '28px', width: '79px' }}>
                                    거절
                                </Button>
                            </Stack>
                        </MenuItemProfile>
                    ))}
                </Stack>
            </Box>
            <Box>
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
                        icon={<UsersThree size={20} color={palette.grey[500]} />}
                        content="친구 목록"
                        fontSize={20}
                        fontWeight={700}
                        color={palette.text.main}
                    />
                    <Typography
                        variant="main/small"
                        sx={{ fontWeight: 700, color: palette.primary[600] }}
                    >{`(5)`}</Typography>
                </Stack>{' '}
                <Stack sx={{ maxHeight: '600px', overflowY: 'scroll' }}>
                    {Array.from({ length: 7 }).map(() => (
                        <MenuItemProfile>
                            <Stack direction="row" gap="10px">
                                <Button
                                    variant="WhiteContainedBlackOutlined"
                                    sx={{ height: '28px', width: '79px' }}
                                >
                                    VIEW
                                </Button>
                                <Button variant="Error" sx={{ height: '28px', width: '79px' }}>
                                    거절
                                </Button>
                            </Stack>
                        </MenuItemProfile>
                    ))}
                </Stack>
            </Box>
        </Stack>
    );
};
