import React from 'react';

import { Stack } from '@mui/material';

import { useGetReplyComment } from '@/apis/comment/useGetReplyComment';
import { palette } from '@/themes';
import { CommentProps } from '@/types/comment';

import { Comment } from './Comment';
import { CommentTextField } from './CommentTextField';

export const CommentContainer: React.FC<CommentProps> = ({
    like,
    nickname,
    content,
    replyCommentCnt,
    createdAt,
    id,
}) => {
    const { data: replyComment } = useGetReplyComment(id);
    const [open, setOpen] = React.useState<boolean>(false);
    return (
        <Stack>
            <Comment
                like={like}
                nickname={nickname}
                content={content}
                replyCommentCnt={replyCommentCnt}
                createdAt={createdAt}
                setOpen={setOpen}
            />
            {open &&
                replyComment?.map((item) => (
                    <Comment
                        key={item.comment_id}
                        like={like}
                        nickname={item.nickname}
                        content={item.content}
                        replyCommentCnt={0}
                        createdAt={item.created_at}
                        reply={true}
                    />
                ))}
            {open && (
                <Stack
                    sx={{
                        // height: '141px',
                        width: '100%',
                        padding: '20px 10px',
                        borderBottom: `1px solid ${palette.grey[200]}`,
                        background: palette.grey[50],
                    }}
                    gap="10px"
                >
                    <CommentTextField parent_comment_id={id} />
                </Stack>
            )}
        </Stack>
    );
};
