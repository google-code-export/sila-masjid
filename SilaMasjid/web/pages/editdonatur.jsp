<%-- 
    Document   : editdonatur
    Created on : Nov 21, 2011, 10:37:28 AM
    Author     : danke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="entities.Donatur"%>
<%@include file='aplikasitemplate.html' %>
<% Donatur dona =(Donatur)request.getAttribute("donatur");%>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%--JUDUL DI SINI--%>
        <td width="700" height="32" class="contentheader"><div align="center"><b>EDIT DONATUR</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <form action="" method="post" >
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Nama</td>
                        <td><input type="text" name="nmDonatur" value="<%=dona.getNmDonatur().substring(0)%>"style="width: 160px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td >Nomor Telepon</td><td><input type="text" name="telpDonatur" value="<%=dona.getTelpDonatur().substring(0)%>"style="width: 160px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Alamat</td><td><input type="text" name="almtDonatur" value="<%=dona.getAlmtDonatur()%>"style="width: 160px"></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>&nbsp;</td><td><input type="button" value="Simpan" onclick="this.form.action='simpan_edit_donatur';this.form.submit();">
                            <input type="reset" value="Batal" onclick="this.form.action='batal_donatur';this.form.submit();"></td>
                        <td><input type="button" value="Hapus" style="background-color:#c00; color:#fff;" onclick="this.form.action='hapus_donatur';this.form.submit();"></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                </form>
   
                <%--ISI SAMPAI SINI--%>

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
