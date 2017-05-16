<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ attribute name="count"  required="true" rtexprvalue="true" type="java.lang.Integer"%>
<%@ attribute name="step"  required="true" rtexprvalue="true" type="java.lang.Integer"%>
<%@ attribute name="urlprefix"  required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="prefix"  required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="currstart"  required="true" type="java.lang.Integer"%>
<%
        out.println(prefix);
        if (currstart==null) currstart = 0;
        for (int i = 0; i <= (count-1)/step; i++) {
           String typebutton = "info";
           if (currstart == i*step){
               typebutton = "primary";
             }
           out.println(String.format("&nbsp<a class='btn btn-%s btn-xs' href='%s%d&step=%d'>%d</a>",typebutton,urlprefix,i*step,step,i+1));
        }
%>

