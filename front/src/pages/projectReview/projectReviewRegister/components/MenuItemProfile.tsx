import { Box, Checkbox, Stack, Typography } from '@mui/material';

import { Tag } from '@/components/Tag';
import { palette } from '@/themes';

export const MenuItemProfile = () => {
    return (
        <Stack
            flex={1}
            direction="row"
            alignItems="center"
            sx={{ height: '100px', padding: '10px 12px' }}
        >
            <Box
                sx={{
                    width: '50px',
                    height: '50px',
                    borderRadius: '50%',
                    background: palette.grey[200],
                }}
            />
            <Stack gap="2px" flex={1} sx={{ marginLeft: '40px' }}>
                <Typography sx={{ fontWeight: 700 }}>eun</Typography>
                <Stack direction="row" alignItems="center">
                    <Tag label="FrontEnd Developer" />
                    <Tag label="BackEnd Developer" />
                </Stack>
                <Typography variant="main/small/grey">
                    풀스택 개발자 입니다. 디자이너 구합니다.
                </Typography>
            </Stack>
            <Checkbox sx={{ justifyContent: 'flex-end' }} />
        </Stack>
    );
};
