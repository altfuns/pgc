package org.apache.jsp.ModuloAdministracion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdministracionPermisos_jspx extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGrid_id_columns_cellpadding;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGroup_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_selectOneRadio_valueChangeListener_value_style_partialSubmit_layout_id_autocomplete;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_selectOneMenu_valueChangeListener_value_partialSubmit_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputText_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_selectOneListbox_valueChangeListener_style_size_partialSubmit_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_selectItems_value_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_commandButton_value_partialSubmit_image_id_actionListener_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_selectOneMenu_valueChangeListener_partialSubmit_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelPopup_visible_styleClass_modal_id_draggable;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_facet_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGroup_styleClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_outputText_value_styleClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_commandButton_value_type_id_actionListener_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ice_panelGroup_styleClass_effect;

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
    _jspx_tagPool_ice_panelGrid_id_columns_cellpadding = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGroup_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_selectOneRadio_valueChangeListener_value_style_partialSubmit_layout_id_autocomplete = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_selectOneMenu_valueChangeListener_value_partialSubmit_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputText_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_selectOneListbox_valueChangeListener_style_size_partialSubmit_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_selectItems_value_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_commandButton_value_partialSubmit_image_id_actionListener_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_selectOneMenu_valueChangeListener_partialSubmit_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelPopup_visible_styleClass_modal_id_draggable = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_facet_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGroup_styleClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_outputText_value_styleClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_commandButton_value_type_id_actionListener_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ice_panelGroup_styleClass_effect = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
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
    _jspx_tagPool_ice_panelGrid_id_columns_cellpadding.release();
    _jspx_tagPool_ice_panelGroup_id.release();
    _jspx_tagPool_ice_selectOneRadio_valueChangeListener_value_style_partialSubmit_layout_id_autocomplete.release();
    _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.release();
    _jspx_tagPool_ice_selectOneMenu_valueChangeListener_value_partialSubmit_id.release();
    _jspx_tagPool_ice_outputText_value_nobody.release();
    _jspx_tagPool_ice_selectOneListbox_valueChangeListener_style_size_partialSubmit_id.release();
    _jspx_tagPool_f_selectItems_value_id_nobody.release();
    _jspx_tagPool_ice_commandButton_value_partialSubmit_image_id_actionListener_nobody.release();
    _jspx_tagPool_ice_selectOneMenu_valueChangeListener_partialSubmit_id.release();
    _jspx_tagPool_ice_panelPopup_visible_styleClass_modal_id_draggable.release();
    _jspx_tagPool_f_facet_name.release();
    _jspx_tagPool_ice_panelGroup_styleClass.release();
    _jspx_tagPool_ice_outputText_value_styleClass_nobody.release();
    _jspx_tagPool_ice_commandButton_value_type_id_actionListener_nobody.release();
    _jspx_tagPool_ice_panelGroup_styleClass_effect.release();
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
        if (_jspx_meth_ice_outputStyle_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_outputStyle_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("<title>");
        out.write("UNA | Oficina Postal | Administración de Permisos");
        out.write("</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("<table style=\"height:100%; vertical-align: top;\" width=\"100%\">");
        out.write("<tr>");
        out.write("<td valign=\"top\" colspan=\"2\">");
        if (_jspx_meth_ice_panelGrid_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td valign=\"top\">");
        if (_jspx_meth_ice_form_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("<td style=\"height:100%\" valign=\"top\" width=\"100%\">");
        out.write("<p align=\"right\">");
        if (_jspx_meth_ice_outputText_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</p>");
        out.write("<table width=\"100%\">");
        out.write("<tr>");
        out.write("<td width=\"50%\">");
        if (_jspx_meth_ice_form_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("<td>");
        if (_jspx_meth_ice_form_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("</tr>");
        out.write("</table>");
        if (_jspx_meth_ice_form_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
          return true;
        out.write("</td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td colspan=\"2\">");
        if (_jspx_meth_ice_panelGroup_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_view_0, _jspx_page_context))
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
    _jspx_th_ice_outputStyle_0.setJspId("id5");
    _jspx_th_ice_outputStyle_0.setId("outputStyle2");
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
    _jspx_th_ice_outputStyle_1.setJspId("id6");
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
    _jspx_th_ice_outputText_0.setValue("Administración | Administración de Permisos");
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
    _jspx_th_ice_form_1.setJspId("id37");
    _jspx_th_ice_form_1.setId("frm_sinAsignar");
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
    _jspx_th_ice_panelGrid_2.setJspId("id38");
    _jspx_th_ice_panelGrid_2.setCellpadding("10");
    _jspx_th_ice_panelGrid_2.setColumns("2");
    _jspx_th_ice_panelGrid_2.setId("pgrd_sinAsignar");
    int _jspx_eval_ice_panelGrid_2 = _jspx_th_ice_panelGrid_2.doStartTag();
    if (_jspx_eval_ice_panelGrid_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_2.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGroup_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_2, _jspx_page_context))
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
      _jspx_tagPool_ice_panelGrid_id_columns_cellpadding.reuse(_jspx_th_ice_panelGrid_2);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns_cellpadding.reuse(_jspx_th_ice_panelGrid_2);
    return false;
  }

  private boolean _jspx_meth_ice_panelGroup_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_1 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_1      );
    }
    _jspx_th_ice_panelGroup_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_2);
    _jspx_th_ice_panelGroup_1.setJspId("id39");
    _jspx_th_ice_panelGroup_1.setId("pgrp_seleccionTipoP");
    int _jspx_eval_ice_panelGroup_1 = _jspx_th_ice_panelGroup_1.doStartTag();
    if (_jspx_eval_ice_panelGroup_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_1.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGroup_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_1, _jspx_page_context))
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

  private boolean _jspx_meth_ice_panelGroup_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_2 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_2      );
    }
    _jspx_th_ice_panelGroup_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_1);
    _jspx_th_ice_panelGroup_2.setJspId("id40");
    _jspx_th_ice_panelGroup_2.setId("pgrp_TipoP");
    int _jspx_eval_ice_panelGroup_2 = _jspx_th_ice_panelGroup_2.doStartTag();
    if (_jspx_eval_ice_panelGroup_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_2.doInitBody();
      }
      do {
        out.write("<p align=\"center\">");
        if (_jspx_meth_ice_outputText_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_2, _jspx_page_context))
          return true;
        out.write("</p>");
        if (_jspx_meth_ice_selectOneRadio_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_id.reuse(_jspx_th_ice_panelGroup_2);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_id.reuse(_jspx_th_ice_panelGroup_2);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_1 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_1      );
    }
    _jspx_th_ice_outputText_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_2);
    _jspx_th_ice_outputText_1.setJspId("id42");
    _jspx_th_ice_outputText_1.setValue("Permisos asignados a:");
    _jspx_th_ice_outputText_1.setId("ot_TipoP");
    int _jspx_eval_ice_outputText_1 = _jspx_th_ice_outputText_1.doStartTag();
    if (_jspx_th_ice_outputText_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_1);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_1);
    return false;
  }

  private boolean _jspx_meth_ice_selectOneRadio_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:selectOneRadio
    com.icesoft.faces.component.SelectOneRadioTag _jspx_th_ice_selectOneRadio_0 = new com.icesoft.faces.component.SelectOneRadioTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_selectOneRadio_0      );
    }
    _jspx_th_ice_selectOneRadio_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_selectOneRadio_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_2);
    _jspx_th_ice_selectOneRadio_0.setJspId("id43");
    _jspx_th_ice_selectOneRadio_0.setStyle("width: 150%;");
    _jspx_th_ice_selectOneRadio_0.setValueChangeListener("#{PermisoFacadeManaged.valueChange_sol_cambiarTipoP}");
    _jspx_th_ice_selectOneRadio_0.setAutocomplete("true");
    _jspx_th_ice_selectOneRadio_0.setValue("#{PermisoFacadeManaged.auxPermiso.tipoP}");
    _jspx_th_ice_selectOneRadio_0.setPartialSubmit("true");
    _jspx_th_ice_selectOneRadio_0.setId("sol_TipoP");
    _jspx_th_ice_selectOneRadio_0.setLayout("pageDirection");
    int _jspx_eval_ice_selectOneRadio_0 = _jspx_th_ice_selectOneRadio_0.doStartTag();
    if (_jspx_eval_ice_selectOneRadio_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_selectOneRadio_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_selectOneRadio_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_selectOneRadio_0.doInitBody();
      }
      do {
        if (_jspx_meth_f_selectItem_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectOneRadio_0, _jspx_page_context))
          return true;
        if (_jspx_meth_f_selectItem_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectOneRadio_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_selectOneRadio_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_selectOneRadio_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_selectOneRadio_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_selectOneRadio_valueChangeListener_value_style_partialSubmit_layout_id_autocomplete.reuse(_jspx_th_ice_selectOneRadio_0);
      return true;
    }
    _jspx_tagPool_ice_selectOneRadio_valueChangeListener_value_style_partialSubmit_layout_id_autocomplete.reuse(_jspx_th_ice_selectOneRadio_0);
    return false;
  }

  private boolean _jspx_meth_f_selectItem_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectOneRadio_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:selectItem
    com.sun.faces.taglib.jsf_core.SelectItemTag _jspx_th_f_selectItem_0 = new com.sun.faces.taglib.jsf_core.SelectItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_selectItem_0      );
    }
    _jspx_th_f_selectItem_0.setPageContext(_jspx_page_context);
    _jspx_th_f_selectItem_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectOneRadio_0);
    _jspx_th_f_selectItem_0.setJspId("id44");
    _jspx_th_f_selectItem_0.setItemLabel(org.apache.jasper.runtime.PageContextImpl.getValueExpression("Cargo", (PageContext)_jspx_page_context, java.lang.String.class, null));
    _jspx_th_f_selectItem_0.setItemValue(org.apache.jasper.runtime.PageContextImpl.getValueExpression("Cargo", (PageContext)_jspx_page_context, java.lang.Object.class, null));
    _jspx_th_f_selectItem_0.setId("sit_cargo");
    int _jspx_eval_f_selectItem_0 = _jspx_th_f_selectItem_0.doStartTag();
    if (_jspx_th_f_selectItem_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_0);
      return true;
    }
    _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_0);
    return false;
  }

  private boolean _jspx_meth_f_selectItem_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectOneRadio_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:selectItem
    com.sun.faces.taglib.jsf_core.SelectItemTag _jspx_th_f_selectItem_1 = new com.sun.faces.taglib.jsf_core.SelectItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_selectItem_1      );
    }
    _jspx_th_f_selectItem_1.setPageContext(_jspx_page_context);
    _jspx_th_f_selectItem_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectOneRadio_0);
    _jspx_th_f_selectItem_1.setJspId("id45");
    _jspx_th_f_selectItem_1.setItemLabel(org.apache.jasper.runtime.PageContextImpl.getValueExpression("Empleado", (PageContext)_jspx_page_context, java.lang.String.class, null));
    _jspx_th_f_selectItem_1.setItemValue(org.apache.jasper.runtime.PageContextImpl.getValueExpression("Empleado", (PageContext)_jspx_page_context, java.lang.Object.class, null));
    _jspx_th_f_selectItem_1.setId("sit_empleado");
    int _jspx_eval_f_selectItem_1 = _jspx_th_f_selectItem_1.doStartTag();
    if (_jspx_th_f_selectItem_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_1);
      return true;
    }
    _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_1);
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
    _jspx_th_ice_panelGrid_3.setJspId("id46");
    _jspx_th_ice_panelGrid_3.setColumns("1");
    _jspx_th_ice_panelGrid_3.setId("pgrd_porAsignar");
    int _jspx_eval_ice_panelGrid_3 = _jspx_th_ice_panelGrid_3.doStartTag();
    if (_jspx_eval_ice_panelGrid_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_3.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGrid_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_3, _jspx_page_context))
          return true;
        out.write("<p align=\"center\">");
        if (_jspx_meth_ice_outputText_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_3, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_selectOneListbox_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_3, _jspx_page_context))
          return true;
        out.write("</p>");
        int evalDoAfterBody = _jspx_th_ice_panelGrid_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_3);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_3);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_4(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_4 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_4      );
    }
    _jspx_th_ice_panelGrid_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_3);
    _jspx_th_ice_panelGrid_4.setJspId("id47");
    _jspx_th_ice_panelGrid_4.setColumns("2");
    _jspx_th_ice_panelGrid_4.setId("pgrd_modulo");
    int _jspx_eval_ice_panelGrid_4 = _jspx_th_ice_panelGrid_4.doStartTag();
    if (_jspx_eval_ice_panelGrid_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_4.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_4, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_selectOneMenu_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_4, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_4);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_4);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_2 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_2      );
    }
    _jspx_th_ice_outputText_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_4);
    _jspx_th_ice_outputText_2.setJspId("id48");
    _jspx_th_ice_outputText_2.setValue("Módulo:");
    _jspx_th_ice_outputText_2.setId("ot_modulo");
    int _jspx_eval_ice_outputText_2 = _jspx_th_ice_outputText_2.doStartTag();
    if (_jspx_th_ice_outputText_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_2);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_2);
    return false;
  }

  private boolean _jspx_meth_ice_selectOneMenu_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:selectOneMenu
    com.icesoft.faces.component.SelectOneMenuTag _jspx_th_ice_selectOneMenu_0 = new com.icesoft.faces.component.SelectOneMenuTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_selectOneMenu_0      );
    }
    _jspx_th_ice_selectOneMenu_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_selectOneMenu_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_4);
    _jspx_th_ice_selectOneMenu_0.setJspId("id49");
    _jspx_th_ice_selectOneMenu_0.setValueChangeListener("#{PermisoFacadeManaged.valueChange_som_cambiarPermisos}");
    _jspx_th_ice_selectOneMenu_0.setPartialSubmit("true");
    _jspx_th_ice_selectOneMenu_0.setValue("#{PermisoFacadeManaged.auxPermiso.moduloSel}");
    _jspx_th_ice_selectOneMenu_0.setId("som_modulo");
    int _jspx_eval_ice_selectOneMenu_0 = _jspx_th_ice_selectOneMenu_0.doStartTag();
    if (_jspx_eval_ice_selectOneMenu_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_selectOneMenu_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_selectOneMenu_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_selectOneMenu_0.doInitBody();
      }
      do {
        if (_jspx_meth_f_selectItem_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectOneMenu_0, _jspx_page_context))
          return true;
        if (_jspx_meth_f_selectItem_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectOneMenu_0, _jspx_page_context))
          return true;
        if (_jspx_meth_f_selectItem_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectOneMenu_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_selectOneMenu_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_selectOneMenu_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_selectOneMenu_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_selectOneMenu_valueChangeListener_value_partialSubmit_id.reuse(_jspx_th_ice_selectOneMenu_0);
      return true;
    }
    _jspx_tagPool_ice_selectOneMenu_valueChangeListener_value_partialSubmit_id.reuse(_jspx_th_ice_selectOneMenu_0);
    return false;
  }

  private boolean _jspx_meth_f_selectItem_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectOneMenu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:selectItem
    com.sun.faces.taglib.jsf_core.SelectItemTag _jspx_th_f_selectItem_2 = new com.sun.faces.taglib.jsf_core.SelectItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_selectItem_2      );
    }
    _jspx_th_f_selectItem_2.setPageContext(_jspx_page_context);
    _jspx_th_f_selectItem_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectOneMenu_0);
    _jspx_th_f_selectItem_2.setJspId("id50");
    _jspx_th_f_selectItem_2.setItemLabel(org.apache.jasper.runtime.PageContextImpl.getValueExpression("Interna - Externa por Mensajero Propio", (PageContext)_jspx_page_context, java.lang.String.class, null));
    _jspx_th_f_selectItem_2.setItemValue(org.apache.jasper.runtime.PageContextImpl.getValueExpression("rutas", (PageContext)_jspx_page_context, java.lang.Object.class, null));
    _jspx_th_f_selectItem_2.setId("sit_modulo1");
    int _jspx_eval_f_selectItem_2 = _jspx_th_f_selectItem_2.doStartTag();
    if (_jspx_th_f_selectItem_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_2);
      return true;
    }
    _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_2);
    return false;
  }

  private boolean _jspx_meth_f_selectItem_3(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectOneMenu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:selectItem
    com.sun.faces.taglib.jsf_core.SelectItemTag _jspx_th_f_selectItem_3 = new com.sun.faces.taglib.jsf_core.SelectItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_selectItem_3      );
    }
    _jspx_th_f_selectItem_3.setPageContext(_jspx_page_context);
    _jspx_th_f_selectItem_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectOneMenu_0);
    _jspx_th_f_selectItem_3.setJspId("id51");
    _jspx_th_f_selectItem_3.setItemLabel(org.apache.jasper.runtime.PageContextImpl.getValueExpression("Vía Correos de Costa Rica", (PageContext)_jspx_page_context, java.lang.String.class, null));
    _jspx_th_f_selectItem_3.setItemValue(org.apache.jasper.runtime.PageContextImpl.getValueExpression("externa", (PageContext)_jspx_page_context, java.lang.Object.class, null));
    _jspx_th_f_selectItem_3.setId("sit_modulo2");
    int _jspx_eval_f_selectItem_3 = _jspx_th_f_selectItem_3.doStartTag();
    if (_jspx_th_f_selectItem_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_3);
      return true;
    }
    _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_3);
    return false;
  }

  private boolean _jspx_meth_f_selectItem_4(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectOneMenu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:selectItem
    com.sun.faces.taglib.jsf_core.SelectItemTag _jspx_th_f_selectItem_4 = new com.sun.faces.taglib.jsf_core.SelectItemTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_selectItem_4      );
    }
    _jspx_th_f_selectItem_4.setPageContext(_jspx_page_context);
    _jspx_th_f_selectItem_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectOneMenu_0);
    _jspx_th_f_selectItem_4.setJspId("id52");
    _jspx_th_f_selectItem_4.setItemLabel(org.apache.jasper.runtime.PageContextImpl.getValueExpression("Módulo Administrativo", (PageContext)_jspx_page_context, java.lang.String.class, null));
    _jspx_th_f_selectItem_4.setItemValue(org.apache.jasper.runtime.PageContextImpl.getValueExpression("administracion", (PageContext)_jspx_page_context, java.lang.Object.class, null));
    _jspx_th_f_selectItem_4.setId("sit_modulo3");
    int _jspx_eval_f_selectItem_4 = _jspx_th_f_selectItem_4.doStartTag();
    if (_jspx_th_f_selectItem_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_4);
      return true;
    }
    _jspx_tagPool_f_selectItem_itemValue_itemLabel_id_nobody.reuse(_jspx_th_f_selectItem_4);
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
    _jspx_th_ice_outputText_3.setJspId("id54");
    _jspx_th_ice_outputText_3.setValue("Permisos sin asignar");
    int _jspx_eval_ice_outputText_3 = _jspx_th_ice_outputText_3.doStartTag();
    if (_jspx_th_ice_outputText_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_nobody.reuse(_jspx_th_ice_outputText_3);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_nobody.reuse(_jspx_th_ice_outputText_3);
    return false;
  }

  private boolean _jspx_meth_ice_selectOneListbox_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:selectOneListbox
    com.icesoft.faces.component.SelectOneListboxTag _jspx_th_ice_selectOneListbox_0 = new com.icesoft.faces.component.SelectOneListboxTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_selectOneListbox_0      );
    }
    _jspx_th_ice_selectOneListbox_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_selectOneListbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_3);
    _jspx_th_ice_selectOneListbox_0.setJspId("id55");
    _jspx_th_ice_selectOneListbox_0.setValueChangeListener("#{PermisoFacadeManaged.valueChange_sol_seleccionarPermisoNoAsignado}");
    _jspx_th_ice_selectOneListbox_0.setStyle("width: 100%;");
    _jspx_th_ice_selectOneListbox_0.setPartialSubmit("true");
    _jspx_th_ice_selectOneListbox_0.setSize("8");
    _jspx_th_ice_selectOneListbox_0.setId("sol_porAsignar");
    int _jspx_eval_ice_selectOneListbox_0 = _jspx_th_ice_selectOneListbox_0.doStartTag();
    if (_jspx_eval_ice_selectOneListbox_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_selectOneListbox_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_selectOneListbox_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_selectOneListbox_0.doInitBody();
      }
      do {
        if (_jspx_meth_f_selectItems_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectOneListbox_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_selectOneListbox_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_selectOneListbox_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_selectOneListbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_selectOneListbox_valueChangeListener_style_size_partialSubmit_id.reuse(_jspx_th_ice_selectOneListbox_0);
      return true;
    }
    _jspx_tagPool_ice_selectOneListbox_valueChangeListener_style_size_partialSubmit_id.reuse(_jspx_th_ice_selectOneListbox_0);
    return false;
  }

  private boolean _jspx_meth_f_selectItems_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectOneListbox_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:selectItems
    com.sun.faces.taglib.jsf_core.SelectItemsTag _jspx_th_f_selectItems_0 = new com.sun.faces.taglib.jsf_core.SelectItemsTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_selectItems_0      );
    }
    _jspx_th_f_selectItems_0.setPageContext(_jspx_page_context);
    _jspx_th_f_selectItems_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectOneListbox_0);
    _jspx_th_f_selectItems_0.setJspId("id56");
    _jspx_th_f_selectItems_0.setValue(org.apache.jasper.runtime.PageContextImpl.getValueExpression("#{PermisoFacadeManaged.itemesNoAsignados}", (PageContext)_jspx_page_context, java.lang.Object.class, null));
    _jspx_th_f_selectItems_0.setId("sits_permisosN");
    int _jspx_eval_f_selectItems_0 = _jspx_th_f_selectItems_0.doStartTag();
    if (_jspx_th_f_selectItems_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_selectItems_value_id_nobody.reuse(_jspx_th_f_selectItems_0);
      return true;
    }
    _jspx_tagPool_f_selectItems_value_id_nobody.reuse(_jspx_th_f_selectItems_0);
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
    _jspx_th_ice_form_2.setJspId("id58");
    _jspx_th_ice_form_2.setId("frm_asignadas");
    int _jspx_eval_ice_form_2 = _jspx_th_ice_form_2.doStartTag();
    if (_jspx_eval_ice_form_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_form_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_form_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_form_2.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGrid_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_form_2, _jspx_page_context))
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

  private boolean _jspx_meth_ice_panelGrid_5(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_form_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_5 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_5      );
    }
    _jspx_th_ice_panelGrid_5.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_form_2);
    _jspx_th_ice_panelGrid_5.setJspId("id59");
    _jspx_th_ice_panelGrid_5.setCellpadding("15");
    _jspx_th_ice_panelGrid_5.setColumns("2");
    _jspx_th_ice_panelGrid_5.setId("pgrd_asignadas");
    int _jspx_eval_ice_panelGrid_5 = _jspx_th_ice_panelGrid_5.doStartTag();
    if (_jspx_eval_ice_panelGrid_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_5.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGrid_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_5, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_panelGrid_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_5, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns_cellpadding.reuse(_jspx_th_ice_panelGrid_5);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns_cellpadding.reuse(_jspx_th_ice_panelGrid_5);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_6(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_6 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_6      );
    }
    _jspx_th_ice_panelGrid_6.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_5);
    _jspx_th_ice_panelGrid_6.setJspId("id60");
    _jspx_th_ice_panelGrid_6.setColumns("2");
    _jspx_th_ice_panelGrid_6.setId("pgrd_acciones");
    int _jspx_eval_ice_panelGrid_6 = _jspx_th_ice_panelGrid_6.doStartTag();
    if (_jspx_eval_ice_panelGrid_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_6.doInitBody();
      }
      do {
        if (_jspx_meth_ice_commandButton_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_6, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_commandButton_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_6, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_6);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_6);
    return false;
  }

  private boolean _jspx_meth_ice_commandButton_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:commandButton
    com.icesoft.faces.component.CommandButtonTag _jspx_th_ice_commandButton_0 = new com.icesoft.faces.component.CommandButtonTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_commandButton_0      );
    }
    _jspx_th_ice_commandButton_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_commandButton_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_6);
    _jspx_th_ice_commandButton_0.setJspId("id61");
    _jspx_th_ice_commandButton_0.setActionListener("#{PermisoFacadeManaged.action_cb_removerPermiso}");
    _jspx_th_ice_commandButton_0.setPartialSubmit("true");
    _jspx_th_ice_commandButton_0.setValue("Desasignar");
    _jspx_th_ice_commandButton_0.setImage("../resources/rime/css-images/cal_arrow_left_dis.gif");
    _jspx_th_ice_commandButton_0.setId("cb_desasignar");
    int _jspx_eval_ice_commandButton_0 = _jspx_th_ice_commandButton_0.doStartTag();
    if (_jspx_th_ice_commandButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_commandButton_value_partialSubmit_image_id_actionListener_nobody.reuse(_jspx_th_ice_commandButton_0);
      return true;
    }
    _jspx_tagPool_ice_commandButton_value_partialSubmit_image_id_actionListener_nobody.reuse(_jspx_th_ice_commandButton_0);
    return false;
  }

  private boolean _jspx_meth_ice_commandButton_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:commandButton
    com.icesoft.faces.component.CommandButtonTag _jspx_th_ice_commandButton_1 = new com.icesoft.faces.component.CommandButtonTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_commandButton_1      );
    }
    _jspx_th_ice_commandButton_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_commandButton_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_6);
    _jspx_th_ice_commandButton_1.setJspId("id62");
    _jspx_th_ice_commandButton_1.setActionListener("#{PermisoFacadeManaged.action_cb_asignarPermiso}");
    _jspx_th_ice_commandButton_1.setPartialSubmit("true");
    _jspx_th_ice_commandButton_1.setValue("Asignar");
    _jspx_th_ice_commandButton_1.setImage("../resources/rime/css-images/cal_arrow_right_dis.gif");
    _jspx_th_ice_commandButton_1.setId("cb_asignar");
    int _jspx_eval_ice_commandButton_1 = _jspx_th_ice_commandButton_1.doStartTag();
    if (_jspx_th_ice_commandButton_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_commandButton_value_partialSubmit_image_id_actionListener_nobody.reuse(_jspx_th_ice_commandButton_1);
      return true;
    }
    _jspx_tagPool_ice_commandButton_value_partialSubmit_image_id_actionListener_nobody.reuse(_jspx_th_ice_commandButton_1);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_7(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_7 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_7      );
    }
    _jspx_th_ice_panelGrid_7.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_5);
    _jspx_th_ice_panelGrid_7.setJspId("id63");
    _jspx_th_ice_panelGrid_7.setColumns("1");
    _jspx_th_ice_panelGrid_7.setId("pgrd_asignados");
    int _jspx_eval_ice_panelGrid_7 = _jspx_th_ice_panelGrid_7.doStartTag();
    if (_jspx_eval_ice_panelGrid_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_7.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelGrid_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_7, _jspx_page_context))
          return true;
        out.write("<p align=\"center\">");
        if (_jspx_meth_ice_outputText_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_7, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_selectOneListbox_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_7, _jspx_page_context))
          return true;
        out.write("</p>");
        int evalDoAfterBody = _jspx_th_ice_panelGrid_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_7);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_7);
    return false;
  }

  private boolean _jspx_meth_ice_panelGrid_8(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGrid
    com.icesoft.faces.component.PanelGridTag _jspx_th_ice_panelGrid_8 = new com.icesoft.faces.component.PanelGridTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGrid_8      );
    }
    _jspx_th_ice_panelGrid_8.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGrid_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_7);
    _jspx_th_ice_panelGrid_8.setJspId("id64");
    _jspx_th_ice_panelGrid_8.setColumns("2");
    _jspx_th_ice_panelGrid_8.setId("pgrd_seleccion");
    int _jspx_eval_ice_panelGrid_8 = _jspx_th_ice_panelGrid_8.doStartTag();
    if (_jspx_eval_ice_panelGrid_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGrid_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGrid_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGrid_8.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_8, _jspx_page_context))
          return true;
        if (_jspx_meth_ice_selectOneMenu_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGrid_8, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGrid_8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGrid_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGrid_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_8);
      return true;
    }
    _jspx_tagPool_ice_panelGrid_id_columns.reuse(_jspx_th_ice_panelGrid_8);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_4(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_8, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_4 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_4      );
    }
    _jspx_th_ice_outputText_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_8);
    _jspx_th_ice_outputText_4.setJspId("id65");
    _jspx_th_ice_outputText_4.setValue("#{PermisoFacadeManaged.etqAsignando}");
    _jspx_th_ice_outputText_4.setId("ot_seleccion");
    int _jspx_eval_ice_outputText_4 = _jspx_th_ice_outputText_4.doStartTag();
    if (_jspx_th_ice_outputText_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_4);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_id_nobody.reuse(_jspx_th_ice_outputText_4);
    return false;
  }

  private boolean _jspx_meth_ice_selectOneMenu_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_8, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:selectOneMenu
    com.icesoft.faces.component.SelectOneMenuTag _jspx_th_ice_selectOneMenu_1 = new com.icesoft.faces.component.SelectOneMenuTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_selectOneMenu_1      );
    }
    _jspx_th_ice_selectOneMenu_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_selectOneMenu_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_8);
    _jspx_th_ice_selectOneMenu_1.setJspId("id66");
    _jspx_th_ice_selectOneMenu_1.setValueChangeListener("#{PermisoFacadeManaged.valueChange_som_seleccionarItem}");
    _jspx_th_ice_selectOneMenu_1.setPartialSubmit("true");
    _jspx_th_ice_selectOneMenu_1.setId("som_seleccion");
    int _jspx_eval_ice_selectOneMenu_1 = _jspx_th_ice_selectOneMenu_1.doStartTag();
    if (_jspx_eval_ice_selectOneMenu_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_selectOneMenu_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_selectOneMenu_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_selectOneMenu_1.doInitBody();
      }
      do {
        if (_jspx_meth_f_selectItems_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectOneMenu_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_selectOneMenu_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_selectOneMenu_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_selectOneMenu_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_selectOneMenu_valueChangeListener_partialSubmit_id.reuse(_jspx_th_ice_selectOneMenu_1);
      return true;
    }
    _jspx_tagPool_ice_selectOneMenu_valueChangeListener_partialSubmit_id.reuse(_jspx_th_ice_selectOneMenu_1);
    return false;
  }

  private boolean _jspx_meth_f_selectItems_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectOneMenu_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:selectItems
    com.sun.faces.taglib.jsf_core.SelectItemsTag _jspx_th_f_selectItems_1 = new com.sun.faces.taglib.jsf_core.SelectItemsTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_selectItems_1      );
    }
    _jspx_th_f_selectItems_1.setPageContext(_jspx_page_context);
    _jspx_th_f_selectItems_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectOneMenu_1);
    _jspx_th_f_selectItems_1.setJspId("id67");
    _jspx_th_f_selectItems_1.setValue(org.apache.jasper.runtime.PageContextImpl.getValueExpression("#{PermisoFacadeManaged.itemes}", (PageContext)_jspx_page_context, java.lang.Object.class, null));
    _jspx_th_f_selectItems_1.setId("sits_itemes");
    int _jspx_eval_f_selectItems_1 = _jspx_th_f_selectItems_1.doStartTag();
    if (_jspx_th_f_selectItems_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_selectItems_value_id_nobody.reuse(_jspx_th_f_selectItems_1);
      return true;
    }
    _jspx_tagPool_f_selectItems_value_id_nobody.reuse(_jspx_th_f_selectItems_1);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_5(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_5 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_5      );
    }
    _jspx_th_ice_outputText_5.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_7);
    _jspx_th_ice_outputText_5.setJspId("id69");
    _jspx_th_ice_outputText_5.setValue("Permisos asignados");
    int _jspx_eval_ice_outputText_5 = _jspx_th_ice_outputText_5.doStartTag();
    if (_jspx_th_ice_outputText_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_nobody.reuse(_jspx_th_ice_outputText_5);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_nobody.reuse(_jspx_th_ice_outputText_5);
    return false;
  }

  private boolean _jspx_meth_ice_selectOneListbox_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGrid_7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:selectOneListbox
    com.icesoft.faces.component.SelectOneListboxTag _jspx_th_ice_selectOneListbox_1 = new com.icesoft.faces.component.SelectOneListboxTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_selectOneListbox_1      );
    }
    _jspx_th_ice_selectOneListbox_1.setPageContext(_jspx_page_context);
    _jspx_th_ice_selectOneListbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGrid_7);
    _jspx_th_ice_selectOneListbox_1.setJspId("id70");
    _jspx_th_ice_selectOneListbox_1.setValueChangeListener("#{PermisoFacadeManaged.valueChange_sol_seleccionarPermisoAsignado}");
    _jspx_th_ice_selectOneListbox_1.setStyle("width: 100%;");
    _jspx_th_ice_selectOneListbox_1.setPartialSubmit("true");
    _jspx_th_ice_selectOneListbox_1.setSize("8");
    _jspx_th_ice_selectOneListbox_1.setId("sol_asignado");
    int _jspx_eval_ice_selectOneListbox_1 = _jspx_th_ice_selectOneListbox_1.doStartTag();
    if (_jspx_eval_ice_selectOneListbox_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_selectOneListbox_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_selectOneListbox_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_selectOneListbox_1.doInitBody();
      }
      do {
        if (_jspx_meth_f_selectItems_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_selectOneListbox_1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_selectOneListbox_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_selectOneListbox_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_selectOneListbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_selectOneListbox_valueChangeListener_style_size_partialSubmit_id.reuse(_jspx_th_ice_selectOneListbox_1);
      return true;
    }
    _jspx_tagPool_ice_selectOneListbox_valueChangeListener_style_size_partialSubmit_id.reuse(_jspx_th_ice_selectOneListbox_1);
    return false;
  }

  private boolean _jspx_meth_f_selectItems_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_selectOneListbox_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:selectItems
    com.sun.faces.taglib.jsf_core.SelectItemsTag _jspx_th_f_selectItems_2 = new com.sun.faces.taglib.jsf_core.SelectItemsTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_f_selectItems_2      );
    }
    _jspx_th_f_selectItems_2.setPageContext(_jspx_page_context);
    _jspx_th_f_selectItems_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_selectOneListbox_1);
    _jspx_th_f_selectItems_2.setJspId("id71");
    _jspx_th_f_selectItems_2.setValue(org.apache.jasper.runtime.PageContextImpl.getValueExpression("#{PermisoFacadeManaged.itemesAsignados}", (PageContext)_jspx_page_context, java.lang.Object.class, null));
    _jspx_th_f_selectItems_2.setId("sits_permisosA");
    int _jspx_eval_f_selectItems_2 = _jspx_th_f_selectItems_2.doStartTag();
    if (_jspx_th_f_selectItems_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_f_selectItems_value_id_nobody.reuse(_jspx_th_f_selectItems_2);
      return true;
    }
    _jspx_tagPool_f_selectItems_value_id_nobody.reuse(_jspx_th_f_selectItems_2);
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
    _jspx_th_ice_form_3.setJspId("id72");
    _jspx_th_ice_form_3.setId("frm_paneles");
    int _jspx_eval_ice_form_3 = _jspx_th_ice_form_3.doStartTag();
    if (_jspx_eval_ice_form_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_form_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_form_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_form_3.doInitBody();
      }
      do {
        if (_jspx_meth_ice_panelPopup_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_form_3, _jspx_page_context))
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

  private boolean _jspx_meth_ice_panelPopup_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_form_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelPopup
    com.icesoft.faces.component.panelpopup.PanelPopupTag _jspx_th_ice_panelPopup_0 = new com.icesoft.faces.component.panelpopup.PanelPopupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelPopup_0      );
    }
    _jspx_th_ice_panelPopup_0.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelPopup_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_form_3);
    _jspx_th_ice_panelPopup_0.setJspId("id73");
    _jspx_th_ice_panelPopup_0.setStyleClass("corePopup");
    _jspx_th_ice_panelPopup_0.setVisible("#{PermisoFacadeManaged.errorVisible}");
    _jspx_th_ice_panelPopup_0.setModal("true");
    _jspx_th_ice_panelPopup_0.setDraggable("false");
    _jspx_th_ice_panelPopup_0.setId("ppop_errores");
    int _jspx_eval_ice_panelPopup_0 = _jspx_th_ice_panelPopup_0.doStartTag();
    if (_jspx_eval_ice_panelPopup_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelPopup_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelPopup_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelPopup_0.doInitBody();
      }
      do {
        if (_jspx_meth_f_facet_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelPopup_0, _jspx_page_context))
          return true;
        if (_jspx_meth_f_facet_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelPopup_0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelPopup_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelPopup_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelPopup_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelPopup_visible_styleClass_modal_id_draggable.reuse(_jspx_th_ice_panelPopup_0);
      return true;
    }
    _jspx_tagPool_ice_panelPopup_visible_styleClass_modal_id_draggable.reuse(_jspx_th_ice_panelPopup_0);
    return false;
  }

  private boolean _jspx_meth_f_facet_0(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelPopup_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:facet
    javax.faces.webapp.FacetTag _jspx_th_f_facet_0 = (javax.faces.webapp.FacetTag) _jspx_tagPool_f_facet_name.get(javax.faces.webapp.FacetTag.class);
    _jspx_th_f_facet_0.setPageContext(_jspx_page_context);
    _jspx_th_f_facet_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelPopup_0);
    _jspx_th_f_facet_0.setName("header");
    int _jspx_eval_f_facet_0 = _jspx_th_f_facet_0.doStartTag();
    if (_jspx_eval_f_facet_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        if (_jspx_meth_ice_panelGroup_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_facet_0, _jspx_page_context))
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

  private boolean _jspx_meth_ice_panelGroup_3(javax.servlet.jsp.tagext.JspTag _jspx_th_f_facet_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_3 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_3      );
    }
    _jspx_th_ice_panelGroup_3.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_facet_0);
    _jspx_th_ice_panelGroup_3.setJspId("id75");
    _jspx_th_ice_panelGroup_3.setStyleClass("popupHeaderWrapper");
    int _jspx_eval_ice_panelGroup_3 = _jspx_th_ice_panelGroup_3.doStartTag();
    if (_jspx_eval_ice_panelGroup_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_3.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_3, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_styleClass.reuse(_jspx_th_ice_panelGroup_3);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_styleClass.reuse(_jspx_th_ice_panelGroup_3);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_6(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_6 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_6      );
    }
    _jspx_th_ice_outputText_6.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_3);
    _jspx_th_ice_outputText_6.setJspId("id76");
    _jspx_th_ice_outputText_6.setStyleClass("popupHeaderText");
    _jspx_th_ice_outputText_6.setValue("Error");
    int _jspx_eval_ice_outputText_6 = _jspx_th_ice_outputText_6.doStartTag();
    if (_jspx_th_ice_outputText_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_styleClass_nobody.reuse(_jspx_th_ice_outputText_6);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_styleClass_nobody.reuse(_jspx_th_ice_outputText_6);
    return false;
  }

  private boolean _jspx_meth_f_facet_1(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelPopup_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:facet
    javax.faces.webapp.FacetTag _jspx_th_f_facet_1 = (javax.faces.webapp.FacetTag) _jspx_tagPool_f_facet_name.get(javax.faces.webapp.FacetTag.class);
    _jspx_th_f_facet_1.setPageContext(_jspx_page_context);
    _jspx_th_f_facet_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelPopup_0);
    _jspx_th_f_facet_1.setName("body");
    int _jspx_eval_f_facet_1 = _jspx_th_f_facet_1.doStartTag();
    if (_jspx_eval_f_facet_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        if (_jspx_meth_ice_panelGroup_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_facet_1, _jspx_page_context))
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

  private boolean _jspx_meth_ice_panelGroup_4(javax.servlet.jsp.tagext.JspTag _jspx_th_f_facet_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_4 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_4      );
    }
    _jspx_th_ice_panelGroup_4.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_facet_1);
    _jspx_th_ice_panelGroup_4.setJspId("id78");
    _jspx_th_ice_panelGroup_4.setStyleClass("popupBody");
    int _jspx_eval_ice_panelGroup_4 = _jspx_th_ice_panelGroup_4.doStartTag();
    if (_jspx_eval_ice_panelGroup_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_4.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_4, _jspx_page_context))
          return true;
        out.write("<br />");
        out.write("<p align=\"center\">");
        if (_jspx_meth_ice_commandButton_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_4, _jspx_page_context))
          return true;
        out.write("</p>");
        int evalDoAfterBody = _jspx_th_ice_panelGroup_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_styleClass.reuse(_jspx_th_ice_panelGroup_4);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_styleClass.reuse(_jspx_th_ice_panelGroup_4);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_7(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_7 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_7      );
    }
    _jspx_th_ice_outputText_7.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_4);
    _jspx_th_ice_outputText_7.setJspId("id79");
    _jspx_th_ice_outputText_7.setValue("#{PermisoFacadeManaged.mensajeError}");
    int _jspx_eval_ice_outputText_7 = _jspx_th_ice_outputText_7.doStartTag();
    if (_jspx_th_ice_outputText_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_outputText_value_nobody.reuse(_jspx_th_ice_outputText_7);
      return true;
    }
    _jspx_tagPool_ice_outputText_value_nobody.reuse(_jspx_th_ice_outputText_7);
    return false;
  }

  private boolean _jspx_meth_ice_commandButton_2(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:commandButton
    com.icesoft.faces.component.CommandButtonTag _jspx_th_ice_commandButton_2 = new com.icesoft.faces.component.CommandButtonTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_commandButton_2      );
    }
    _jspx_th_ice_commandButton_2.setPageContext(_jspx_page_context);
    _jspx_th_ice_commandButton_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_4);
    _jspx_th_ice_commandButton_2.setJspId("id82");
    _jspx_th_ice_commandButton_2.setActionListener("#{PermisoFacadeManaged.action_cb_cerrarPopup}");
    _jspx_th_ice_commandButton_2.setValue("Cerrar");
    _jspx_th_ice_commandButton_2.setType("submit");
    _jspx_th_ice_commandButton_2.setId("modalPnlCloseButton");
    int _jspx_eval_ice_commandButton_2 = _jspx_th_ice_commandButton_2.doStartTag();
    if (_jspx_th_ice_commandButton_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_commandButton_value_type_id_actionListener_nobody.reuse(_jspx_th_ice_commandButton_2);
      return true;
    }
    _jspx_tagPool_ice_commandButton_value_type_id_actionListener_nobody.reuse(_jspx_th_ice_commandButton_2);
    return false;
  }

  private boolean _jspx_meth_ice_panelGroup_5(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:panelGroup
    com.icesoft.faces.component.PanelGroupTag _jspx_th_ice_panelGroup_5 = new com.icesoft.faces.component.PanelGroupTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_panelGroup_5      );
    }
    _jspx_th_ice_panelGroup_5.setPageContext(_jspx_page_context);
    _jspx_th_ice_panelGroup_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_ice_panelGroup_5.setJspId("id85");
    _jspx_th_ice_panelGroup_5.setEffect("#{PermisoFacadeManaged.efecto}");
    _jspx_th_ice_panelGroup_5.setStyleClass("footer");
    int _jspx_eval_ice_panelGroup_5 = _jspx_th_ice_panelGroup_5.doStartTag();
    if (_jspx_eval_ice_panelGroup_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_ice_panelGroup_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_ice_panelGroup_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_ice_panelGroup_5.doInitBody();
      }
      do {
        if (_jspx_meth_ice_outputText_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_ice_panelGroup_5, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_ice_panelGroup_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_ice_panelGroup_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_ice_panelGroup_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ice_panelGroup_styleClass_effect.reuse(_jspx_th_ice_panelGroup_5);
      return true;
    }
    _jspx_tagPool_ice_panelGroup_styleClass_effect.reuse(_jspx_th_ice_panelGroup_5);
    return false;
  }

  private boolean _jspx_meth_ice_outputText_8(javax.servlet.jsp.tagext.JspTag _jspx_th_ice_panelGroup_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ice:outputText
    com.icesoft.faces.component.OutputTextTag _jspx_th_ice_outputText_8 = new com.icesoft.faces.component.OutputTextTag();
    if (_jspx_resourceInjector != null) {
      _jspx_resourceInjector.inject(_jspx_th_ice_outputText_8      );
    }
    _jspx_th_ice_outputText_8.setPageContext(_jspx_page_context);
    _jspx_th_ice_outputText_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_ice_panelGroup_5);
    _jspx_th_ice_outputText_8.setJspId("id86");
    _jspx_th_ice_outputText_8.setValue("#{PermisoFacadeManaged.infoFooter}");
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