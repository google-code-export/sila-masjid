<%-- 
    Document   : terima
    Created on : Dec 12, 2011, 5:08:20 PM
    Author     : Lulu
--%>

<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarKodeTransaksi"%>
<%@page import="entities.KodeTransaksi"%>
<%@page import="entities.DaftarTransaksi"%>
<%@page import="entities.Transaksi"%>
<%@page import="entities.DaftarRekening"%>
<%@page import="entities.Rekening"%>
<%@page import="entities.DaftarDonatur"%>
<%@page import="entities.Donatur"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DecimalFormat"%>

<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<%-- for dropdown kode transaksi--%>
<% DaftarKodeTransaksi dafkd = new DaftarKodeTransaksi();%>
<% List<KodeTransaksi> kdtrans = dafkd.getKodeTerimas(idMasjid);%>
<% Iterator<KodeTransaksi> iterator = kdtrans.iterator();%>

<%-- for list of transaksi--%>
<% DaftarTransaksi daftr = new DaftarTransaksi();%>
<% List<Transaksi> trans = daftr.getTrmKlr(idMasjid, "1");%>
<% Iterator<Transaksi> iterTr = trans.iterator();%>

<%-- for dropdown kode rekening--%>
<% DaftarRekening dafrek = new DaftarRekening();%>
<% List<Rekening> reks = dafrek.getRekenings(idMasjid);%>
<% Iterator<Rekening> iterRek = reks.iterator();%>

<%-- for dropdown kode donatur--%>
<% DaftarDonatur dafDon = new DaftarDonatur();%>
<% List<Donatur> dons = dafDon.getDonaturs(idMasjid);%>
<% Iterator<Donatur> iterDon = dons.iterator();%>

<%Date tanggal = new Date();%>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%--JUDUL DI SINI--%>
        <td width="700" height="32" class="contentheader"><div align="center"><b>PENERIMAAN DANA</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <form action="simpan_terima" method="post" >
                    <tr><td width="10%">&nbsp;</td>
                        <td >&nbsp;</td>
                        <td><label align="center"><font color="red"><b>${errorTerima}</b></font>
                            </label></td></tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td >Tanggal</td><td><input type="text" name="tgl" value="<%=DateFormat.getDateInstance(3).format(tanggal)%>"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Kode Transaksi</td><td><select name="idTrans">
                                <option value="">Pilih transaksi</option>
                                <% while (iterator.hasNext()) {%>
                                <% KodeTransaksi next = iterator.next();%>
                                <option value=<%=next.getId()%>><%=next.getKdTrans() + " - " + next.getNmTrans()%></option>
                                <%}%>
                            </select></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Donatur</td><td><select name="idDon">
                                <option value="">Pilih donatur</option>
                                <% while (iterDon.hasNext()) {%>
                                <% Donatur next = iterDon.next();%>
                                <option value=<%=next.getId()%>><%=next.getId() + " - " + next.getNmDonatur()%></option>
                                <%}%>
                            </select></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Kas/bank</td><td><select name="idRek">
                                <option value="">Pilih Rekening</option>
                                <% while (iterRek.hasNext()) {%>
                                <% Rekening next = iterRek.next();%>
                                <option value=<%=next.getId()%>><%=next.getNoRek() + " - " + next.getBank()%></option>
                                <%}%>
                            </select></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td >Jumlah</td><td><input type="text" name="jumlah" ></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Keterangan</td><td><input type="text" name="nmTrans"></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>&nbsp;</td><td><input type="submit" value="Simpan" ><input type="reset" value="Reset"></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                </form>

                <%--ISI SAMPAI SINI--%>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <th width="20%" align="left">Tanggal</th>
                    <th align="left">Nama Transaksi</th>
                    <th align="left">Kas/Bank</th>
                    <th align="right">Jumlah</th>
                    <th width="5%">&nbsp;</th>
                    <th align="left">Donatur</th>
                </tr>

                <% while (iterTr.hasNext()) {%>
                <% Transaksi next = iterTr.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=DateFormat.getDateInstance(3).format(next.getTglTran())%></td>
                    <td><%=next.getTran().getNmTrans()%></td>
                    <td><%=next.getRek().getBank()+"-"+next.getRek().getNoRek()%></td>
                    <td align="right"><%=DecimalFormat.getInstance().format(next.getJmlTran())%></td>
                    <td >&nbsp;</td>
                    <td><%=next.getDon().getNmDonatur()%></td>
                    <%--   <td bgcolor="#F4F4F4"><a href="editkode?id=<%=next.getId() %>"><font color="brown">pilih</font></a></td>
                    --%>                </tr>
                    <%}%>     
                <tr><td>&nbsp;</td></tr>
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
