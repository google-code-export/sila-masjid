<%-- 
    Document   : rekening
    Created on : Dec 12, 2011, 9:40:06 PM
    Author     : sumding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Proposal"%>
<%@page import="entities.DaftarProposal" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<% DaftarProposal daftar=new DaftarProposal();%>
<% List<Proposal> proposal=daftar.getProposals();%>
<% Iterator<Proposal> iterator = proposal.iterator();%>

    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">
                
                    <%--JUDUL DISINI--%>
        <tr>
            <td width="452" height="32" class="contentheader">
            <div align="center"><b>DAFTAR PROPOSAL</b></div></td>
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
                  <td align="left">Nomor Rekening</td>
                  <td align="center"><strong>:</strong></td>
                  <td width="21%" align="left"><input type="text" name="noRek" style="width: 160px"></td>
                  <td width="17%">&nbsp;</td>
                </tr>
                <tr>
                  <td width="10%" align="left">&nbsp;</td>
                  <td align="left">Atas Nama</td>
                  <td align="center"><strong>:</strong></td>
                  <td align="left"><input type="text" name="nmRek" style="width: 160px"></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td width="10%" align="left">&nbsp;</td>
                  <td align="left">Bank</td>
                  <td align="center"><strong>:</strong></td>
                  <td align="left"><strong>
                    <input type="text" name="bank" style="width: 80px">
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
                  <td><input type="button" value="Simpan" onclick="this.form.action='inputrekening';this.form.submit();">
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
                <th width="10%" align="center">&nbsp;</th>
                <th width="24%" align="center">Nama</th>
                <th colspan="2" align="center">Keperluan</th>
                <th align="center">Besar Dana</th>
                <th width="11%" align="center">Edit/Hapus</th>
                <th width="3%" align="left">&nbsp;</th>
              </tr>
              <% while (iterator.hasNext()) {%>
              <% Proposal next = iterator.next();%>
              <tr>
                <td>&nbsp;</td>
                <td align="left"><%=next.getNama()%></td>
                <td colspan="2" align="left"><%=next.getJudul()%></td>
                <td align="center"><%=next.getBesarDana()%>,-</td>
                <td align="center" bgcolor="#F4F4F4"><a href="editrekening?id=<%=next.getId() %>"><font color="brown">edit</font></a></td>
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

