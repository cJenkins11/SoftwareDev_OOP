package Clock;

/**
 * @author: Callum Jenkins
 * 30/09/2020
 *
 * Class: Clock
 */

public class Clock {
    private Display hours;
    private Display minutes;
    private Display seconds;
    private String time;

    /**
     * Constructor:
     * Creates a new clock object using the hour/minute/second displays
     * Display needs a value to know when to reset
     */
    public Clock() {
        hours = new Display(24);
        minutes = new Display(60);
        seconds = new Display(60);
    }

    /**
     * Overloaded constructor for setting the start time of a new clock.
     * @param startHour - Starting hour
     * @param startMinute - Starting minute
     * @param startSecond - Starting second
     */
    public Clock(int startHour, int startMinute, int startSecond)  {
        hours = new Display(24);
        minutes = new Display(60);
        seconds = new Display(60);

        SetTime(startHour, startMinute, startSecond);
    }

    /**
     *
     * @param newHour - Hour to be set
     * @param newMinute - Minute to be set
     * @param newSecond - Second to be set
     */
    public void SetTime(int newHour, int newMinute, int newSecond) {

        hours.SetValue(newHour);
        minutes.SetValue(newMinute);
        seconds.SetValue(newSecond);
        UpdateDisplay();
    }

    public void tick() {
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
    }

    public String GetTime() {
        return time;
    }

    public void UpdateDisplay() {
        String timeOfDay = "";

        if (hours.GetValue() >= 0 && hours.GetValue() < 12)
        {
            timeOfDay = "AM";
        }
        else if (hours.GetValue() >= 0 && hours.GetValue() < 24)
        {
            timeOfDay = "PM";
        }

        time = hours.GetDisplayValue() + ":" + minutes.GetDisplayValue() + ":" + seconds.GetDisplayValue() + " " + timeOfDay;
        System.out.println(time);
    }
}