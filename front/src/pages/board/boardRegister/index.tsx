import { Button, MenuItem, Select, Stack, TextField, Typography, styled } from '@mui/material';

import { PageLayout } from '@/components/PageLayout';
import { Tag } from '@/components/Tag';

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
                    <TypographyStyle>카테고리</TypographyStyle>
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
                    <TypographyStyle>제목</TypographyStyle>
                    <TextField fullWidth placeholder="제목을 입력해 주세요." />
                </StackStyle>
                <StackStyle direction="row" alignItems="center">
                    <TypographyStyle>내용</TypographyStyle>
                    <TextField />
                </StackStyle>
                <StackStyle direction="row" alignItems="center">
                    <TypographyStyle>파일첨부</TypographyStyle>
                    <TextField />
                </StackStyle>
                {/* 첨부된 파일들 */}
                <StackStyle direction="row" alignItems="center" gap="16px">
                    <Tag label="첨부파일 1" onDelete={() => {}} />
                    <Tag label="첨부파일 1" onDelete={() => {}} />
                    <Tag label="첨부파일 1" onDelete={() => {}} />
                </StackStyle>
            </Stack>
        </PageLayout>
    );
};
