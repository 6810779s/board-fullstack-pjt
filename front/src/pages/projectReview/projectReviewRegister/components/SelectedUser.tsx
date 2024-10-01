import { Stack, Typography } from '@mui/material';
import { User } from '@phosphor-icons/react';

import { palette } from '@/themes';

const SelectedUser = () => {
    return (
        <Stack gap="3px" sx={{ height: '53px', alignItems: 'center', justifyContent: 'center' }}>
            <Stack
                alignItems="center"
                justifyContent="center"
                sx={{
                    width: '30px',
                    height: '30px',
                    borderRadius: '50%',
                    background: palette.grey[400],
                }}
            >
                <User weight="fill" color={palette.grey[600]} size={15} />
            </Stack>
            <Typography sx={{ fontSize: '12px' }}>김사또1</Typography>
        </Stack>
    );
};

export default SelectedUser;
