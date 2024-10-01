import React from 'react';

import { LinearProgress, Stack, Typography } from '@mui/material';
import { FileImage } from '@phosphor-icons/react';

import { palette } from '@/themes';

interface FileUploadInfoProps {
    fileName: string;
    progress: number;
    speed: string;
    size: string;
}
const FileUploadInfo: React.FC<FileUploadInfoProps> = ({ fileName, progress, speed, size }) => {
    return (
        <Stack
            direction="row"
            gap="10px"
            sx={{ width: '100%', height: '50px' }}
            alignItems="center"
        >
            <FileImage size={20} />
            <Stack gap="2px" flex={1}>
                <Stack direction="row" justifyContent="space-between">
                    <Typography>{fileName.slice(0, 10) + '...'}</Typography>
                    <Typography variant="main/small/grey">{`${size}MB`}</Typography>
                </Stack>
                <LinearProgress variant="determinate" value={progress} sx={{ height: '3px' }} />
                <Stack direction="row" justifyContent="space-between">
                    <Typography
                        sx={{ fontSize: '12px', color: palette.grey[500] }}
                    >{`${progress}% done`}</Typography>
                    <Typography
                        sx={{ fontSize: '12px', color: palette.grey[500] }}
                    >{`${speed}KB/sec`}</Typography>
                </Stack>
            </Stack>
        </Stack>
    );
};

export default FileUploadInfo;
