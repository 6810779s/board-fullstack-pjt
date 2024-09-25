import React from 'react';

import { useNavigate } from 'react-router-dom';

import { Button, Stack, Typography } from '@mui/material';

import { ProjectReviewCard } from '@/components/ProjectReviewCard';

export const ProjectReview = () => {
    const navigate = useNavigate();
    const [login, setLogin] = React.useState<boolean>(false);
    return (
        <Stack direction="row" sx={{ padding: '60px 0' }}>
            <Stack justifyContent="center" gap="24px" flex={1}>
                <Typography sx={{ fontWeight: 700, fontSize: '40px' }}>프로젝트 리뷰</Typography>
                <Typography>완료한 프로젝트에 대한 리뷰를 볼 수 있어요.</Typography>
                <Button sx={{ width: '240px' }} onClick={() => navigate('/project-review-list')}>
                    프로젝트 리뷰 더보기
                </Button>
            </Stack>

            <Stack flex={1} sx={{ position: 'relative' }}>
                {!login && (
                    <Button
                        sx={{
                            position: 'absolute',
                            transform: 'translate(-50%,-50%)',
                            top: '50%',
                            left: '50%',
                            zIndex: 999,
                        }}
                        onClick={() => setLogin(!login)}
                        variant="WhiteContainedBlackOutlined"
                    >
                        로그인 하러 가기
                    </Button>
                )}
                <Stack direction="row" gap="40px" sx={{ filter: login ? 'none' : 'blur(10px)' }}>
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
        </Stack>
    );
};
