import { useLocation, useParams } from 'react-router-dom';

import { Stack } from '@mui/material';

import { userEmailDummy } from '@/const';

import { ActiveHistory } from './activeHistory';
import { Feedback } from './feedback';
import { FriendList } from './friendList';
import { ProjectReview } from './projectReview';
import { Setting } from './setting';
import { UserProfile } from './userProfile';

export const MypageContainer = () => {
    const { userNickname } = useParams();
    const location = useLocation();

    const searchParams = new URLSearchParams(location.search);

    const page = searchParams.get('page');

    return (
        <Stack>
            {userNickname === userEmailDummy ? (
                <Stack>
                    {(page === null || page == 'active-history') && <ActiveHistory />}
                    {page === 'friend-list' && <FriendList />}
                    {page === 'feedback' && <Feedback />}
                    {page === 'project-review' && <ProjectReview />}
                    {page === 'setting' && <Setting />}
                </Stack>
            ) : (
                <UserProfile />
            )}
        </Stack>
    );
};
