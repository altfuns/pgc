package org.apache.jsp.ModuloEstadistica;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gastosAnuales_jspx extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_view;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputStyle_id_href_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_styleClass_columns_cellspacing;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_form_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGroup_styleClass_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_id_columns;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_menuBar_orientation_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_menuItem_value_link_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_menuItem_value_onclick_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_menuItems_value_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_menuItem_value_id_actionListener_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputText_value_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_width_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_id_columns_cellspacing;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_selectInputDate_value_required_renderAsPopup_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_convertDateTime_pattern_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_selectInputDate_value_renderAsPopup_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_commandButton_value_id_action_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_width_visible_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelCollapsible_id_expanded;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_facet_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_width_id_columns;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGroup_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_dataTable_var_value_id_columnClasses;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_column;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputText_value_style_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_columns_var_value_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGroup;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGroup_style;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputChart_yaxisTitle_xaxisTitle_xaxisLabels_width_type_renderOnSubmit_labels_data_chartTitle_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputResource_type_resource_mimeType_id_fileName_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_styleClass;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_f_view = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputStyle_id_href_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_styleClass_columns_cellspacing = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_form_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGroup_styleClass_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_id_columns = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_menuBar_orientation_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_menuItem_value_link_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_menuItem_value_onclick_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_menuItems_value_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_menuItem_value_id_actionListener_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputText_value_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_width_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_id_columns_cellspacing = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_selectInputDate_value_required_renderAsPopup_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_convertDateTime_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_selectInputDate_value_renderAsPopup_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_commandButton_value_id_action_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_width_visible_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelCollapsible_id_expanded = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_facet_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_width_id_columns = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGroup_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_dataTable_var_value_id_columnClasses = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_column = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputText_value_style_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_columns_var_value_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGroup = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGroup_style = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputChart_yaxisTitle_xaxisTitle_xaxisLabels_width_type_renderOnSubmit_labels_data_chartTitle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputResource_type_resource_mimeType_id_fileName_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGrid_styleClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_f_view.release();
    _jspx_tagPool_ice_outputStyle_id_href_nobody.release();
    _jspx_tagPool_ice_panelGrid_styleClass_columns_cellspacing.release();
    _jspx_tagPool_ice_form_id.release();
    _jspx_tagPool_ice_panelGroup_styleClass_id.release();
    _jspx_tagPool_ice_panelGrid_id_columns.release();
    _jspx_tagPool_ice_menuBar_orientation_id.release();
    _jspx_tagPool_ice_menuItem_value_link_id_nobody.release();
    _jspx_tagPool_ice_menuItem_value_onclick_id.release();
    _jspx_tagPool_ice_menuItems_value_id_nobody.release();
    _jspx_tagPool_ice_menuItem_value_id_actionListener_nobody.release();
    _jspx_tagPool_ice_outputText_value_id_nobody.release();
    _jspx_tagPool_ice_panelGrid_width_id.release();
    _jspx_tagPool_ice_panelGrid_id_columns_cellspacing.release();
    _jspx_tagPool_ice_selectInputDate_value_required_renderAsPopup_id.release();
    _jspx_tagPool_f_convertDateTime_pattern_nobody.release();
    _jspx_tagPool_ice_selectInputDate_value_renderAsPopup_id.release();
    _jspx_tagPool_ice_commandButton_value_id_action_nobody.release();
    _jspx_tagPool_ice_panelGrid_width_visible_id.release();
    _jspx_tagPool_ice_panelCollapsible_id_expanded.release();
    _jspx_tagPool_f_facet_name.release();
    _jspx_tagPool_ice_panelGrid_width_id_columns.release();
    _jspx_tagPool_ice_panelGroup_id.release();
    _jspx_tagPool_ice_dataTable_var_value_id_columnClasses.release();
    _jspx_tagPool_ice_column.release();
    _jspx_tagPool_ice_outputText_value_style_nobody.release();
    _jspx_tagPool_ice_columns_var_value_id.release();
    _jspx_tagPool_ice_panelGroup.release();
    _jspx_tagPool_ice_panelGroup_style.release();
    _jspx_tagPool_ice_outputChart_yaxisTitle_xaxisTitle_xaxisLabels_width_type_renderOnSubmit_labels_data_chartTitle_nobody.release();
    _jspx_tagPool_ice_outputResource_type_resource_mimeType_id_fileName_nobody.release();
    _jspx_tagPool_ice_panelGrid_styleClass.release();
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
        out.write("UNA | Oficina Postal | Reporte Anual de Gastos");
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
        out.write("<td valign=\"top\">");
        if (_jspx_meth_ice_form_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("<td style=\"height:100%\" valign=\"top\" width=\"100%\">");
        out.write("<p align=\"right\">");
        if (_jspx_meth_ice_outputText_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</p>");
        if (_jspx_meth_ice_form_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_form_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_form_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td colspan=\"2\" id=\"td_footer\">");
        if (_jspx_meth_ice_form_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
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
    _jspx_th_ice_outputStyle_0.setHref("../resources/rime/rime.css");
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
    _jspx_th_ice_outputStyle_1.setHref("../resources/paneles.css");
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
        out.write("<img align=\"left\" alt=\"Logotipo UNA\" src=\"../resources/images/logoUNA.png\" />");
        out.write("<img align=\"left\" alt=\"Logotipo PGC\" src=\"../resources/images/pgc2.png\" />");
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
    _jspx_th_ice_form_0.setJspId("id17");
    _jspx_th_ice_form_0.setId("frm_Menu");
    int _jspx_eval_ice_form_0 = _jspx_th_ice_form_0.doStartTag();
    if (_jspx_eval_ice_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_form_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_form_0.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGroup_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_form_0, _jspx_page_context))
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

  private boolean _jspx_meth_ice_panelGroup_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_0 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_0      );
    }
    _jspx_th_ice_panelGroup_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_form_0);
    _jspx_th_ice_panelGroup_0.setJspId("id18");
    _jspx_th_ice_panelGroup_0.setStyleClass("menu");
    _jspx_th_ice_panelGroup_0.setId("pgrp_menu");
    int _jspx_eval_ice_panelGroup_0 = _jspx_th_ice_panelGroup_0.doStartTag();
    if (_jspx_eval_ice_panelGroup_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_0.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGrid_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_styleClass_id.reuse(_jspx_th_ice_panelGroup_0);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_styleClass_id.reuse(_jspx_th_ice_panelGroup_0);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_1 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_1      );
    }
    _jspx_th_ice_panelGrid_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_0);
    _jspx_th_ice_panelGrid_1.setJspId("id19");
    _jspx_th_ice_panelGrid_1.setColumns("1");
    _jspx_th_ice_panelGrid_1.setId("pgrd_menu");
    int _jspx_eval_ice_panelGrid_1 = _jspx_th_ice_panelGrid_1.doStartTag();
    if (_jspx_eval_ice_panelGrid_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_1.doInitBody();
      }
      do {
        if (_jspx_meth_ice_menuBar_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_1);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_1);
    return false;
  }

  private boolean _jspx_meth_ice_menuBar_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuBar
    com.icesoft.faces.component.menubar.MenuBarTag _jspx_th_ice_menuBar_0 = new com.icesoft.faces.component.menubar.MenuBarTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuBar_0      );
    }
    _jspx_th_ice_menuBar_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuBar_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_1);
    _jspx_th_ice_menuBar_0.setJspId("id20");
    _jspx_th_ice_menuBar_0.setOrientation("Vertical");
    _jspx_th_ice_menuBar_0.setId("mb_menu");
    int _jspx_eval_ice_menuBar_0 = _jspx_th_ice_menuBar_0.doStartTag();
    if (_jspx_eval_ice_menuBar_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_menuBar_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_menuBar_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_menuBar_0.doInitBody();
      }
      do {
        if (_jspx_meth_ice_menuItem_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuBar_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_menuItem_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuBar_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_menuItem_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuBar_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_menuItem_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuBar_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_menuItem_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuBar_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_menuItem_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuBar_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_menuBar_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_menuBar_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_menuBar_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuBar_orientation_id.reuse(_jspx_th_ice_menuBar_0);
      return true;
    }
    _jspx_tagPool_ice_menuBar_orientation_id.reuse(_jspx_th_ice_menuBar_0);
    return false;
  }

  private boolean _jspx_meth_ice_menuItem_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuBar_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItem
    com.icesoft.faces.component.menubar.MenuItemTag _jspx_th_ice_menuItem_0 = new com.icesoft.faces.component.menubar.MenuItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItem_0      );
    }
    _jspx_th_ice_menuItem_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItem_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuBar_0);
    _jspx_th_ice_menuItem_0.setJspId("id21");
    _jspx_th_ice_menuItem_0.setLink("#{SeguridadManagedBean.linkBienvenida}");
    _jspx_th_ice_menuItem_0.setId("mi_home");
    _jspx_th_ice_menuItem_0.setValue("Inicio");
    int _jspx_eval_ice_menuItem_0 = _jspx_th_ice_menuItem_0.doStartTag();
    if (_jspx_th_ice_menuItem_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItem_value_link_id_nobody.reuse(_jspx_th_ice_menuItem_0);
      return true;
    }
    _jspx_tagPool_ice_menuItem_value_link_id_nobody.reuse(_jspx_th_ice_menuItem_0);
    return false;
  }

  private boolean _jspx_meth_ice_menuItem_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuBar_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItem
    com.icesoft.faces.component.menubar.MenuItemTag _jspx_th_ice_menuItem_1 = new com.icesoft.faces.component.menubar.MenuItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItem_1      );
    }
    _jspx_th_ice_menuItem_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItem_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuBar_0);
    _jspx_th_ice_menuItem_1.setJspId("id22");
    _jspx_th_ice_menuItem_1.setOnclick("return false;");
    _jspx_th_ice_menuItem_1.setId("mi_interna");
    _jspx_th_ice_menuItem_1.setValue("Interna - Externa");
    int _jspx_eval_ice_menuItem_1 = _jspx_th_ice_menuItem_1.doStartTag();
    if (_jspx_eval_ice_menuItem_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_menuItem_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_menuItem_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_menuItem_1.doInitBody();
      }
      do {
        if (_jspx_meth_ice_menuItems_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuItem_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_menuItem_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_menuItem_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_menuItem_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItem_value_onclick_id.reuse(_jspx_th_ice_menuItem_1);
      return true;
    }
    _jspx_tagPool_ice_menuItem_value_onclick_id.reuse(_jspx_th_ice_menuItem_1);
    return false;
  }

  private boolean _jspx_meth_ice_menuItems_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuItem_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItems
    com.icesoft.faces.component.menubar.MenuItemsTag _jspx_th_ice_menuItems_0 = new com.icesoft.faces.component.menubar.MenuItemsTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItems_0      );
    }
    _jspx_th_ice_menuItems_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItems_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuItem_1);
    _jspx_th_ice_menuItems_0.setJspId("id23");
    _jspx_th_ice_menuItems_0.setValue("#{SeguridadManagedBean.itemesRutas}");
    _jspx_th_ice_menuItems_0.setId("mits_rutas");
    int _jspx_eval_ice_menuItems_0 = _jspx_th_ice_menuItems_0.doStartTag();
    if (_jspx_th_ice_menuItems_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItems_value_id_nobody.reuse(_jspx_th_ice_menuItems_0);
      return true;
    }
    _jspx_tagPool_ice_menuItems_value_id_nobody.reuse(_jspx_th_ice_menuItems_0);
    return false;
  }

  private boolean _jspx_meth_ice_menuItem_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuBar_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItem
    com.icesoft.faces.component.menubar.MenuItemTag _jspx_th_ice_menuItem_2 = new com.icesoft.faces.component.menubar.MenuItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItem_2      );
    }
    _jspx_th_ice_menuItem_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItem_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuBar_0);
    _jspx_th_ice_menuItem_2.setJspId("id24");
    _jspx_th_ice_menuItem_2.setOnclick("return false;");
    _jspx_th_ice_menuItem_2.setId("mi_edit");
    _jspx_th_ice_menuItem_2.setValue("Correos de Costa Rica");
    int _jspx_eval_ice_menuItem_2 = _jspx_th_ice_menuItem_2.doStartTag();
    if (_jspx_eval_ice_menuItem_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_menuItem_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_menuItem_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_menuItem_2.doInitBody();
      }
      do {
        if (_jspx_meth_ice_menuItems_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuItem_2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_menuItem_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_menuItem_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_menuItem_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItem_value_onclick_id.reuse(_jspx_th_ice_menuItem_2);
      return true;
    }
    _jspx_tagPool_ice_menuItem_value_onclick_id.reuse(_jspx_th_ice_menuItem_2);
    return false;
  }

  private boolean _jspx_meth_ice_menuItems_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuItem_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItems
    com.icesoft.faces.component.menubar.MenuItemsTag _jspx_th_ice_menuItems_1 = new com.icesoft.faces.component.menubar.MenuItemsTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItems_1      );
    }
    _jspx_th_ice_menuItems_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItems_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuItem_2);
    _jspx_th_ice_menuItems_1.setJspId("id25");
    _jspx_th_ice_menuItems_1.setValue("#{SeguridadManagedBean.itemesExterna}");
    _jspx_th_ice_menuItems_1.setId("mits_externa");
    int _jspx_eval_ice_menuItems_1 = _jspx_th_ice_menuItems_1.doStartTag();
    if (_jspx_th_ice_menuItems_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItems_value_id_nobody.reuse(_jspx_th_ice_menuItems_1);
      return true;
    }
    _jspx_tagPool_ice_menuItems_value_id_nobody.reuse(_jspx_th_ice_menuItems_1);
    return false;
  }

  private boolean _jspx_meth_ice_menuItem_3(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuBar_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItem
    com.icesoft.faces.component.menubar.MenuItemTag _jspx_th_ice_menuItem_3 = new com.icesoft.faces.component.menubar.MenuItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItem_3      );
    }
    _jspx_th_ice_menuItem_3.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItem_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuBar_0);
    _jspx_th_ice_menuItem_3.setJspId("id26");
    _jspx_th_ice_menuItem_3.setOnclick("return false;");
    _jspx_th_ice_menuItem_3.setId("mi_administracion");
    _jspx_th_ice_menuItem_3.setValue("Administración");
    int _jspx_eval_ice_menuItem_3 = _jspx_th_ice_menuItem_3.doStartTag();
    if (_jspx_eval_ice_menuItem_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_menuItem_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_menuItem_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_menuItem_3.doInitBody();
      }
      do {
        if (_jspx_meth_ice_menuItems_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuItem_3, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_menuItem_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_menuItem_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_menuItem_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItem_value_onclick_id.reuse(_jspx_th_ice_menuItem_3);
      return true;
    }
    _jspx_tagPool_ice_menuItem_value_onclick_id.reuse(_jspx_th_ice_menuItem_3);
    return false;
  }

  private boolean _jspx_meth_ice_menuItems_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuItem_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItems
    com.icesoft.faces.component.menubar.MenuItemsTag _jspx_th_ice_menuItems_2 = new com.icesoft.faces.component.menubar.MenuItemsTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItems_2      );
    }
    _jspx_th_ice_menuItems_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItems_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuItem_3);
    _jspx_th_ice_menuItems_2.setJspId("id27");
    _jspx_th_ice_menuItems_2.setValue("#{SeguridadManagedBean.itemesAdministracion}");
    _jspx_th_ice_menuItems_2.setId("mits_admon");
    int _jspx_eval_ice_menuItems_2 = _jspx_th_ice_menuItems_2.doStartTag();
    if (_jspx_th_ice_menuItems_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItems_value_id_nobody.reuse(_jspx_th_ice_menuItems_2);
      return true;
    }
    _jspx_tagPool_ice_menuItems_value_id_nobody.reuse(_jspx_th_ice_menuItems_2);
    return false;
  }

  private boolean _jspx_meth_ice_menuItem_4(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuBar_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItem
    com.icesoft.faces.component.menubar.MenuItemTag _jspx_th_ice_menuItem_4 = new com.icesoft.faces.component.menubar.MenuItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItem_4      );
    }
    _jspx_th_ice_menuItem_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItem_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuBar_0);
    _jspx_th_ice_menuItem_4.setJspId("id28");
    _jspx_th_ice_menuItem_4.setOnclick("return false;");
    _jspx_th_ice_menuItem_4.setId("mi_estadistica");
    _jspx_th_ice_menuItem_4.setValue("Estadística");
    int _jspx_eval_ice_menuItem_4 = _jspx_th_ice_menuItem_4.doStartTag();
    if (_jspx_eval_ice_menuItem_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_menuItem_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_menuItem_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_menuItem_4.doInitBody();
      }
      do {
        if (_jspx_meth_ice_menuItems_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_menuItem_4, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_menuItem_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_menuItem_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_menuItem_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItem_value_onclick_id.reuse(_jspx_th_ice_menuItem_4);
      return true;
    }
    _jspx_tagPool_ice_menuItem_value_onclick_id.reuse(_jspx_th_ice_menuItem_4);
    return false;
  }

  private boolean _jspx_meth_ice_menuItems_3(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuItem_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItems
    com.icesoft.faces.component.menubar.MenuItemsTag _jspx_th_ice_menuItems_3 = new com.icesoft.faces.component.menubar.MenuItemsTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItems_3      );
    }
    _jspx_th_ice_menuItems_3.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItems_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuItem_4);
    _jspx_th_ice_menuItems_3.setJspId("id29");
    _jspx_th_ice_menuItems_3.setValue("#{SeguridadManagedBean.itemesEstadistica}");
    _jspx_th_ice_menuItems_3.setId("mits_estadistica");
    int _jspx_eval_ice_menuItems_3 = _jspx_th_ice_menuItems_3.doStartTag();
    if (_jspx_th_ice_menuItems_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItems_value_id_nobody.reuse(_jspx_th_ice_menuItems_3);
      return true;
    }
    _jspx_tagPool_ice_menuItems_value_id_nobody.reuse(_jspx_th_ice_menuItems_3);
    return false;
  }

  private boolean _jspx_meth_ice_menuItem_5(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_menuBar_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:menuItem
    com.icesoft.faces.component.menubar.MenuItemTag _jspx_th_ice_menuItem_5 = new com.icesoft.faces.component.menubar.MenuItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_menuItem_5      );
    }
    _jspx_th_ice_menuItem_5.setPageContext(_jspx_page_context);
    _jspx_th_ice_menuItem_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_menuBar_0);
    _jspx_th_ice_menuItem_5.setJspId("id30");
    _jspx_th_ice_menuItem_5.setActionListener("#{SeguridadManagedBean.action_mi_salir}");
    _jspx_th_ice_menuItem_5.setId("mi_salir");
    _jspx_th_ice_menuItem_5.setValue("Salir");
    int _jspx_eval_ice_menuItem_5 = _jspx_th_ice_menuItem_5.doStartTag();
    if (_jspx_th_ice_menuItem_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_menuItem_value_id_actionListener_nobody.reuse(_jspx_th_ice_menuItem_5);
      return true;
    }
    _jspx_tagPool_ice_menuItem_value_id_actionListener_nobody.reuse(_jspx_th_ice_menuItem_5);
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
    _jspx_th_ice_outputText_0.setJspId("id33");
    _jspx_th_ice_outputText_0.setValue("Estadística | Reporte de Anual de Gastos");
    _jspx_th_ice_outputText_0.setId("ot_navegacion");
    int _jspx_eval_ice_outputText_0 = _jspx_th_ice_outputText_0.doStartTag();
    if (_jspx_th_ice_outputText_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_0);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_0);
    return false;
  }

  private boolean _jspx_meth_ice_form_1(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:form
    com.icesoft.faces.component.FormTag _jspx_th_ice_form_1 = new com.icesoft.faces.component.FormTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_form_1      );
    }
    _jspx_th_ice_form_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_form_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_form_1.setJspId("id34");
    _jspx_th_ice_form_1.setId("frm_Titulo");
    int _jspx_eval_ice_form_1 = _jspx_th_ice_form_1.doStartTag();
    if (_jspx_eval_ice_form_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_form_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_form_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_form_1.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGrid_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_form_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_form_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_form_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_form_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_1);
      return true;
    }
    _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_1);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_form_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_2 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_2      );
    }
    _jspx_th_ice_panelGrid_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_form_1);
    _jspx_th_ice_panelGrid_2.setJspId("id35");
    _jspx_th_ice_panelGrid_2.setWidth("100%");
    _jspx_th_ice_panelGrid_2.setId("pgrd_Titulo");
    int _jspx_eval_ice_panelGrid_2 = _jspx_th_ice_panelGrid_2.doStartTag();
    if (_jspx_eval_ice_panelGrid_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_2.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_2, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_panelGrid_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_width_id.reuse(_jspx_th_ice_panelGrid_2);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_width_id.reuse(_jspx_th_ice_panelGrid_2);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_1 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_1      );
    }
    _jspx_th_ice_outputText_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_2);
    _jspx_th_ice_outputText_1.setJspId("id36");
    _jspx_th_ice_outputText_1.setValue("Seleccione las fechas por las cuales desea generar el reporte.                                                     Si seleciona solo la Fecha Inicial, generará el reporte del último año.");
    _jspx_th_ice_outputText_1.setId("ot_discripcion");
    int _jspx_eval_ice_outputText_1 = _jspx_th_ice_outputText_1.doStartTag();
    if (_jspx_th_ice_outputText_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_1);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_1);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_3(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_3 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_3      );
    }
    _jspx_th_ice_panelGrid_3.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_2);
    _jspx_th_ice_panelGrid_3.setJspId("id37");
    _jspx_th_ice_panelGrid_3.setId("pgrd_Ruta");
    _jspx_th_ice_panelGrid_3.setColumns("2");
    _jspx_th_ice_panelGrid_3.setCellspacing("5");
    int _jspx_eval_ice_panelGrid_3 = _jspx_th_ice_panelGrid_3.doStartTag();
    if (_jspx_eval_ice_panelGrid_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_3.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_3, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_selectInputDate_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_3, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_outputText_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_3, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_selectInputDate_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_3, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_commandButton_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_3, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns_cellspacing.reuse(_jspx_th_ice_panelGrid_3);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns_cellspacing.reuse(_jspx_th_ice_panelGrid_3);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_2 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_2      );
    }
    _jspx_th_ice_outputText_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_3);
    _jspx_th_ice_outputText_2.setJspId("id38");
    _jspx_th_ice_outputText_2.setValue("Fecha Inicial : ");
    _jspx_th_ice_outputText_2.setId("ot_fi");
    int _jspx_eval_ice_outputText_2 = _jspx_th_ice_outputText_2.doStartTag();
    if (_jspx_th_ice_outputText_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_2);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_2);
    return false;
  }

  private boolean _jspx_meth_ice_selectInputDate_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:selectInputDate
    com.icesoft.faces.component.selectinputdate.SelectInputDateTag _jspx_th_ice_selectInputDate_0 = new com.icesoft.faces.component.selectinputdate.SelectInputDateTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_selectInputDate_0      );
    }
    _jspx_th_ice_selectInputDate_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_selectInputDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_3);
    _jspx_th_ice_selectInputDate_0.setJspId("id39");
    _jspx_th_ice_selectInputDate_0.setRequired("true");
    _jspx_th_ice_selectInputDate_0.setRenderAsPopup("true");
    _jspx_th_ice_selectInputDate_0.setValue("#{EstadisticaFacadeManaged.fechaInicial}");
    _jspx_th_ice_selectInputDate_0.setId("sid_fechaInicial");
    int _jspx_eval_ice_selectInputDate_0 = _jspx_th_ice_selectInputDate_0.doStartTag();
    if (_jspx_eval_ice_selectInputDate_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_selectInputDate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_selectInputDate_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_selectInputDate_0.doInitBody();
      }
      do {
        if (_jspx_meth_f_convertDateTime_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectInputDate_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_selectInputDate_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_selectInputDate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_selectInputDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_selectInputDate_value_required_renderAsPopup_id.reuse(_jspx_th_ice_selectInputDate_0);
      return true;
    }
    _jspx_tagPool_ice_selectInputDate_value_required_renderAsPopup_id.reuse(_jspx_th_ice_selectInputDate_0);
    return false;
  }

  private boolean _jspx_meth_f_convertDateTime_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectInputDate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:convertDateTime
    com.sun.faces.taglib.jsf_core.ConvertDateTimeTag _jspx_th_f_convertDateTime_0 = (com.sun.faces.taglib.jsf_core.ConvertDateTimeTag) _jspx_tagPool_f_convertDateTime_pattern_nobody.get(com.sun.faces.taglib.jsf_core.ConvertDateTimeTag.class);
    _jspx_th_f_convertDateTime_0.setPageContext(_jspx_page_context);
    _jspx_th_f_convertDateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectInputDate_0);
    _jspx_th_f_convertDateTime_0.setPattern(org.apache.jasper.runtime.PageContextImpl.getValueExpression("dd/MM/yyyy", (PageContext)_jspx_page_context, java.lang.String.class, null));
    int _jspx_eval_f_convertDateTime_0 = _jspx_th_f_convertDateTime_0.doStartTag();
    if (_jspx_th_f_convertDateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_convertDateTime_pattern_nobody.reuse(_jspx_th_f_convertDateTime_0);
      return true;
    }
    _jspx_tagPool_f_convertDateTime_pattern_nobody.reuse(_jspx_th_f_convertDateTime_0);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_3(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_3 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_3      );
    }
    _jspx_th_ice_outputText_3.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_3);
    _jspx_th_ice_outputText_3.setJspId("id41");
    _jspx_th_ice_outputText_3.setValue("Fecha Final : ");
    _jspx_th_ice_outputText_3.setId("ot_ff");
    int _jspx_eval_ice_outputText_3 = _jspx_th_ice_outputText_3.doStartTag();
    if (_jspx_th_ice_outputText_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_3);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_3);
    return false;
  }

  private boolean _jspx_meth_ice_selectInputDate_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:selectInputDate
    com.icesoft.faces.component.selectinputdate.SelectInputDateTag _jspx_th_ice_selectInputDate_1 = new com.icesoft.faces.component.selectinputdate.SelectInputDateTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_selectInputDate_1      );
    }
    _jspx_th_ice_selectInputDate_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_selectInputDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_3);
    _jspx_th_ice_selectInputDate_1.setJspId("id42");
    _jspx_th_ice_selectInputDate_1.setRenderAsPopup("true");
    _jspx_th_ice_selectInputDate_1.setValue("#{EstadisticaFacadeManaged.fechaFinal}");
    _jspx_th_ice_selectInputDate_1.setId("sid_fechaFinal");
    int _jspx_eval_ice_selectInputDate_1 = _jspx_th_ice_selectInputDate_1.doStartTag();
    if (_jspx_eval_ice_selectInputDate_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_selectInputDate_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_selectInputDate_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_selectInputDate_1.doInitBody();
      }
      do {
        if (_jspx_meth_f_convertDateTime_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectInputDate_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_selectInputDate_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_selectInputDate_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_selectInputDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_selectInputDate_value_renderAsPopup_id.reuse(_jspx_th_ice_selectInputDate_1);
      return true;
    }
    _jspx_tagPool_ice_selectInputDate_value_renderAsPopup_id.reuse(_jspx_th_ice_selectInputDate_1);
    return false;
  }

  private boolean _jspx_meth_f_convertDateTime_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectInputDate_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:convertDateTime
    com.sun.faces.taglib.jsf_core.ConvertDateTimeTag _jspx_th_f_convertDateTime_1 = (com.sun.faces.taglib.jsf_core.ConvertDateTimeTag) _jspx_tagPool_f_convertDateTime_pattern_nobody.get(com.sun.faces.taglib.jsf_core.ConvertDateTimeTag.class);
    _jspx_th_f_convertDateTime_1.setPageContext(_jspx_page_context);
    _jspx_th_f_convertDateTime_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectInputDate_1);
    _jspx_th_f_convertDateTime_1.setPattern(org.apache.jasper.runtime.PageContextImpl.getValueExpression("dd/MM/yyyy", (PageContext)_jspx_page_context, java.lang.String.class, null));
    int _jspx_eval_f_convertDateTime_1 = _jspx_th_f_convertDateTime_1.doStartTag();
    if (_jspx_th_f_convertDateTime_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_convertDateTime_pattern_nobody.reuse(_jspx_th_f_convertDateTime_1);
      return true;
    }
    _jspx_tagPool_f_convertDateTime_pattern_nobody.reuse(_jspx_th_f_convertDateTime_1);
    return false;
  }

  private boolean _jspx_meth_ice_commandButton_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:commandButton
    com.icesoft.faces.component.CommandButtonTag _jspx_th_ice_commandButton_0 = new com.icesoft.faces.component.CommandButtonTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_commandButton_0      );
    }
    _jspx_th_ice_commandButton_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_commandButton_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_3);
    _jspx_th_ice_commandButton_0.setJspId("id44");
    _jspx_th_ice_commandButton_0.setAction("#{EstadisticaFacadeManaged.generarReporteAnual}");
    _jspx_th_ice_commandButton_0.setValue("Generar Reporte");
    _jspx_th_ice_commandButton_0.setId("cb_generar");
    int _jspx_eval_ice_commandButton_0 = _jspx_th_ice_commandButton_0.doStartTag();
    if (_jspx_th_ice_commandButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_commandButton_value_id_action_nobody.reuse(_jspx_th_ice_commandButton_0);
      return true;
    }
    _jspx_tagPool_ice_commandButton_value_id_action_nobody.reuse(_jspx_th_ice_commandButton_0);
    return false;
  }

  private boolean _jspx_meth_ice_form_2(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:form
    com.icesoft.faces.component.FormTag _jspx_th_ice_form_2 = new com.icesoft.faces.component.FormTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_form_2      );
    }
    _jspx_th_ice_form_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_form_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_form_2.setJspId("id45");
    _jspx_th_ice_form_2.setId("frm_principal");
    int _jspx_eval_ice_form_2 = _jspx_th_ice_form_2.doStartTag();
    if (_jspx_eval_ice_form_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_form_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_form_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_form_2.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGrid_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_form_2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_form_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_form_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_form_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_2);
      return true;
    }
    _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_2);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_4(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_form_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_4 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_4      );
    }
    _jspx_th_ice_panelGrid_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_form_2);
    _jspx_th_ice_panelGrid_4.setJspId("id46");
    _jspx_th_ice_panelGrid_4.setVisible("#{EstadisticaFacadeManaged.visible}");
    _jspx_th_ice_panelGrid_4.setWidth("100%");
    _jspx_th_ice_panelGrid_4.setId("pnlgrd_informe");
    int _jspx_eval_ice_panelGrid_4 = _jspx_th_ice_panelGrid_4.doStartTag();
    if (_jspx_eval_ice_panelGrid_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_4.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelCollapsible_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_4, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_width_visible_id.reuse(_jspx_th_ice_panelGrid_4);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_width_visible_id.reuse(_jspx_th_ice_panelGrid_4);
    return false;
  }

  private boolean _jspx_meth_ice_panelCollapsible_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelCollapsible
    com.icesoft.faces.component.panelcollapsible.PanelCollapsibleTag _jspx_th_ice_panelCollapsible_0 = new com.icesoft.faces.component.panelcollapsible.PanelCollapsibleTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelCollapsible_0      );
    }
    _jspx_th_ice_panelCollapsible_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelCollapsible_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_4);
    _jspx_th_ice_panelCollapsible_0.setJspId("id47");
    _jspx_th_ice_panelCollapsible_0.setExpanded("true");
    _jspx_th_ice_panelCollapsible_0.setId("pclp_principal");
    int _jspx_eval_ice_panelCollapsible_0 = _jspx_th_ice_panelCollapsible_0.doStartTag();
    if (_jspx_eval_ice_panelCollapsible_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelCollapsible_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelCollapsible_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelCollapsible_0.doInitBody();
      }
      do {
        if (_jspx_meth_f_facet_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelCollapsible_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_panelGrid_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelCollapsible_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelCollapsible_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelCollapsible_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelCollapsible_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelCollapsible_id_expanded.reuse(_jspx_th_ice_panelCollapsible_0);
      return true;
    }
    _jspx_tagPool_ice_panelCollapsible_id_expanded.reuse(_jspx_th_ice_panelCollapsible_0);
    return false;
  }

  private boolean _jspx_meth_f_facet_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelCollapsible_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:facet
    javax.faces.webapp.FacetTag _jspx_th_f_facet_0 = (javax.faces.webapp.FacetTag) _jspx_tagPool_f_facet_name.get(javax.faces.webapp.FacetTag.class);
    _jspx_th_f_facet_0.setPageContext(_jspx_page_context);
    _jspx_th_f_facet_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelCollapsible_0);
    _jspx_th_f_facet_0.setName("header");
    int _jspx_eval_f_facet_0 = _jspx_th_f_facet_0.doStartTag();
    if (_jspx_eval_f_facet_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        if (_jspx_meth_ice_outputText_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_facet_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_f_facet_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_f_facet_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_facet_name.reuse(_jspx_th_f_facet_0);
      return true;
    }
    _jspx_tagPool_f_facet_name.reuse(_jspx_th_f_facet_0);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_4(javax.servlet.jsp.tagext.JspTag _jspx_th_f_facet_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_4 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_4      );
    }
    _jspx_th_ice_outputText_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_facet_0);
    _jspx_th_ice_outputText_4.setJspId("id49");
    _jspx_th_ice_outputText_4.setValue("Informe Anual de Gastos");
    _jspx_th_ice_outputText_4.setId("ot_linkHeader");
    int _jspx_eval_ice_outputText_4 = _jspx_th_ice_outputText_4.doStartTag();
    if (_jspx_th_ice_outputText_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_4);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_4);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_5(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelCollapsible_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_5 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_5      );
    }
    _jspx_th_ice_panelGrid_5.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelCollapsible_0);
    _jspx_th_ice_panelGrid_5.setJspId("id50");
    _jspx_th_ice_panelGrid_5.setWidth("100%");
    _jspx_th_ice_panelGrid_5.setColumns("1");
    _jspx_th_ice_panelGrid_5.setId("pgrp_principal");
    int _jspx_eval_ice_panelGrid_5 = _jspx_th_ice_panelGrid_5.doStartTag();
    if (_jspx_eval_ice_panelGrid_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_5.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGroup_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_5, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_panelGroup_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_5, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_width_id_columns.reuse(_jspx_th_ice_panelGrid_5);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_width_id_columns.reuse(_jspx_th_ice_panelGrid_5);
    return false;
  }

  private boolean _jspx_meth_ice_panelGroup_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_1 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_1      );
    }
    _jspx_th_ice_panelGroup_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_5);
    _jspx_th_ice_panelGroup_1.setJspId("id51");
    _jspx_th_ice_panelGroup_1.setId("pgrp_tabla");
    int _jspx_eval_ice_panelGroup_1 = _jspx_th_ice_panelGroup_1.doStartTag();
    if (_jspx_eval_ice_panelGroup_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_1.doInitBody();
      }
      do {
        if (_jspx_meth_ice_dataTable_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_id.reuse(_jspx_th_ice_panelGroup_1);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_id.reuse(_jspx_th_ice_panelGroup_1);
    return false;
  }

  private boolean _jspx_meth_ice_dataTable_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:dataTable
    com.icesoft.faces.component.DataTableTag _jspx_th_ice_dataTable_0 = new com.icesoft.faces.component.DataTableTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_dataTable_0      );
    }
    _jspx_th_ice_dataTable_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_dataTable_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_1);
    _jspx_th_ice_dataTable_0.setJspId("id52");
    _jspx_th_ice_dataTable_0.setColumnClasses("columnsColumn");
    _jspx_th_ice_dataTable_0.setValue("#{EstadisticaFacadeManaged.rowDataModel}");
    _jspx_th_ice_dataTable_0.setVar("row");
    _jspx_th_ice_dataTable_0.setId("dataTbl");
    int _jspx_eval_ice_dataTable_0 = _jspx_th_ice_dataTable_0.doStartTag();
    if (_jspx_eval_ice_dataTable_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_dataTable_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_dataTable_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_dataTable_0.doInitBody();
      }
      do {
        if (_jspx_meth_ice_column_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_dataTable_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_columns_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_dataTable_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_dataTable_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_dataTable_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_dataTable_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_dataTable_var_value_id_columnClasses.reuse(_jspx_th_ice_dataTable_0);
      return true;
    }
    _jspx_tagPool_ice_dataTable_var_value_id_columnClasses.reuse(_jspx_th_ice_dataTable_0);
    return false;
  }

  private boolean _jspx_meth_ice_column_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_dataTable_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:column
    com.icesoft.faces.component.UIColumnTag _jspx_th_ice_column_0 = new com.icesoft.faces.component.UIColumnTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_column_0      );
    }
    _jspx_th_ice_column_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_column_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_dataTable_0);
    _jspx_th_ice_column_0.setJspId("id53");
    int _jspx_eval_ice_column_0 = _jspx_th_ice_column_0.doStartTag();
    if (_jspx_eval_ice_column_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_column_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_column_0.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_column_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_column_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_column_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_column.reuse(_jspx_th_ice_column_0);
      return true;
    }
    _jspx_tagPool_ice_column.reuse(_jspx_th_ice_column_0);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_5(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_column_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_5 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_5      );
    }
    _jspx_th_ice_outputText_5.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_column_0);
    _jspx_th_ice_outputText_5.setJspId("id54");
    _jspx_th_ice_outputText_5.setStyle("font-weight: bold;");
    _jspx_th_ice_outputText_5.setValue("#{row}");
    int _jspx_eval_ice_outputText_5 = _jspx_th_ice_outputText_5.doStartTag();
    if (_jspx_th_ice_outputText_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_style_nobody.reuse(_jspx_th_ice_outputText_5);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_style_nobody.reuse(_jspx_th_ice_outputText_5);
    return false;
  }

  private boolean _jspx_meth_ice_columns_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_dataTable_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:columns
    com.icesoft.faces.component.UIColumnsTag _jspx_th_ice_columns_0 = new com.icesoft.faces.component.UIColumnsTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_columns_0      );
    }
    _jspx_th_ice_columns_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_columns_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_dataTable_0);
    _jspx_th_ice_columns_0.setJspId("id55");
    _jspx_th_ice_columns_0.setVar("column");
    _jspx_th_ice_columns_0.setValue("#{EstadisticaFacadeManaged.columnDataModel}");
    _jspx_th_ice_columns_0.setId("dc_reporteDataModel");
    int _jspx_eval_ice_columns_0 = _jspx_th_ice_columns_0.doStartTag();
    if (_jspx_eval_ice_columns_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_columns_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_columns_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_columns_0.doInitBody();
      }
      do {
        if (_jspx_meth_f_facet_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_columns_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_panelGroup_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_columns_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_columns_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_columns_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_columns_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_columns_var_value_id.reuse(_jspx_th_ice_columns_0);
      return true;
    }
    _jspx_tagPool_ice_columns_var_value_id.reuse(_jspx_th_ice_columns_0);
    return false;
  }

  private boolean _jspx_meth_f_facet_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_columns_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:facet
    javax.faces.webapp.FacetTag _jspx_th_f_facet_1 = (javax.faces.webapp.FacetTag) _jspx_tagPool_f_facet_name.get(javax.faces.webapp.FacetTag.class);
    _jspx_th_f_facet_1.setPageContext(_jspx_page_context);
    _jspx_th_f_facet_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_columns_0);
    _jspx_th_f_facet_1.setName("header");
    int _jspx_eval_f_facet_1 = _jspx_th_f_facet_1.doStartTag();
    if (_jspx_eval_f_facet_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        if (_jspx_meth_ice_panelGroup_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_facet_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_f_facet_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_f_facet_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_facet_name.reuse(_jspx_th_f_facet_1);
      return true;
    }
    _jspx_tagPool_f_facet_name.reuse(_jspx_th_f_facet_1);
    return false;
  }

  private boolean _jspx_meth_ice_panelGroup_2(javax.servlet.jsp.tagext.JspTag _jspx_th_f_facet_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_2 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_2      );
    }
    _jspx_th_ice_panelGroup_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_facet_1);
    _jspx_th_ice_panelGroup_2.setJspId("id57");
    int _jspx_eval_ice_panelGroup_2 = _jspx_th_ice_panelGroup_2.doStartTag();
    if (_jspx_eval_ice_panelGroup_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_2.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup.reuse(_jspx_th_ice_panelGroup_2);
      return true;
    }
    _jspx_tagPool_ice_panelGroup.reuse(_jspx_th_ice_panelGroup_2);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_6(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_6 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_6      );
    }
    _jspx_th_ice_outputText_6.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_2);
    _jspx_th_ice_outputText_6.setJspId("id58");
    _jspx_th_ice_outputText_6.setValue("#{column}");
    _jspx_th_ice_outputText_6.setId("ot_Encabeazados");
    int _jspx_eval_ice_outputText_6 = _jspx_th_ice_outputText_6.doStartTag();
    if (_jspx_th_ice_outputText_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_6);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_6);
    return false;
  }

  private boolean _jspx_meth_ice_panelGroup_3(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_columns_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_3 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_3      );
    }
    _jspx_th_ice_panelGroup_3.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_columns_0);
    _jspx_th_ice_panelGroup_3.setJspId("id59");
    _jspx_th_ice_panelGroup_3.setStyle("text-align: center; white-space: nowrap;");
    int _jspx_eval_ice_panelGroup_3 = _jspx_th_ice_panelGroup_3.doStartTag();
    if (_jspx_eval_ice_panelGroup_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_3.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_3, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_style.reuse(_jspx_th_ice_panelGroup_3);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_style.reuse(_jspx_th_ice_panelGroup_3);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_7(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_7 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_7      );
    }
    _jspx_th_ice_outputText_7.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_3);
    _jspx_th_ice_outputText_7.setJspId("id60");
    _jspx_th_ice_outputText_7.setValue("#{EstadisticaFacadeManaged.anualCellValue}");
    _jspx_th_ice_outputText_7.setId("ot_celdaValor");
    int _jspx_eval_ice_outputText_7 = _jspx_th_ice_outputText_7.doStartTag();
    if (_jspx_th_ice_outputText_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_7);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_7);
    return false;
  }

  private boolean _jspx_meth_ice_panelGroup_4(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_4 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_4      );
    }
    _jspx_th_ice_panelGroup_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_5);
    _jspx_th_ice_panelGroup_4.setJspId("id61");
    _jspx_th_ice_panelGroup_4.setId("pgr_grafico");
    int _jspx_eval_ice_panelGroup_4 = _jspx_th_ice_panelGroup_4.doStartTag();
    if (_jspx_eval_ice_panelGroup_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_4.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputChart_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_4, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_id.reuse(_jspx_th_ice_panelGroup_4);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_id.reuse(_jspx_th_ice_panelGroup_4);
    return false;
  }

  private boolean _jspx_meth_ice_outputChart_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputChart
    com.icesoft.faces.component.outputchart.OutputChartTag _jspx_th_ice_outputChart_0 = new com.icesoft.faces.component.outputchart.OutputChartTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputChart_0      );
    }
    _jspx_th_ice_outputChart_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputChart_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_4);
    _jspx_th_ice_outputChart_0.setJspId("id62");
    _jspx_th_ice_outputChart_0.setRenderOnSubmit("true");
    _jspx_th_ice_outputChart_0.setWidth("800");
    _jspx_th_ice_outputChart_0.setType("bar");
    _jspx_th_ice_outputChart_0.setLabels("#{EstadisticaFacadeManaged.xlabel}");
    _jspx_th_ice_outputChart_0.setXaxisTitle("#{EstadisticaFacadeManaged.xlabel}");
    _jspx_th_ice_outputChart_0.setChartTitle("#{EstadisticaFacadeManaged.title}");
    _jspx_th_ice_outputChart_0.setYaxisTitle("#{EstadisticaFacadeManaged.ylabel}");
    _jspx_th_ice_outputChart_0.setXaxisLabels("#{EstadisticaFacadeManaged.xLabels}");
    _jspx_th_ice_outputChart_0.setData("#{EstadisticaFacadeManaged.data}");
    int _jspx_eval_ice_outputChart_0 = _jspx_th_ice_outputChart_0.doStartTag();
    if (_jspx_th_ice_outputChart_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputChart_yaxisTitle_xaxisTitle_xaxisLabels_width_type_renderOnSubmit_labels_data_chartTitle_nobody.reuse(_jspx_th_ice_outputChart_0);
      return true;
    }
    _jspx_tagPool_ice_outputChart_yaxisTitle_xaxisTitle_xaxisLabels_width_type_renderOnSubmit_labels_data_chartTitle_nobody.reuse(_jspx_th_ice_outputChart_0);
    return false;
  }

  private boolean _jspx_meth_ice_form_3(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:form
    com.icesoft.faces.component.FormTag _jspx_th_ice_form_3 = new com.icesoft.faces.component.FormTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_form_3      );
    }
    _jspx_th_ice_form_3.setPageContext(_jspx_page_context);
    _jspx_th_ice_form_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_form_3.setJspId("id63");
    _jspx_th_ice_form_3.setId("frm_acciones");
    int _jspx_eval_ice_form_3 = _jspx_th_ice_form_3.doStartTag();
    if (_jspx_eval_ice_form_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_form_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_form_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_form_3.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGroup_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_form_3, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_form_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_form_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_form_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_3);
      return true;
    }
    _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_3);
    return false;
  }

  private boolean _jspx_meth_ice_panelGroup_5(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_form_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_5 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_5      );
    }
    _jspx_th_ice_panelGroup_5.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_form_3);
    _jspx_th_ice_panelGroup_5.setJspId("id64");
    _jspx_th_ice_panelGroup_5.setId("pgrp_botones");
    int _jspx_eval_ice_panelGroup_5 = _jspx_th_ice_panelGroup_5.doStartTag();
    if (_jspx_eval_ice_panelGroup_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_5.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputResource_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_5, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_id.reuse(_jspx_th_ice_panelGroup_5);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_id.reuse(_jspx_th_ice_panelGroup_5);
    return false;
  }

  private boolean _jspx_meth_ice_outputResource_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputResource
    com.icesoft.faces.component.outputresource.OutputResourceTag _jspx_th_ice_outputResource_0 = new com.icesoft.faces.component.outputresource.OutputResourceTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputResource_0      );
    }
    _jspx_th_ice_outputResource_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputResource_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_5);
    _jspx_th_ice_outputResource_0.setJspId("id65");
    _jspx_th_ice_outputResource_0.setType("button");
    _jspx_th_ice_outputResource_0.setFileName("Bajar PDF");
    _jspx_th_ice_outputResource_0.setMimeType("application/pdf");
    _jspx_th_ice_outputResource_0.setResource("#{EstadisticaFacadeManaged.resourceGastos}");
    _jspx_th_ice_outputResource_0.setId("or_pdfResource");
    int _jspx_eval_ice_outputResource_0 = _jspx_th_ice_outputResource_0.doStartTag();
    if (_jspx_th_ice_outputResource_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputResource_type_resource_mimeType_id_fileName_nobody.reuse(_jspx_th_ice_outputResource_0);
      return true;
    }
    _jspx_tagPool_ice_outputResource_type_resource_mimeType_id_fileName_nobody.reuse(_jspx_th_ice_outputResource_0);
    return false;
  }

  private boolean _jspx_meth_ice_form_4(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:form
    com.icesoft.faces.component.FormTag _jspx_th_ice_form_4 = new com.icesoft.faces.component.FormTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_form_4      );
    }
    _jspx_th_ice_form_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_form_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_form_4.setJspId("id68");
    _jspx_th_ice_form_4.setId("frm_footer");
    int _jspx_eval_ice_form_4 = _jspx_th_ice_form_4.doStartTag();
    if (_jspx_eval_ice_form_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_form_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_form_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_form_4.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGrid_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_form_4, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_form_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_form_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_form_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_4);
      return true;
    }
    _jspx_tagPool_ice_form_id.reuse(_jspx_th_ice_form_4);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_6(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_form_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_6 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_6      );
    }
    _jspx_th_ice_panelGrid_6.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_form_4);
    _jspx_th_ice_panelGrid_6.setJspId("id69");
    _jspx_th_ice_panelGrid_6.setStyleClass("footer");
    int _jspx_eval_ice_panelGrid_6 = _jspx_th_ice_panelGrid_6.doStartTag();
    if (_jspx_eval_ice_panelGrid_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_6.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_6, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_styleClass.reuse(_jspx_th_ice_panelGrid_6);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_styleClass.reuse(_jspx_th_ice_panelGrid_6);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_8(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_8 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_8      );
    }
    _jspx_th_ice_outputText_8.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_6);
    _jspx_th_ice_outputText_8.setJspId("id70");
    _jspx_th_ice_outputText_8.setValue("No hay información");
    _jspx_th_ice_outputText_8.setId("south");
    int _jspx_eval_ice_outputText_8 = _jspx_th_ice_outputText_8.doStartTag();
    if (_jspx_th_ice_outputText_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_8);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_8);
    return false;
  }
}
