public class Schedule implements showPageInfo{
    @Override
    public void showInfo() {
        System.out.println("График тренировок");
    }

    void schedule(){
        System.out.println("no-gi: дни: 2/4/6 | время: 20:00");
        System.out.println("gi: дни: 1/3/5 | время: 20:00");
    }
}

interface showPageInfo{
    void showInfo();
}