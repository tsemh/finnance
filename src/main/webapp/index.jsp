<script>
const btn = document
.querySelector('.read-more-btn');

const text = document
    .querySelector('.card__read-more');

const cardHolder = document
    .querySelector('.card-holder');

cardHolder
    .addEventListener('click', e => {

        const current = e.target;

        const isReadMoreBtn = current.className.includes('read-more-btn');

        if (!isReadMoreBtn)
            return;

        const currentText = e.target.parentNode.querySelector('.card__read-more');

        currentText.classList.toggle('card__read-more--open');

        current.textContent = current.textContent.includes('Mais Detalhes') ? 'Menos Detalhes' : 'Mais Detalhes';

}); 
</script>
<section id="centraliza">
	<div class="card-holder">

		<div class="card" style="border-radius: 50px; border: none;">

			<div class="card-contents">



				<h1 class="card__name">Investimentos</h1>


				<div class="row">
					<div class="grafico">
						<div id="grafico"></div>
					</div>
					<div class="col" id="label">
						<label>Total Investido:
							<div>R$156.2</div>
						</label>
					</div>
					<div class="col sm-6">
						<label> Carteira Rendendo
							<div>18% a.a</div>
						</label>
					</div>
				</div>



				<span class="card__read-more">
					<div class="row">
						<c:forEach items="${investimentos}" var="i">
						<c:set var = "codInv" value="${i.cd_investimento}"/>
						<c:set var = "codInv" value="0"/>
						<c:forEach items="${aplicacoes}" var="a">
						<c:if test="${codInv == a.investimento.cd_investimento}" />
						<c:set var = "totalInv" value="${totalInv+ a.vl_aplicacao}"/>	
						</c:forEach>
						
							<div class="col-6">${i.ds_investimento}
								<div class="vlr">${totalInv}</div>
							</div>
							<div class="col-6">
								Carteira Rendendo:
								<div class="vlr">${i.pr_rendimento_a_a}</div>
							</div>
						</c:forEach>

						<div id="centraliza2">
							<div class="row">
								<div class="c4">
									<a href="AddInvestimentoJSP.jsp"><input type="image"
										src="./Resources/Images/download.png" style="border: double;"
										height="55" width="70" id="add" /></a>
								</div>
							</div>
							<div class="row">
								<a href="historico.html"><button id="historico">Histórico</button></a>
							</div>
						</div>
					</div>
				</span>

				<p class="read-more-btn" style="border-radius: 50px;">Mais
					Detalhes</p>

			</div>
		</div>

	</div>
</section>
