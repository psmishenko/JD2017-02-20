package by.it.akhmelev.jd01_08.level_A_classwork_demo;

class VideoPleer extends Pleer{
    @Override
    public String showState() {
        String state="Плеер остановлен";
        if (this.isStatePlay()) {
            state = "Воспроизведение видео";
            if (this.isStatePause())
                state = "Плеер на паузе";
        }
        return state;
    }
}
