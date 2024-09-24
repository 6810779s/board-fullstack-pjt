import React from 'react';

import { Link } from 'react-router-dom';

import { Stack, Typography } from '@mui/material';
import { List } from '@phosphor-icons/react';

import { palette } from '@/themes';

export const GNB = () => {
    const [dummyLogin, setDummyLogin] = React.useState<boolean>(true);
    return (
        <Stack
            direction="row"
            alignItems="center"
            gap="20px"
            sx={{
                padding: '20px',
                height: '56px',
                width: '100%',
                background: palette.common.white,
            }}
        >
            <List size={30} />
            <Typography
                flex={1}
                sx={{ color: palette.text.main, fontSize: '25px', fontWeight: 700 }}
            >
                PJT REVIEWER
            </Typography>

            {dummyLogin ? (
                <Stack direction="row" gap="40px" alignItems="center">
                    <Typography>
                        <Link to="/">Home</Link>
                    </Typography>
                    <Typography>
                        <Link to="/my-page">Mypage</Link>
                    </Typography>
                    <Typography>
                        <Link to="/" onClick={() => setDummyLogin(false)}>
                            Logout
                        </Link>
                    </Typography>
                </Stack>
            ) : (
                <Stack direction="row" gap="40px" alignItems="center">
                    <Typography>
                        <Link to="/">Home</Link>
                    </Typography>
                    <Typography>
                        <Link to="/login" onClick={() => setDummyLogin(true)}>
                            Login
                        </Link>
                    </Typography>
                </Stack>
            )}
        </Stack>
    );
};
