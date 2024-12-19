import React, { ChangeEvent } from 'react';

import { useParams } from 'react-router-dom';

import { Button, Stack, TextField, Typography } from '@mui/material';
import { CalendarBlank, ChatCenteredDots, User } from '@phosphor-icons/react';
import { useQueryClient } from '@tanstack/react-query';
import { format } from 'date-fns';

import { QUERY_KEYS } from '@/apis/QueryKeys';
import { useGetBoardDetail } from '@/apis/board/useGetBoardDetail';
import { useGetComment } from '@/apis/comment/useGetComment';
import { usePostCreateComment } from '@/apis/comment/usePostCreateComment';
import { IconWithText } from '@/components/IconWithText';
import { OtherBoards } from '@/components/OtherBoards';
import { PageLayout } from '@/components/PageLayout';
import { CommentContainer } from '@/components/comment/CommentContainer';
import { palette } from '@/themes';

import { LikeButtonForBoard } from './components/LikeButtonForBoard';
import UserProfile from './components/UserProfile';

export const BoardDetail = () => {
    const queryClient = useQueryClient();
    const { id } = useParams();
    const { data: boardDetailData } = useGetBoardDetail(Number(id));
    const { data: commentData } = useGetComment(Number(id));
    const { mutateAsync: createComment } = usePostCreateComment();
    const [comment, setComment] = React.useState<string>('');
    const submitComment = () => {
        createComment({ board_id: Number(id), parent_comment_id: null, content: comment }).then(
            (res) => {
                if (res?.data?.status === 'SUCCESS') {
                    queryClient.invalidateQueries({ queryKey: QUERY_KEYS.COMMENT.all() });
                    setComment('');
                }
            }
        );
    };
    return (
        <PageLayout alignItems="center">
            {boardDetailData && (
                <Stack flex={1} gap="15px" sx={{ width: '770px', position: 'relative' }}>
                    <LikeButtonForBoard likeCnt={boardDetailData.like_cnt} />
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
                            content={`${boardDetailData.participant_limit}/${boardDetailData.participant_cnt}`}
                        />
                        <IconWithText
                            icon={<CalendarBlank color={palette.grey[500]} size={16} />}
                            content={`${format(boardDetailData.created_at, 'yyyy.MM.dd hh:mm')}`}
                        />
                        <IconWithText
                            icon={<ChatCenteredDots color={palette.grey[500]} size={16} />}
                            content={`댓글 ${boardDetailData.comment_cnt}건`}
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
                    <TextField
                        onChange={(e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
                            setComment(e.target.value);
                        }}
                        value={comment}
                        multiline={true}
                        rows={5}
                        placeholder="댓글을 입력해 주세요."
                    />
                    <Stack flex={1} alignItems="flex-end">
                        <Button onClick={submitComment} sx={{ width: '97px', fontWeight: 700 }}>
                            댓글 작성
                        </Button>
                    </Stack>
                    {commentData?.map((item) => (
                        <CommentContainer
                            key={`${item.comment_id}-${item.created_at}`}
                            id={item.comment_id}
                            nickname={item.nickname}
                            content={item.content}
                            replyCommentCnt={item.reply_comment_cnt}
                            createdAt={item.created_at}
                            like={item.like_cnt}
                        />
                    ))}
                </Stack>
            )}
        </PageLayout>
    );
};
