
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="./Resources/CSS/MovimentacaoTRN_Style.css">

<c:choose>
	<c:when test='${Mode.toUpperCase().trim().equals("RECEITAINS")}'>
		<c:set var="TitleType" value="Receita"/>
		<c:set var="Receita_Config" value='<%="checked-".split("-")%>'/>
		<c:set var="Despesa_Config" value='<%="disabled-Input_Disabled".split("-")%>'/>
	</c:when>
	<c:when test='${Mode.toUpperCase().trim().equals("DESPESAINS")}'>
		<c:set var="TitleType" value="Despesa"/>
		<c:set var="Receita_Config" value='<%="disabled-Input_Disabled".split("-")%>'/>
		<c:set var="Despesa_Config" value='<%="checked-".split("-")%>'/>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>

<div class="Popup">
	<div class="Popup_Wrapper">
		<div class="Popup_Content">
			<p class="Popup_Title">Incluí - ${TitleType}</p>
			<i class="Popup_Close fa-solid fa-xmark"></i>
			<form action="ServletMovimentacao?User=${param.User}&Account=${param.Account}&Action=Add" method="get" class="Popup_Form">

					<fieldset class="Form_Type">
						<input type="radio"  name="Tipo" value="R" id="MovReceita" ${Receita_Config[0]}>
						<label for="MovReceita" class="${Receita_Config[1]}">
							<em class="fa-solid fa-arrow-up" style="margin-right: 6px;"></em>
							Receita
						</label>
	
						<input type="radio"  name="Tipo" value="D" id="MovDespesa" ${Despesa_Config[0]}>
						<label for="MovDespesa" class="${Despesa_Config[1]}">
							<em class="fa-solid fa-arrow-down" style="margin-right: 5px;"></em>						
							Despesa
						</label>
					</fieldset>

					<fieldset class="Form_Main">
						<div>
							<label for="MovValor">Valor</label>
							<input type="number" name="Valor" id="MovValor" value="${ValorMovimentacao}">
						</div>
						<div>
							<label for="MovData">Data</label>
							<input type="date" 	 name="Data" id="MovData" value="${DataMovimentacao}">
						</div>
					</fieldset>

					<fieldset class="Form_Selection">					
						<label for="MovCategoria">Categoria</label>
						<select name="Categoria" id="MovCategoria">
							<option value="!0!">Selecione</option>
							<c:forEach var="Categoria" items="${Categorias}">
								<option value="${Categoria.cd_categoria}">${Categoria.nm_categoria}</option>
							</c:forEach>
						</select>
					</fieldset>

					<fieldset class="Form_Buttons">
						<input type="button" value="Cancelar" class="Buttons_Cancel">
						<input type="submit" value="Salvar"  class="Buttons_Confirm">
					</fieldset>

			</form>
		</div>
	</div>
</div>

<script src="./Resources/JS/MovimentacaoPopupApp.js"></script>
