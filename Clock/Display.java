package Clock;

public class Display {

    private int limit;
    private int value;

    public Display(int resetLimit){
        limit = resetLimit;
        value = 0;
    }

    public int GetValue() {
        return value;
    }

    public String GetDisplayValue() {
        if (value < 10)
        {
            return "0" + value;
        }
        else
        {
            return "" + value;
        }
    }

    public void SetValue(int newValue) {
        if (newValue >= 0 && newValue < limit)
        {
            value = newValue;
        }
    }

    public void Increment() {
        value= (value + 1) % limit;
    }
}