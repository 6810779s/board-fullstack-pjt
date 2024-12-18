import { Controller, FormProvider, SubmitHandler, UseFormReturn } from 'react-hook-form';

import {
    FormControl,
    IconButton,
    MenuItem,
    Select,
    Stack,
    TextField,
    Typography,
} from '@mui/material';
import { MagnifyingGlass } from '@phosphor-icons/react';

import { palette } from '@/themes';
import { TSearchFilter } from '@/types/pagination';

interface SearchAndSelectProps {
    select_list: { value: string; label: string }[];
    methods: UseFormReturn<TSearchFilter>;
    onSubmit: SubmitHandler<TSearchFilter>;
}
export const SearchAndSelect = ({ select_list, onSubmit, methods }: SearchAndSelectProps) => {
    const { handleSubmit, control } = methods;
    return (
        <FormProvider {...methods}>
            <FormControl>
                <Stack direction="row" gap="15px">
                    <Controller
                        name={'searchType'}
                        control={control}
                        render={({ field }) => (
                            <Select
                                {...field}
                                sx={{ width: '140px' }}
                                displayEmpty
                                renderValue={(value) => {
                                    const selectedItem = select_list.find(
                                        (item) => item.value === value
                                    );
                                    if (!selectedItem) return <Typography>empty</Typography>;
                                    return <Typography>{selectedItem.label}</Typography>;
                                }}
                            >
                                {select_list.map((item, index) => (
                                    <MenuItem key={index} value={item.value}>
                                        {item.label}
                                    </MenuItem>
                                ))}
                            </Select>
                        )}
                    />
                    <Controller
                        name={'keyword'}
                        control={control}
                        render={({ field }) => (
                            <TextField
                                {...field}
                                placeholder="검색어 입력"
                                slotProps={{
                                    input: {
                                        endAdornment: (
                                            <IconButton onClick={handleSubmit(onSubmit)}>
                                                <MagnifyingGlass
                                                    color={palette.grey[500]}
                                                    size={20}
                                                />
                                            </IconButton>
                                        ),
                                    },
                                }}
                            />
                        )}
                    />
                </Stack>
            </FormControl>
        </FormProvider>
    );
};
