package by.it.zeynalov.jd01_12_Collections.TaskB;

import java.util.*;

public class TaskB1 {
    static String text = "There are many safety factors that pilots have to take into consideration while completing a safe flight. " +
            "Everything has to be taken into mind when planning a flight. From weight and balance to preflight inspections. One safety factor that is impossible to have control over is weather. There are many aspects of weather that can affect an aircraft, in this report I will specifically talk about the microburst.\n" +
            "Microbursts are powerful downdrafts associated with thunderstorms. We have been able to identify microbursts through many studies regarding wind shear and meteorology research. Wind shear is basically a rapid change in wind velocity and direction that happen because of many factors in weather conditions. Such conditions include frontal activity, temperature inversions, and thunderstorms amongst other factors.\n" +
            "Wherever there is convective activity such as thunderstorms there is the possibility of a microburst. Microbursts are associated with downdrafts. These are typically only a few hundred to a few thousand feet across. When the downdraft reaches the ground, it spreads out horizontally and may form a vortex around the downdraft.\n" +
            "Unfortunately microbursts can occur without the presence of precipitation being present making the detection of this almost impossible. This is one of the major reasons why there have been so many incidents involving aircrafts and microbursts. There are now many different kinds of service stations that help identify microbursts though. The aircraft accident rate due to microbursts in association with classic severe local storms is practically nonexistent for commercial aviation, since the system is apparently well designed to protect passenger jets against these.\n" +
            "Although most accidents are found to be pilot error due to hazardous attitudes such as macho there arent many training emphasis on fighting a microburst because most of the time the microburst wins.\n" +
            "From the most famous cases of aircraft accidents associated with microbursts is Delta 191. This flight left from Fort Lauderdale Hollywood International to Los Angeles International Airport in California through Dallas International Airport. The crash happened while the plane was on approach into Dallas. At 1500 the first officer reported seeing lightning ahead yet they continued with the approach. At 800 feet the aircraft accelerated so the crew member reduced power to compensate, then came the adverse effect of the microburst slowing the aircraft down. To compensate for this they added power but the downbursts were to strong and Delta 191 ended up crashing on the ground.\n" +
            "In conclusion the one factor pilots must always take into consideration and fear is weather. This phenomenon is still something that humans haven’t been able to completely understand and predict.";

    public static void main(String[] args) {
        ArrayList<String> mass = new ArrayList<>(Arrays.asList(text.split("[\\s.,\\n]+")));
        HashSet<String> add = new HashSet<>(mass);
        TreeMap<String, Integer> sb = new TreeMap<>();
        for (String o: add)
            sb.put(o, Collections.frequency(mass, o));
        Iterator<Map.Entry<String, Integer>> gg = sb.entrySet().iterator();
        while (gg.hasNext()) {
            Map.Entry<String, Integer> vb = gg.next();
            System.out.println(vb);
        }
        //System.out.println(sb);
    }
}
