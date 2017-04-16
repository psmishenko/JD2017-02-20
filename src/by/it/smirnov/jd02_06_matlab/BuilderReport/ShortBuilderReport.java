package by.it.smirnov.jd02_06_matlab.BuilderReport;

import by.it.smirnov.jd02_06_matlab.Log.LogStr;
import by.it.smirnov.jd02_06_matlab.Log.SingleLogger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Класс краткого отчета
 */
public class ShortBuilderReport extends AbstractBuilderReport {
    private int counter = 0;
    /**
     * Формирование шапки отчета
     */
    @Override
    public void makeHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════╗\n");
        sb.append("║                       КРАТКИЙ ОТЧЕТ                        ║\n");
        sb.append("║               (нет сообщений с типом DEBUG)                ║\n");
        sb.append(String.format("║              Сформирован: %s              ║\n",Helper.sdf.format(System.currentTimeMillis()) ));
        sb.append("╠═════════════════════╦══════════════════════════════════════╣\n");
        report.setHeader(sb.toString());
    }
    /**
     * Формирование тела отчета
     */
    @Override
    public void makeBody() {
        counter = 0;
        LinkedList<LogStr> listLogFull = SingleLogger.getInstance().getListLogFull();
        Iterator<LogStr> it = listLogFull.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            LogStr strOne = it.next();
            if (!strOne.getMessageType().equals("DEBUG")) {
                sb.append(String.format("║ %s ║ %-36s ║\n",Helper.sdf.format(strOne.getDateTime()), strOne.getMessageType()));
                sb.append("╠═════════════════════╩══════════════════════════════════════╣\n");
                ArrayList<String> list = Helper.getStrPart(58, strOne.getMessage());
                Iterator<String> itList = list.iterator();
                while (itList.hasNext()) {
                    sb.append(String.format("║ %-58s ║\n",itList.next() ));
                }
                if (it.hasNext())
                    sb.append("╠═════════════════════╦══════════════════════════════════════╣\n");
                counter ++;
            }
        }
        report.setBody(sb.toString());
    }

    /**
     * Формирование итога отчета
     */
    @Override
    public void makeFooter() {
        StringBuilder sb = new StringBuilder();
        sb.append("╠════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Кол-во записей: %-42s ║\n", counter));
        sb.append(String.format("║ Время запуска пакета: %-36s ║\n", Helper.sdf.format(SingleLogger.getTimeCreateLogger())));
        sb.append(String.format("║ %-58s ║\n", "КРАТКИЙ ОТЧЕТ желает Вам хорошего дня!!!"));
        sb.append("╚════════════════════════════════════════════════════════════╝\n");
        report.setFooter(sb.toString());
    }
}
