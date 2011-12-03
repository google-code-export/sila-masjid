<%-- 
    Document   : donator
    Created on : Nov 25, 2011, 2:03:17 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarDonatur"%>
<%@page import="entities.Donatur"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<% DaftarDonatur daftran=new DaftarDonatur();%>
<% List<Donatur> trans=daftran.getDonaturs(idMasjid);%>
<% Iterator<Donatur> iterator = trans.iterator();%>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%--JUDUL DI SINI--%>
        <td width="452" height="32" class="contentheader"><div align="center"><b>DONATUR</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="452" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <form action="inputdonatur" method="post" >
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Nama Donatur</td><td><input name="nmDonatur" style="width: 160px">
                                </td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td >Nomor Telepon</td><td><input type="text" name="telpDonatur" style="width: 160px" ></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Alamat</td><td><input type="text" name="almtDonatur" style="width: 160px" ></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>&nbsp;</td><td><input type="submit" value="Simpan" ><input type="reset" value="Reset"></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr><td colspan="3" align="center"><label align="center"><font color="red"><b>${error}</b></font></label></td></tr>

                </form>
   
                <%--ISI SAMPAI SINI--%>
                    <tr>
                        <tr><td>&nbsp;</td></tr>
                    <td width="10%">&nbsp;</td>
                    <th width="20%" align="left">Nama</th>
                    <th>Nomor Telepon</th>
                    <th align="left">Edit/Hapus</th>
                    </tr>
                    
                    <% while (iterator.hasNext()) {%>
                        <% Donatur next = iterator.next();%>
                    <tr>
                        <td>&nbsp;</td>
                        <td><%=next.getNmDonatur()%></td>
                        <td align="center"><%=next.getTelpDonatur()%></td>
                        <td bgcolor="#F4F4F4"><a href="editdonatur?id=<%=next.getId() %>"><font color="brown">pilih</font></a></td>
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
