import React from 'react';

import { useForm } from 'react-hook-form';

import {
    Button,
    Checkbox,
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
import { Tag } from '@/components/Tag';
import { TextfieldWithBtn } from '@/components/TextfieldBtn';
import { palette } from '@/themes';

import { Label } from '../projectReviewRegister/components/Label';
import FileUploadInfo from './components/FileUploadInfo';
import { MenuItemProfile } from './components/MenuItemProfile';
import SelectedUser from './components/SelectedUser';

interface FileUploadInfo {
    file: File;
    progress: number;
    speed: number; // KB/s
    size: number; // MB
}
export const ProjectReviewRegister = () => {
    const fileInputRef = React.useRef<HTMLInputElement | null>(null);
    const { register } = useForm();
    const [filesInfo, setFilesInfo] = React.useState<FileUploadInfo[]>([]);
    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        if (event.target.files) {
            const filesArray = Array.from(event.target.files).map((file) => ({
                file,
                progress: 0,
                speed: 0,
                size: file.size / (1024 * 1024), // Convert bytes to MB
            }));

            setFilesInfo(filesArray);
            filesArray.forEach(uploadFile);
        }
    };
    const uploadFile = (fileInfo: FileUploadInfo) => {
        const formData = new FormData();
        formData.append('file', fileInfo.file);

        const startTime = Date.now();
        console.log({ startTime });
        console.log({ formData });
        // axios.post('/upload', formData, {
        //     headers: {
        //         'Content-Type': 'multipart/form-data',
        //     },
        //     onUploadProgress: (progressEvent) => {
        //         const { loaded, total } = progressEvent;
        //         const progress = Math.round((loaded * 100) / total!);

        //         // Time difference in seconds
        //         const timeElapsed = (Date.now() - startTime) / 1000;
        //         const speed = loaded / 1024 / timeElapsed; // KB/s

        //         setFilesInfo((prevFiles) =>
        //             prevFiles.map((prevFile) =>
        //                 prevFile.file === fileInfo.file
        //                     ? { ...prevFile, progress, speed }
        //                     : prevFile
        //             )
        //         );
        //     },
        // });
    };
    const handleButtonClick = () => {
        fileInputRef.current?.click(); // input 요소 클릭
    };
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
                        <Stack
                            direction="row"
                            alignItems="center"
                            sx={{ padding: '10px 0' }}
                            gap="10px"
                        >
                            <SelectedUser />
                            <SelectedUser />
                            <SelectedUser />
                        </Stack>
                        <Select
                            value={[]}
                            displayEmpty
                            multiple
                            renderValue={(value) => {
                                if (value.length === 0) {
                                    return (
                                        <Typography color={palette.grey[400]}>
                                            프로젝트에 참여한 인원을 추가해 주세요.
                                        </Typography>
                                    );
                                }
                                return <Typography>{''}</Typography>;
                            }}
                        >
                            <MenuItem value="one">
                                <MenuItemProfile>
                                    <Checkbox sx={{ justifyContent: 'flex-end' }} />
                                </MenuItemProfile>
                            </MenuItem>
                            <MenuItem value="two">
                                <MenuItemProfile>
                                    <Checkbox sx={{ justifyContent: 'flex-end' }} />
                                </MenuItemProfile>
                            </MenuItem>
                            <MenuItem value="three">
                                <MenuItemProfile>
                                    <Checkbox sx={{ justifyContent: 'flex-end' }} />
                                </MenuItemProfile>
                            </MenuItem>
                        </Select>
                    </Label>
                    <Label title="프로젝트 URL">
                        <Stack direction="row" gap="5px">
                            <Tag label="Naver | https://www.naver.com" onDelete={() => {}} />
                            <Tag label="Github | https://www.Github.com" onDelete={() => {}} />
                        </Stack>
                        <Stack direction="row" gap="5px">
                            <TextField placeholder="URL 이름" />
                            <TextfieldWithBtn
                                onClick={() => {}}
                                placeholder="프로젝트와 연관된 URL을 등록하세요."
                                width="100%"
                                variant="outlined"
                            />
                        </Stack>
                    </Label>
                    <Label title="프로젝트 이미지">
                        <input
                            type="file"
                            accept="image/*"
                            onChange={handleFileChange}
                            multiple
                            style={{ display: 'none' }} // input 요소 숨김
                            ref={fileInputRef} // ref를 통해 input 요소를 참조
                        />
                        <Stack direction="row" gap="10px">
                            <Stack
                                justifyContent="center"
                                alignItems="center"
                                sx={{ height: '180px', border: `1px dotted ${palette.grey[500]}` }}
                                gap="7px"
                                flex={1}
                            >
                                <Image size={26} color={palette.grey[500]} />
                                <Typography color={palette.grey[500]}>
                                    Drag files to upload
                                </Typography>
                                <Button sx={{ width: '150px' }} onClick={handleButtonClick}>
                                    Choose File
                                </Button>
                            </Stack>
                            <Stack
                                sx={{
                                    width: filesInfo.length > 0 ? '280px' : '0px',
                                    height: '188px',
                                    overflowY: 'scroll',
                                }}
                            >
                                {filesInfo.map((fileInfo, index) => (
                                    <FileUploadInfo
                                        key={index}
                                        fileName={fileInfo.file.name}
                                        progress={fileInfo.progress}
                                        speed={fileInfo.speed.toFixed(2)}
                                        size={fileInfo.size.toFixed(2)}
                                    />
                                ))}
                            </Stack>
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
