<%-- 
    Document   : editpengurus
    Created on : 24-Nov-2011, 21:24:12
    Author     : Sumurmunding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarPengurusMasjid"%>
<%@page import="entities.PengurusMasjid"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% PengurusMasjid pengurus = (PengurusMasjid) request.getAttribute("pengurus");%>
<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<% DaftarPengurusMasjid daftar = new DaftarPengurusMasjid();%>
<% List<PengurusMasjid> pengurus2 = daftar.getPengurusMasjids(idMasjid);%>
<% Iterator<PengurusMasjid> iterator = pengurus2.iterator();%>
<html>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
            <tr> 
                <%-- JUDUL DI SINI--%> 
                <td width="452" height="32" class="contentheader"><div align="center"><b>PENGURUS MASJID</b></div></td>
            </tr>
            <tr> 
                <td><img src="images/main_content_header_under.gif" width="452" height="26"></td>
            </tr>
            <tr> 
                <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                        <%-- ISI MULAI SINI---%>
                        <form action="simpaneditpengurus" method="post" >
                            <tr>
                                <td width="10%"><input type="hidden" name="id" value="<%=pengurus.getId()%>" style="width: 160px"></td>
                                <td>Nama</td><td><input type="text" name="nama" value="<%=pengurus.getNama()%>" style="width: 160px"></td>
                            </tr>
                            <tr>
                                <td width="10%">&nbsp;</td>
                                <td>Jabatan</td><td><input type="text" name="jabatan" value="<%=pengurus.getJabatan()%>" style="width: 120px"></td>
                            </tr>
                            <tr>
                                <td width="10%">&nbsp;</td>
                                <td>No. Telepon</td><td><input type="text" name="noTelp" value="<%=pengurus.getNoTelp()%>"style="width: 120px"></td>
                            </tr>
                            <tr>
                                <td >&nbsp;</td>
                            </tr>
                            <tr>
                                <td width="10%">&nbsp;</td>
                                <td></td><td><input type="submit" value="Simpan" ></td>
                            </tr>
                            <tr>
                                <td >&nbsp;</td>
                            </tr>
                            <tr><td colspan="3" align="center"><label align="center"><font color="red"><b>${errorpengurus}</b></font></label></td></tr>
                            <tr>
                                <td >&nbsp;</td>
                            </tr>
                        </form>
                        <%--ISI SAMPAI SINI--%>
                    <tr>
                    <td width="10%">&nbsp;</td>
                    <th width="20%" align="left">Nama Pengurus</th>
                    <th>Jabatan</th>
                    <th>No. Telepon</th>
                    <th align="left">Edit</th>
                    <th align="left">Hapus</th>
                </tr>

                <% while (iterator.hasNext()) {%>
                <% PengurusMasjid next = iterator.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=next.getNama()%></td>
                    <td><%=next.getJabatan()%></td>
                    <td><%=next.getNoTelp()%></td>
                    <td bgcolor="#F4F4F4"><a href="editpengurus?id=<%=next.getId()%>" > <font color="brown">edit</font></a></td>
                    <td bgcolor="#F4F4F4"><a href="hapuspengurus?id=<%=next.getId()%>"><font color="red">hapus</font></a></td>
                </tr>
                <%}%>     
                <tr><td>&nbsp;</td></tr>
            </table></td>
    </tr>
    <tr> 
        <td class="mctop"><img src="images/mc_box_bottom.gif" alt="-" width="452" height="23"></td>
    </tr>
</table>
        <!-- COPYRIGHT - WWW.ZYMIC.COM - IF YOU REMOVE COPYRIGHT LEGAL ACTION WILL BE TAKEN -->
        <!-- WE TRACK COPYRIGHT ON A DAILY BASIS, WE KNOW WHO YOU ARE!                      -->
        <div align="center"><a href="http://www.zymic.com" target="_blank"><img src="images/copyright_DO_NOT_STEAL_ELSE_LEGAL_ACTION.gif" alt="Free Templates" width="422" height="15" border="0"></a></div></td>
</tr>
</table>
</body>
</html>

