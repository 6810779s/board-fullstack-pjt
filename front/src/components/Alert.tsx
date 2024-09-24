import React from 'react';

import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogContentText,
    DialogProps,
    DialogTitle,
    Stack,
    Typography,
    styled,
} from '@mui/material';
import { Check, WarningCircle } from '@phosphor-icons/react';

import { palette } from '@/themes';

const ButtonStyle = styled(Button)({
    width: '58px',
    height: '38px',
});
export interface AlertProps extends DialogProps {
    variant: 'confirm' | 'error';
    title: string;
    content: string;
    onConfirm: () => void;
}
const Alert: React.FC<AlertProps> = ({ variant, title, content, onConfirm, ...props }) => {
    return (
        <Dialog
            {...props}
            sx={{
                '& .MuiDialog-container': {
                    '& .MuiPaper-root': { width: '500px', height: '186px' },
                },
            }}
        >
            <DialogTitle>
                <Stack direction={'row'} gap={'10px'}>
                    <Stack
                        alignItems={'center'}
                        justifyContent={'center'}
                        sx={{
                            borderRadius: '50%',
                            background:
                                variant === 'confirm' ? palette.primary[100] : palette.error[50],
                            width: '32px',
                            height: '32px',
                        }}
                    >
                        {variant === 'confirm' && <Check color={palette.primary[600]} />}
                        {variant === 'error' && <WarningCircle color={palette.error[500]} />}
                    </Stack>
                    <Typography> {title}</Typography>
                </Stack>
            </DialogTitle>
            <DialogContent>
                <DialogContentText id="alert-dialog-description">{content}</DialogContentText>
            </DialogContent>
            <DialogActions>
                <ButtonStyle
                    variant="LightGrey"
                    onClick={() => {
                        if (props.onClose) props.onClose({}, 'backdropClick');
                    }}
                >
                    {variant === 'confirm' ? '닫기' : '취소'}
                </ButtonStyle>
                <ButtonStyle
                    variant={variant === 'confirm' ? 'Primary' : 'Error'}
                    sx={{ width: '58px', height: '38px' }}
                    onClick={onConfirm}
                >
                    확인
                </ButtonStyle>
            </DialogActions>
        </Dialog>
    );
};

export default Alert;
