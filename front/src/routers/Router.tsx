import { createBrowserRouter } from 'react-router-dom';

import { GnbLayout } from '@/components/gnb/GnbLayout';
import { Login } from '@/pages/auth/login';
import { SignUp } from '@/pages/auth/signUp';
import { BoardDetail } from '@/pages/board/boardDetail';
import { BoardList } from '@/pages/board/boardList';
import { BoardRegister } from '@/pages/board/boardRegister';
import { Error } from '@/pages/error';
import { Home } from '@/pages/home';
import { MyPage } from '@/pages/myPage';
import { MypageContainer } from '@/pages/myPage/MypageContainer';
import { ProjectReviewDetail } from '@/pages/projectReview/projectReviewDetail';
import { ProjectReviewList } from '@/pages/projectReview/projectReviewList';
import { ProjectReviewRegister } from '@/pages/projectReview/projectReviewRegister';

import { Redirect } from './Redirect';

export const router = createBrowserRouter([
    {
        element: <GnbLayout />,
        children: [
            //로그인
            { path: 'login', element: <Login /> },
            //회원가입
            { path: 'sign-up', element: <SignUp /> },
            //홈
            { index: true, element: <Home /> },
            //팀원 구하기 게시판 목록
            {
                path: 'board-list',
                element: <BoardList />,
            },
            //팀원 구하기 게시판 상세
            {
                path: 'board/:id',
                element: <BoardDetail />,
            },
            //팀원 구하기 게시판 등록
            {
                path: 'board-register',
                element: <BoardRegister />,
            },
            //프로젝트 리뷰 목록
            {
                path: 'project-review-list',
                element: <ProjectReviewList />,
            },
            //프로젝트 리뷰 상세
            {
                path: 'project-review/:id',
                element: <ProjectReviewDetail />,
            },
            //프로젝트 리뷰 등록
            {
                path: 'project-register',
                element: <ProjectReviewRegister />,
            },
            //마이페이지
            {
                path: 'my-page/:userNickname',
                element: <MyPage />,
                children: [{ path: '', element: <MypageContainer /> }],
            },

            { path: '*', element: <Redirect /> },
        ],
        errorElement: <Error />,
    },
    { path: '*', element: <Redirect /> },
]);
