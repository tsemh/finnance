
<section id="centraliza">
	<div class="card-holder">

		<div class="card">

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
							<div class="col-6">${i.ds_investimento}
								<div class="vlr">135 R$</div>
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
