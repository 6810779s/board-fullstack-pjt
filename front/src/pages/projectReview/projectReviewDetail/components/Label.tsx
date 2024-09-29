import { Stack, Typography } from '@mui/material';

interface LabelProps {
    title: string;
    children: React.ReactNode;
}
export const Label: React.FC<LabelProps> = ({ title, children }) => {
    return (
        <Stack gap="10px">
            <Typography sx={{ fontWeight: 700 }}>{title}</Typography>
            {children}
        </Stack>
    );
};
