import react from '@vitejs/plugin-react';
import { defineConfig } from 'vite';
import tsconfigPaths from 'vite-tsconfig-paths';

export default defineConfig({
    plugins: [react(), tsconfigPaths()],
    build: {
        outDir: '../../../target/classes/static',
    },
    root: 'src/main/webapp',
    server: {
        port: 9000,
        hmr: { overlay: false },
        proxy: {
            '/api': {
                target: 'http://localhost:8060',
                changeOrigin: true,
            },
        },
    },
    define: {
        'process.env': {},
    },
});
