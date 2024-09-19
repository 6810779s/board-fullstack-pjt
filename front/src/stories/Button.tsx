import { Button, Stack } from '@mui/material';

export interface ButtonProps {
    /** Is this the principal call to action on the page? */
    primary?: boolean;
    /** What background color to use */
    backgroundColor?: string;
    /** How large should the button be? */
    size?: 'small' | 'medium' | 'large';
    /** Button contents */
    label: string;
    /** Optional click handler */
    onClick?: () => void;
}

/** Primary UI component for user interaction */
export const ButtonStorybook = ({
    size = 'medium',
    backgroundColor,
    label,
    ...props
}: ButtonProps) => {
    return (
        <Stack>
            <Button type="button" size={size} style={{ backgroundColor }} {...props}>
                {label}
            </Button>
        </Stack>
    );
};
