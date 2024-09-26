import React from 'react';

import { Stack } from '@mui/material';

import { CommentProps } from '@/const';

import { Comment } from '.';

export const CommentContainer: React.FC<Omit<CommentProps, 'id'>> = ({
    like,
    nickname,
    content,
    replyComment,
    createdAt,
}) => {
    const [open, setOpen] = React.useState<boolean>(false);
    return (
        <Stack>
            <Comment
                like={like}
                nickname={nickname}
                content={content}
                replyCommentCnt={replyComment.replyCommentCnt}
                createdAt={createdAt}
                setOpen={setOpen}
            />
            {open &&
                replyComment.replyCommentArr.map((item) => (
                    <Comment
                        key={item.id}
                        like={like}
                        nickname={item.nickname}
                        content={item.content}
                        replyCommentCnt={0}
                        createdAt={item.createdAt}
                        reply={true}
                    />
                ))}
        </Stack>
    );
};
