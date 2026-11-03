
package ma.emsi.chorouk.tp1_chorouk;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

 @Override
 protected void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

  response.setContentType("text/html;charset=UTF-8");

  try (PrintWriter out = response.getWriter()) {
   out.println("<!DOCTYPE html>");
   out.println("<html lang=\"fr\">");
   out.println("<head>");
   out.println("<meta charset=\"UTF-8\">");
   out.println("<title>TP0 - Jakarta EE</title>");
   out.println("</head>");
   out.println("<body>");

   out.println("<h1>Bienvenue dans mon TP0 Jakarta EE !</h1>");
   out.println("<h2>Application de Chorouk - Groupe G1 - N°14</h2>");

   out.println("<p>Cette page est générée par une Servlet Jakarta EE.</p>");
   out.println("<p>Serveur d'application : Payara 7</p>");

   out.println("<h3>Fonctionnalités de mon projet :</h3>");
   out.println("<ul>");
   out.println("<li>Application Web Jakarta EE 11</li>");
   out.println("<li>Interface JSF avec historique des conversations</li>");
   out.println("<li>Bonus : analyse et transformation créative du texte</li>");
   out.println("</ul>");

   out.println("<p><a href=\""
           + request.getContextPath()
           + "/index.xhtml\">Accéder à mon application JSF</a></p>");

   out.println("</body>");
   out.println("</html>");
  }
 }
}
