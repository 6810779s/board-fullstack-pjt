import Slider from 'react-slick';

import { Button, Chip, Pagination, Rating, Stack, TextField, Typography } from '@mui/material';
import { CalendarBlank, ChatCircleText, User } from '@phosphor-icons/react';

import { IconWithText } from '@/components/IconWithText';
import { OtherBoards } from '@/components/OtherBoards';
import { PageLayout } from '@/components/PageLayout';
import { Tag } from '@/components/Tag';
import { CommentContainer } from '@/components/comment/CommentContainer';
import { boardDetailDummyData } from '@/const';
// import { settings } from '@/const';
import UserProfile from '@/pages/board/boardDetail/components/UserProfile';
import { palette } from '@/themes';

import { Label } from './components/Label';

export const ProjectReviewDetail = () => {
    let post = true;
    const settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
    };
    post = false;
    return (
        <PageLayout alignItems="center">
            <Stack flex={1} gap="15px" sx={{ width: '770px' }}>
                <Typography sx={{ fontWeight: 700, fontSize: '25px' }}>Title</Typography>
                <Stack direction="row" gap="8px">
                    <Typography color={palette.error[500]}>1.0</Typography>
                    <Rating value={1} />
                </Stack>
                <Stack
                    direction="row"
                    gap="15px"
                    sx={{ height: '44px', borderBottom: `1px solid ${palette.grey[500]}` }}
                >
                    <IconWithText icon={<User color={palette.grey[500]} size={16} />} content="3" />
                    <IconWithText
                        icon={<CalendarBlank color={palette.grey[500]} size={16} />}
                        content="2024.08.25 17:35"
                    />
                    <IconWithText
                        icon={<ChatCircleText color={palette.grey[500]} size={16} />}
                        content="댓글 3건"
                    />
                </Stack>
                <Stack gap="40px">
                    <Label title="Description">
                        <Typography>멀티 채팅 프로그램 이에요~~~~</Typography>
                    </Label>
                    <Label title="Stack">
                        <Stack direction="row" flexWrap="wrap" gap="10px">
                            {Array.from({ length: 5 }).map((_, index) => (
                                <Chip key={index} label="JAVA" />
                            ))}
                        </Stack>
                    </Label>
                    <Label title="URL">
                        <Stack gap="5px" sx={{ maxHeight: '82px', overflowY: 'scroll' }}>
                            <Tag label="https://naver.com" />
                            <Tag label="https://board-full-pjt.com" />
                            <Tag label="https://eunhee-pjt.co.kr" />
                        </Stack>
                    </Label>
                    <Label title="Member">
                        <Stack>
                            <UserProfile />
                            <UserProfile />
                            <UserProfile />
                            <Pagination count={2} page={1} />
                        </Stack>
                    </Label>
                    <Label title="Image">
                        <Stack
                            sx={{
                                'padding': '0 20px',
                                'button': { '&::before': { color: palette.grey[500] } },
                                '.slick-slider': { height: '421px' },
                                '.slick-dots': {
                                    height: '26px',
                                    bottom: 0,
                                },
                            }}
                        >
                            <Slider {...settings}>
                                <Stack>
                                    <img
                                        src="/src/assets/sky.svg"
                                        alt="book_img"
                                        style={{ width: '100%', height: '100%' }}
                                    />
                                </Stack>
                                <Stack>
                                    <img
                                        src="/src/assets/book_img.svg"
                                        alt="book_img"
                                        style={{ width: '100%', height: '100%' }}
                                    />
                                </Stack>
                            </Slider>
                        </Stack>
                    </Label>
                </Stack>
                <Stack direction="row" gap="45px">
                    {post ? (
                        <OtherBoards type="prev" title={'Prev Pjt Review'} />
                    ) : (
                        <Stack flex={1} sx={{ height: '64px' }} />
                    )}
                    {!post ? (
                        <OtherBoards type="next" title={'Next Pjt Review'} />
                    ) : (
                        <Stack flex={1} sx={{ height: '64px' }} />
                    )}
                </Stack>
                <Stack gap="20px">
                    <TextField multiline={true} rows={5} placeholder="댓글을 입력해 주세요." />
                    <Stack flex={1} alignItems="flex-end">
                        <Button sx={{ width: '97px' }}>댓글 작성</Button>
                    </Stack>
                    {boardDetailDummyData.comment.commentsArr.map((item) => (
                        <CommentContainer
                            key={item.id}
                            nickname={item.nickname}
                            content={item.content}
                            replyComment={item.replyComment}
                            createdAt={item.createdAt}
                            like={item.like}
                        />
                    ))}
                </Stack>
            </Stack>
        </PageLayout>
    );
};
