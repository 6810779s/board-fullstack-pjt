import { Button, Stack, TextField, Typography } from '@mui/material';

import { Tag } from '@/components/Tag';

export const ParticipantProject = () => {
    const dummyData = ['Web Designer', 'Frontend Developer', 'Project Management', '+5 Skills'];
    return (
        <Stack direction="row">
            <Stack justifyContent="center" flex={1}>
                <Typography sx={{ fontWeight: 700, fontSize: '40px' }}>
                    프로젝트 참여하기
                </Typography>
                <Typography>나만의 양식을 작성하여 팀원을 구해보세요.</Typography>
            </Stack>
            <Stack flex={{ xs: 1.5, lx: 1 }} gap="40px">
                <Stack gap="4px">
                    <Typography sx={{ fontSize: '14px' }}>제목</Typography>
                    <TextField placeholder="제목을 입력하세요" />
                </Stack>
                <Stack>
                    <Typography sx={{ fontSize: '14px' }}>Skills</Typography>
                    <TextField placeholder="보유하고 있는 기술을 등록해보세요." />
                </Stack>
                <Stack direction="row" gap="4px">
                    {dummyData.map((item, index) => (
                        <Tag key={`${item}-${index}`} label={item} />
                    ))}
                </Stack>
                <Button sx={{ width: '240px' }}>제출하기</Button>
            </Stack>
        </Stack>
    );
};
