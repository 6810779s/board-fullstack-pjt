import React from 'react';

import { Button, Stack, TextField, Typography } from '@mui/material';
import { ArrowElbowDownRight } from '@phosphor-icons/react';
import { useQueryClient } from '@tanstack/react-query';

import { QUERY_KEYS } from '@/apis/QueryKeys';
import { usePostCreateComment } from '@/apis/comment/usePostCreateComment';
import { palette } from '@/themes';

interface CommentTextFieldProps {
    parentCommentId: number;
    boardId: number;
}
export const CommentTextField: React.FC<CommentTextFieldProps> = ({ boardId, parentCommentId }) => {
    const queryClient = useQueryClient();
    const { mutateAsync: createComment } = usePostCreateComment();
    const [comment, setComment] = React.useState<string>('');
    const submitComment = () => {
        createComment({
            board_id: Number(boardId),
            parent_comment_id: parentCommentId,
            content: comment,
        }).then((res) => {
            if (res?.data?.status === 'SUCCESS') {
                queryClient.invalidateQueries({ queryKey: QUERY_KEYS.COMMENT.all() });
                setComment('');
            }
        });
    };

    return (
        <Stack direction="row" gap="7px">
            <Stack sx={{ width: '52px', alignItems: 'center' }}>
                <ArrowElbowDownRight size={25} color={palette.grey[500]} />
            </Stack>
            <Stack gap="4px" flex={1}>
                <Stack sx={{ background: palette.common.white, padding: '12px 24px' }} gap="10px">
                    <Typography sx={{ fontWeight: 600 }}>user nickname</Typography>
                    <TextField
                        fullWidth
                        onChange={(e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) =>
                            setComment(e.target.value)
                        }
                        value={comment}
                        sx={{
                            '& .MuiOutlinedInput-root': {
                                'padding': 0,
                                'border': 'none',
                                '& fieldset': {
                                    border: 'none',
                                },
                                '&:hover fieldset': {
                                    border: 'none',
                                },
                                '&.Mui-focused fieldset': {
                                    border: 'none',
                                },
                            },
                        }}
                        multiline={true}
                        rows={5}
                        placeholder="댓글을 입력해 주세요."
                    />
                </Stack>
                <Stack
                    sx={{
                        marginTop: '10px',

                        direction: 'row',
                        alignItems: 'end',
                    }}
                >
                    <Button
                        onClick={submitComment}
                        variant="BlackContained"
                        sx={{ width: '97px', height: '32px' }}
                    >
                        댓글 작성
                    </Button>
                </Stack>
            </Stack>
        </Stack>
    );
};
