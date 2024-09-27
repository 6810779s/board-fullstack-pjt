import React from 'react';

import ReactQuill from 'react-quill-new';
import 'react-quill-new/dist/quill.snow.css';

import { Stack } from '@mui/material';
import Delta from 'quill-delta';
import { SizeStyle } from 'quill/formats/size';

import { formats, modules } from '@/pages/board/boardRegister/const';

import './Editor.css';

export const Editor = () => {
    SizeStyle.whitelist = ['12px', '13px', '14px', '15px', '16px', '18px', '20px', '24px'];
    ReactQuill.Quill.register(SizeStyle, true);
    const [value, setValue] = React.useState<string>('');

    const handleChange = (
        content: string,
        _delta: Delta,
        _source: string,
        editor: ReactQuill.UnprivilegedEditor
    ) => {
        setValue(content);
        console.log({ content });
        console.log({ editor });
    };

    return (
        <Stack
            sx={{
                'height': '600px',
                'width': '100%',
                '.quill': {
                    width: '100%',
                    height: '600px',
                    display: 'flex',
                    flexDirection: 'column',
                },
            }}
        >
            <ReactQuill
                modules={modules}
                formats={formats}
                value={value}
                onChange={handleChange}
                theme="snow"
            />
        </Stack>
    );
};
