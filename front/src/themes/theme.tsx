import { PaginationItem, createTheme } from '@mui/material';
import { CaretDoubleLeft, CaretDoubleRight, CaretLeft, CaretRight } from '@phosphor-icons/react';

// import { CaretDoubleLeft, CaretDoubleRight, CaretLeft, CaretRight } from '@assets/index';
import { palette } from './palette';

declare module '@mui/material/Typography' {
    interface TypographyPropsVariantOverrides {
        'main': true;
        'main/small': true;
    }
}
// declare module '@mui/material/Pagination' {
//     interface PaginationPropsColorOverrides {
//         black: true;
//     }
// }
export const theme = createTheme({
    palette: palette,
    components: {
        MuiTypography: {
            defaultProps: { variant: 'main' },
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
                    'li > button': { width: '32px', border: `1px solid ${palette.grey[200]}` },
                    '& .Mui-selected': {
                        background: palette.common.black,
                        color: palette.common.white,
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
    },
});
