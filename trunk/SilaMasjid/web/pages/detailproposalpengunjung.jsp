<%-- 
    Document   : detailproposalpengunjung
    Created on : 03-Jan-2012, 09:33:12
    Author     : Sumurmunding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarProposal"%>
<%@page import="entities.Proposal"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<% Proposal proposal = (Proposal) request.getAttribute("proposal");%>
<!DOCTYPE html>
<%@include file='hometemplate2.html' %>

<html>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
            <tr> 
                <%--JUDUL DI SINI--%>
                <td width="700" height="32" class="contentheader"><div align="center"><b>DETAIL PROPOSAL</b></div></td>
            </tr>
            <tr> 
                <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
            </tr>
            <tr> 
                <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                        <%--ISI MULAI SINI--%>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="25%" align="left">Nama Pengaju</td><td align="center">:</td><td><%=proposal.getNama()%></td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="25%" align="left">Alamat</td><td align="center">:</td><td><%=proposal.getAlamat()%></td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="25%" align="left">Email</td><td align="center">:</td><td><%=proposal.getEmail()%></td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="25%" align="left">No. Telp.</td><td align="center">:</td><td><%=proposal.getNoTelp()%></td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="25%" align="left">Judul Proposal</td><td align="center">:</td><td><%=proposal.getJudul()%></td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="25%" align="left">Besar Dana</td><td align="center">:</td><td>Rp<%=proposal.getBesarDana()%>,-</td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <% Date tgl = (Date) proposal.getTglUnggah();%>
                            <td width="25%" align="left">Tanggal Pengajuan</td><td align="center">:</td><td><%=DateFormat.getDateInstance().format(tgl)%></td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td colspan="3"><p><b><u>Keterangan</u></b><br />
                                    <%=proposal.getDetailProposal().replace("\n", "<br>")%></p></td>
                        </tr>
                        <%
                        %>
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
