import { useNavigate } from 'react-router-dom';

import { Button, Stack, Typography } from '@mui/material';

import { ProjectReviewCard } from '@/components/ProjectReviewCard';

export const ProjectReview = () => {
    const navigate = useNavigate();
    return (
        <Stack direction="row" sx={{ padding: '60px 0' }}>
            <Stack justifyContent="center" gap="24px" flex={1}>
                <Typography sx={{ fontWeight: 700, fontSize: '40px' }}>프로젝트 리뷰</Typography>
                <Typography>완료한 프로젝트에 대한 리뷰를 볼 수 있어요.</Typography>
                <Button sx={{ width: '240px' }} onClick={() => navigate('/project-review-list')}>
                    프로젝트 리뷰 더보기
                </Button>
            </Stack>
            <Stack direction="row" gap="40px" flex={1}>
                <ProjectReviewCard
                    imgSrc={'/src/assets/book_img.svg'}
                    title="자바 실시간 채팅 프로그램"
                    starCnt={3}
                    member={3}
                    startDate="2024.05.02"
                    endDate="2024.06.07"
                    commentCnt={5}
                    hashTags={['JAVA', 'Spring', 'React']}
                />
                <ProjectReviewCard
                    imgSrc={'/src/assets/code_img.svg'}
                    title="자바 실시간 채팅 프로그램"
                    starCnt={3}
                    member={3}
                    startDate="2024.05.02"
                    endDate="2024.06.07"
                    commentCnt={5}
                    hashTags={['JAVA', 'Spring', 'React']}
                />
            </Stack>
        </Stack>
    );
};
