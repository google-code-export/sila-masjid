<%-- 
    Document   : editrekening
    Created on : Nov 22, 2011, 8:21:38 AM
    Author     : yooganz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="entities.Rekening"%>
<% Rekening rek=(Rekening)request.getAttribute("rek");%>
<html>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">
<%--JUDUL DISINI--%>
        <tr>
            <td width="452" height="32" class="contentheader"><div align="center"><b>REKENING MASJID</b></div></td>
        </tr>
        <tr>
            <td><img src="images/main_content_header_under.gif" width="452" height="26"></td>
        </tr>
        <tr>

            <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">

                    <%--ISI MULAI SINI--%>
        <form action="InputRekening" method="post">
        <table border="0" align="center">
            <tr>
                <td align="center">Nomor Rekening</td>
                <td><input type="text" name="noRek" value="<%=rek.getNoRek()%>"></td>
            </tr>
            <tr>
                <td>Atas Nama</td>
                <td><input type="text" name="nmRek" value="<%=rek.getNmRek()%>"></td>
            </tr>
            <tr>
                <td>Bank</td>
                <td><input type="text" name="bank" <%=rek.getBank()%>"></td>
            </tr>
            <tr>
            <td></td>
                <td colspan="2">
                <input  type="submit" value="Simpan">
                <input  type="reset" value="Batal">
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            </form>                
            
            <%--ISI SAMPAI SINI--%>

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
