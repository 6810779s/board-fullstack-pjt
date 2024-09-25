import { useNavigate } from 'react-router-dom';

import { ListItem, Stack, Typography } from '@mui/material';
import { CalendarBlank, ChatCenteredDots, Heart, User } from '@phosphor-icons/react';

import { IconWithText } from '@/components/IconWithText';
import { TBoardListDummyData, boardListDummyData } from '@/const';
import { palette } from '@/themes';
import { calcTime } from '@/util';

export const BoardListItem: React.FC<TBoardListDummyData> = ({
    id,
    category,
    like,
    title,
    member,
    createdAt,
    commentCnt,
    content,
    projectName,
}) => {
    const navigate = useNavigate();
    return (
        <ListItem
            disablePadding
            sx={{
                display: 'flex',
                cursor: 'pointer',
                padding: '18px 0',
                borderBottom:
                    id === boardListDummyData.length - 1
                        ? 'none'
                        : `1px solid ${palette.grey[200]}`,
            }}
            onClick={() => navigate(`/board/${id}`)}
        >
            <Stack sx={{ width: '180px', padding: '0 25px' }} gap="22px">
                <Typography variant="main/small/grey">{category}</Typography>
                <Stack>
                    <Typography variant="main/small/grey">{calcTime(createdAt)}</Typography>
                    <Stack direction="row" alignItems="center" gap="5px">
                        <Heart color={palette.error[500]} size={16} weight="fill" />
                        <Typography variant="main/small/grey">{like}</Typography>
                    </Stack>
                </Stack>
            </Stack>
            <Stack flex={1} gap="10px">
                <Typography sx={{ fontSize: '22px' }}>{title}</Typography>
                <Stack direction="row" gap="15px">
                    <IconWithText
                        icon={<User color={palette.grey[500]} size={16} />}
                        content={`${member.total}/${member.participants}`}
                    />
                    <IconWithText
                        icon={<CalendarBlank color={palette.grey[500]} size={16} />}
                        content={`${createdAt}`}
                    />
                    <IconWithText
                        icon={<ChatCenteredDots color={palette.grey[500]} size={16} />}
                        content={`댓글 ${commentCnt}건`}
                    />
                </Stack>
                <Typography variant="main/small/grey">{content}</Typography>
                <Typography variant="main/small">{projectName}</Typography>
            </Stack>
        </ListItem>
    );
};
