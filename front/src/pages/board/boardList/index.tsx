import { List, MenuItem, Pagination, Select, Stack, TextField, Typography } from '@mui/material';
import { MagnifyingGlass, Trophy } from '@phosphor-icons/react';

import { PageLayout } from '@/components/PageLayout';
import { boardListDummyData, boardListTopThreeDummyData } from '@/const';
import { palette } from '@/themes';

import { BoardListItem } from './components/BoardListItem';
import { PostCard } from './components/PostCard';

export const BoardList = () => {
    return (
        <PageLayout>
            <Stack flex={1} gap="30px">
                <Stack>
                    <Stack direction="row" alignItems="center" gap="10px" sx={{ height: '68px' }}>
                        <Trophy color={palette.grey[500]} size={20} />
                        <Typography>Top 3</Typography>
                    </Stack>
                    <Stack direction="row" gap="63px">
                        {boardListTopThreeDummyData.map((item) => (
                            <PostCard
                                key={item.id}
                                id={item.id}
                                imgSrc={item.imgSrc}
                                title={item.title}
                                subTitle={item.subTitle}
                                member={item.member}
                                createdAt={item.createdAt}
                                commentCnt={item.commentCnt}
                                like={item.like}
                                content={item.content}
                            />
                        ))}
                    </Stack>
                </Stack>
                <Stack direction="row" gap="15px">
                    <Select value={'ALL'}>
                        <MenuItem value="ALL">전체</MenuItem>
                        <MenuItem value="WRITER">글쓴이</MenuItem>
                        <MenuItem value="CONTENT">내용</MenuItem>
                    </Select>
                    <TextField
                        placeholder="검색어 입력"
                        slotProps={{
                            input: {
                                endAdornment: (
                                    <MagnifyingGlass color={palette.grey[500]} size={20} />
                                ),
                            },
                        }}
                    />
                </Stack>
                <Stack>
                    <List disablePadding>
                        {boardListDummyData.map((item) => (
                            <BoardListItem
                                id={item.id}
                                category={item.category}
                                like={item.like}
                                title={item.title}
                                member={item.member}
                                createdAt={item.createdAt}
                                commentCnt={item.commentCnt}
                                content={item.content}
                                projectName={item.projectName}
                            />
                        ))}
                    </List>
                </Stack>
            </Stack>
            <Pagination count={10} page={1} />
        </PageLayout>
    );
};
