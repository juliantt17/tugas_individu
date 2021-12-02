

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
       <h1>Halaman Admin - List Mahasiswa</h1>
        <h2>Daftar Mahasiswa</h2>
        <p>
        <table class="table table-striped table-bordered table-primary" >
            <tr style="background-color:black; color:white;">
                <th>ID</th>                   
                <th>Nama</th>
                <th>Nim</th>
                <th>Kelas</th>
                <th>Jurusan</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listMahasiswa}" var="mhs">
                <tr>
                    <td>${mhs.id}</td>                                 
                    <td>${mhs.nama}</td>
                    <td>${mhs.nim}</td>
                    <td>${mhs.kelas}</td>
                    <td>${mhs.jurusan}</td>
                    <td>
                        <button class="btn btn-primary" onclick="window.location.href='mahasiswa-form.html?action=edit&id=${mhs.id}'">Edit</button>
                        <button class="btn btn-danger" onclick="window.location.href='mahasiswa-form.html?action=delete&id=${mhs.id}'">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </p>
        <p>
            <button class="btn btn-primary" onclick="window.location.href='mahasiswa-form.html'" >
                Add Mahasiswa
            </button>
        </p>
        
    </body>
</html>
