<%-- 
    Document   : keluar
    Created on : 23 Des 11, 9:13:42
    Author     : Alin
--%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarKodeTransaksi"%>
<%@page import="entities.KodeTransaksi"%>
<%@page import="entities.DaftarTransaksi"%>
<%@page import="entities.Transaksi"%>
<%@page import="entities.DaftarRekening"%>
<%@page import="entities.Rekening"%>
<%@page import="entities.DaftarPenerimaDana"%>
<%@page import="entities.PenerimaDana"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DecimalFormat"%>

<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<%-- for dropdown kode transaksi--%>
<% DaftarKodeTransaksi dafkd = new DaftarKodeTransaksi();%>
<% List<KodeTransaksi> kdtrans = dafkd.getKodeKeluars(idMasjid);%>
<% Iterator<KodeTransaksi> iterator = kdtrans.iterator();%>

<%-- for list of transaksi--%>
<% DaftarTransaksi daftr = new DaftarTransaksi();%>
<% List<Transaksi> trans = daftr.getTrmKlr(idMasjid, "2");%>
<% Iterator<Transaksi> iterTr = trans.iterator();%>

<%-- for dropdown kode rekening--%>
<% DaftarRekening dafrek = new DaftarRekening();%>
<% List<Rekening> reks = dafrek.getRekenings(idMasjid);%>
<% Iterator<Rekening> iterRek = reks.iterator();%>

<%-- for dropdown kode PenerimaDana--%>
<% DaftarPenerimaDana dafPen = new DaftarPenerimaDana();%>
<% List<PenerimaDana> pens = dafPen.getPenerimaDanas(idMasjid);%>
<% Iterator<PenerimaDana> iterPen = pens.iterator();%>

<%Date tanggal = new Date();%>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%--JUDUL DI SINI--%>
        <td width="700" height="32" class="contentheader"><div align="center"><b>PENGELUARAN DANA</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <form action="simpan_keluar" method="post" >
                    <tr><td width="7%">&nbsp;</td>
                        <td >&nbsp;</td>
                        <td><label align="center"><font color="red"><b>${errorTerima}</b></font>
                            </label></td></tr>
                    <tr>
                        <td width="7%">&nbsp;</td>
                        <td >Tanggal</td><td><input type="text" name="tgl" value="<%=DateFormat.getDateInstance(3).format(tanggal)%>"></td>
                    </tr>
                    <tr>
                        <td width="7%">&nbsp;</td>
                        <td>Kode Transaksi</td><td><select name="idTrans">
                                <option value="">Pilih transaksi</option>
                                <% while (iterator.hasNext()) {%>
                                <% KodeTransaksi next = iterator.next();%>
                                <option value=<%=next.getId()%>><%=next.getKdTrans() + " - " + next.getNmTrans()%></option>
                                <%}%>
                            </select></td>
                    </tr>
                    <tr>
                        <td width="7%">&nbsp;</td>
                        <td>PenerimaDana</td><td><select name="idPen">
                                <option value="">Pilih PenerimaDana</option>
                                <% while (iterPen.hasNext()) {%>
                                <% PenerimaDana next = iterPen.next();%>
                                <option value=<%=next.getId()%>><%=next.getId() + " - " + next.getNmPenDan()%></option>
                                <%}%>
                            </select></td>
                    </tr>
                    <tr>
                        <td width="7%">&nbsp;</td>
                        <td>Kas/bank</td><td><select name="idRek">
                                <option value="">Pilih Rekening</option>
                                <% while (iterRek.hasNext()) {%>
                                <% Rekening next = iterRek.next();%>
                                <option value=<%=next.getId()%>><%=next.getNoRek() + " - " + next.getBank()%></option>
                                <%}%>
                            </select></td>
                    </tr>
                    <tr>
                        <td width="7%">&nbsp;</td>
                        <td >Jumlah</td><td><input type="text" name="jumlah" ></td>
                    </tr>
                    <tr>
                        <td width="7%">&nbsp;</td>
                        <td>Keterangan</td><td><textarea rows="2" cols="18" name="nmTrans"></textarea></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td width="7%">&nbsp;</td>
                        <td>&nbsp;</td><td><input type="submit" value="Simpan" ><input type="reset" value="Reset"></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                </form>

                <%--ISI SAMPAI SINI--%>
                <tr>
                    <td width="7%">&nbsp;</td>
                    <th width="20%" align="left">Tanggal</th>
                    <th align="left">Nama Transaksi</th>
                    <th align="left">Kas/Bank</th>
                    <th align="right">Jumlah</th>
                    <th width="2%">&nbsp;</th>
                    <th align="left">PenerimaDana</th>
                    <th align="left">Keterangan</th>
                </tr>

                <% while (iterTr.hasNext()) {%>
                <% Transaksi next = iterTr.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=DateFormat.getDateInstance(3).format(next.getTglTran())%></td>
                    <td><%=next.getTran().getNmTrans()%></td>
                    <td><a href="editrekening?id=<%=next.getRek().getId()%>"><font color="blue"><%=next.getRek().getBank()+"-"+next.getRek().getNoRek()%></font></a></td>
                    <td align="right"><%=DecimalFormat.getInstance().format(next.getJmlTran())%></td>
                    <td >&nbsp;</td>
                    <td><a href="editpenerimadana?id=<%=next.getPen().getId() %>"><font color="blue"><%=next.getPen().getNmPenDan()%></font></a></td>
                    <td><%=next.getKet() %></td>
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
