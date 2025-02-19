import { screen } from '@testing-library/dom';
import { render } from '@testing-library/react';
import userEvent from '@testing-library/user-event';

import Alert, { AlertProps } from '@/components/Alert';

describe('Alert Component', () => {
    const mockOnConfirm = jest.fn();
    const mockOnClose = jest.fn();

    const renderAlert = (props?: Partial<AlertProps>) => {
        return render(
            <Alert
                open={true} // 모달이 보이도록 설정
                onClose={mockOnClose}
                onConfirm={mockOnConfirm}
                title="테스트 제목"
                content="테스트 내용"
                variant="confirm"
                {...props}
            />
        );
    };

    test('제목과 내용이 정상적으로 표시되는지 확인', () => {
        renderAlert();

        expect(screen.getByText('테스트 제목')).toBeInTheDocument();
        expect(screen.getByText('테스트 내용')).toBeInTheDocument();
    });

    test('variant가 confirm일 때 Check 아이콘이 표시되는지 확인', () => {
        renderAlert({ variant: 'confirm' });

        expect(screen.getByTestId('CheckIcon')).toBeInTheDocument();
    });

    test('variant가 error일 때 WarningCircle 아이콘이 표시되는지 확인', () => {
        renderAlert({ variant: 'error' });

        expect(screen.getByTestId('WarningCircleIcon')).toBeInTheDocument();
    });

    test('확인 버튼 클릭 시 onConfirm이 호출되는지 확인', async () => {
        renderAlert();

        const confirmButton = screen.getByRole('button', { name: '확인' });
        await userEvent.click(confirmButton);

        expect(mockOnConfirm).toHaveBeenCalledTimes(1);
    });

    test('닫기 버튼 클릭 시 onClose가 호출되는지 확인', async () => {
        renderAlert();

        const closeButton = screen.getByRole('button', { name: '닫기' });
        await userEvent.click(closeButton);

        expect(mockOnClose).toHaveBeenCalledTimes(1);
    });
});
