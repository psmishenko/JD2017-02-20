<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=login" method="POST">

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Добавление товара</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="название">Название</label>
  <div class="col-md-5">
  <input id="название" name="название" type="text" placeholder="название товара" class="form-control input-md">
  <span class="help-block">Например: Телефоны</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="цена">Цена</label>
  <div class="col-md-4">
  <input id="цена" name="цена" type="text" placeholder="цена товара, руб" class="form-control input-md">
  <span class="help-block">Например: 10.6 </span>
  </div>
</div>

<!-- File Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="добавить картинку">Добавить картинку</label>
  <div class="col-md-4">
    <input id="добавить картинку" name="добавить картинку" class="input-file" type="file">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="добавить">Добавить</label>
  <div class="col-md-4">
    <button id="добавить" name="добавить" class="btn btn-success">Button</button>
  </div>
</div>

</fieldset>
</form>



<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>