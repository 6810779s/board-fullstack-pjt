import { createBrowserRouter } from 'react-router-dom';

import GnbLayout from '@components/GnbLayout';
import SnbLayout from '@components/SnbLayout';

import Login from '@pages/accounts/Login';
import SignUp from '@pages/accounts/SignUp';
import Board from '@pages/board/Board';
import BoardDetail from '@pages/board/BoardDetail';
import MyPage from '@pages/myPage/MyPage';

import { PATH } from './Path';
import { Redirect } from './Redirect';

export const router = createBrowserRouter([
    {
        path: PATH.BOARD.INDEX,
        element: <GnbLayout />,
        children: [
            {
                path: '',
                element: <SnbLayout />,
                children: [
                    { index: true, element: <Board /> },
                    { path: PATH.BOARD.DETAIL, element: <BoardDetail /> },
                    { path: PATH.ACCOUNT.LOGIN, element: <Login /> },
                    { path: PATH.ACCOUNT.SIGN_UP, element: <SignUp /> },
                    { path: PATH.MY_PAGE.INDEX, element: <MyPage /> },
                    { path: '*', element: <Redirect /> },
                ],
            },
        ],
    },
    { path: '*', element: <Redirect /> },
]);
