package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jspx extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_view;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputStyle_id_href_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_styleClass_columns_cellspacing;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputText_value_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_form_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_style_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_menuItemSeparator_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_id_columns;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_inputText_value_maxlength_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_inputSecret_value_maxlength_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_commandButton_value_id_actionListener_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGroup_styleClass_effect;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputText_visible_value_id_nobody;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_f_view = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputStyle_id_href_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_styleClass_columns_cellspacing = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputText_value_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_form_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_style_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_menuItemSeparator_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_id_columns = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_inputText_value_maxlength_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_inputSecret_value_maxlength_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_commandButton_value_id_actionListener_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGroup_styleClass_effect = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputText_visible_value_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_f_view.release();
    _jspx_tagPool_ice_outputStyle_id_href_nobody.release();
    _jspx_tagPool_ice_panelGrid_styleClass_columns_cellspacing.release();
    _jspx_tagPool_ice_outputText_value_id_nobody.release();
    _jspx_tagPool_ice_form_id.release();
    _jspx_tagPool_ice_panelGrid_style_id.release();
    _jspx_tagPool_ice_menuItemSeparator_id_nobody.release();
    _jspx_tagPool_ice_panelGrid_id_columns.release();
    _jspx_tagPool_ice_inputText_value_maxlength_id_nobody.release();
    _jspx_tagPool_ice_inputSecret_value_maxlength_id_nobody.release();
    _jspx_tagPool_ice_commandButton_value_id_actionListener_nobody.release();
    _jspx_tagPool_ice_panelGroup_styleClass_effect.release();
    _jspx_tagPool_ice_outputText_visible_value_id_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      if (_jspx_meth_f_view_0(_jspx_page_context))
        return;
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_f_view_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:view
    com.sun.faces.taglib.jsf_core.ViewTag _jspx_th_f_view_0 = new com.sun.faces.taglib.jsf_core.ViewTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_view_0      );
    }
    _jspx_th_f_view_0.setPageContext(_jspx_page_context);
    _jspx_th_f_view_0.setParent(null);
    _jspx_th_f_view_0.setJspId("id2");
    int _jspx_eval_f_view_0 = _jspx_th_f_view_0.doStartTag();
    if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_f_view_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_f_view_0.doInitBody();
      }
      do {
        out.write("<html>");
        out.write("<head>");
        out.write("<title>");
        out.write("UNA | Oficina Postal | Ingreso de Usuarios");
        out.write("</title>");
        if (_jspx_meth_ice_outputStyle_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_outputStyle_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</head>");
        out.write("<body>");
        out.write("<table style=\"height:100%; vertical-align: top;\" width=\"100%\">");
        out.write("<tr>");
        out.write("<td valign=\"top\" colspan=\"2\">");
        if (_jspx_meth_ice_panelGrid_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("</tr>");
        out.write("<tr valign=\"top\">");
        out.write("<td style=\"height:100%\" align=\"center\" valign=\"top\" width=\"100%\">");
        out.write("<p align=\"right\">");
        if (_jspx_meth_ice_outputText_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</p>");
        if (_jspx_meth_ice_form_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td colspan=\"2\" id=\"td_footer\">");
        if (_jspx_meth_ice_panelGroup_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("</tr>");
        out.write("</table>");
        out.write("</body>");
        out.write("</html>");
        int evalDoAfterBody = _jspx_th_f_view_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_f_view_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_view.reuse(_jspx_th_f_view_0);
      return true;
    }
    _jspx_tagPool_f_view.reuse(_jspx_th_f_view_0);
    return false;
  }

  private boolean _jspx_meth_ice_outputStyle_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputStyle
    com.icesoft.faces.component.style.OutputStyleTag _jspx_th_ice_outputStyle_0 = new com.icesoft.faces.component.style.OutputStyleTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputStyle_0      );
    }
    _jspx_th_ice_outputStyle_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputStyle_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_outputStyle_0.setJspId("id6");
    _jspx_th_ice_outputStyle_0.setId("rimeStyle");
    _jspx_th_ice_outputStyle_0.setHref("./resources/rime/rime.css");
    int _jspx_eval_ice_outputStyle_0 = _jspx_th_ice_outputStyle_0.doStartTag();
    if (_jspx_th_ice_outputStyle_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputStyle_id_href_nobody.reuse(_jspx_th_ice_outputStyle_0);
      return true;
    }
    _jspx_tagPool_ice_outputStyle_id_href_nobody.reuse(_jspx_th_ice_outputStyle_0);
    return false;
  }

  private boolean _jspx_meth_ice_outputStyle_1(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputStyle
    com.icesoft.faces.component.style.OutputStyleTag _jspx_th_ice_outputStyle_1 = new com.icesoft.faces.component.style.OutputStyleTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputStyle_1      );
    }
    _jspx_th_ice_outputStyle_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputStyle_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_outputStyle_1.setJspId("id7");
    _jspx_th_ice_outputStyle_1.setId("panelesStyle");
    _jspx_th_ice_outputStyle_1.setHref("./resources/paneles.css");
    int _jspx_eval_ice_outputStyle_1 = _jspx_th_ice_outputStyle_1.doStartTag();
    if (_jspx_th_ice_outputStyle_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputStyle_id_href_nobody.reuse(_jspx_th_ice_outputStyle_1);
      return true;
    }
    _jspx_tagPool_ice_outputStyle_id_href_nobody.reuse(_jspx_th_ice_outputStyle_1);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_0 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_0      );
    }
    _jspx_th_ice_panelGrid_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_panelGrid_0.setJspId("id12");
    _jspx_th_ice_panelGrid_0.setStyleClass("headerGrid");
    _jspx_th_ice_panelGrid_0.setCellspacing("10");
    _jspx_th_ice_panelGrid_0.setColumns("2");
    int _jspx_eval_ice_panelGrid_0 = _jspx_th_ice_panelGrid_0.doStartTag();
    if (_jspx_eval_ice_panelGrid_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_0.doInitBody();
      }
      do {
        out.write("<img align=\"left\" alt=\"Logotipo UNA\" src=\"./resources/images/logoUNA.png\" />");
        out.write("<img align=\"left\" alt=\"Logotipo PGC\" src=\"./resources/images/pgc2.png\" />");
        int evalDoAfterBody = _jspx_th_ice_panelGrid_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_styleClass_columns_cellspacing.reuse(_jspx_th_ice_panelGrid_0);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_styleClass_columns_cellspacing.reuse(_jspx_th_ice_panelGrid_0);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_0 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_0      );
    }
    _jspx_th_ice_outputText_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_outputText_0.setJspId("id18");
    _jspx_th_ice_outputText_0.setValue("Ingreso de Usuarios");
    _jspx_th_ice_outputText_0.setId("ot_navegacion");
    int _jspx_eval_ice_outputText_0 = _jspx_th_ice_outputText_0.doStartTag();
    if (_jspx_th_ice_outputText_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_0);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_0);
    return false;
  }

  private boolean _jspx_meth_ice_form_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:form
    com.icesoft.faces.component.FormTag _jspx_th_ice_form_0 = new com.icesoft.faces.component.FormTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_form_0      );
    }
    _jspx_th_ice_form_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_form_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_form_0.setJspId("id19");
    _jspx_th_ice_form_0.setId("frm_principal");
    int _jspx_eval_ice_form_0 = _jspx_th_ice_form_0.doStartTag();
    if (_jspx_eval_ice_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_form_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_form_0.doInitBody();
      }
      do {
        out.write("<br />");
        out.write("<br />");
        if (_jspx_meth_ice_panelGrid_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_form_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_0);
      return true;
    }
    _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_0);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_1 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_1      );
    }
    _jspx_th_ice_panelGrid_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_form_0);
    _jspx_th_ice_panelGrid_1.setJspId("id22");
    _jspx_th_ice_panelGrid_1.setStyle("width: 45%; align: center;");
    _jspx_th_ice_panelGrid_1.setId("pgrd_principal");
    int _jspx_eval_ice_panelGrid_1 = _jspx_th_ice_panelGrid_1.doStartTag();
    if (_jspx_eval_ice_panelGrid_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_1.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_1, _jspx_page_context))
          return true;
        out.write("<br />");
        if (_jspx_meth_ice_menuItemSeparator_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_1, _jspx_page_context))
          return true;
        out.write("<br />");
        if (_jspx_meth_ice_panelGrid_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_1, _jspx_page_context))
          return true;
        out.write("<br />");
        out.write("<p align=\"center\">");
        if (_jspx_meth_ice_commandButton_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_1, _jspx_page_context))
          return true;
        out.write("</p>");
        out.write("<br />");
        out.write("<p align=\"right\">");
        out.write("<a href=\"http://www.claves.una.ac.cr\">");
        out.write("Cambiar la clave de acceso");
        out.write("</a>");
        out.write("</p>");
        int evalDoAfterBody = _jspx_th_ice_panelGrid_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_style_id.reuse(_jspx_th_ice_panelGrid_1);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_style_id.reuse(_jspx_th_ice_panelGrid_1);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_1 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_1      );
    }
    _jspx_th_ice_outputText_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_1);
    _jspx_th_ice_outputText_1.setJspId("id23");
    _jspx_th_ice_outputText_1.setValue("Introduzca la información necesaria para ingresar al sistema.");
    _jspx_th_ice_outputText_1.setId("ot_instrucciones");
    int _jspx_eval_ice_outputText_1 = _jspx_th_ice_outputText_1.doStartTag();
    if (_jspx_th_ice_outputText_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_1);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_1);
    return false;
  }

  private boolean _jspx_meth_ice_menuItemSeparator_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItemSeparator
    com.icesoft.faces.component.menubar.MenuItemSeparatorTag _jspx_th_ice_menuItemSeparator_0 = new com.icesoft.faces.component.menubar.MenuItemSeparatorTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItemSeparator_0      );
    }
    _jspx_th_ice_menuItemSeparator_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItemSeparator_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_1);
    _jspx_th_ice_menuItemSeparator_0.setJspId("id25");
    _jspx_th_ice_menuItemSeparator_0.setId("mis_separador");
    int _jspx_eval_ice_menuItemSeparator_0 = _jspx_th_ice_menuItemSeparator_0.doStartTag();
    if (_jspx_th_ice_menuItemSeparator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItemSeparator_id_nobody.reuse(_jspx_th_ice_menuItemSeparator_0);
      return true;
    }
    _jspx_tagPool_ice_menuItemSeparator_id_nobody.reuse(_jspx_th_ice_menuItemSeparator_0);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_2 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_2      );
    }
    _jspx_th_ice_panelGrid_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_1);
    _jspx_th_ice_panelGrid_2.setJspId("id27");
    _jspx_th_ice_panelGrid_2.setColumns("2");
    _jspx_th_ice_panelGrid_2.setId("pgrd_ingreso");
    int _jspx_eval_ice_panelGrid_2 = _jspx_th_ice_panelGrid_2.doStartTag();
    if (_jspx_eval_ice_panelGrid_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_2.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_2, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_inputText_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_2, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_outputText_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_2, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_inputSecret_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_2);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_2);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_2 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_2      );
    }
    _jspx_th_ice_outputText_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_2);
    _jspx_th_ice_outputText_2.setJspId("id28");
    _jspx_th_ice_outputText_2.setValue("Identificación: ");
    _jspx_th_ice_outputText_2.setId("ot_identificacion");
    int _jspx_eval_ice_outputText_2 = _jspx_th_ice_outputText_2.doStartTag();
    if (_jspx_th_ice_outputText_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_2);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_2);
    return false;
  }

  private boolean _jspx_meth_ice_inputText_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:inputText
    com.icesoft.faces.component.InputTextTag _jspx_th_ice_inputText_0 = new com.icesoft.faces.component.InputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_inputText_0      );
    }
    _jspx_th_ice_inputText_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_inputText_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_2);
    _jspx_th_ice_inputText_0.setJspId("id29");
    _jspx_th_ice_inputText_0.setMaxlength("9");
    _jspx_th_ice_inputText_0.setValue("#{SeguridadManagedBean.id}");
    _jspx_th_ice_inputText_0.setId("it_identificador");
    int _jspx_eval_ice_inputText_0 = _jspx_th_ice_inputText_0.doStartTag();
    if (_jspx_th_ice_inputText_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_inputText_value_maxlength_id_nobody.reuse(_jspx_th_ice_inputText_0);
      return true;
    }
    _jspx_tagPool_ice_inputText_value_maxlength_id_nobody.reuse(_jspx_th_ice_inputText_0);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_3(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_3 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_3      );
    }
    _jspx_th_ice_outputText_3.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_2);
    _jspx_th_ice_outputText_3.setJspId("id30");
    _jspx_th_ice_outputText_3.setValue("Contraseña: ");
    _jspx_th_ice_outputText_3.setId("ot_clave");
    int _jspx_eval_ice_outputText_3 = _jspx_th_ice_outputText_3.doStartTag();
    if (_jspx_th_ice_outputText_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_3);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_3);
    return false;
  }

  private boolean _jspx_meth_ice_inputSecret_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:inputSecret
    com.icesoft.faces.component.InputSecretTag _jspx_th_ice_inputSecret_0 = new com.icesoft.faces.component.InputSecretTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_inputSecret_0      );
    }
    _jspx_th_ice_inputSecret_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_inputSecret_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_2);
    _jspx_th_ice_inputSecret_0.setJspId("id31");
    _jspx_th_ice_inputSecret_0.setMaxlength("6");
    _jspx_th_ice_inputSecret_0.setValue("#{SeguridadManagedBean.contra}");
    _jspx_th_ice_inputSecret_0.setId("is_contraseña");
    int _jspx_eval_ice_inputSecret_0 = _jspx_th_ice_inputSecret_0.doStartTag();
    if (_jspx_th_ice_inputSecret_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_inputSecret_value_maxlength_id_nobody.reuse(_jspx_th_ice_inputSecret_0);
      return true;
    }
    _jspx_tagPool_ice_inputSecret_value_maxlength_id_nobody.reuse(_jspx_th_ice_inputSecret_0);
    return false;
  }

  private boolean _jspx_meth_ice_commandButton_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:commandButton
    com.icesoft.faces.component.CommandButtonTag _jspx_th_ice_commandButton_0 = new com.icesoft.faces.component.CommandButtonTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_commandButton_0      );
    }
    _jspx_th_ice_commandButton_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_commandButton_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_1);
    _jspx_th_ice_commandButton_0.setJspId("id34");
    _jspx_th_ice_commandButton_0.setActionListener("#{SeguridadManagedBean.action_cb_ingresarUsuario}");
    _jspx_th_ice_commandButton_0.setValue("Ingresar al sistema");
    _jspx_th_ice_commandButton_0.setId("cb_ingresar");
    int _jspx_eval_ice_commandButton_0 = _jspx_th_ice_commandButton_0.doStartTag();
    if (_jspx_th_ice_commandButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_commandButton_value_id_actionListener_nobody.reuse(_jspx_th_ice_commandButton_0);
      return true;
    }
    _jspx_tagPool_ice_commandButton_value_id_actionListener_nobody.reuse(_jspx_th_ice_commandButton_0);
    return false;
  }

  private boolean _jspx_meth_ice_panelGroup_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_0 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_0      );
    }
    _jspx_th_ice_panelGroup_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_panelGroup_0.setJspId("id40");
    _jspx_th_ice_panelGroup_0.setEffect("#{SeguridadManagedBean.efecto}");
    _jspx_th_ice_panelGroup_0.setStyleClass("footer");
    int _jspx_eval_ice_panelGroup_0 = _jspx_th_ice_panelGroup_0.doStartTag();
    if (_jspx_eval_ice_panelGroup_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_0.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_outputText_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_styleClass_effect.reuse(_jspx_th_ice_panelGroup_0);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_styleClass_effect.reuse(_jspx_th_ice_panelGroup_0);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_4(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_4 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_4      );
    }
    _jspx_th_ice_outputText_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_0);
    _jspx_th_ice_outputText_4.setJspId("id41");
    _jspx_th_ice_outputText_4.setValue("#{SeguridadManagedBean.infoFooter}");
    _jspx_th_ice_outputText_4.setId("south");
    int _jspx_eval_ice_outputText_4 = _jspx_th_ice_outputText_4.doStartTag();
    if (_jspx_th_ice_outputText_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_4);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_4);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_5(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_5 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_5      );
    }
    _jspx_th_ice_outputText_5.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_0);
    _jspx_th_ice_outputText_5.setJspId("id42");
    _jspx_th_ice_outputText_5.setVisible("false");
    _jspx_th_ice_outputText_5.setValue("#{Log.init}");
    _jspx_th_ice_outputText_5.setId("ot_cargar");
    int _jspx_eval_ice_outputText_5 = _jspx_th_ice_outputText_5.doStartTag();
    if (_jspx_th_ice_outputText_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_visible_value_id_nobody.reuse(_jspx_th_ice_outputText_5);
      return true;
    }
    _jspx_tagPool_ice_outputText_visible_value_id_nobody.reuse(_jspx_th_ice_outputText_5);
    return false;
  }
}
