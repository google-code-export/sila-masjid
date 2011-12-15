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
<%@include file='aplikasitemplate.html' %>

<html>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
            <tr> 
                <%--JUDUL DI SINI--%>
                <td width="452" height="32" class="contentheader"><div align="center"><b>SEPUTAR BERITA</b></div></td>
            </tr>
            <tr> 
                <td><img src="images/main_content_header_under.gif" width="452" height="26"></td>
            </tr>
            <tr> 
                <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                        <%--ISI MULAI SINI--%>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="25%" align="left">Judul Berita</td><td align="center">:</td><td><%=berita.getJudul()%></td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="25%" align="left">Isi Berita</td><td align="center">:</td><td><%=berita.getIsiBerita()%></td>
                        </tr>
                        
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <% Date tgl = (Date) berita.getTglUnggah();%>
                            <td width="25%" align="left">Tanggal Unggah</td><td align="center">:</td><td><%=DateFormat.getDateInstance().format(tgl)%></td>
                        </tr>
                        
                        <%
                        %>
                    </table></td>
            </tr>
            <tr> 
                <td class="mctop"><img src="images/mc_box_bottom.gif" alt="-" width="452" height="23"></td>
            </tr>
        </table>
        <%--ISI SAMPAI SINI--%>
        <!-- COPYRIGHT - WWW.ZYMIC.COM - IF YOU REMOVE COPYRIGHT LEGAL ACTION WILL BE TAKEN -->
        <!-- WE TRACK COPYRIGHT ON A DAILY BASIS, WE KNOW WHO YOU ARE!                      -->
        <div align="center"><a href="http://www.zymic.com" target="_blank"><img src="images/copyright_DO_NOT_STEAL_ELSE_LEGAL_ACTION.gif" alt="Free Templates" width="422" height="15" border="0"></a></div></td>
</body>
</html>
