import { Control, Controller, FieldValues, Path } from 'react-hook-form';

import { FormControl, MenuItem, Select, Stack, TextField, Typography } from '@mui/material';
import { MagnifyingGlass } from '@phosphor-icons/react';

import { palette } from '@/themes';

interface SearchAndSelectProps<T extends FieldValues> {
    selectName: Path<T>;
    textFieldName: Path<T>;
    control: Control<T>;
    select_list: { value: string; label: string }[];
}
export const SearchAndSelect = <T extends FieldValues>({
    selectName,
    textFieldName,
    control,
    select_list,
}: SearchAndSelectProps<T>) => {
    return (
        <FormControl onSubmit={() => {}}>
            <Stack direction="row" gap="15px">
                <Controller
                    name={selectName}
                    control={control}
                    render={({ field }) => (
                        <Select
                            {...field}
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
                    name={textFieldName}
                    control={control}
                    render={({ field }) => (
                        <TextField
                            {...field}
                            placeholder="검색어 입력"
                            slotProps={{
                                input: {
                                    endAdornment: (
                                        <MagnifyingGlass color={palette.grey[500]} size={20} />
                                    ),
                                },
                            }}
                        />
                    )}
                />
            </Stack>
        </FormControl>
    );
};
