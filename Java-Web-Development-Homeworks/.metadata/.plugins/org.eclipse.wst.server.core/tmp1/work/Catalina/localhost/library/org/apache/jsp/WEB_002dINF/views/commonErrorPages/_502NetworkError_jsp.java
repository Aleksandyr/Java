/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.30
 * Generated at: 2016-04-09 17:01:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.commonErrorPages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _502NetworkError_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/tags/LoadScriptsAndStyles.tag", Long.valueOf(1460213143851L));
    _jspx_dependants.put("jar:file:/E:/Java/Java-Web-Development-Homeworks/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LibraryProject/WEB-INF/lib/spring-webmvc-4.2.5.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1456355492000L));
    _jspx_dependants.put("/WEB-INF/custTags.tld", Long.valueOf(1459770430601L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.2.5.RELEASE.jar", Long.valueOf(1456760046969L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t<title>Insert title here</title>\r\n");
      out.write("\t");
      if (_jspx_meth_ct_005fLoadScriptsAndStyles_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t  <!-- Jumbotron -->\r\n");
      out.write("\t\t  <div class=\"jumbotron\">\r\n");
      out.write("\t\t    <h1><i class=\"fa fa-bolt orange\"></i> 502 Server network error!</h1>\r\n");
      out.write("\t\t    <p class=\"lead\">The web server is returning an unexpected networking error for <em><span id=\"display-domain\"></span></em>.</p>\r\n");
      out.write("\t\t    <a href=\"javascript:document.location.reload(true);\" class=\"btn btn-default btn-lg text-center\"><span class=\"green\">Try This Page Again</span></a>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t  <div class=\"body-content\">\r\n");
      out.write("\t\t    <div class=\"row\">\r\n");
      out.write("\t\t      <div class=\"col-md-6\">\r\n");
      out.write("\t\t        <h2>What happened?</h2>\r\n");
      out.write("\t\t        <p class=\"lead\">A 502 error status implies that that the server received an invalid response from an upstream server it accessed to fulfill the request.</p>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      <div class=\"col-md-6\">\r\n");
      out.write("\t\t        <h2>What can I do?</h2>\r\n");
      out.write("\t\t        <p class=\"lead\">If you're a site visitor</p>\r\n");
      out.write("\t\t        <p><a onclick=javascript:checkSite();>Check to see if this website down for everyone or just you.</a>\r\n");
      out.write("\t\t          <script type=\"text/javascript\">\r\n");
      out.write("\t\t              function checkSite(){\r\n");
      out.write("\t\t                var currentSite = window.location.hostname;\r\n");
      out.write("\t\t                  window.location = \"http://isup.me/\" + currentSite;\r\n");
      out.write("\t\t              }\r\n");
      out.write("\t\t          </script></p>\r\n");
      out.write("\t\t        <p>Also, clearing your browser cache and refreshing the page may clear this issue. If the problem persists and you need immediate assistance, please send us an email instead.</p>\r\n");
      out.write("\t\t        <p class=\"lead\">If you're the site owner</p>\r\n");
      out.write("\t\t         <p>Clearing your browser cache and refreshing the page may clear this issue. If the problem persists and you need immediate assistance, please contact your website provider.</p>\r\n");
      out.write("\t\t     </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_ct_005fLoadScriptsAndStyles_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ct:LoadScriptsAndStyles
    org.apache.jsp.tag.web.LoadScriptsAndStyles_tag _jspx_th_ct_005fLoadScriptsAndStyles_005f0 = (new org.apache.jsp.tag.web.LoadScriptsAndStyles_tag());
    _jsp_getInstanceManager().newInstance(_jspx_th_ct_005fLoadScriptsAndStyles_005f0);
    _jspx_th_ct_005fLoadScriptsAndStyles_005f0.setJspContext(_jspx_page_context);
    _jspx_th_ct_005fLoadScriptsAndStyles_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_ct_005fLoadScriptsAndStyles_005f0);
    return false;
  }
}