import { Button, Stack, TextField, Typography } from '@mui/material';
import { ArrowElbowDownRight } from '@phosphor-icons/react';

import { palette } from '@/themes';

interface CommentTextFieldProps {
    parent_comment_id: number;
}
export const CommentTextField: React.FC<CommentTextFieldProps> = ({ parent_comment_id }) => {
    console.log(parent_comment_id);
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
                    <Button variant="BlackContained" sx={{ width: '97px', height: '32px' }}>
                        댓글 작성
                    </Button>
                </Stack>
            </Stack>
        </Stack>
    );
};
