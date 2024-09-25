import { PageLayout } from '@/components/PageLayout';

import { ParticipantProject } from './ParticipantProject';
import { ProjectReview } from './ProjectReview';
import { RecentPosts } from './RecentPosts';

export const Home = () => {
    return (
        <PageLayout>
            <RecentPosts />
            <ProjectReview />
            <ParticipantProject />
        </PageLayout>
    );
};
