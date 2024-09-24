import { Stack } from '@mui/material';

import { Profile } from '@/components/profile';
import { Header } from '@/components/profile/Header';

export const Home = () => {
    return (
        <Stack>
            <Header />
            <Profile />
        </Stack>
    );
};
