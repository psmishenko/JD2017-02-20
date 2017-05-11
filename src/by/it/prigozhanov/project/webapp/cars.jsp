<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<p>Cmd CARS: ${cars}</p>

<div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="http://files1.porsche.com/filestore/image/multimedia/none/982-718-bo-detail-personalisation-exclusive718-xs/normal/7bc8bb2f-bf6e-11e5-8bd4-0019999cd470/porsche-normal.png" alt="...">
      <div class="caption">
        <h3>Porsche Cayman</h3>
        <p>1500$ per day</p>
        <p><a class="btn btn-primary" role="button" action="do?command=rentcar">Rent Car</a></p>
      </div>
    </div>
  </div>

  <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
        <img src="http://www.bentleymotors.com/content/dam/bentley/Master/Models/Hero/Bentayga%20Diesel/Bentayga_MY18_Portofino_profile%201920x670.jpg/_jcr_content/renditions/original.image_file.1366.477.file/Bentayga_MY18_Portofino_profile%201920x670.jpg" alt="...">
        <div class="caption">
          <h3>Bentley Bentayga</h3>
          <p>2500$ per day</p>
          <p><a class="btn btn-primary" role="button" action="do?command=rentcar">Rent Car</a></p>
        </div>
      </div>
    </div>

    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img src="http://st.automobilemag.com/uploads/sites/10/2016/08/2017-bmw-m4-base-coupe-side-view.png" alt="...">
          <div class="caption">
            <h3>BMW m3</h3>
            <p>1200$ per day</p>
            <p><a class="btn btn-primary" role="button" action="do?command=rentcar">Rent Car</a></p>
          </div>
        </div>
      </div>
</div>



<%@ include file="include/end-html.jsp" %>