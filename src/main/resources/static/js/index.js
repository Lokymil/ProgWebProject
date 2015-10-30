var subFragment = {};
var logFragment = {};
var articleFragment = {};
var articles = {};
var test = "test";
var formLogin = {};
var formSub = {};
var formNewArt = {};
var login = {};
var authoriation = {};

function inscription(){
	state=subFragment.style.display;
	if(state=="none"){
		window.location.hash="subscribe";
		subFragment.style.display="inline";
		logFragment.style.display="none";
		articleFragment.style.display="none";
		articles.style.display="none";
	}
}

var subscribe = function(){
	console.log("Subscribe");
	var password = formSub.children("#password").val();
	if(password == formSub.children("#password2").val()){
		console.log("password ok " + password);
		$.post("/subscribe",
			{
				firstName:formSub.children("#firstName").val(),
				lastName:formSub.children("#lastName").val(),
				userName:formSub.children("#userName").val(),
				email:formSub.children("#email").val(),
				password:password
			},
			function(data){
				console.log("data : " + data);
				if (data != null && data != ""){
					if (data.indexOf("exists") > -1){
						alert("Votre pseudo existe déjà! Trouvez en un autre.");
					} else if (data.indexOf("error") > -1){
						alert("Nous ne pouvons vous enregistrer à cause d'un problème interne.");
					} else {
						console.log("Is ok " + data);
						login = formSub.children("#userName").val();
						authorisation = data;
					}
				} else {
					alert("Nous ne pouvons vous enregistrer à cause d'un problème interne.");
				}
			});
	} else {
		alert("Votre mot de passe n'est pas identique dans les deux champs");
	}
	
};

function connexion(){
	state=logFragment.style.display;
	if(state=="none"){
		window.location.hash="login";
		subFragment.style.display="none";
		logFragment.style.display="inline";
		articleFragment.style.display="none";
		articles.style.display="none";
	}
}

var login = function(){
	console.log("Send login");
	$.post("/login",{userName:formLogin.children("#userName").val(),
					password:formLogin.children("#password").val()}, 
					function(data){
							console.log("data : " + data);
							if (data != null && data != ""){ 
								login = formLogin.children("#userName").val();
								authorisation = data;
							} else {
								alert("Votre mot de passe ou votre identifiant sont erronés");
							}
					});
	console.log("loged in")
};

function addArticle(){
	state=articleFragment.style.display;
	if(state=="none"){
		window.location.hash="newArticle";
		subFragment.style.display="none";
		logFragment.style.display="none";
		articleFragment.style.display="inline";
		articles.style.display="none";
	}
}

function getArticles(){
	state=articles.style.display;
	if(state=="none"){
		window.location.hash="articles";
		subFragment.style.display="none";
		logFragment.style.display="none";
		articleFragment.style.display="none";
		articles.style.display="inline";
	}
}

$(document).ready(

		function(){
			console.log("ready");
			
			subFragment = document.getElementById("fragmentInscription");
			logFragment = document.getElementById("fragmentConnexion");
			articleFragment = document.getElementById("fragmentArticle");
			articles = document.getElementById("listArticles");
			formLogin = $("#formLogin");
			formSub = $("#formSubscribe");
			formNewArt = $("#formNewArt");
			
			
			if (window.location.hash == "#subscribe") {
				console.log("anchor subscribe");
				inscription();
			}
			
			if (window.location.hash == "#login") {
				console.log("anchor login");
				connexion();
			}
			
			if (window.location.hash == "#newArticle") {
				console.log("anchor newArticle");
				addArticle();
			}
			
			if (window.location.hash == "#articles") {
				console.log("anchor articles");
				getArticles();
			}
			
			formLogin.children("#postLogin").click(login);
		
			formSub.children("#postSubscribe").click(subscribe);
			
			/*var subscribe = function() {
					$.ajax({
						url: "http://localhost:8090/subscribe",
						method: "GET",
						success: function(data){
							console.log(data);
							content.html(data);
						}
					});
				};
			menu.children("#toSubscribe").click(subscribe);
			
			if(window.location.anchor == "subscribe") {
				subscribe();
			}*/
			
			/*$.ajax({
				url: "http://localhost:8090/new_article",
				method: "POST",
				data: myData,
				dataType: "json",
				success: function(data){
					console.log(data);
				}
			});*/
		}
	);