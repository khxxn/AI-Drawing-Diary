import { useState, type FormEvent } from 'react';
import styles from './StartPage.module.css';
import { checkUsername } from '../api/userApi';
import { useNavigate } from 'react-router-dom';

function StartPage() {
    const [usernameInput, setUsernameInput] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async(event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        // validation
        if(!usernameInput.trim()) {
            alert('이름을 입력해주세요.');
            return;
        }

        // API
        try {
            const {status: duplicate} = await checkUsername(usernameInput)

            if (duplicate) {
                alert('이미 해당 이름은 사용 중입니다.');
                return;
            }

        // todo 로컬 쿠키에 username save.
            navigate('/');
        } catch (error) {
            console.error(error);
            alert('서버와의 통신 중 오류가 발생');
        }
        
    }

    return (
        <div className={styles.root}>
            <div className={styles.content}>
                <div className={styles.innerContent}>
                    <div className={styles.title}>일기를 통해<br />내 감정을 알아보세요.</div>
                    <form onSubmit={handleSubmit} className={styles.form}>
                        <input
                            value={usernameInput}
                            onChange={event => setUsernameInput(event.target.value)}
                            placeholder={'이름을 입력해주세요.'}
                            className={styles.input}
                        />
                        <button type={'submit'} className={styles.button}>시작</button>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default StartPage;