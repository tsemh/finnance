
const popup = document.querySelector(".Popup");

popup.addEventListener('click', (element)=>{
	
	let url   = location.search.slice(1);
	let dados = url.split('&');
	let param = {};
	
	dados.forEach((dado)=> {
	    let chaveValor = dado.split('=');
	    let chave = chaveValor[0];
	    let valor = chaveValor[1];
	    param[chave] = valor;
	});
	
	
    let elementClicked  = element.target.classList[0];
    let elementsToClose = ["Popup_Close", "Popup_Wrapper", "Buttons_Cancel"];
    let close = elementsToClose.some(elementsToClose => elementsToClose === elementClicked);

    if (close) {
		location.href = "ServletHome?User="+param["User"]+"&Account="+param["Account"];
    }

})
