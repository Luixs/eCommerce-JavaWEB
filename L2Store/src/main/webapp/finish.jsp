<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String nome="";
	if (request.getAttribute("name") == null){
		nome = (String) "";		
	}else{
		String nomeServlet = (String) request.getAttribute("name");
		nome = nomeServlet;
	}
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- MINHAS CONFIGURAÇÕES  -->
    <link rel="stylesheet" href="css/finish.css">
    <link rel="stylesheet" href="css/index.css">
    <!-- CONFIGURAÇÕES ONLINE -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" media="all">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" media="all">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body id="body">
	<nav class="navbar fixed-top opacity-90" id="navFinal">
	  <div class="container-fluid">
	    <a class="navbar-brand text-white" href="#page-top" id="navFinal_Text">L2 STORE</a>
	  </div>
	</nav>
    <div class="container mt-5 px-5">
        <div class="mb-4 text-white" id="top_editar">
            <h2>Confirmar dados e pagar</h2> <span>Realize o pagamento e aproveite todos os nossos benefícios!</span>
        </div>
        <div class="row">
            <div class="col-md-8">
                <div class="card p-3">
                    <h6 class="text-uppercase">Detalhes do Pagamento</h6>
                    <div class="inputbox mt-3"> <input type="text" name="name" class="form-control" required="required"> <span>Nome no cartão</span> </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="inputbox mt-3 mr-2"> <input type="text" name="name" class="form-control" required="required"> <i class="fa fa-credit-card"></i> <span>Número do Cartão</span> </div>
                        </div>
                        <div class="col-md-6">
                            <div class="d-flex flex-row">
                                <div class="inputbox mt-3 mr-2"> <input type="text" name="name" class="form-control" required="required"> <span>Validade</span> </div>
                                <div class="inputbox mt-3 mr-2"> <input type="text" name="name" class="form-control" required="required"> <span>CVC</span> </div>
                            </div>
                        </div>
                    </div>
                    <div class="mt-4 mb-4">
                        <h6 class="text-uppercase">Endereço de Entrega</h6>
                        <div class="row mt-3">
                            <div class="col-md-6">
                                <div class="inputbox mt-3 mr-2"> <input type="text" name="name" class="form-control" required="required"> <span>Endereço Completo</span> </div>
                            </div>
                            <div class="col-md-6">
                                <div class="inputbox mt-3 mr-2"> <input type="text" name="name" class="form-control" required="required"> <span>Cidade</span> </div>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-6">
                                <div class="inputbox mt-3 mr-2"> <input type="text" name="name" class="form-control" required="required"> <span>Cidade/Estado</span> </div>
                            </div>
                            <div class="col-md-6">
                                <div class="inputbox mt-3 mr-2"> <input type="text" name="name" class="form-control" required="required"> <span>CEP</span> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 ">
            
                <div class="card card-blue p-3 text-dark mb-3">
               		<div id="demo">A</div>
                	 <span>------------------------------------------</span>
                	 <span>Total</span>
                    <div class="d-flex flex-row align-items-end mb-3">
                        <h1 class="mb-0 text-dark" id="finalValue">R$549</h1>
                    </div>
                    <span>Aproveite todas as vantagens de ser um assinante no nosso site, pegue seu desconto!!!</span> <a href="#" class="text-primary decoration">Vire assinante</a><br>
                    <form method="POST" action="ordemCompra">
                    	<input class="invisible" type="text" name="user" id="example">
                    	<input class="invisible" type="text" name="user2" id="valorOrdemCompra">
                    	<button class="btn btn-success px-3 text-white text-center" type="submit"> <span>PAGAR</span> </button>
                    </form>
               	</div>	
           	</div>
        </div>
    </div>>
    <script src="scripts/finish.js"></script>
</body>
</html>