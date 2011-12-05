<%-- 
    Document   : penerimadana
    Created on : Dec 5, 2011, 11:41:38 PM
    Author     : yooganz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.PenerimaDana"%>
<%@page import="entities.DaftarPenerimaDana" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<% DaftarPenerimaDana daftar=new DaftarPenerimaDana();%>
<% List<PenerimaDana> pendan=daftar.getPenerimaDanas(idMasjid);%>
<% Iterator<PenerimaDana> iterator = pendan.iterator();%>

    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">
                
                    <%--JUDUL DISINI--%>
        <tr>
            <td width="452" height="32" class="contentheader">
            <div align="center"><b>PENERIMA DANA</b></div></td>
        </tr>
        <tr>
            <td><img src="images/main_content_header_under.gif" width="452" height="26"></td>
        </tr>
       
        <tr>
            <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
              <%--ISI MULAI SINI--%>
              <form action="" method="post">
                <tr>
                  <td width="10%" align="left">&nbsp;</td>
                  <td align="left">Nama</td>
                  <td align="center"><strong>:</strong></td>
                  <td width="21%" align="left"><input type="text" name="nmPenDan" style="width: 160px"></td>
                  <td width="17%">&nbsp;</td>
                </tr>
                <tr>
                  <td width="10%" align="left">&nbsp;</td>
                  <td align="left">Alamat</td>
                  <td align="center"><strong>:</strong></td>
                  <td align="left"><input type="text" name="almtPenDan" style="width: 160px"></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td width="10%" align="left">&nbsp;</td>
                  <td align="left">Nomor Telepon</td>
                  <td align="center"><strong>:</strong></td>
                  <td align="left"><strong>
                    <input type="text" name="notelpPenDan" style="width: 80px">
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
                  <td><input type="button" value="Simpan" onclick="this.form.action='inputpenerimadana';this.form.submit();">
                    <input type="reset" value="Reset"></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td height="20">&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
              </form>
              <%--ISI SAMPAI SINI--%>
              <tr>
                <td width="10%" align="center">&nbsp;</td>
                <th width="24%" align="center">Nama</th>
                <th colspan="2" align="center">Alamat</th>
                <th align="center">No.Telp</th>
                <th width="11%" align="center">Ubah/Hapus</th>
                <th width="3%" align="left">&nbsp;</th>
              </tr>
              <% while (iterator.hasNext()) {%>
              <% PenerimaDana next = iterator.next();%>
              <tr>
                <td>&nbsp;</td>
                <td align="left"><%=next.getNmPenDan()%></td>
                <td colspan="2" align="left"><%=next.getAlmtPenDan()%></td>
                <td align="center"><%=next.getNotelpPenDan()%></td>
                <td align="center" bgcolor="#F4F4F4"><a href="editpenerimadana?id=<%=next.getId() %>"><font color="brown">edit</font></a></td>
                <td bgcolor="#F4F4F4">&nbsp;</td>
              </tr>
              <%}%>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
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

