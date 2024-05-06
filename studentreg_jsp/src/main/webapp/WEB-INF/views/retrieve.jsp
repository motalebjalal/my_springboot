<%@include file="header.jsp"%>

    <div class="content">
    <div class="row">
        <div class="col text-center align-items-center p-3">
            <table class="table table-striped table-bordered table-hover">
                <thead class="table-dark">
                <tr>
                    <th>Roll</th>
                    <th>Department</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
<%--                <jsp:useBean id="showStudents" scope="request" type="java.util.List"/>--%>

                <%--@elvariable id="showStudents" type="java.util.List"--%>
                <c:forEach items="${showStudents}" var="shows">
                    <tr>
                        <td><c:out value="${shows.roll}"/></td>
                        <td><c:out value="${shows.department}"/></td>
                        <td><c:out value="${shows.name}"/></td>
                        <td><c:out value="${shows.age}"/></td>
                        <td> <a type="button" href= " /editinfo?roll=<c:out value="${shows.roll}"/>"class="btn btn-primary"><i class="fas fa-edit"></i></a></td>
                        <td><a type="button" href= " /delete?roll= <c:out value="${shows.roll}"/>" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>

<br>
<br>
<br>
<br>
<%@include file="footer.jsp"%>