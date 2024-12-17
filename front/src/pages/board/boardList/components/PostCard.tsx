import React from 'react';

import { useNavigate } from 'react-router-dom';

import { Card, CardContent, CardMedia, Stack, Typography } from '@mui/material';
import { CalendarBlank, ChatCircleDots, Heart, User } from '@phosphor-icons/react';
import { format } from 'date-fns';

import { IconWithText } from '@/components/IconWithText';
import { TBoardListTopThreeDummyData } from '@/const';
import { palette } from '@/themes';

export const PostCard: React.FC<TBoardListTopThreeDummyData> = ({
    id,
    imgSrc,
    title,
    projectName,
    participantCnt,
    participantLimit,
    createdAt,
    commentCnt,
    like,
    content,
}) => {
    const navigate = useNavigate();
    console.log(`${import.meta.env.VITE_BASE_URL}${imgSrc}`);
    return (
        <Stack flex={1} sx={{ cursor: 'pointer' }} onClick={() => navigate(`/board/${id}`)}>
            <Card variant="outlined">
                <CardMedia
                    image={`${import.meta.env.VITE_BASE_URL}${imgSrc}`}
                    sx={{ width: '100%', height: '220px' }}
                />
                <CardContent sx={{ display: 'flex', flexDirection: 'column' }}>
                    <Typography sx={{ fontSize: '25px', fontWeight: 700 }}>{title}</Typography>
                    <Stack sx={{ gap: '10px' }}>
                        <Typography sx={{ fontSize: '22px' }}>{projectName}</Typography>
                        <Stack direction="row" alignItems="center" gap="15px">
                            <IconWithText
                                icon={<User color={palette.grey[500]} size={16} />}
                                content={`${participantLimit}/${participantCnt}`}
                            />
                            <IconWithText
                                icon={<CalendarBlank color={palette.grey[500]} size={16} />}
                                content={`${format(createdAt, 'yyyy.MM.dd hh:mm')}`}
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
                            {content.length > 150 ? content.slice(0, 150) + '...' : content}
                        </Typography>
                    </Stack>
                </CardContent>
            </Card>
        </Stack>
    );
};
