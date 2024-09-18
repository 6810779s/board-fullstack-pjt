import react from '@vitejs/plugin-react-swc';
import { defineConfig, loadEnv } from 'vite';
import svgr from 'vite-plugin-svgr';
import tsconfigPaths from 'vite-tsconfig-paths';

export default defineConfig(({ mode }) => {
    loadEnv(mode, process.cwd(), '');

    return {
        plugins: [react(), tsconfigPaths(), svgr()],
        base: './',
    };
});
