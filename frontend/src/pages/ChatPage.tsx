import { useNavigate } from 'react-router-dom';
import Button from '../components/Button';
import styles from './ChatPage.module.css'
import type { MessageDto } from '../type/message';
import useUser from '../hook/useUser';

const DUMMY_MESSAGES: MessageDto[] = [
    {
        id: 0,
        diaryId: 0,
        type: 'MSG',
        username: 'HI',
        message: '안녕'
    },
    {
        id: 1,
        diaryId: 0,
        type: 'MSG',
        username: 'HI',
        message: '안녕!'
    },
    {
        id: 2,
        diaryId: 0,
        type: 'MSG',
        username: 'test06',
        message: 'me!'
    },
    
]

function ChatPage() {
    const navigate = useNavigate();
    const { username } = useUser();

    const handleSubmit = () => {

    };

    return (
        <>
            <header className={styles.header}>
                <Button variant={'ghost'} size={'small'} onClick={() => navigate('/')} style={{ padding: 8 }}>
                    {'<'}
                </Button>
            </header>
            <div className={styles.chatList}>
                {DUMMY_MESSAGES.map(message => {
                    const isMe = username === message.username;

                    return (
                        <div key={message.id} className={`${styles.messageRow} ${isMe ? styles.myMessage : styles.otherMessage}`}>
                            {!isMe && <div className={styles.avatar} />}
                            <div className={styles.bubble}>
                                {message.type == 'MSG' ? (message.message) : (<img />)}
                            </div>
                        </div>
                    )
                })}
            </div>
            <form className={styles.inputArea} onSubmit={handleSubmit}>
                <input className={styles.input} placeholder="메시지를 입력하세요..." />
                <Button type={'submit'}>
                    전송
                </Button>
            </form>
        </>
    )
}

export default ChatPage;