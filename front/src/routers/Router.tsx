import Board from "@pages/board/Board";
import { createBrowserRouter } from "react-router-dom";
import { PATH } from "./Path";
import BoardDetail from "@pages/board/BoardDetail";
import Login from "@pages/accounts/Login";
import SignUp from "@pages/accounts/SignUp";
import { Redirect } from "./Redirect";
import GnbLayout from "@components/layout/GnbLayout";
import SnbLayout from "@components/layout/SnbLayout";
import MyPage from "@pages/myPage/MyPage";

export const router = createBrowserRouter([
  {
    path: PATH.BOARD.INDEX,
    element: <GnbLayout />,
    children: [
      {
        path: "",
        element: <SnbLayout />,
        children: [
          { index: true, element: <Board /> },
          { path: PATH.BOARD.DETAIL, element: <BoardDetail /> },
          { path: PATH.ACCOUNT.LOGIN, element: <Login /> },
          { path: PATH.ACCOUNT.SIGN_UP, element: <SignUp /> },
          { path: PATH.MY_PAGE.INDEX, element: <MyPage /> },
          { path: "*", element: <Redirect /> },
        ],
      },
    ],
  },
  { path: "*", element: <Redirect /> },
]);
