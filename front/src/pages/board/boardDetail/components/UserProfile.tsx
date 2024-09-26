import { Box, Button, Stack, Typography } from '@mui/material';

import { Tag } from '@/components/Tag';
import { boardDetailDummyData } from '@/const';
import { palette } from '@/themes';

const UserProfile = () => {
    return (
        <Stack
            direction="row"
            alignItems="center"
            justifyContent="space-between"
            sx={{
                padding: '20px 10px',
                height: '140px',
                borderBottom: `1px solid ${palette.grey[200]}`,
            }}
        >
            <Stack direction="row" alignItems="center" gap="40px" sx={{ height: '100%' }}>
                <Box
                    sx={{
                        width: '100px',
                        height: '100px',
                        borderRadius: '50%',
                        background: palette.grey[200],
                    }}
                />
                <Stack justifyContent="space-between" sx={{ height: '100%' }}>
                    <Typography sx={{ fontSize: '24px', fontWeight: 700 }}>
                        {boardDetailDummyData.writer.nickname}
                    </Typography>
                    <Stack direction="row" gap="6px">
                        {boardDetailDummyData.writer.tags.map((item, index) => (
                            <Tag key={index} label={item} />
                        ))}
                    </Stack>
                    <Typography>{boardDetailDummyData.writer.message}</Typography>
                </Stack>
            </Stack>
            {!boardDetailDummyData.writer.friend && (
                <Button variant="WhiteContainedBlackOutlined" sx={{ borderRadius: '20px' }}>
                    팔로우
                </Button>
            )}
        </Stack>
    );
};

export default UserProfile;
