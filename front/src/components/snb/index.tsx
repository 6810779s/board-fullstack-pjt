import React from 'react';

import { useNavigate } from 'react-router-dom';

import {
    Box,
    List,
    ListItem,
    ListItemButton,
    ListItemIcon,
    Stack,
    Typography,
} from '@mui/material';
import {
    ChatCircleText,
    ClockCounterClockwise,
    Gear,
    ProjectorScreenChart,
    SignOut,
    Star,
    User,
    UsersThree,
} from '@phosphor-icons/react';

import { palette } from '@/themes';

interface SNBProps {
    setOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

export const SNB: React.FC<SNBProps> = ({ setOpen }) => {
    const SNB_MENU = [
        {
            category: '게시판',
            children: [
                {
                    category: '프로젝트 리뷰',
                    path: '/project-review-list',
                    icon: <Star color={palette.grey[500]} size={16} />,
                },
                {
                    category: '팀원 구하기',
                    path: '/board-list',
                    icon: <User color={palette.grey[500]} size={16} />,
                },
            ],
        },
        {
            category: '마이페이지',
            children: [
                {
                    category: '활동내역',
                    path: '/my-page?page=active-history',
                    icon: <ClockCounterClockwise color={palette.grey[500]} size={16} />,
                },
                {
                    category: '친구목록',
                    path: '/my-page?page=friend-list',
                    icon: <UsersThree color={palette.grey[500]} size={16} />,
                },
                {
                    category: '피드백',
                    path: '/my-page?page=feedback',
                    icon: <ChatCircleText color={palette.grey[500]} size={16} />,
                },
                {
                    category: '프로젝트 리뷰',
                    path: '/my-page?page=project-review',
                    icon: <ProjectorScreenChart color={palette.grey[500]} size={16} />,
                },
                {
                    category: 'setting',
                    path: '/my-page?page=setting',
                    icon: <Gear color={palette.grey[500]} size={16} />,
                },
                {
                    category: '로그아웃',
                    path: '/login',
                    icon: <SignOut color={palette.grey[500]} size={16} />,
                },
            ],
        },
    ];
    const navigate = useNavigate();
    return (
        <Box
            sx={{ width: '320px', padding: '60px 0' }}
            role="presentation"
            onClick={() => setOpen(false)}
        >
            <Stack>
                {SNB_MENU.map((item, index) => (
                    <Stack key={`${item.category}-${index}`}>
                        <Typography
                            sx={{
                                height: '45px',
                                paddingLeft: '15px',
                                fontSize: '18px',
                                fontWeight: 700,
                                borderBottom: `1px solid ${palette.grey[200]}`,
                            }}
                        >
                            {item.category}
                        </Typography>
                        <List>
                            {item.children.map((child, index) => (
                                <ListItem
                                    key={`${child.category}-${index}`}
                                    disablePadding
                                    sx={{
                                        height: '45px',
                                    }}
                                >
                                    <ListItemButton
                                        onClick={() => navigate(child.path)}
                                        sx={{
                                            'width': '100%',
                                            'height': '100%',
                                            'padding': '15px',
                                            '&:hover': {
                                                background: palette.grey[200],
                                                cursor: 'pointer',
                                            },
                                        }}
                                    >
                                        <ListItemIcon
                                            sx={{ minWidth: 'fit-content', marginRight: '10px' }}
                                        >
                                            {child.icon}
                                        </ListItemIcon>
                                        <Typography>{child.category}</Typography>
                                    </ListItemButton>
                                </ListItem>
                            ))}
                        </List>
                    </Stack>
                ))}
            </Stack>
        </Box>
    );
};
