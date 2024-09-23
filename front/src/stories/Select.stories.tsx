import { Controller, useForm } from 'react-hook-form';

import { MenuItem, Select, SelectProps, Typography } from '@mui/material';
import { Meta, StoryFn } from '@storybook/react';

const meta = {
    title: 'Example/Select',
    component: Select,
    parameters: { layout: 'centered' },
    tags: ['autodocs'],
    argTypes: {},
    args: {},
} satisfies Meta<typeof Select>;

export default meta;

type Story = StoryFn<typeof meta>;

const Template: StoryFn<SelectProps> = (props) => {
    const { control } = useForm<{ selectTest: string }>({ defaultValues: { selectTest: '' } });
    return (
        <Controller
            name="selectTest"
            control={control}
            render={({ field }) => (
                <Select
                    {...field}
                    {...props}
                    displayEmpty
                    renderValue={(value) => {
                        const newValue = value as string;
                        if (newValue === '') return <Typography>empty</Typography>;
                        return <Typography>{newValue}</Typography>;
                    }}
                >
                    <MenuItem value="value1">value1</MenuItem>
                    <MenuItem value="value2">value2</MenuItem>
                    <MenuItem value="value3">value3</MenuItem>
                </Select>
            )}
        />
    );
};
export const SimpleSelect: Story = Template.bind({});
