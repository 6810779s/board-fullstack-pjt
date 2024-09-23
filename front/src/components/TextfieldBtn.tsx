import { Button, Stack, TextField, TextFieldProps } from '@mui/material';

export interface TextfieldWithBtnProps extends TextFieldProps<'outlined'> {
    onClick: () => void;
    buttonText?: string;
    width?: number;
}
export const TextfieldWithBtn: React.FC<TextfieldWithBtnProps> = ({
    onClick,
    width = 430,
    buttonText = '등록',
    variant = 'outlined',
    ...props
}) => {
    return (
        <Stack
            direction={'row'}
            alignItems={'center'}
            sx={{ position: 'relative', paddingRight: '40px', width: `${width}px` }}
        >
            <TextField variant={variant} {...props} sx={{ flex: 1 }} />
            <Button
                onClick={onClick}
                sx={{
                    position: 'absolute',
                    width: '80px',
                    height: '40px',
                    right: 0,
                    borderTopLeftRadius: 0,
                    borderBottomLeftRadius: 0,
                }}
            >
                {buttonText}
            </Button>
        </Stack>
    );
};
