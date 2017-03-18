package questionTypes;

/**
 * Created by knkbga on 8/6/2016.
 */

public class Option
{
    public String value;
    public boolean is_answer;
    public Option(String value, boolean is_answer)
    {
        this.is_answer=is_answer;
        this.value=value;
    }
}