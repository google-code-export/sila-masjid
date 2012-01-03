<%-- 
    Document   : index
    Created on : Nov 1, 2011, 8:55:27 PM
    Author     : alin
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="entities.Berita"%>
<%@page import="java.util.List"%>
<%@page import="entities.IndexBerita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%IndexBerita dafBer=new IndexBerita();%>
<%List<Berita> beritas=dafBer.getTerkini();%>
<%Iterator<Berita> itBer=beritas.iterator();%>
<!DOCTYPE html>
<%@include file='pages/hometemplate.html' %>
<html>
    <tr> 
        <td width="700" height="32" class="contentheader"><div align="center"><b>BERITA TERKINI</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%while (itBer.hasNext()){
                 Berita next=itBer.next();%>
                 <tr> 
                  <h3><%=next.getJudul()%></h3>
                  <p><%="Oleh: "+next.getMasjid().getNmMasjid()+","+next.getMasjid().getKotaMasjid()
                           +" pada "+DateFormat.getDateInstance(3).format(next.getTglUnggah())%>
                       </p>
                 </tr>
                 <tr>
                     <p><img src="images/berita.jpg" align="left" width="50px" height="50px">          
                         <%=next.getIsiBerita().substring(0,300) %>
                     </p>
                 </tr>
                 <tr><a href="detailberita?id=<%=next.getId()%>"><font color="blue">Selengkapnya....</font></a>
                 </tr>
                 
                <%}%>
         </table></td>
    </tr>
    <tr> 
        <td class="mctop"><img src="images/mc_box_bottom.gif" alt="-" width="700" height="23"></td>
    </tr>
</table>
<!-- COPYRIGHT - WWW.ZYMIC.COM - IF YOU REMOVE COPYRIGHT LEGAL ACTION WILL BE TAKEN -->
<!-- WE TRACK COPYRIGHT ON A DAILY BASIS, WE KNOW WHO YOU ARE!                      -->
<div align="center"><a href="http://www.zymic.com" target="_blank"><img src="images/copyright_DO_NOT_STEAL_ELSE_LEGAL_ACTION.gif" alt="Free Templates" width="452" height="15" border="0"></a></div></td>
</tr>
</table>
</body>
</html>
