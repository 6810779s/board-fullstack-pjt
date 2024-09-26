import React from 'react';

import { Button, IconButton, Stack, Typography } from '@mui/material';
import { ArrowElbowDownRight, Heart } from '@phosphor-icons/react';

import { CommentProps } from '@/const';
import { palette } from '@/themes';

export const Comment: React.FC<
    Omit<
        CommentProps & {
            replyCommentCnt: number;
            reply?: boolean;
            setOpen?: React.Dispatch<React.SetStateAction<boolean>>;
        },
        'replyComment' | 'id'
    >
> = ({ like, nickname, content, replyCommentCnt, createdAt, reply = false, setOpen }) => {
    return (
        <Stack
            sx={{
                height: '141px',
                padding: '20px 10px',
                borderBottom: `1px solid ${palette.grey[200]}`,
                background: reply ? palette.grey[50] : 'transparent',
            }}
            gap="10px"
        >
            <Stack direction="row" gap="7px" alignItems="center">
                {reply && (
                    <Stack alignItems="center" justifyContent="center" sx={{ width: '52px' }}>
                        <ArrowElbowDownRight size={25} color={palette.grey[500]} />
                    </Stack>
                )}
                <Stack gap="4px">
                    <Typography sx={{ fontWeight: 700 }}>{nickname}</Typography>
                    <Typography>{content}</Typography>
                    <Typography color={palette.grey[500]} sx={{ fontSize: '12px' }}>
                        {createdAt}
                    </Typography>
                </Stack>
            </Stack>
            <Stack direction="row" sx={{ height: '25px' }}>
                {!reply && (
                    <Button
                        onClick={() => {
                            if (setOpen) {
                                setOpen((prev) => !prev);
                            }
                        }}
                        variant="WhiteContainedBlackOutlined"
                        sx={{ height: '100%', borderColor: palette.grey[200] }}
                    >
                        {`답글`}
                        {replyCommentCnt > 0 && (
                            <Typography
                                component={'span'}
                                sx={{ fontWeight: 700, marginLeft: '4px' }}
                            >
                                {`${replyCommentCnt}`}
                            </Typography>
                        )}
                    </Button>
                )}
                <Stack
                    direction="row"
                    alignItems="center"
                    gap="5px"
                    flex={1}
                    justifyContent="flex-end"
                >
                    <IconButton>
                        <Heart color={palette.error[500]} size={20} />
                    </IconButton>
                    <Typography variant="main/small/grey">{like}</Typography>
                </Stack>
            </Stack>
        </Stack>
    );
};
