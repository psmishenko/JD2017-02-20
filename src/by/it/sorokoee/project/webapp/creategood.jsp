<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CreateGood" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Создать товар</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="modelCar">Модель авто</label>
  <div class="col-md-4">
  <input id="modelCar" name="modelCar" type="text" placeholder="" class="form-control input-md" required="" value="bmw" >

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="yearOfIssue">Год выпуска</label>
  <div class="col-md-4">
  <input id="yearOfIssue" name="yearOfIssue" type="text" placeholder="" class="form-control input-md" required=""  value="2008">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="spare">запчасть</label>
  <div class="col-md-4">
  <input id="spare" name="spare" type="text" placeholder="" class="form-control input-md" required="" value="bumper" >

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="typeEngine">тип двигателя</label>
  <div class="col-md-4">
  <input id="typeEngine" name="typeEngine" type="text" placeholder="" class="form-control input-md" required="" value="disel" >

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="capacityEngine">объем двигателя</label>
  <div class="col-md-4">
  <input id="capacityEngine" name="capacityEngine" type="text" placeholder="" class="form-control input-md" required="" value="3000" >

  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="postbutton"></label>
  <div class="col-md-4">
    <button id="postbutton" name="postbutton" class="btn btn-primary">Создать</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>