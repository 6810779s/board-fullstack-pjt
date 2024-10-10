import {
    Pagination,
    Stack,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Typography,
} from '@mui/material';

import { palette } from '@/themes';

interface Columns {
    id: string;
    label: string;
    width: number;
    align?: 'right' | 'left' | 'center';
}
interface Rows {
    [key: string]: string;
}
export interface TableComponentProps {
    columns: Columns[];
    rows: Rows[];
}
export const TableComponent: React.FC<TableComponentProps> = ({ columns, rows }) => {
    return (
        <Stack>
            <TableContainer>
                <Table>
                    <TableHead sx={{ background: palette.grey[100] }}>
                        <TableRow>
                            {columns.map((column, index) => (
                                <TableCell
                                    key={index}
                                    width={column.width}
                                    align="center"
                                    sx={{ height: '50px', padding: 0 }}
                                >
                                    <Typography sx={{ fontWeight: 700 }}>{column.label}</Typography>
                                </TableCell>
                            ))}
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows.map((row, index) => (
                            <TableRow key={index}>
                                {columns.map((column) => (
                                    <TableCell key={column.id} align={column.align || 'center'}>
                                        {row[column.id]}
                                    </TableCell>
                                ))}
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
            <Pagination count={10} />
        </Stack>
    );
};
