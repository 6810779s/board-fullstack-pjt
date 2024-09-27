import React from 'react';

import {
    Button,
    IconButton,
    MenuItem,
    Select,
    Stack,
    TextField,
    Typography,
    styled,
} from '@mui/material';
import { X } from '@phosphor-icons/react';

import { PageLayout } from '@/components/PageLayout';
import { Editor } from '@/pages/board/boardRegister/components/editor/editor';
import { palette } from '@/themes';

import { RequiredTitle } from './components/RequiredTitle';

const StackStyle = styled(Stack)({
    flexDirection: 'row',
    alignItems: 'center',
    gap: '20px',
});
export const BoardRegister = () => {
    const [selectedFile, setSelectedFile] = React.useState<File | null>(null);
    const [previewUrl, setPreviewUrl] = React.useState<string | null>(null);
    const fileInputRef = React.useRef<HTMLInputElement | null>(null);
    const handleButtonClick = () => {
        fileInputRef.current?.click(); // input 요소 클릭
    };
    // 선택한 이미지 미리보기 설정
    const previewImage = (file: File) => {
        const reader = new FileReader();
        reader.onloadend = () => {
            setPreviewUrl(reader.result as string); // 이미지 미리보기 URL 설정
        };
        reader.readAsDataURL(file);
    };
    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const file = event.target.files?.[0];
        if (file) {
            setSelectedFile(file);
            previewImage(file); // 미리보기 이미지 설정
        }
        console.log({ selectedFile });
    };

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
                    <Stack direction="row" alignItems="center" alignSelf="flex-start" gap="20px">
                        <RequiredTitle title="이미지 첨부" required={true} />
                        <Stack direction="row" alignItems="center" gap="16px">
                            <input
                                type="file"
                                accept="image/*"
                                onChange={handleFileChange}
                                style={{ display: 'none' }} // input 요소 숨김
                                ref={fileInputRef} // ref를 통해 input 요소를 참조
                            />
                            <Stack
                                sx={{
                                    width: '168px',
                                    height: '168px',
                                    border: `1px solid ${palette.grey[200]}`,
                                    position: 'relative',
                                }}
                                alignItems="center"
                                justifyContent="center"
                            >
                                {previewUrl && (
                                    <IconButton
                                        sx={{ position: 'absolute', zIndex: 999, right: 0, top: 0 }}
                                    >
                                        <X
                                            weight="fill"
                                            color={palette.grey[300]}
                                            size={18}
                                            onClick={() => {
                                                setPreviewUrl('');
                                                setSelectedFile(null);
                                            }}
                                        />
                                    </IconButton>
                                )}
                                {previewUrl && (
                                    <Stack sx={{ padding: '8px', position: 'absolute' }}>
                                        <img
                                            src={previewUrl}
                                            alt="Preview"
                                            style={{
                                                width: '100%',
                                                height: 'auto',
                                            }}
                                        />
                                    </Stack>
                                )}
                                <Button
                                    variant="text"
                                    sx={{
                                        width: '100%',
                                        height: '100%',

                                        color: previewUrl ? 'transparent' : palette.text.main,
                                    }}
                                    onClick={handleButtonClick}
                                >
                                    대표 이미지 선택
                                </Button>
                            </Stack>
                        </Stack>
                    </Stack>
                </Stack>
            </Stack>
        </PageLayout>
    );
};
