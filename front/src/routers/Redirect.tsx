import { useEffect } from "react";

import { useNavigate } from "react-router-dom";
import { PATH } from "./Path";

export const Redirect = () => {
  const navigate = useNavigate();
  useEffect(() => {
    navigate(PATH.BOARD.INDEX, { replace: true });
  }, [navigate]);
  return null;
};
