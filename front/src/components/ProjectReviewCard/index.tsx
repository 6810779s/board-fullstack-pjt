import { useNavigate } from 'react-router-dom';

import { Card, CardContent, CardMedia, Stack, Typography } from '@mui/material';
import { CalendarBlank, ChatCircleText, Star, User } from '@phosphor-icons/react';

import { palette } from '@/themes';

import { IconWithText } from '../IconWithText';

interface ProjectReviewCardProps {
    imgSrc: string;
    title: string;
    starCnt: number;
    member: number;
    startDate: string;
    endDate: string;
    commentCnt: number;
    hashTags: string[];
    minWidth?: string;
    flex?: string;
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
    minWidth = 'unset',
    flex = 'none',
}) => {
    const navigate = useNavigate();
    return (
        <Card
            variant="outlined"
            sx={{ cursor: 'pointer', minWidth, flex }}
            onClick={() => navigate('/project-review/1')}
        >
            <CardMedia image={imgSrc} sx={{ width: '100%', height: '170px' }} />
            <CardContent sx={{ display: 'flex', flexDirection: 'column', gap: '5px' }}>
                <Typography sx={{ fontSize: '20px', fontWeight: 700 }}>{title}</Typography>
                <Stack direction="row" alignItems="center" gap="1px">
                    {Array.from({ length: 5 }).map((_, index) => {
                        if (index > starCnt - 1) {
                            return (
                                <Star key={`star-${index}`} color={palette.error[500]} size={10} />
                            );
                        } else {
                            return (
                                <Star
                                    key={`star-${index}`}
                                    weight="fill"
                                    color={palette.error[500]}
                                    size={10}
                                />
                            );
                        }
                    })}
                </Stack>
                <IconWithText
                    icon={<User size={16} color={palette.grey[500]} />}
                    content={`${member} 명`}
                    gap={10}
                    color={palette.text.main}
                />
                <IconWithText
                    icon={<CalendarBlank size={16} color={palette.grey[500]} />}
                    content={`${startDate} ~ ${endDate}`}
                    gap={10}
                    color={palette.text.main}
                />
                <IconWithText
                    icon={<ChatCircleText size={16} color={palette.grey[500]} />}
                    content={`댓글 ${commentCnt}건`}
                    gap={10}
                    color={palette.text.main}
                />
                <Stack direction="row" alignItems="center" gap="3px">
                    {hashTags.map((item, index) => (
                        <Typography key={`${item}-${index}`} color={palette.primary[700]}>
                            #{item}
                        </Typography>
                    ))}
                </Stack>
            </CardContent>
        </Card>
    );
};
