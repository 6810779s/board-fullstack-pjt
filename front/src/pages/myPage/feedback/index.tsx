import { Stack, Typography } from '@mui/material';
import { ChatCircleText } from '@phosphor-icons/react';

import { IconWithText } from '@/components/IconWithText';
import { palette } from '@/themes';

import { FeedbackForm } from './FeedbackForm';

export const Feedback = () => {
    return (
        <Stack flex={1}>
            <Stack
                direction="row"
                alignItems="center"
                gap="6px"
                sx={{
                    borderBottom: `1px solid ${palette.common.black}`,
                    padding: '10px 0',
                }}
            >
                <IconWithText
                    icon={<ChatCircleText size={20} color={palette.grey[500]} />}
                    content="Feedback"
                    fontSize={20}
                    fontWeight={700}
                    color={palette.text.main}
                />
                <Typography
                    variant="main/small"
                    sx={{ fontWeight: 700, color: palette.primary[600] }}
                >{`(5)`}</Typography>
            </Stack>
            <Stack sx={{ height: '760px', overflowY: 'scroll' }}>
                {Array.from({ length: 10 }).map((_, idx) => (
                    <FeedbackForm key={idx} />
                ))}
            </Stack>
        </Stack>
    );
};
