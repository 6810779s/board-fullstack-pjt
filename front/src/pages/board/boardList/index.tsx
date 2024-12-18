import React from 'react';

import { SubmitHandler, useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';

import { Button, List, Pagination, Stack, Typography } from '@mui/material';
import { Trophy } from '@phosphor-icons/react';

import { useGetBoard } from '@/apis/home/useGetBoard';
import { useGetBoardPagination } from '@/apis/home/userGetBoardPagination';
import { PageLayout } from '@/components/PageLayout';
import { SearchAndSelect } from '@/components/searchAndSelect';
import { palette } from '@/themes';
import { TSearchFilter, TSearchType } from '@/types/pagination';

import { BoardListItem } from './components/BoardListItem';
import { PostCard } from './components/PostCard';

export const BoardList = () => {
    const methods = useForm<TSearchFilter>({
        defaultValues: {
            searchType: 'ALL',
            keyword: '',
        },
    });
    const [page, setPage] = React.useState<number>(0);
    const { data: boardTopList } = useGetBoard({ limit: 3 });
    const [keyword, setKeyword] = React.useState<string>('');
    const [searchType, setSearchType] = React.useState<TSearchType>('ALL');
    const { data: boardPageList } = useGetBoardPagination({
        page,
        pageSize: 10,
        keyword,
        searchType,
    });

    const onSubmit: SubmitHandler<TSearchFilter> = (data) => {
        setKeyword(data.keyword);
        setSearchType(data.searchType);
    };

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
                        {boardTopList?.map((item) => (
                            <PostCard
                                key={item.board_id}
                                id={item.board_id}
                                imgSrc={item.main_image_path}
                                title={item.title}
                                projectName={item.project_name}
                                participantCnt={item.participant_cnt}
                                participantLimit={item.participant_limit}
                                createdAt={item.created_at}
                                commentCnt={item.comment_cnt}
                                like={item.like_cnt}
                                content={item.content}
                            />
                        ))}
                    </Stack>
                </Stack>
                <SearchAndSelect
                    methods={methods}
                    onSubmit={onSubmit}
                    select_list={[
                        { value: 'ALL', label: '전체' },
                        { value: 'TITLE', label: '제목' },
                        { value: 'CONTENT', label: '내용' },
                        { value: 'PROJECT_NAME', label: '프로젝트 명' },
                    ]}
                />
                <Stack>
                    <List disablePadding>
                        {boardPageList?.contents.map((item) => (
                            <BoardListItem
                                key={`boardList-${item.board_id}`}
                                id={item.board_id}
                                category={item.category_name}
                                like={item.like_cnt}
                                title={item.title}
                                participantCnt={item.participant_cnt}
                                participantLimit={item.participant_limit}
                                createdAt={item.created_at}
                                commentCnt={item.comment_cnt}
                                content={item.content}
                                projectName={item.project_name}
                            />
                        ))}
                    </List>
                </Stack>
            </Stack>
            <Pagination
                count={boardPageList?.totalPages || 1}
                page={page + 1}
                onChange={(_e, value) => {
                    setPage(value - 1);
                }}
            />
        </PageLayout>
    );
};
