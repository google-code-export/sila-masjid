<%-- 
    Document   : Proposal
    Created on : Dec 12, 2011, 9:40:06 PM
    Author     : sumding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.IndexBerita"%>
<%@page import="entities.Berita"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>

<!DOCTYPE html>
<%@include file='hometemplate.html' %>
<% IndexBerita index = new IndexBerita();%>
<% List<Berita> berita = index.getBeritas();%>
<% Iterator<Berita> iterator = berita.iterator();%>
<html>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
            <tr> 
                <%--JUDUL DI SINI--%>
                <td width="700" height="32" class="contentheader"><div align="center"><b>INDEX BERITA</b></div></td>
            </tr>
            <tr> 
                <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
            </tr>
            <tr> 
                <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                        <%--ISI MULAI SINI--%>
                        <form action="" method="post">
                            <tr>
                                <td width="10%">&nbsp;</td>
                                <th width="20%" align="left">Judul Berita</th>
                                
                                <th width="20%" align="left">Tgl Unggah</th>
                               

                            </tr>

                            <% while (iterator.hasNext()) {%>
                            <% Berita next = iterator.next();%>
                            <tr>
                                <td width="10%">&nbsp;</td>
                                
                                <td width="20%"><a href="detailberita?id=<%=next.getId()%>" ><font color="blue"><%=next.getJudul()%></font></a></td>
                                
                                <% Date tgl = (Date) next.getTglUnggah();%>
                                <td width="20%"><%=DateFormat.getDateInstance().format(tgl)%></td>
                                
                            </tr>
                            <%}%>
                            
                        </form>
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
