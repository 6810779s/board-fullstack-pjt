import { QUERY_KEYS } from "@apis/QueryKeys";
import { api } from "@apis/axios";
import { useQuery } from "@tanstack/react-query";

const getTest = async () => {
  return await api.get(QUERY_KEYS.TEST.test()[0]).then((res) => {
    console.log("res", res);
    return res.data;
  });
};

export const useGetTest = () => {
  return useQuery({
    queryKey: QUERY_KEYS.TEST.test(),
    queryFn: () => getTest(),
  });
};
