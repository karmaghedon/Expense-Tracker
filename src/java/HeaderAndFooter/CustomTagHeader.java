/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeaderAndFooter;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author nicolaenastas
 */
public class CustomTagHeader extends SimpleTagSupport{
    StringWriter sw = new StringWriter();
    SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd, yyyy - HH:MM:ss a z");
    Date date= new Date();
    

    @Override
    public void doTag() throws JspException, IOException {
           // sw.append(date.toString());
             sw.append(format.format(date));
        getJspContext().getOut().println(sw);
    }
}
