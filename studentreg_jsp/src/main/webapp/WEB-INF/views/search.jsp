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
                </tr>
                </thead>
                <tbody>
                <%--                <jsp:useBean id="showStudents" scope="request" type="java.util.List"/>--%>

                <%--@elvariable id="showStudents" type="java.util.List"--%>
                    <tr>
                        <td><c:out value="${oneStudent.roll}"/></td>
                        <td><c:out value="${oneStudent.department}"/></td>
                        <td><c:out value="${oneStudent.name}"/></td>
                        <td><c:out value="${oneStudent.age}"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>