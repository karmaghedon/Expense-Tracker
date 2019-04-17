/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeaderAndFooter;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author nicolaenastas
 */
public class CustomTagFooter extends SimpleTagSupport{
            StringWriter sw = new StringWriter();
    @Override
    public void doTag() throws JspException, IOException {
        sw.append("\u00A9 Nicolae Nastas");
        getJspContext().getOut().println(sw);
    }
}
