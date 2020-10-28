package Clock;/*
Callum Jenkins
Title
23/09/2020 of 09, 2020
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;

//TODO Testing todo list

public class ClockFace {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        String time;
        String hourString;
        String minuteString;
        String secondString;
        int currentHour;
        int currentMinute;
        int currentSecond;

        time = sdf.format(cal.getTime());
        hourString = time.substring(0, 2);
        minuteString = time.substring(3, 5);
        secondString = time.substring(6, 8);

        currentHour = Integer.valueOf(hourString);
        currentMinute = Integer.valueOf(minuteString);
        currentSecond = Integer.valueOf(secondString);

        boolean tiktok = true;

        Clock c1 = new Clock(currentHour, currentMinute, currentSecond);
        do
        {
            c1.tick();
            if (Integer.valueOf(c1.GetTime().substring(0, 2)) == 12)
            {
                tiktok = false;
            }
        } while (tiktok);

    }

}
