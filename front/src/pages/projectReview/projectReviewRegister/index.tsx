import { useForm } from 'react-hook-form';

import {
    Button,
    Chip,
    MenuItem,
    Rating,
    Select,
    Stack,
    TextField,
    Typography,
} from '@mui/material';
import { Image } from '@phosphor-icons/react';

import { PageLayout } from '@/components/PageLayout';
import { TextfieldWithBtn } from '@/components/TextfieldBtn';
import { palette } from '@/themes';

import { Label } from '../projectReviewRegister/components/Label';

export const ProjectReviewRegister = () => {
    const { register } = useForm();
    return (
        <PageLayout alignItems="center">
            <Stack flex={1} gap="40px" sx={{ width: '770px' }}>
                <Stack gap="40px">
                    <Label title="프로젝트 명">
                        <TextField
                            {...register('projectName')}
                            placeholder="프로젝트 명을 입력해 주세요."
                        />
                    </Label>
                    <Label title="별점">
                        <Rating name="review-controlled" />
                    </Label>
                    <Label title="프로젝트 설명">
                        <TextField
                            multiline={true}
                            rows={5}
                            placeholder="프로젝트에 대한 설명을 작성해 주세요."
                        />
                    </Label>
                    <Label title="기술 스택">
                        <Stack gap="10px">
                            <TextfieldWithBtn
                                variant="outlined"
                                onClick={() => {}}
                                width="100%"
                                placeholder="기술 스택"
                            />
                            <Stack direction="row" flexWrap="wrap" gap="10px">
                                <Chip label="JAVA" onDelete={() => {}} />
                            </Stack>
                        </Stack>
                    </Label>
                    <Label title="참여 인원">
                        <Select
                            value=""
                            displayEmpty
                            renderValue={(value) => {
                                const newValue = value as string;
                                if (newValue === '') {
                                    return (
                                        <Typography color={palette.grey[400]}>
                                            프로젝트에 참여한 인원을 추가해 주세요.
                                        </Typography>
                                    );
                                }
                                return <Typography>{newValue}</Typography>;
                            }}
                        >
                            <MenuItem></MenuItem>
                        </Select>
                    </Label>
                    <Label title="프로젝트 URL">
                        <TextfieldWithBtn
                            onClick={() => {}}
                            placeholder="프로젝트와 연관된 URL을 등록하세요."
                            width="100%"
                            variant="outlined"
                        />
                    </Label>
                    <Label title="프로젝트 이미지">
                        <Stack
                            justifyContent="center"
                            alignItems="center"
                            sx={{ height: '180px', border: `1px dotted ${palette.grey[500]}` }}
                            gap="7px"
                        >
                            <Image size={26} color={palette.grey[500]} />
                            <Typography color={palette.grey[500]}>Drag files to upload</Typography>
                            <Button sx={{ width: '150px' }}>Choose File</Button>
                        </Stack>
                    </Label>
                </Stack>
                <Stack direction="row" gap="12px">
                    <Button variant="WhiteContainedBlackOutlined" sx={{ flex: 1 }}>
                        초기화
                    </Button>
                    <Button sx={{ flex: 1 }}>저장</Button>
                </Stack>
            </Stack>
        </PageLayout>
    );
};
