import React from 'react';

import { Box, Stack, Tab, Tabs } from '@mui/material';
import { ChatCircleText, ClipboardText, ClockCounterClockwise, Heart } from '@phosphor-icons/react';

import { IconWithText } from '@/components/IconWithText';
import { NoBoard } from '@/components/NoBoard';
import { palette } from '@/themes';

import { IconWithInfo } from '../components/IconWithInfo';
import { TabPanel } from './TabPanel';
import { TableComponent, TableComponentProps } from './TableComponent';

export const ActiveHistory = () => {
    const [value, setValue] = React.useState<number>(0);
    const dummy_board_data: TableComponentProps = {
        columns: [
            { id: 'title', label: '제목', width: 461, align: 'left' },
            { id: 'date', label: '날짜', width: 200 },
            { id: 'comment', label: '댓글', width: 109 },
        ],
        rows: [
            {
                title: '1제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                comment: '99',
            },
            {
                title: '2제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                comment: '11',
            },
            {
                title: '3제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                comment: '13',
            },
        ],
    };
    const dummy_comment_data: TableComponentProps = {
        columns: [
            { id: 'title', label: '제목', width: 461, align: 'left' },
            { id: 'date', label: '날짜', width: 200 },
            { id: 'like', label: '공감', width: 109 },
        ],
        rows: [
            {
                title: '1제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                like: '99',
            },
            {
                title: '2제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                like: '11',
            },
            {
                title: '3제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                like: '13',
            },
        ],
    };
    const dummy_like_data: TableComponentProps = {
        columns: [
            { id: 'title', label: '제목', width: 461, align: 'left' },
            { id: 'date', label: '날짜', width: 200 },
            { id: 'comment', label: '댓글', width: 109 },
        ],
        rows: [
            {
                title: '1제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                comment: '99',
            },
            {
                title: '2제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                comment: '11',
            },
            {
                title: '3제목이 어쩌고, 저쩌고 이래라 저래라 입니다.제목',
                date: '2024.09.02',
                comment: '13',
            },
        ],
    };
    return (
        <Stack flex={1}>
            <Box>
                <Stack
                    direction="row"
                    justifyContent="space-between"
                    sx={{
                        borderBottom: `1px solid ${palette.common.black}`,
                        padding: '10px 0',
                    }}
                >
                    <IconWithText
                        icon={<ClockCounterClockwise size={20} color={palette.grey[500]} />}
                        content="My History"
                        fontSize={20}
                        fontWeight={700}
                        color={palette.text.main}
                    />
                </Stack>
                <Stack
                    direction="row"
                    alignItems="center"
                    justifyContent="space-between"
                    sx={{ padding: '24px 0' }}
                >
                    <IconWithInfo
                        icon={<ClipboardText size={55} color={palette.grey[500]} />}
                        content="작성한 게시글"
                        num={35}
                    />
                    <IconWithInfo
                        icon={<ChatCircleText size={55} color={palette.grey[500]} />}
                        content="작성한 댓글"
                        num={35}
                    />
                    <IconWithInfo
                        icon={<Heart size={55} color={palette.grey[500]} />}
                        content="공감"
                        num={35}
                    />
                </Stack>
            </Box>
            <Box>
                <Tabs
                    value={value}
                    onChange={(_e, newValue: number) => setValue(newValue)}
                    sx={{ borderBottom: `1px solid ${palette.grey[300]}` }}
                >
                    <Tab label="작성한 게시글" value={0} />
                    <Tab label="작성한 댓글" value={1} />
                    <Tab label="공감한 게시글" value={2} />
                </Tabs>
                <TabPanel
                    value={value}
                    index={0}
                    icon={<ClipboardText size={20} color={palette.grey[500]} />}
                    content="내 게시글"
                >
                    {dummy_board_data.rows.length > 0 ? (
                        <TableComponent
                            columns={dummy_board_data.columns}
                            rows={dummy_board_data.rows}
                        />
                    ) : (
                        <Stack height="240px">
                            <NoBoard content="작성된 게시글이 없습니다." />
                        </Stack>
                    )}
                </TabPanel>
                <TabPanel
                    value={value}
                    index={1}
                    icon={<ChatCircleText size={20} color={palette.grey[500]} />}
                    content="내 댓글"
                >
                    <TableComponent
                        columns={dummy_comment_data.columns}
                        rows={dummy_comment_data.rows}
                    />
                </TabPanel>
                <TabPanel
                    value={value}
                    index={2}
                    icon={<Heart size={20} color={palette.grey[500]} />}
                    content="내가 공감한 게시글"
                >
                    <TableComponent columns={dummy_like_data.columns} rows={dummy_like_data.rows} />
                </TabPanel>
            </Box>
        </Stack>
    );
};
