import { HamburgerButton } from "@assets/svgs";
import { Stack } from "@mui/material";

const Gnb = () => {
  return (
    <Stack direction={"row"} alignItems={"center"} sx={{ height: "100px" }}>
      <HamburgerButton height={"30px"} />
    </Stack>
  );
};

export default Gnb;
