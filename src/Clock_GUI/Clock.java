package Clock_GUI;/*
Callum Jenkins
Clock
22/09/2020 of 09, 2020
*/

public class Clock {
    private Display hours;
    private Display minutes;
    private Display seconds;
    private String time;

    public Clock() {
        hours = new Display(24);
        minutes = new Display(60);
        seconds = new Display(60);
    }

    public Clock(int startHour, int startMinute, int startSecond)  {
        hours = new Display(24);
        minutes = new Display(60);
        seconds = new Display(60);

        SetTime(startHour, startMinute, startSecond);
    }

    public void SetTime(int newHour, int newMinute, int newSecond) {

        hours.SetValue(newHour);
        minutes.SetValue(newMinute);
        seconds.SetValue(newSecond);
        UpdateDisplay();
    }

    public String tick() {
        seconds.Increment();
        if(seconds.GetValue() == 0)
        {
            minutes.Increment();
        }
        if (minutes.GetValue() == 0 && seconds.GetValue() == 0)
        {
            hours.Increment();
        }
        UpdateDisplay();
        return time;
    }

    public String GetTime() {
        return time;
    }

    public void UpdateDisplay() {
        time = hours.GetDisplayValue() + ":" + minutes.GetDisplayValue() + ":" + seconds.GetDisplayValue();
        System.out.println(time);
    }

    public void DisplayTime() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}