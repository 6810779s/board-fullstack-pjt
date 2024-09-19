import { Color, PaletteOptions } from '@mui/material';

interface CustomColor extends Omit<Color, 'A100' | 'A200' | 'A400' | 'A700'> {
    main: string;
}

interface CustomPaletteOptions extends PaletteOptions {
    primary: CustomColor;
    grey: Omit<CustomColor, 'main'>;
    success: CustomColor;
    error: CustomColor;
    warning: CustomColor;
    divider: string;
    text: { main: string; disabled: string; placeholder: string };
    common: { black: string; white: string };
    action: { hover: string; focus: string; selected: string };
}

export const palette: CustomPaletteOptions = {
    primary: {
        main: '#1C64F2', // 600
        50: '#EBF5FF',
        100: '#E1EFFE',
        200: '#C3DDFD',
        300: '#A4CAFE',
        400: '#76A9FA',
        500: '#3F83F8',
        600: '#1C64F2',
        700: '#1A56DB',
        800: '#1E429F',
        900: '#233876',
    },
    // TODO: update secondary color 2024.04.01 kbc
    grey: {
        50: '#F9FAFB',
        100: '#F5F5F5',
        200: '#E5E7EB',
        300: '#D1D5DB',
        400: '#9CA3AF',
        500: '#6B7280',
        600: '#4B5563',
        700: '#374151',
        800: '#1F2A37',
        900: '#111928',
    },
    success: {
        main: '#0E9F6E', // 500
        50: '#F3FAF7',
        100: '#DEF7EC',
        200: '#BCF0DA',
        300: '#84E1BC',
        400: '#31C48D',
        500: '#0E9F6E',
        600: '#057A55',
        700: '#046C4E',
        800: '#03543F',
        900: '#014737',
    },
    error: {
        main: '#F05252', // 500
        50: '#FDF2F2',
        100: '#FDE8E8',
        200: '#FBD5D5',
        300: '#F8B4B4',
        400: '#F98080',
        500: '#F05252',
        600: '#E02424',
        700: '#C81E1E',
        800: '#9B1C1C',
        900: '#771D1D',
    },
    warning: {
        main: '#F5C647', // 500
        50: '#FFF9DF',
        100: '#FEF3C6',
        200: '#FDECA5',
        300: '#FBE17A',
        400: '#FAD55A',
        500: '#F5C647',
        600: '#F1B33F',
        700: '#EAA339',
        800: '#E49134',
        900: '#DA7D2E',
    },
    divider: '#E5E7EB',
    text: { main: '#111928', disabled: '#D1D5DB', placeholder: '#9CA3AF' }, // grey 900
    common: { black: '#000000', white: '#FFFFFF' },
    action: { hover: '#0000000A', focus: '#0000000A', selected: '#EBF5FF' }, // TODO: disabled, disabledBackground, disabledOpacity color 2024.04.01 kbc
};
