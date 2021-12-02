
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container" >
            <h2>Add Mahasiswa ${message} </h2>
            <div class="row">
                    <form action="mahasiswa-form.html" modelAttribute="mhs" method="POST" >                    
                        <div class="mb-3">
                            <label for="nama" class="form-label" >Nama</label>
                            <input type="text" class="form-control" id="nama" name="nama" value="${mhs.nama}"/>
                        </div>
                         <div class="mb-3">
                              <label for="nim" class="form-label" >NIM</label>
                              <input type="text" class="form-control" id="nim" name="nim" value="${mhs.nim}"/>
                        </div>
                         <div class="mb-3">
                              <label for="jurusan" class="form-label" >Jurusan</label>
                              <input type="text" class="form-control" id="jurusan" name="jurusan" value="${mhs.jurusan}"/>
                        </div>
                        <div class="mb-3">
                             <label for="kelas" class="form-label" >Kelas</label>
                             <input type="text" class="form-control" id="kelas" name="kelas" value="${mhs.kelas}"/>
                        </div> 
                        <input type="hidden" name="id" value="${mhs.id}" >
                         <div class="mb-3">
                        <button type="submit" class="btn btn-primary">Save</button>
                         </div>
                    </form>
                
            </div>
            <a href="${pageContext.request.contextPath}/home.html">Back To List</a>
        </div>
    </body>
</html>
