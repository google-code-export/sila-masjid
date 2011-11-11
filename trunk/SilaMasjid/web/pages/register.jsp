<%-- 
    Document   : register
    Created on : 02-Nov-2011, 23:37:46
    Author     : Sumurmunding
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.DaftarMasjid"%>
<%@page import="entities.Masjid"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Registrasi</title>
    </head>
    <body>
        <h2>Registrasi Pengguna Baru SILA MASJID</h2>
        <form action="processregister" method="post" >
            <table width="450">
                <tr>
                    <td>Email</td><td><input type="text" name="email" style="width: 160px"></td>
                </tr>
                <tr>
                    <td>Password</td><td><input type="password" name="password" style="width: 120px"></td>
                </tr>
                <tr>
                    <td>Ulangi Password</td><td><input type="password" name="ulangipassword" style="width: 120px"></td>
                </tr>
                <tr>
                    <td></td><td><input type="reset"><input type="submit" value="Register" ></td>
                </tr>
            </table>
        </form>
    </body>
</html>
