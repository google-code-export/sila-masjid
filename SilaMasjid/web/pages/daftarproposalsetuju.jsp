<%-- 
    Document   : Proposal
    Created on : Dec 12, 2011, 9:40:06 PM
    Author     : sumding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarProposal"%>
<%@page import="entities.Proposal"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>

<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<% DaftarProposal daftar = new DaftarProposal();%>
<% List<Proposal> proposal = daftar.getProposalSudahs(idMasjid);%>
<% Iterator<Proposal> iterator = proposal.iterator();%>
<html>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
            <tr> 
                <%--JUDUL DI SINI--%>
                <td width="700" height="32" class="contentheader"><div align="center"><b>LAPORAN PERSETUJUAN PROPOSAL</b></div></td>
            </tr>
            <tr> 
                <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
            </tr>
            <tr> 
                <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                        <%--ISI MULAI SINI--%>
                        <form action="setujuproposal" method="post">
                            <tr>
                                <td width="5%">&nbsp;</td>
                                <th width="20%" align="left">Pengunggah</th>
                                <th width="25%" align="left">Judul Proposal</th>
                                <th width="20%" align="left">Besar Dana</th>
                                <th width="15%" align="left">Tgl Unggah</th>
                                <th width="15%" align="left">Tgl Setuju</th>
                            </tr>

                            <% while (iterator.hasNext()) {%>
                            <% Proposal next = iterator.next();%>
                            <tr>
                                <td width="5%">&nbsp;</td>
                                <td width="20%"><%=next.getNama()%></td>
                                <td width="25%"><a title="Lihat detail proposal" href="detailproposal?id=<%=next.getId()%>" ><font color="blue"><%=next.getJudul()%></font></a></td>
                                <td width="20%"><%=next.getBesarDana()%></td>
                                <% Date tgl = (Date) next.getTglUnggah();%>
                                <td width="15%"><%=DateFormat.getDateInstance().format(tgl)%></td>
                                <% Date tgl2 = (Date) next.getTglSetuju();%>
                                <td width="15%"><%=DateFormat.getDateInstance().format(tgl2)%></td>
                            </tr>
                            <%}%>     
                            <tr><td>&nbsp;</td></tr>
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
