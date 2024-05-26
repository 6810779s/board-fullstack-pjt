import react from "@vitejs/plugin-react-swc";
import { defineConfig } from "vite";
import svgr from "vite-plugin-svgr";
// import tsconfigPaths from "vite-tsconfig-paths";
import path from "path";

export default defineConfig({
  // loadEnv(mode, process.cwd(), "");
  plugins: [react(), svgr()],
  base: "./",
  resolve: {
    alias: [
      { find: "@", replacement: path.resolve(__dirname, "src") },
      { find: "@apis", replacement: path.resolve(__dirname, "src/apis") },
      { find: "@assets", replacement: path.resolve(__dirname, "src/assets") },
      {
        find: "@components",
        replacement: path.resolve(__dirname, "src/components"),
      },
      { find: "@hooks", replacement: path.resolve(__dirname, "src/hooks") },
      { find: "@pages", replacement: path.resolve(__dirname, "src/pages") },
      { find: "@routers", replacement: path.resolve(__dirname, "src/routers") },
      { find: "@stores", replacement: path.resolve(__dirname, "src/stores") },
      { find: "@themes", replacement: path.resolve(__dirname, "src/themes") },
      { find: "@typings", replacement: path.resolve(__dirname, "src/typings") },
      { find: "@utils", replacement: path.resolve(__dirname, "src/utils") },
      { find: "@wapls", replacement: path.resolve(__dirname, "src/wapls") },
    ],
  },
});
