package questionTypes;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kanak on 30/8/16.
 */
public class SingleChoice implements Questions
{
    private String preQuestionStatement;
    private List<String> questionImages;
    private String postQuestionStatement;
    public Option options[];

    public SingleChoice(String preQuestionStatement,List<String> questionImages,String postQuestionStatement,Option options[])
    {
        this.preQuestionStatement=preQuestionStatement;
        this.questionImages=questionImages;
        this.postQuestionStatement=postQuestionStatement;
        this.options=options;
    }

    @Override
    public String getQuestion() {
        String webview = "";
        int ascii = 65;

        //Adding prequestionstatement
        webview += "<div class='container' style='margin-bottom:7%'> <div class='col-md-10 col-md-offset-1' style='text-align:justify;margin-top:4%' > <div class='col-md-12 question'> <div class='row'><div class='col-md-11'> <p>" + preQuestionStatement + "</p><br></div></div>";

        //Adding images (in the question)
        webview += "<div class='row' align='center'></div>";
        if(questionImages!=null)
        {
            Iterator it = questionImages.iterator();
            while(it.hasNext())
            {
                webview += it.next();
            }
        }
        webview += "</div>";

        //Adding postQuestionStatement
        if(postQuestionStatement!=null)
        {
            webview += "<br><div class='row'> <div class='col-md-11 col-md-offset-1'> <p>" + postQuestionStatement + "</p></div></div>";
        }

        //Adding options
        webview += "<div class='col-md-12 answer'><div class='col-md-10 col-md-offset-1'><div class='row'>";
        if(options!=null)
        {
            for(int i=0;i<options.length;i++)
            {
                webview += "<div class='col-md-5' style='text-align:left'> <span class='option'>" + Character.toString((char) ascii) + "</span> " + options[i].value + " </div>";
                ascii++;
            }
        }
        webview += "</div>";

        return webview;
    }
}
