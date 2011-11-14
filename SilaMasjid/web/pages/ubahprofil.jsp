<%-- 
    Document   : register
    Created on : 14-Nov-2011, 10:57:46
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
        <h2>Profil Masjid</h2>
        <form action="ubahprofil" method="post" >
            <table width="450">
                <tr>
                    <td>Email</td><td><input type="text" name="email" style="width: 160px"></td>
                </tr>
                <tr>
                    <td>Password</td><td><input type="password" name="password" style="width: 120px"></td>
                </tr>
                <tr>
                    <td>Nama Masjid</td><td><input type="text" name="nmmasjid" style="width: 120px"></td>
                </tr>
                <tr>
                    <td>Alamat</td><td><input type="text" name="alamat" style="width: 120px"></td>
                </tr>
                <tr>
                    <td>Kota</td><td><input type="text" name="kota" style="width: 120px"></td>
                </tr>
                <tr>
                    <td>Telepon</td><td><input type="text" name="telepon" style="width: 120px"></td>
                </tr>
                
                <tr>
                    <td></td><td><input type="submit" value="Simpan" ></td>
                </tr>
            </table>
        </form>
    </body>
</html>
