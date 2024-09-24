import React from 'react';

import { Link } from 'react-router-dom';

import { Typography, TypographyProps } from '@mui/material';

interface LinkComponentProps extends TypographyProps {
    to: string;
    content: string;
    onClick?: () => void;
}
export const LinkComponent: React.FC<LinkComponentProps> = ({ to, content, onClick, ...props }) => {
    return (
        <Typography {...props}>
            <Link to={to} onClick={onClick}>
                {content}
            </Link>
        </Typography>
    );
};
