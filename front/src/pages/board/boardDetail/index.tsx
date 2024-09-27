import { useParams } from 'react-router-dom';

import { Button, Stack, TextField, Typography } from '@mui/material';
import { CalendarBlank, ChatCenteredDots, User } from '@phosphor-icons/react';

import { IconWithText } from '@/components/IconWithText';
import { PageLayout } from '@/components/PageLayout';
import { CommentContainer } from '@/components/comment/CommentContainer';
import { boardDetailDummyData } from '@/const';
import { palette } from '@/themes';

import { LikeButtonForBoard } from './components/LikeButtonForBoard';
import { OtherBoards } from './components/OtherBoards';
import UserProfile from './components/UserProfile';

export const BoardDetail = () => {
    const { id } = useParams();
    return (
        <PageLayout alignItems="center">
            <Stack flex={1} gap="15px" sx={{ width: '770px', position: 'relative' }}>
                <LikeButtonForBoard />
                <Typography sx={{ fontWeight: 700, textAlign: 'right' }}>
                    {boardDetailDummyData.category}
                </Typography>
                <Typography sx={{ fontSize: '25px', fontWeight: 700 }}>
                    {boardDetailDummyData.title}-{id}
                </Typography>
                <Stack
                    direction="row"
                    alignItems="center"
                    gap="15px"
                    sx={{ height: '44px', borderBottom: `1px solid ${palette.grey[500]}` }}
                >
                    <IconWithText
                        icon={<User color={palette.grey[500]} size={16} />}
                        content={`${boardDetailDummyData.member.total}/${boardDetailDummyData.member.participants}`}
                    />
                    <IconWithText
                        icon={<CalendarBlank color={palette.grey[500]} size={16} />}
                        content={`${boardDetailDummyData.createdAt}`}
                    />
                    <IconWithText
                        icon={<ChatCenteredDots color={palette.grey[500]} size={16} />}
                        content={`댓글 ${boardDetailDummyData.comment.commentCnt}건`}
                    />
                </Stack>
                <Typography sx={{ paddingBottom: '100px' }}>
                    {boardDetailDummyData.content}
                </Typography>
                <UserProfile />
                <Stack direction="row" gap="45px">
                    {boardDetailDummyData.prevBoard ? (
                        <OtherBoards type="prev" title={boardDetailDummyData.prevBoard.title} />
                    ) : (
                        <Stack flex={1} sx={{ height: '64px' }} />
                    )}
                    {boardDetailDummyData.nextBoard ? (
                        <OtherBoards type="next" title={boardDetailDummyData.nextBoard.title} />
                    ) : (
                        <Stack flex={1} sx={{ height: '64px' }} />
                    )}
                </Stack>
                <TextField multiline={true} rows={5} placeholder="댓글을 입력해 주세요." />
                <Stack flex={1} alignItems="flex-end">
                    <Button sx={{ width: '97px' }}>댓글 작성</Button>
                </Stack>
                {boardDetailDummyData.comment.commentsArr.map((item) => (
                    <CommentContainer
                        key={item.id}
                        nickname={item.nickname}
                        content={item.content}
                        replyComment={item.replyComment}
                        createdAt={item.createdAt}
                        like={item.like}
                    />
                ))}
            </Stack>
        </PageLayout>
    );
};
