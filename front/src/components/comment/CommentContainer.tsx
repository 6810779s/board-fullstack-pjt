import React from 'react';

import { Stack } from '@mui/material';

import { useGetReplyComment } from '@/apis/comment/useGetReplyComment';
import { CommentProps } from '@/types/comment';

import { Comment } from '.';

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
        </Stack>
    );
};
