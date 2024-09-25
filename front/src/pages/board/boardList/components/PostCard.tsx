import React from 'react';

import { useNavigate } from 'react-router-dom';

import { Card, CardContent, CardMedia, Stack, Typography } from '@mui/material';
import { CalendarBlank, ChatCircleDots, Heart, User } from '@phosphor-icons/react';

import { IconWithText } from '@/components/IconWithText';
import { TBoardListTopThreeDummyData } from '@/const';
import { palette } from '@/themes';

export const PostCard: React.FC<TBoardListTopThreeDummyData> = ({
    id,
    imgSrc,
    title,
    subTitle,
    member,
    createdAt,
    commentCnt,
    like,
    content,
}) => {
    const navigate = useNavigate();
    return (
        <Stack flex={1} sx={{ cursor: 'pointer' }} onClick={() => navigate(`/board/${id}`)}>
            <Card variant="outlined">
                <CardMedia image={imgSrc} sx={{ width: '100%', height: '220px' }} />
                <CardContent sx={{ display: 'flex', flexDirection: 'column', gap: '5px' }}>
                    <Typography sx={{ fontSize: '25px', fontWeight: 700 }}>{title}</Typography>
                    <Stack>
                        <Typography sx={{ fontSize: '22px' }}>{subTitle}</Typography>
                        <Stack direction="row" alignItems="center" gap="15px">
                            <IconWithText
                                icon={<User color={palette.grey[500]} size={16} />}
                                content={`${member.total}/${member.participants}`}
                            />
                            <IconWithText
                                icon={<CalendarBlank color={palette.grey[500]} size={16} />}
                                content={`${createdAt}`}
                            />
                            <IconWithText
                                icon={<ChatCircleDots color={palette.grey[500]} size={16} />}
                                content={`댓글 ${commentCnt}건`}
                            />
                            <IconWithText
                                icon={<Heart color={palette.grey[500]} size={16} />}
                                content={`${like}`}
                            />
                        </Stack>
                        <Typography
                            variant="main/small/grey"
                            sx={{
                                height: '48px',
                            }}
                        >
                            {content.length}
                            {content.length > 75 ? content.slice(0, 75) + '...' : content}
                        </Typography>
                    </Stack>
                </CardContent>
            </Card>
        </Stack>
    );
};
