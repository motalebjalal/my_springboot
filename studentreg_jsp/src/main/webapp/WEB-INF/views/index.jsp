<%@include file="header.jsp"%>

<div class="content">
    <div class="row">
        <div class="col">
           
            <%--@elvariable id="student" type="com.jalal.studentreg_jsp.model.Student"--%>
            <sf:form action="/create" method="post" modelAttribute="student" class="m-3">
                <div class="mb-2">
                    <label for="roll" class="form-label">Your Roll:</label>
                    <sf:input type="text" class="form-control input-sm" path="roll" id="roll" name="roll"/>
                    <sf:errors path="roll" cssClass="alert-danger"/>
                  </div>
                <div class="mb-3">
                    <label for="department" class="form-label">Depertment Name:</label>
                    <sf:input type="text" path="department" class="form-control" id="department" name="department"/>
                    <sf:errors path="department" cssClass="alert-danger"/>
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Your Name:</label>
                    <sf:input type="text" path="name" class="form-control" id="name" name="name"/>
                    <sf:errors path="name" cssClass="alert-danger"/>
                </div>
                <div class="mb-3">
                    <label for="age" class="form-label">Your Age:</label>
                    <sf:input type="text" path="age" class="form-control" id="age" name="age"/>
                    <sf:errors path="age" cssClass="alert-danger"/>
                </div>
                <div class="mb-3 form-check">
                  <input type="checkbox" class="form-check-input" id="checbox">
                  <label class="form-check-label" for="checbox">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">Register</button>
              </sf:form>
            
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>


