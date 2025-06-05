import './HomePage.css';

import JHipsterLiteNeonBlue from '@assets/JHipster-Lite-neon-blue.png';
import ReactLogo from '@assets/ReactLogo.png';

import { useTranslation } from 'react-i18next';

function HomePage() {
    const { t } = useTranslation();

    return (
        <div>
            <div id="app">
                <img alt="React logo" src={ReactLogo} />
                <br />
                <img alt="JHipster logo" src={JHipsterLiteNeonBlue} />
                <h1>React + TypeScript + Vite</h1>

                <p>{t('home.translationEnabled')}</p>
                <p>
                    Recommended IDE setup:&nbsp;
                    <a href="https://code.visualstudio.com/" target="_blank" rel="noopener noreferrer">
                        VSCode
                    </a>
                </p>

                <p>
                    <a href="https://vite.dev/guide/features.html" target="_blank" rel="noopener noreferrer">
                        Vite Documentation
                    </a>
                    <span>&nbsp;|&nbsp;</span>
                    <a href="https://react.dev/" target="_blank" rel="noopener noreferrer">
                        React Documentation
                    </a>
                </p>

                <p>
                    Edit&nbsp;<code>src/main/webapp/app/common/primary/app/App.tsx</code> to test hot module replacement.
                </p>
            </div>
        </div>
    );
}

export default HomePage;
