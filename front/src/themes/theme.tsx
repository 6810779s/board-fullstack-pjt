import { PaginationItem, createTheme } from '@mui/material';
import { CaretDoubleLeft, CaretDoubleRight, CaretLeft, CaretRight } from '@phosphor-icons/react';

// import { CaretDoubleLeft, CaretDoubleRight, CaretLeft, CaretRight } from '@assets/index';
import { palette } from './palette';

declare module '@mui/material/Button' {
    interface ButtonPropsVariantOverrides {
        Primary: true;
        WhiteOutlined: true;
        BlackContained: true;
        WhiteContained: true;
        WhiteContainedBlackOutlined: true;
        Error: true;
        ErrorOutlined: true;
        WhiteOutlinedIconButton: true;
        LightGrey: true;
    }
}

declare module '@mui/material/Typography' {
    interface TypographyPropsVariantOverrides {
        'main': true;
        'main/small': true;
    }
}

declare module '@mui/material/Dialog' {
    interface DialogPropsVariantOverrides {
        confirm: true;
        error: true;
    }
}

export const theme = createTheme({
    palette: palette,
    components: {
        MuiCssBaseline: {
            styleOverrides: {
                'a': { textDecoration: 'none', color: palette.text.main },
                '&::webkit-scrollbar': { width: '8px' },
                '&::webkit-scrollbar-thumb': {
                    backgroundColor: palette.grey[400],
                    backgroundClip: 'padding-box',
                    borderRadius: '3px',
                },
            },
        },
        MuiTypography: {
            defaultProps: { variant: 'main' },
            variants: [
                {
                    props: {
                        variant: 'main',
                    },
                    style: { color: palette.text.main },
                },
            ],
        },

        MuiPagination: {
            defaultProps: {
                variant: 'outlined',
                shape: 'rounded',
                showFirstButton: true,
                showLastButton: true,
                renderItem: (item) => (
                    <PaginationItem
                        slots={{
                            previous: CaretLeft,
                            next: CaretRight,
                            first: CaretDoubleLeft,
                            last: CaretDoubleRight,
                        }}
                        {...item}
                    />
                ),
            },
            styleOverrides: {
                root: {
                    'li > button': {
                        'width': '32px',
                        'border': `1px solid ${palette.grey[200]}`,
                        'borderRadius': '6px',
                        '&.Mui-selected': {
                            'background': palette.common.black,
                            'color': palette.common.white,
                            '&:hover': {
                                background: palette.grey[700],
                            },
                        },
                    },

                    'svg': { width: '14px', height: '14px' },

                    '& .MuiPaginationItem-firstLast': {
                        border: 0,
                        svg: { color: palette.grey[700] },
                    },
                    '& .MuiPaginationItem-previousNext': {
                        border: 0,
                        svg: { color: palette.grey[700] },
                    },

                    '& .Mui-disabled': {
                        svg: { color: palette.grey[300] },
                    },
                },
            },
        },
        MuiIconButton: {
            styleOverrides: {
                root: {
                    padding: 0,
                },
            },
        },
        MuiChip: {
            styleOverrides: {
                root: {
                    'color': palette.text.main,
                    'fontSize': '14px',
                    '& .MuiChip-deleteIcon': {
                        color: palette.grey[500],
                    },
                },
            },
        },
        MuiButton: {
            defaultProps: {
                variant: 'BlackContained',
            },
            styleOverrides: {
                root: {
                    fontSize: '14px',
                },
            },
            variants: [
                {
                    props: { variant: 'BlackContained' },
                    style: {
                        background: palette.common.black,
                        color: palette.common.white,
                    },
                },
                {
                    props: { variant: 'WhiteOutlined' },
                    style: {
                        background: 'transparent',
                        color: palette.common.white,
                        border: `1px solid ${palette.common.white}`,
                    },
                },
                {
                    props: { variant: 'WhiteContained' },
                    style: {
                        background: palette.common.white,
                        color: palette.text.main,
                    },
                },
                {
                    props: { variant: 'WhiteContainedBlackOutlined' },
                    style: {
                        background: palette.common.white,
                        color: palette.common.black,
                        border: `1px solid ${palette.common.black}`,
                    },
                },
                {
                    props: { variant: 'Error' },
                    style: {
                        background: palette.error[500],
                        color: palette.common.white,
                    },
                },
                {
                    props: { variant: 'ErrorOutlined' },
                    style: {
                        background: 'transparent',
                        color: palette.common.white,
                        border: `1px solid ${palette.error[500]}`,
                    },
                },
                {
                    props: { variant: 'WhiteOutlinedIconButton' },
                    style: {
                        background: 'transparent',
                        color: palette.common.white,
                        border: `1px solid ${palette.common.white}`,
                    },
                },
                {
                    props: { variant: 'Primary' },
                    style: {
                        background: palette.primary[500],
                        color: palette.common.white,
                    },
                },
                {
                    props: { variant: 'LightGrey' },
                    style: {
                        background: palette.grey[100],
                        border: `1px solid ${palette.grey[200]}`,
                        color: palette.grey[500],
                    },
                },
            ],
        },
        MuiTabs: {
            styleOverrides: {
                root: {
                    '& .MuiTabs-indicator': {
                        backgroundColor: palette.common.black,
                    },
                    'borderBottom': `1px solid ${palette.common.white}`,
                    'height': '43px',
                    '& .MuiButtonBase-root': {
                        '&.Mui-selected': {
                            color: palette.text.main,
                        },

                        'height': '100%',
                        'color': palette.grey[400],
                    },
                },
            },
        },
        MuiTextField: {
            defaultProps: { variant: 'outlined', size: 'small' },
            styleOverrides: {
                root: {
                    '& .MuiOutlinedInput-root': {
                        'borderRadius': '6px',
                        '& input': {
                            '&.Mui-disabled': {
                                '-webkit-text-fill-color': palette.text.disabled,
                                'background': palette.grey[50],
                            },
                            '&::placeholder': { color: palette.text.placeholder, opacity: 1 },
                        },
                        '& fieldset': {
                            borderColor: palette.grey[200],
                        },
                        '&:hover fieldset': {
                            borderColor: palette.primary[500],
                        },
                        '&.Mui-focused fieldset': {
                            borderColor: palette.primary[500],
                        },
                        '&.Mui-disabled fieldset': {
                            borderColor: palette.grey[200],
                        },
                    },
                },
            },
        },
        MuiSelect: {
            defaultProps: { size: 'small' },
        },
    },
});
