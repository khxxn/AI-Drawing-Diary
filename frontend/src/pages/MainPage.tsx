import { useState } from 'react';
import useUser from '../hook/useUser';
import styles from './MainPage.module.css';
import { formatDate } from '../utils/date=util';

function MainPage() {
    const { username } = useUser();
    const [currentDate, setCurrentData] = useState(new Date())
    // 현재 선택된 달력 월을 기반으로 캘린더 날짜 구하기
    const year = currentDate.getFullYear();
    const month = currentDate.getMonth();
    const firstDate = new Date(year, month, 1).getDay();
    const lastDate = new Date(year, month + 1, 0).getDate();
    const calendarDate: ({ date: Date; key: string } | null)[] = [];

    for (let i = 0; i < firstDate; i++) {
        calendarDate.push(null)
    }

    for (let d = 1; d <= lastDate; d++) {
        const date = new Date(year, month, d);
        const key = formatDate(date);
        calendarDate.push({ date, key })
    }

    const today = new Date();
    const todayKey = formatDate(today);

    const handlePrevMonthClick = () => {
        setCurrentData(new Date(year, month - 1, 1));
    };

    const handleNextMonthClick = () => {
        setCurrentData(new Date(year, month + 1, 1));
    };

    return (
        <div className={styles.root}>
            <h1 className={styles.greeting}>
                {username}님 <br />
                오늘 하루는 어떠셨나요?
            </h1>
            <div className={styles.calendarContainer}>
                <div className={styles.calendarHeader}>
                    <button className={styles.navButton} onClick={handlePrevMonthClick}>
                        {'<'}
                    </button>
                    <span className={styles.monthTitle}>
                        {year}년 {month + 1}월
                    </span>
                    <button className={styles.navButton} onClick={handleNextMonthClick}>
                        {'>'}
                    </button>
                </div>
                <div className={styles.weekdays}>
                    {['일', '월', '화', '수', '목', '금', '토'].map(w => (
                        <div key={w} className={styles.weekday}>{w}</div>
                    ))}
                </div>
                <div className={styles.calendarBody}>
                    {calendarDate.map((item, index) => {
                        if (item == null) {
                            return <div key={index} />;
                        }

                        return (
                            <div key={item.key} className={`${styles.dateCell} ${todayKey == item.key ? styles.dateCellActive : ''}`}>
                                {item.date.getDate()}
                            </div>
                        )
                    })}
                </div>
            </div>
        </div>
    )
}

export default MainPage;