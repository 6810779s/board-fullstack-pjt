import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';

import { Button, List, Pagination, Stack, Typography } from '@mui/material';
import { Trophy } from '@phosphor-icons/react';

import { SearchAndSelect } from '@/components/\bsearchAndSelect';
import { PageLayout } from '@/components/PageLayout';
import { boardListDummyData, boardListTopThreeDummyData } from '@/const';
import { palette } from '@/themes';

import { BoardListItem } from './components/BoardListItem';
import { PostCard } from './components/PostCard';

export const BoardList = () => {
    const { control } = useForm<{ selectValue: 'ALL' | 'ONE' | 'TWO'; textValue: string }>({
        defaultValues: { selectValue: 'ALL', textValue: '' },
    });
    const navigate = useNavigate();
    return (
        <PageLayout>
            <Stack flex={1} gap="30px">
                <Stack>
                    <Stack direction="row" justifyContent="space-between" alignItems="center">
                        <Stack
                            direction="row"
                            alignItems="center"
                            gap="10px"
                            sx={{ height: '68px' }}
                        >
                            <Trophy color={palette.grey[500]} size={20} />
                            <Typography>Top 3</Typography>
                        </Stack>
                        <Button onClick={() => navigate('/board-register')}>글쓰기</Button>
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
                <SearchAndSelect
                    selectName="selectValue"
                    textFieldName="textValue"
                    control={control}
                    select_list={[
                        { value: 'ALL', label: '전체' },
                        { value: 'ONE', label: '하나' },
                        { value: 'TWO', label: '둘' },
                    ]}
                />
                <Stack>
                    <List disablePadding>
                        {boardListDummyData.map((item) => (
                            <BoardListItem
                                key={`boardList-${item.id}`}
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
