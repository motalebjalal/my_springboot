<%@include file="header.jsp"%>
    
<!-- bootstrap form control start here -->
<div class="content">

    <div class="row">
        <div class="col">
            <form action="/update" method="post" class="m-3">
                <div class="mb-3">
                    <label for="name" class="form-label">Your Roll:</label>
                    <input type="text" class="form-control" id="roll" name="roll" value="${mydata.roll}" >
                  </div>
                <div class="mb-3">
                    <label for="department" class="form-label">Your Department:</label>
                    <input type="text" class="form-control" id="department" name="department" value="${mydata.department}">
                </div>
                <div class="mb-3">
                  <label for="name" class="form-label">Your Name:</label>
                  <input type="text" class="form-control" id="name" name="name" value="${mydata.name}">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Your Age:</label>
                    <input type="text" class="form-control" id="age" name="age" value="${mydata.age}">
                </div>
                <div class="mb-3 form-check">
                  <input type="checkbox" class="form-check-input" id="checbox">
                  <label class="form-check-label" for="checbox">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
              </form>
            
        </div>
    </div>
</div>

<!-- bootstrap form control end here -->

<%@include file="footer.jsp"%>