import { useNavigate } from 'react-router-dom';

import { Button, List, ListItem, Stack, Typography } from '@mui/material';
import { CalendarBlank, ChatCircleText, Clock, User } from '@phosphor-icons/react';
import { format } from 'date-fns';

import { IconWithText } from '@/components/IconWithText';
import { palette } from '@/themes';
import { calcTime } from '@/util';

interface TDummyData {
    id: number;
    category: string;
    createdAt: string;
    like: number;
    title: string;
    member: {
        total: number;
        participants: number;
    };
    totalCommentCnt: number;
    projectName: string;
    content: string;
}

export const RecentPosts = () => {
    const navigate = useNavigate();

    const dummyData: TDummyData[] = [
        {
            id: 0,
            category: '팀원 구함',
            createdAt: '2024-09-25 15:50:00',
            like: 100,
            title: '함께하실 프론트엔드 개발자 구합니다.',
            content:
                '게시판 프로젝트에서는 이런 저런 기능을 넣을 것이고, 토요일 일요일에 만나서 프로젝트를 하던지 줌으로 하던지 어쩌고... ...',
            member: {
                total: 5,
                participants: 3,
            },
            totalCommentCnt: 5,
            projectName: '게시판 프로젝트',
        },
        {
            id: 1,
            category: '스터디원 구함',
            createdAt: '2024-09-24 15:50:00',
            like: 68,
            title: '함께하실 프론트엔드 개발자 구합니다.',
            content:
                '게시판 프로젝트에서는 이런 저런 기능을 넣을 것이고, 토요일 일요일에 만나서 프로젝트를 하던지 줌으로 하던지 어쩌고... ...',
            member: {
                total: 5,
                participants: 3,
            },
            totalCommentCnt: 5,
            projectName: 'JAVA Spring & JAP 공부',
        },
        {
            id: 2,
            category: '팀원 구함',
            createdAt: '2024-09-21 15:50:00',
            like: 23,
            title: '함께하실 프론트엔드 개발자 구합니다.',
            content:
                '게시판 프로젝트에서는 이런 저런 기능을 넣을 것이고, 토요일 일요일에 만나서 프로젝트를 하던지 줌으로 하던지 어쩌고... ...',
            member: {
                total: 5,
                participants: 3,
            },
            totalCommentCnt: 5,
            projectName: '부루마블 게임 프로젝트',
        },
    ];

    return (
        <Stack>
            <Stack
                direction="row"
                alignItems="center"
                justifyContent="space-between"
                sx={{ padding: '10px 25px', borderBottom: `1px solid ${palette.common.black}` }}
            >
                <Stack direction="row" gap="10px" alignItems="center">
                    <Clock size={20} color={palette.grey[500]} />
                    <Typography sx={{ fontWeight: 700, fontSize: '20px' }}>최신</Typography>
                </Stack>
                <Button sx={{ width: '71px' }} onClick={() => navigate('/board-list')}>
                    더보기
                </Button>
            </Stack>
            <List disablePadding>
                {dummyData.map((item, idx) => (
                    <ListItem
                        key={item.id}
                        disablePadding
                        sx={{
                            padding: '18px 0',
                            borderBottom:
                                idx === dummyData.length - 1 ? 0 : `1px solid ${palette.grey[200]}`,
                        }}
                    >
                        <Stack
                            flex={1}
                            direction="row"
                            onClick={() => {
                                navigate(`/board/${idx}`);
                            }}
                            sx={{ cursor: 'pointer' }}
                        >
                            <Stack gap="22px" sx={{ width: '180px', padding: '0 25px' }}>
                                <Typography variant="main/small/grey">{item.category}</Typography>
                                <Stack gap="2px">
                                    <Typography variant="main/small/grey">
                                        {calcTime(item.createdAt)}
                                    </Typography>
                                    <Typography variant="main/small/grey">{`찜 ${item.like}`}</Typography>
                                </Stack>
                            </Stack>
                            <Stack gap="10px" sx={{ padding: '0 12px' }}>
                                <Typography sx={{ fontSize: '22px', fontWeight: 500 }}>
                                    {item.title}
                                </Typography>
                                <Stack direction="row" gap="15px">
                                    <IconWithText
                                        icon={<User color={palette.grey[500]} size={16} />}
                                        content={`${item.member.total}/${item.member.participants}`}
                                    />
                                    <IconWithText
                                        icon={<CalendarBlank color={palette.grey[500]} size={16} />}
                                        content={`${format(item.createdAt, 'yyyy.MM.dd hh:mm')}`}
                                    />
                                    <IconWithText
                                        icon={
                                            <ChatCircleText color={palette.grey[500]} size={16} />
                                        }
                                        content={`댓글 ${item.totalCommentCnt}`}
                                    />
                                </Stack>
                                <Typography
                                    variant="main/small/grey"
                                    sx={{ height: '48px', textOverflow: 'ellipsis' }}
                                >
                                    {item.content}
                                </Typography>
                                <Typography variant="main/small" sx={{ fontWeight: 500 }}>
                                    {item.projectName}
                                </Typography>
                            </Stack>
                        </Stack>
                    </ListItem>
                ))}
            </List>
        </Stack>
    );
};
