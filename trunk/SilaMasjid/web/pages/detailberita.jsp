<%-- 
    Document   : Proposal
    Created on : Dec 12, 2011, 9:40:06 PM
    Author     : sumding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.IndexBerita"%>
<%@page import="entities.Berita"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<% Berita berita = (Berita) request.getAttribute("posting");%>
<!DOCTYPE html>
<%@include file='hometemplate.html' %>

<html>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
            <tr> 
                <%--JUDUL DI SINI--%>
                <td width="700" height="32" class="contentheader"><div align="center"><b>SEPUTAR BERITA</b></div></td>
            </tr>
            <tr> 
                <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
            </tr>
            <tr> 
                <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                        <%--ISI MULAI SINI--%>
                        <tr>
                            <h2><%=berita.getJudul()%></h2>
                        </tr>
                        <tr>
                                <td>&nbsp;</td>
                        </tr>
                        <tr>
                        
                             <p><%=berita.getIsiBerita()%></p>  </tr>
                        
                        <tr>
                            <td>&nbsp;</td>
                         </tr>
                        
                        </table></td>
            </tr>
            <tr> 
                <td class="mctop"><img src="images/mc_box_bottom.gif" alt="-" width="700" height="23"></td>
            </tr>
        </table>
        <%--ISI SAMPAI SINI--%>
        <!-- COPYRIGHT - WWW.ZYMIC.COM - IF YOU REMOVE COPYRIGHT LEGAL ACTION WILL BE TAKEN -->
        <!-- WE TRACK COPYRIGHT ON A DAILY BASIS, WE KNOW WHO YOU ARE!                      -->
        <div align="center"><a href="http://www.zymic.com" target="_blank"><img src="images/copyright_DO_NOT_STEAL_ELSE_LEGAL_ACTION.gif" alt="Free Templates" width="422" height="15" border="0"></a></div></td>
</body>
</html>
