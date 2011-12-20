<%-- 
    Document   : proposal
    Created on : 02-Dec-2011, 22:39:29
    Author     : Sumurmunding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<%@include file='hometemplate2.html' %>
<!DOCTYPE html>
<html>
        <%--JUDUL DI SINI--%>
    <td width="700" height="32" class="contentheader"><div align="center"><b>UNGGAH PROPOSAL</b></div></td>
</tr>
<tr> 
    <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
</tr>
<tr> 
    <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
            <%--ISI MULAI DI SINI--%>
            <form action="unggahproposal" method="post" >

                <tr>
                    <td width="10%">&nbsp;</td>
                    <td>Nama</td><td><input type="text" name="nama" style="width: 120px"></td>
                </tr>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <td>Alamat</td><td><input type="text" name="alamat" style="width: 120px"></td>
                </tr>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <td>Telepon</td><td><input type="text" name="noTelp" style="width: 120px"></td>
                </tr>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <td>Email</td><td><input type="text" name="email" style="width: 120px"></td>
                </tr>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <td>Besar Dana</td><td><input type="text" name="besarDana" style="width: 120px"></td>
                </tr>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <td>Judul</td><td><input type="text" name="judul" style="width: 120px"></td>
                </tr>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <td>Detail Proposal</td><td><textarea style="width: 300px;height: 300px;" name="detailProposal"> </textarea></td>
                </tr>
                <tr><td>&nbsp;</td></tr>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <td>&nbsp;</td><td><input type="submit" value="Unggah" >&nbsp;&nbsp;<input type="reset" value="Reset"></td>
                </tr>
                <tr><td colspan="3" align="center"><label align="center"><font color="red"><b>${errorproposal}</b></font></label></td></tr>
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

