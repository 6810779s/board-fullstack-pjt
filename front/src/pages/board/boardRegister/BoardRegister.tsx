import React from 'react';

import { Controller, FormProvider, SubmitHandler, useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';

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
import { useQueryClient } from '@tanstack/react-query';

import { QUERY_KEYS } from '@/apis/QueryKeys';
import { PostCreateBoardReq, usePostCreateBoard } from '@/apis/board/usePostCreateBoard';
import { useGetCategory } from '@/apis/category/useGetCategory';
import { PageLayout } from '@/components/PageLayout';
import { Editor } from '@/pages/board/boardRegister/components/editor/editor';
import { palette } from '@/themes';

import { RequiredTitle } from './components/RequiredTitle';

const StackStyle = styled(Stack)({
    flexDirection: 'row',
    alignItems: 'center',
    gap: '20px',
});
export type TBoardCreate = Omit<PostCreateBoardReq, 'category_id'> & {
    category_id: number | '';
};
export const BoardRegister = () => {
    const methods = useForm<TBoardCreate>({
        defaultValues: {
            title: '',
            project_name: '',
            participant_limit: 0,
            content: '',
            category_id: '',
            rating: null,
            thumbnail_file: null,
        },
    });
    const navigate = useNavigate();
    const queryClient = useQueryClient();
    const { mutateAsync: createBoard } = usePostCreateBoard();
    const { data: categoryList } = useGetCategory();
    // const [selectedFile, setSelectedFile] = React.useState<File | null>(null);
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
            methods.setValue('thumbnail_file', file);
            console.log({ file });
            previewImage(file); // 미리보기 이미지 설정
        }
    };
    const submitCreateBoard: SubmitHandler<TBoardCreate> = (data) => {
        console.log({ data });
        const formData = new FormData();
        formData.append('title', data.title);
        formData.append('project_name', data.project_name);
        formData.append('participant_limit', data.participant_limit.toString());
        formData.append('content', data.content);
        formData.append('rating', data.rating ? data.rating.toString() : '0');
        formData.append('category_id', data.category_id ? data.category_id.toString() : '0');
        if (data.thumbnail_file instanceof File) {
            formData.append('thumbnail_file', data.thumbnail_file);
        }

        createBoard(formData).then((res) => {
            if (res?.data?.status === 'SUCCESS') {
                queryClient.invalidateQueries({ queryKey: QUERY_KEYS.BOARD.all() });
                navigate('/board-list');
            }
        });
    };

    return (
        <PageLayout gap="30px">
            <FormProvider {...methods}>
                <form onSubmit={methods.handleSubmit(submitCreateBoard)}>
                    <Stack direction="row" alignItems="center" gap="10px" justifyContent="flex-end">
                        <Button variant="WhiteContainedBlackOutlined">취소</Button>
                        <Button type="submit">등록</Button>
                    </Stack>
                    <Stack gap="37px">
                        <StackStyle direction="row" alignItems="center">
                            <RequiredTitle title="카테고리" required={false} />
                            <Controller
                                name="category_id"
                                control={methods.control}
                                render={({ field }) => (
                                    <Select
                                        {...field}
                                        sx={{ width: '395px' }}
                                        displayEmpty
                                        renderValue={(value) => {
                                            if (!value)
                                                return <Typography>선택되지 않음</Typography>;
                                            const selectedItem = categoryList?.find(
                                                (item) => item.category_id === value
                                            );
                                            return (
                                                <Typography>
                                                    {selectedItem
                                                        ? selectedItem.name
                                                        : '선택되지 않음'}
                                                </Typography>
                                            );
                                        }}
                                    >
                                        {categoryList?.map((item) => (
                                            <MenuItem
                                                key={item.category_id}
                                                value={item.category_id}
                                            >
                                                {item.name}
                                            </MenuItem>
                                        ))}
                                    </Select>
                                )}
                            />
                        </StackStyle>
                        <StackStyle>
                            <RequiredTitle title="모집 인원 수" required={true} />
                            <Controller
                                name="participant_limit"
                                control={methods.control}
                                render={({ field }) => (
                                    <TextField {...field} placeholder="1이상 100이하" />
                                )}
                            />
                        </StackStyle>
                        <StackStyle>
                            <RequiredTitle title="프로젝트 명" required={true} />
                            <Controller
                                name="project_name"
                                control={methods.control}
                                render={({ field }) => (
                                    <TextField
                                        {...field}
                                        fullWidth
                                        placeholder="프로젝트 명을 입력해 주세요."
                                    />
                                )}
                            />
                        </StackStyle>
                        <StackStyle direction="row" alignItems="center">
                            <RequiredTitle title="제목" required={true} />
                            <Controller
                                name="title"
                                control={methods.control}
                                render={({ field }) => (
                                    <TextField
                                        {...field}
                                        fullWidth
                                        placeholder="제목을 입력해 주세요."
                                    />
                                )}
                            />
                        </StackStyle>
                        <StackStyle direction="row">
                            <RequiredTitle title="내용" required={true} />
                            <Editor />
                        </StackStyle>
                        <Stack gap="12px">
                            <Stack
                                direction="row"
                                alignItems="center"
                                alignSelf="flex-start"
                                gap="20px"
                            >
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
                                                onClick={() => {
                                                    setPreviewUrl('');
                                                    // setSelectedFile(null);
                                                    console.log('??');
                                                }}
                                                sx={{
                                                    position: 'absolute',
                                                    zIndex: 999,
                                                    right: 0,
                                                    top: 0,
                                                }}
                                            >
                                                <X
                                                    weight="fill"
                                                    color={palette.grey[300]}
                                                    size={18}
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

                                                color: previewUrl
                                                    ? 'transparent'
                                                    : palette.text.main,
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
                </form>
            </FormProvider>
        </PageLayout>
    );
};
