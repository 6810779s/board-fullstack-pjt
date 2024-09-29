import { Button, Stack, TextField, TextFieldProps } from '@mui/material';

export interface TextfieldWithBtnProps extends TextFieldProps<'outlined'> {
    onClick: () => void;
    buttonText?: string;
    width?: string;
    variant: 'outlined';
}
export const TextfieldWithBtn: React.FC<TextfieldWithBtnProps> = ({
    onClick,
    width = '430px',
    buttonText = '등록',
    variant = 'outlined',
    ...props
}) => {
    return (
        <Stack
            direction={'row'}
            alignItems={'center'}
            sx={{ position: 'relative', paddingRight: '40px', width }}
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
