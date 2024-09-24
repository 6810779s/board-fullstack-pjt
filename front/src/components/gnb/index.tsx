import React from 'react';

import { Drawer, IconButton, Stack, Typography } from '@mui/material';
import { List } from '@phosphor-icons/react';

import { palette } from '@/themes';

import { LinkComponent } from '../LinkComponent';
import { SNB } from '../snb';

export const GNB = () => {
    const [dummyLogin, setDummyLogin] = React.useState<boolean>(true);
    const [open, setOpen] = React.useState<boolean>(false);
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
            <IconButton onClick={() => setOpen(true)}>
                <List size={30} />
            </IconButton>
            <Typography
                flex={1}
                sx={{ color: palette.text.main, fontSize: '25px', fontWeight: 700 }}
            >
                PJT REVIEWER
            </Typography>

            {dummyLogin ? (
                <Stack direction="row" gap="40px" alignItems="center">
                    <LinkComponent to="/" content="Home" />
                    <LinkComponent to="/my-page" content="Mypage" />
                    <LinkComponent to="/" content="Logout" onClick={() => setDummyLogin(false)} />
                </Stack>
            ) : (
                <Stack direction="row" gap="40px" alignItems="center">
                    <LinkComponent to="/" content="Home" />
                    <LinkComponent
                        to="/sign-up"
                        content="sign up"
                        onClick={() => setDummyLogin(true)}
                    />
                    <LinkComponent
                        to="/login"
                        content="Login"
                        onClick={() => setDummyLogin(true)}
                    />
                </Stack>
            )}
            <Drawer open={open} onClose={() => setOpen(false)}>
                {<SNB setOpen={setOpen} />}
            </Drawer>
        </Stack>
    );
};
