import React from 'react';

import { Stack, Tab, Tabs } from '@mui/material';

import { palette } from '@/themes';

import { Feedback } from '../feedback';
import { ProjectReview } from '../projectReview';
import { TabPanel } from './TabPanel';
import { UserFeedback } from './UserFeedback';

export const UserProfile = () => {
    const [value, setValue] = React.useState<number>(0);
    return (
        <Stack>
            <Tabs
                value={value}
                onChange={(_e, newValue: number) => setValue(newValue)}
                sx={{ borderBottom: `1px solid ${palette.grey[300]}` }}
            >
                <Tab label="피드백" value={0} />
                <Tab label="프로젝트 리뷰" value={1} />
            </Tabs>
            <TabPanel value={value} index={0}>
                <UserFeedback />
            </TabPanel>
            <TabPanel value={value} index={1}>
                <ProjectReview />
            </TabPanel>
            <Feedback />
        </Stack>
    );
};
