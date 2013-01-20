/*
 * Copyright (C) 2002-2009  OW2 Consortium
 *
 * This file is part of dcsj-rubis (below referred to as "this program").
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package edu.rice.rubis.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** This servlets display the page authentifying the user 
 * to allow him to put a buy an item at the "buy now" price.
 * It must be called this way :
 * <pre>
 * http://..../BuyNowAuth?itemId=xx where xx is the id of the item
 * /<pre>
 * @author <a href="mailto:cecchet@rice.edu">Emmanuel Cecchet</a> and <a href="mailto:julie.marguerite@inrialpes.fr">Julie Marguerite</a>
 * @version 1.0
 */

public class BuyNowAuth extends HttpServlet
{


  /** Display the web page with the form to authenticate the user */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    ServletPrinter sp = null;
    sp = new ServletPrinter(response, "BuyNowAuth");

    String value = request.getParameter("itemId");
    if ((value == null) || (value.equals("")))
    {
      sp.printHTMLheader("RUBiS ERROR: Authentification for buying an item");
      sp.printHTML(
        "No item identifier received - Cannot process the request<br>");
      sp.printHTMLfooter();
      return;
    }

    sp.printHTMLheader("RUBiS: User authentification for buying an item");
    sp.printFile(Config.HTMLFilesPath + "/buy_now_auth_header.html");
    sp.printHTML("<input type=hidden name=\"itemId\" value=\"" + value + "\">");
    sp.printFile(Config.HTMLFilesPath + "/auth_footer.html");
    sp.printHTMLfooter();
  }

  /** Call the doGet method*/
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    doGet(request, response);
  }
}