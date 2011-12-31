<%-- 
    Document   : indeks proposal
    Created on : 17-Dec-2011
    Author     : Sumurmunding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarProposal"%>
<%@page import="entities.Proposal"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<!DOCTYPE html>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<%@include file='hometemplate2.html' %>
<% DaftarProposal daftar = new DaftarProposal();%>
<% List<Proposal> proposal = daftar.getProposals();%>
<% Iterator<Proposal> iterator = proposal.iterator();%>
<!DOCTYPE html>
<html>
    <%--JUDUL DI SINI--%>
    <td width="700" height="32" class="contentheader"><div align="center"><b>INDEKS PROPOSAL</b></div></td>
</tr>
<tr> 
    <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
</tr>
<tr> 
    <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
            <%--ISI MULAI DI SINI--%>
            <form action="" method="post">
                <tr>
                    <td width="5%">&nbsp;</td>
                    <th width="15%" align="left">Pengunggah</th>
                    <th width="20%" align="left">Judul Proposal</th>
                    <th width="15%" align="left">Besar Dana</th>
                    <th width="15%" align="left">Tgl Unggah</th>
                    <th width="10%" align="left">Status</th>
                    <th width="20%" align="left">Masjid</th>

                </tr>

                <% while (iterator.hasNext()) {%>
                <% Proposal next = iterator.next();%>
                <tr>
                    <td width="5%">&nbsp;</td>
                    <td width="15%" align="left"><%=next.getNama()%></td>
                    <td width="20%" align="left"><%=next.getJudul()%></td>
                    <td width="15%" align="left"><%=next.getBesarDana()%></td>
                    <% Date tgl = (Date) next.getTglUnggah();%>
                    <td width="15%" align="left"><%=DateFormat.getDateInstance().format(tgl)%></td>
                    <% boolean status = next.isSetuju();
                        String ketStatus = "";
                        String nmMasjid = "";
                        if (status == true) {
                            ketStatus = "Disetujui";
                            nmMasjid = next.getMasjid().getNmMasjid();
                        } else {
                            ketStatus = "-";
                            nmMasjid = "-";
                        }%>

                    <td width="10%" align="left"><%=ketStatus%></td>
                    <td width="20%" align="left"><%=nmMasjid%></td>
                </tr>
                <%}%>     
                <tr><td>&nbsp;</td></tr>
            </form>
            <%--ISI SAMPAI DI SINI--%>
        </table></td>
</tr>
<tr> 
    <td class="mctop"><img src="images/mc_box_bottom.gif" alt="-" width="700" height="23"></td>
</tr>
</table>
<!-- COPYRIGHT - WWW.ZYMIC.COM - IF YOU REMOVE COPYRIGHT LEGAL ACTION WILL BE TAKEN -->
<!-- WE TRACK COPYRIGHT ON A DAILY BASIS, WE KNOW WHO YOU ARE!                      -->
<div align="center"><a href="http://www.zymic.com" target="_blank"><img src="images/copyright_DO_NOT_STEAL_ELSE_LEGAL_ACTION.gif" alt="Free Templates" width="422" height="15" border="0"></a></div></td>
</tr>
</table>
</body>
</html>

