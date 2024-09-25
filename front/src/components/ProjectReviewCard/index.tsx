import { Card, CardContent, CardMedia, Stack, Typography } from '@mui/material';
import { CalendarBlank, ChatCircleText, Star, User } from '@phosphor-icons/react';

import { palette } from '@/themes';

import { IconWithText } from './IconWithText';

interface ProjectReviewCardProps {
    imgSrc: string;
    title: string;
    starCnt: number;
    member: number;
    startDate: string;
    endDate: string;
    commentCnt: number;
    hashTags: string[];
}
export const ProjectReviewCard: React.FC<ProjectReviewCardProps> = ({
    imgSrc,
    title,
    starCnt,
    member,
    startDate,
    endDate,
    commentCnt,
    hashTags,
}) => {
    return (
        <Card variant="outlined">
            <CardMedia image={imgSrc} sx={{ width: '350px', height: '170px' }} />
            <CardContent sx={{ display: 'flex', flexDirection: 'column', gap: '5px' }}>
                <Typography sx={{ fontSize: '20px', fontWeight: 700 }}>{title}</Typography>
                <Stack direction="row" alignItems="center" gap="1px">
                    {Array.from({ length: 5 }).map((_, index) => {
                        if (index > starCnt - 1) {
                            return <Star color={palette.error[500]} size={10} />;
                        } else {
                            return <Star weight="fill" color={palette.error[500]} size={10} />;
                        }
                    })}
                </Stack>
                <IconWithText
                    icon={<User size={16} color={palette.grey[500]} />}
                    content={`${member} 명`}
                />
                <IconWithText
                    icon={<CalendarBlank size={16} color={palette.grey[500]} />}
                    content={`${startDate} ~ ${endDate}`}
                />
                <IconWithText
                    icon={<ChatCircleText size={16} color={palette.grey[500]} />}
                    content={`댓글 ${commentCnt}건`}
                />
                <Stack direction="row" alignItems="center" gap="3px">
                    {hashTags.map((item) => (
                        <Typography color={palette.primary[600]}>#{item}</Typography>
                    ))}
                </Stack>
            </CardContent>
        </Card>
    );
};