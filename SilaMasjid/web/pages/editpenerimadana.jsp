<%-- 
    Document   : editpenerimadana
    Created on : Dec 5, 2011, 11:52:18 PM
    Author     : yooganz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="entities.PenerimaDana"%>
<%@page import="entities.DaftarPenerimaDana"%>
<%@include file='aplikasitemplate.html' %>
<% PenerimaDana pendan = (PenerimaDana) request.getAttribute("pendan");%>
<html>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">

        <%--JUDUL DISINI--%>
        <tr>
            <td width="700" height="32" class="contentheader">
                <div align="center"><b>UBAH/HAPUS PENERIMA DANA</b></div></td>
        </tr>
        <tr>
            <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
        </tr>
        <tr>
            <td class="mctop">
                <table width="94%" border="0" cellpadding="0" cellspacing="0">

                    <%--ISI MULAI SINI--%>
                    <form action="" method="post">
                        <tr>
                            <td width="10%" align="left">&nbsp;</td>
                            <td align="left">Nama</td>
                            <td align="center"><strong>:</strong></td>
                            <td width="21%" align="left">
                                <input type="text" name="nmPenDan" value="<%=pendan.getNmPenDan()%>"style="width: 160px"></td>
                            <td width="17%">&nbsp;</td>
                        </tr>
                        <tr>
                            <td width="10%" align="left">&nbsp;</td>
                            <td align="left">Alamat</td>
                            <td align="center"><strong>:</strong></td>
                            <td align="left">
                                <input type="text" name="almtPenDan" value="<%=pendan.getAlmtPenDan()%>"style="width: 160px"></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td width="10%" align="left">&nbsp;</td>
                            <td align="left">Bank</td>
                            <td align="center"><strong>:</strong></td>
                            <td align="left"><strong>
                                    <input type="text" name="notelpPenDan" value="<%=pendan.getNotelpPenDan()%>"style="width: 80px">
                                </strong></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td width="10%">&nbsp;</td>
                            <td width="24%">&nbsp;</td>
                            <td width="3%">&nbsp;</td>
                            <td><input type="button" value="Simpan" onclick="this.form.action='simpan_edit_penerimadana';this.form.submit();">
                                <input type="reset" value="Reset"></td>
                            <td><input type="button" value="Hapus" style="background-color:#c00; color:#fff;" onclick="this.form.action='hapus_penerimadana';this.form.submit();"></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr><td colspan="6" align="center"><label align="center"><font color="red"><b>${errorpendan}</b></font></label></td></tr>
                        <tr>
                            <td height="20">&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
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

</body>
</html>