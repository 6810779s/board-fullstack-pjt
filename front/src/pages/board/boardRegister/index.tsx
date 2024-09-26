import { Button, MenuItem, Select, Stack, TextField, Typography, styled } from '@mui/material';
import { FileArrowDown } from '@phosphor-icons/react';

import { PageLayout } from '@/components/PageLayout';
import { Tag } from '@/components/Tag';
import { Editor } from '@/components/editor';
import { palette } from '@/themes';

import { RequiredTitle } from './components/RequiredTitle';

const TypographyStyle = styled(Typography)({
    width: '86px',
    fontWeight: 600,
    fontSize: '14px',
});
const StackStyle = styled(Stack)({
    flexDirection: 'row',
    alignItems: 'center',
    gap: '20px',
});
export const BoardRegister = () => {
    return (
        <PageLayout gap="30px">
            <Stack direction="row" alignItems="center" gap="10px" justifyContent="flex-end">
                <Button variant="WhiteContainedBlackOutlined">취소</Button>
                <Button>등록</Button>
            </Stack>
            <Stack gap="37px">
                <StackStyle direction="row" alignItems="center">
                    <RequiredTitle title="카테고리" required={false} />
                    <Select
                        sx={{ width: '395px' }}
                        displayEmpty
                        value=""
                        renderValue={(value) => {
                            const newValue = value as string;
                            if (newValue === '') return <Typography>선택되지 않음</Typography>;
                            return <Typography>{newValue}</Typography>;
                        }}
                    >
                        <MenuItem value="value1">value1</MenuItem>
                        <MenuItem value="value2">value2</MenuItem>
                        <MenuItem value="value3">value3</MenuItem>
                    </Select>
                </StackStyle>
                <StackStyle direction="row" alignItems="center">
                    <RequiredTitle title="제목" required={true} />
                    <TextField fullWidth placeholder="제목을 입력해 주세요." />
                </StackStyle>
                <StackStyle direction="row">
                    <RequiredTitle title="내용" required={true} />
                    <Editor />
                </StackStyle>
                <Stack gap="12px">
                    <Stack direction="row" alignItems="center" gap="20px">
                        <TypographyStyle>이미지 첨부</TypographyStyle>
                        <Stack direction="row" alignItems="center" gap="16px">
                            <Button
                                variant="WhiteContainedBlackOutlined"
                                endIcon={<FileArrowDown color={palette.grey[500]} />}
                                sx={{ padding: '8px 12px' }}
                            >
                                대표 이미지 선택
                            </Button>
                            <Typography></Typography>
                        </Stack>
                    </Stack>
                    <Stack direction="row" alignItems="center" gap="16px">
                        <Stack sx={{ width: '90px' }} />
                        <Tag
                            label="첨부파일 로딩중 로딩중 로딩..."
                            sx={{ background: palette.common.white }}
                            onDelete={() => {}}
                        />
                    </Stack>
                </Stack>
            </Stack>
        </PageLayout>
    );
};
