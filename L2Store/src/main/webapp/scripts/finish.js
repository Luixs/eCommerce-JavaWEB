//---------- SESSION
//RECEBENDO DADOS 
produtos= JSON.parse(sessionStorage.getItem("jsArray"));
compras = JSON.parse(sessionStorage.getItem("compras"));

//CREATE A TABLE

//document.getElementById("demo").innerHTML= listaMontada;
var totalValue = 0
function montarLista(){
	var string="<table id='tableValorFinal'><tr><th>Id</th><th>Produto</th><th>Valor</th></tr>"; 
	
	for(var i=0; i<compras.length;i++){
		for(var j=0;j<6;j++){
			if(produtos[j]["id"]==compras[i]){
				id = compras[i];
				nome = produtos[j]["Produto"];
				valor = produtos[j]["Valor"];				 
				totalValue+=valor 
				string+= `<tr><td>${id}</td><td>${nome}</td><td>R$${valor}</td></tr>`
			}
		}
	}
	string+="</table>"
	return string;
}
	
	//
	//return alert(compras.length);	

lista = montarLista();
document.getElementById("finalValue").innerHTML= "R$" + totalValue
document.getElementById("demo").innerHTML= lista;
document.getElementById("example").setAttribute('value',compras);
document.getElementById("valorOrdemCompra").setAttribute('value',totalValue);
//------------------------------