import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';

import { Button, Stack, Typography } from '@mui/material';
import { Clock, Fire } from '@phosphor-icons/react';

import { SearchAndSelect } from '@/components/\bsearchAndSelect';
import { IconWithText } from '@/components/IconWithText';
import { PageLayout } from '@/components/PageLayout';
import { ProjectReviewCard } from '@/components/ProjectReviewCard';
import { projectReview } from '@/const';
import { palette } from '@/themes';

export const ProjectReviewList = () => {
    const { control } = useForm<{ selectValue: 'ALL' | 'WRITER' | 'TITLE'; textValue: string }>({
        defaultValues: { selectValue: 'ALL', textValue: '' },
    });
    const navigate = useNavigate();

    return (
        <PageLayout gap="60px">
            <Stack gap="24px" justifyContent="center" alignItems="center">
                <Typography sx={{ fontSize: '40px', fontWeight: 700 }}>Project Reviews</Typography>
                <Typography>다른 개발자들과 구현한 프로젝트를 공유해보세요.</Typography>
                <Button sx={{ width: '240px' }} onClick={() => navigate('/project-register')}>
                    Write a Review
                </Button>
            </Stack>
            <SearchAndSelect
                control={control}
                selectName="selectValue"
                textFieldName="textValue"
                select_list={[
                    { value: 'ALL', label: '전체' },
                    { value: 'WRITER', label: '글쓴이' },
                    { value: 'TITLE', label: '제목' },
                ]}
            />
            <Stack gap="40px" flex={1}>
                <IconWithText
                    icon={<Fire weight="fill" color={palette.error[500]} />}
                    content="Hot Review"
                    color={palette.text.main}
                    fontSize={20}
                />
                <Stack gap="63px" direction="row" flexWrap="wrap">
                    {projectReview.slice(0, 3).map((item, index) => {
                        return (
                            <ProjectReviewCard
                                key={`card-review-${index}`}
                                minWidth="calc(33.33% - 63px)"
                                imgSrc={item.imgSrc}
                                title={item.title}
                                starCnt={item.starCnt}
                                member={item.member}
                                startDate={item.startDate}
                                endDate={item.endDate}
                                commentCnt={item.commentCnt}
                                hashTags={item.hashTags}
                            />
                        );
                    })}
                    {Array.from({ length: (3 - (projectReview.length % 3)) % 3 }).map(
                        (_, index) => (
                            <Stack key={`empty-space-${index}`} flex={1} width="33.33%" />
                        )
                    )}
                </Stack>
            </Stack>
            <Stack gap="40px" flex={1}>
                <IconWithText
                    icon={<Clock color={palette.grey[500]} size={20} />}
                    content="Recent"
                    color={palette.text.main}
                    fontSize={20}
                />
                <Stack gap="63px" direction="row" flexWrap="wrap">
                    {projectReview.map((item, index) => {
                        return (
                            <ProjectReviewCard
                                key={`card-review-${index}`}
                                minWidth="calc(33.33% - 63px)"
                                imgSrc={item.imgSrc}
                                title={item.title}
                                starCnt={item.starCnt}
                                member={item.member}
                                startDate={item.startDate}
                                endDate={item.endDate}
                                commentCnt={item.commentCnt}
                                hashTags={item.hashTags}
                            />
                        );
                    })}
                    {Array.from({ length: (3 - (projectReview.length % 3)) % 3 }).map(
                        (_, index) => (
                            <Stack key={`empty-space-${index}`} flex={1} width="33.33%" />
                        )
                    )}
                </Stack>
            </Stack>
        </PageLayout>
    );
};
