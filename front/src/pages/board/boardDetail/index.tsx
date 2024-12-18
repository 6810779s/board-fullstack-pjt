import { useParams } from 'react-router-dom';

import { Button, Stack, TextField, Typography } from '@mui/material';
import { CalendarBlank, ChatCenteredDots, User } from '@phosphor-icons/react';
import { format } from 'date-fns';

import { useGetBoardDetail } from '@/apis/board/useGetBoardDetail';
import { IconWithText } from '@/components/IconWithText';
import { OtherBoards } from '@/components/OtherBoards';
import { PageLayout } from '@/components/PageLayout';
import { CommentContainer } from '@/components/comment/CommentContainer';
import { boardDetailDummyData } from '@/const';
import { palette } from '@/themes';

import { LikeButtonForBoard } from './components/LikeButtonForBoard';
import UserProfile from './components/UserProfile';

export const BoardDetail = () => {
    const { id } = useParams();
    const { data: boardDetailData } = useGetBoardDetail(Number(id));

    return (
        <PageLayout alignItems="center">
            {boardDetailData && (
                <Stack flex={1} gap="15px" sx={{ width: '770px', position: 'relative' }}>
                    <LikeButtonForBoard likeCnt={0} />
                    <Typography sx={{ fontWeight: 700, textAlign: 'right' }}>
                        {boardDetailData.category.name}
                    </Typography>
                    <Typography sx={{ fontSize: '25px', fontWeight: 700 }}>
                        {boardDetailData.title}
                    </Typography>
                    <Typography sx={{ fontSize: '20px', fontWeight: 700 }}>
                        {boardDetailData.project_name}
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
                            content={`${format(boardDetailData.created_at, 'yyyy.MM.dd hh:mm')}`}
                        />
                        <IconWithText
                            icon={<ChatCenteredDots color={palette.grey[500]} size={16} />}
                            content={`댓글 ${boardDetailDummyData.comment.commentCnt}건`}
                        />
                    </Stack>
                    <Typography sx={{ paddingBottom: '100px' }}>
                        {boardDetailData.content}
                    </Typography>
                    <UserProfile />
                    <Stack direction="row" gap="45px">
                        {boardDetailData.prevBoard ? (
                            <OtherBoards
                                type="prev"
                                title={boardDetailData.prevBoard.title}
                                id={boardDetailData.prevBoard.board_id}
                            />
                        ) : (
                            <Stack flex={1} sx={{ height: '64px' }} />
                        )}
                        {boardDetailData.nextBoard ? (
                            <OtherBoards
                                type="next"
                                title={boardDetailData.nextBoard.title}
                                id={boardDetailData.nextBoard.board_id}
                            />
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
            )}
        </PageLayout>
    );
};
