package mmi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MmiRedirector extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public MmiRedirector() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      // System.out.println("i m in mmi redirector");

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        ServletOutputStream out = response.getOutputStream() ;
        //PrintWriter out= response.getWriter();

        BufferedInputStream in =   new BufferedInputStream ( request.getInputStream (  )  ) ;
        int c = -1;
        StringBuilder sb = new StringBuilder();
        while((c=in.read())>= 0 ){
           sb.append((char)c);
        }

        String mireoResponse = sb.toString();
        int start = 0;
    //    System.out.println("Mireo response:"+mireoResponse);
        /* https deployment */

        /*if(mireoResponse.substring(0,8).equals("https://")){
            start = 8;
        }*/

        /* end https */
        /* http deplyment */
        if(mireoResponse.substring(0,7).equals("http://")){
            start = 7;
        }
        /* end http */
        int i = mireoResponse.indexOf("/", start);
        int j = mireoResponse.indexOf("*", i);
        String server_name = mireoResponse.substring(start, i);
        String page_name = mireoResponse.substring(i, j);
        String post_data = mireoResponse.substring(j+1);
        sb = null;
        sb = new StringBuilder();
        try {
          /* https */
          //URL url = new URL("https://"+server_name+page_name);

          /* http */
          URL url = new URL("http://"+server_name+page_name);

         // System.out.println("URL:"+url.getPath());
          URLConnection conn = url.openConnection();
          conn.setDoOutput(true);
          OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
          wr.write(post_data);
          wr.flush();

         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         String line = null;

         while ((line = rd.readLine()) != null) {
            sb.append(line);
         }
         wr.close();
         rd.close();
         line = null;
         line = sb.toString(); sb = null;
         out.print(line.replaceAll("\uFFFD", ""));
        }catch(java.io.CharConversionException ex){
           ex.printStackTrace();
        }catch(Exception ex){
           ex.printStackTrace();
        }
    }

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
