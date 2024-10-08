import { useLocation, useParams } from 'react-router-dom';

import { Stack } from '@mui/material';

import { ActiveHistory } from './activeHistory';
import { Feedback } from './feedback';
import { FriendList } from './friendList';
import { ProjectReview } from './projectReview';
import { UserProfile } from './userProfile';

const MypageContainer = () => {
    const { userNickname } = useParams();
    const location = useLocation();

    const searchParams = new URLSearchParams(location.search);

    const page = searchParams.get('page');

    return (
        <Stack>
            {userNickname === 'eunhee' ? (
                <Stack>
                    {' '}
                    {(page === null || page == 'active-history') && <ActiveHistory />}
                    {page === 'friend-list' && <FriendList />}
                    {page === 'feedback' && <Feedback />}
                    {page === 'project-review' && <ProjectReview />}
                </Stack>
            ) : (
                <UserProfile />
            )}
        </Stack>
    );
};

export default MypageContainer;
