import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class App {

  public static void main(String[] args) {
    String text = readFile();
    String name = text.substring(text.indexOf(">>>name") + 7,text.indexOf(">>>telephone")).trim();
    String telephone = text.substring(text.indexOf(">>>telephone") + 12,text.indexOf(">>>email")).trim();
    String email = text.substring(text.indexOf(">>>email") + 8,text.indexOf(">>>interests")).trim();
    String[] interests = text.substring(text.indexOf(">>>interests") + 12,text.indexOf(">>>skills")).trim().split("\n");
    String[] skills = text.substring(text.indexOf(">>>skills") + 9,text.indexOf(">>>education")).trim().split("\n");
    String[] educations = text.substring(text.indexOf(">>>education") + 12,text.indexOf(">>>experience")).trim().split("\n");
    String[] experiences = text.substring(text.indexOf(">>>experience") + 13,text.indexOf(">>>about")).trim().split("\n");
    String aboutMe = text.substring(text.indexOf(">>>about") + 8).trim();

    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("resume.html"));
      bw.write("<!DOCTYPE html>\n"
          + "<html lang=\"en\">\n"
          + "<head>\n"
          + "    <meta charset=\"UTF-8\">\n"
          + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
          + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
          + "    <link rel=\"stylesheet\" href=\"style.css\">\n"
          + "    <title>My resume</title>\n"
          + "</head>\n"
          + "<body>\n"
          + "    <div id=\"header\"></div>\n"
          + "<div class=\"left\"></div>\n"
          + "<div class=\"stuff\">\n"
          + "  <br><br>\n"
          + "  <h1>Resume</h1>\n"
          + "  <h2>" + name + "</h2>\n"
          + "  <hr />\n"
          + "  <br>\n"
          + "  <p class=\"head\">Interests</p>\n"
          + "  <ul>\n");
      for (String interest : interests) {
        bw.write("<li>" + interest + "</li>");
      }

      bw.write(" </ul>\n"
          + "  <p class=\"head\">Skills</p>\n"
          + "  <ul>");

      for (String skill : skills) {
        bw.write("<li>" + skill + "</li>");
      }

      bw.write("</ul>\n"
          + "  <p class=\"head\">Education</p>\n"
          + "  <ul>");

      for (String education : educations) {
        bw.write("<li>" + education + "</li>");
      }
      bw.write("</ul>\n"
          + "  <p class=\"head\">Experience</p>\n"
          + "  <ul>");
      for (String experience : experiences) {
        bw.write("<li>" + experience + "</li>");
      }

      bw.write("</ul>\n"
          + "  <br>\n"
          + "  <p class=\"head\">About me</p>\n"
          + "  \n"
          + aboutMe
          + "</div>\n"
          + "<div class=\"right\"></div>\n"
          + "<div id=\"footer\">\n"
          + "  <h2 id=\"name\">" + name + "</h2>\n"
          + "</div>\n"
          + "</body>\n"
          + "</html>");




      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }







  public static String readFile () {
    String text = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader("resumeInfo.txt"));
      String line = "";
      while((line = br.readLine()) != null) {
        text += line + "\n";

      }
      br.close();

    } catch (FileNotFoundException e) {
      System.out.println("resumeInfo.txt file not found");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return text;
  }

}
