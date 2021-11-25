//SESSION BUY

jsarray = [
	{"id":1,"Produto":"Camisa Black Tourus", "Valor": 30},
	{"id":2,"Produto":"Listrada Old-School", "Valor": 65},
	{"id":3,"Produto":"Camisa White Compton", "Valor": 40},
	{"id":4,"Produto":"Moletom Selva", "Valor": 160},
	{"id":5,"Produto":"Camisa Primaveira", "Valor": 35},
	{"id":6,"Produto":"Camisa Black lisa", "Valor": 40},
	];
sessionStorage.setItem("jsArray", JSON.stringify(jsarray));

//---------------------------------------------------------

var carrinho =0;
var id_compras=[];

function adicionar(id){
    carrinho++;
   	id_compras.push(id)
	document.getElementById("carrinhoDeCompras").textContent=carrinho
}

$(document).ready(function(){
    $(".btn").click(function(){
        $("#myModal").modal('show');
    });
});

function fecharModal(){
    $("#myModal").modal('hide');
}

function finalizarCompra(){
    //MANDANDO AS COMPRAS
	sessionStorage.setItem("compras", JSON.stringify(id_compras));
	//INDO PARA A FINALIZAÇÃO
    window.location.replace("finish.jsp");
}setTimeout("pageRedirect()", 10000);