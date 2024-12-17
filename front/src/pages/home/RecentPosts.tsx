import { useNavigate } from 'react-router-dom';

import { Button, List, ListItem, Stack, Typography } from '@mui/material';
import { CalendarBlank, ChatCircleText, Clock, User } from '@phosphor-icons/react';
import { format } from 'date-fns';

import { useGetBoard } from '@/apis/test/home/useGetBoard';
import { IconWithText } from '@/components/IconWithText';
import { palette } from '@/themes';
import { calcTime } from '@/util';

export const RecentPosts = () => {
    const navigate = useNavigate();
    const { data: boardList } = useGetBoard({ limit: 3 });

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
                {boardList?.map((item, idx) => (
                    <ListItem
                        key={`${item.title}-${item.created_at}`}
                        disablePadding
                        sx={{
                            padding: '18px 0',
                            borderBottom:
                                idx === boardList.length - 1 ? 0 : `1px solid ${palette.grey[200]}`,
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
                                <Typography variant="main/small/grey">
                                    {item.category_name}
                                </Typography>
                                <Stack gap="2px">
                                    <Typography variant="main/small/grey">
                                        {calcTime(item.created_at)}
                                    </Typography>
                                    <Typography variant="main/small/grey">{`찜 ${item.like_cnt}`}</Typography>
                                </Stack>
                            </Stack>
                            <Stack gap="10px" sx={{ padding: '0 12px' }}>
                                <Typography sx={{ fontSize: '22px', fontWeight: 500 }}>
                                    {item.title}
                                </Typography>
                                <Stack direction="row" gap="15px">
                                    <IconWithText
                                        icon={<User color={palette.grey[500]} size={16} />}
                                        content={`5/${item.participant_cnt}`}
                                    />
                                    <IconWithText
                                        icon={<CalendarBlank color={palette.grey[500]} size={16} />}
                                        content={`${format(item.created_at, 'yyyy.MM.dd hh:mm')}`}
                                    />
                                    <IconWithText
                                        icon={
                                            <ChatCircleText color={palette.grey[500]} size={16} />
                                        }
                                        content={`댓글 ${item.comment_cnt} 건`}
                                    />
                                </Stack>
                                <Typography
                                    variant="main/small/grey"
                                    sx={{ height: '48px', textOverflow: 'ellipsis' }}
                                >
                                    {/* {item.content} */}
                                    {item.content.length > 150
                                        ? item.content.slice(0, 150) + '...'
                                        : item.content}
                                </Typography>
                                <Typography variant="main/small" sx={{ fontWeight: 500 }}>
                                    {item.project_name}
                                </Typography>
                            </Stack>
                        </Stack>
                    </ListItem>
                ))}
            </List>
        </Stack>
    );
};
