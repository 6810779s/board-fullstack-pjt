import { createBrowserRouter } from 'react-router-dom';

import { GnbLayout } from '@components/GnbLayout';
import { SnbLayout } from '@components/SnbLayout';

import { Login } from '@/pages/auth/login';
import { SignUp } from '@/pages/auth/signUp';
import { BoardDetail } from '@/pages/board/boardDetail';
import { BoardList } from '@/pages/board/boardList';
import { BoardRegister } from '@/pages/board/boardRegister';
import { Error } from '@/pages/error';
import { Home } from '@/pages/home';
import { MyPage } from '@/pages/myPage/myPage';

import { Redirect } from './Redirect';

export const router = createBrowserRouter([
    {
        path: '/',
        element: <GnbLayout />,
        children: [
            {
                path: '',
                element: <SnbLayout />,
                children: [
                    //로그인
                    { path: '/login', element: <Login /> },
                    //회원가입
                    { path: '/signUp', element: <SignUp /> },
                    //홈
                    { path: '/home', element: <Home /> },
                    //게시판 목록
                    {
                        path: '/board',
                        element: <BoardList />,
                    },
                    //게시판 상세
                    {
                        path: 'detail/:id',
                        element: <BoardDetail />,
                    },
                    //게시판 등록
                    {
                        path: 'register',
                        element: <BoardRegister />,
                    },
                    //프로젝트 리뷰 목록
                    //프로젝트 리뷰 상세
                    //프로젝트 리뷰 등록
                    //마이페이지
                    //마이페이지 - 타회원
                    { path: '/myPage', element: <MyPage /> },
                    { path: '*', element: <Redirect /> },
                ],
            },
        ],
        errorElement: <Error />,
    },
    { path: '*', element: <Redirect /> },
]);
