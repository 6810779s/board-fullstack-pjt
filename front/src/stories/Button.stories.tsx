import { Button, ButtonProps } from '@mui/material';
import { Star } from '@phosphor-icons/react/dist/ssr';
import { Meta, StoryFn } from '@storybook/react';

import { palette } from '@/themes';

const meta = {
    title: 'Example/Button',
    component: Button,
    parameters: { backgrounds: { default: 'dark' }, layout: 'centered' },
    tags: ['autodocs'],
    argTypes: {},
    args: {},
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryFn<ButtonProps>;

const Template = (props: ButtonProps) => {
    return <Button {...props}>Button</Button>;
};

export const BlackContainedBtn: Story = Template.bind({});
export const WhiteOutlinedBtn: Story = Template.bind({});
export const WhiteContainedBtn: Story = Template.bind({});
export const WhiteContainedBlackOutlinedBtn: Story = Template.bind({});
export const ErrorBtn: Story = Template.bind({});
export const ErrorOutlinedBtn: Story = Template.bind({});
export const WhiteOutlinedIconBtn: Story = Template.bind({});
export const PrimaryBtn: Story = Template.bind({});
export const LightGreyBtn: Story = Template.bind({});

BlackContainedBtn.args = { variant: 'BlackContained' };
WhiteOutlinedBtn.args = { variant: 'WhiteOutlined' };
WhiteContainedBtn.args = { variant: 'WhiteContained' };
WhiteContainedBlackOutlinedBtn.args = { variant: 'WhiteContainedBlackOutlined' };
ErrorBtn.args = { variant: 'Error' };
ErrorOutlinedBtn.args = { variant: 'ErrorOutlined' };
WhiteOutlinedIconBtn.args = {
    variant: 'WhiteOutlinedIconButton',
    startIcon: <Star weight="fill" color={palette.warning[500]} />,
};
PrimaryBtn.args = {
    variant: 'Primary',
};
LightGreyBtn.args = {
    variant: 'LightGrey',
};
