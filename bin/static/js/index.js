var userDisplay = {};
var buttonSub = {};
var buttonLogin = {};
var buttonLogout = {};
var subFragment = {};
var logFragment = {};
var articleFragment = {};
var articles = {};
var formLogin = {};
var formSub = {};
var formNewArt = {};
var articleTemplate = {};
var login = "";
var authorisation = "";

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
						logedIn();
						getArticles();
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
								logedIn();
								getArticles();
							} else {
								alert("Votre mot de passe ou votre identifiant sont erronés");
							}
					});
	console.log("loged in")
};

function addArticle(){
	console.log("ajout d'article");
	if (login == "" || authorisation == ""){
		connexion();
		alert("Vous devez être enregistré pour faire cette action");
	} else {
		state=articleFragment.style.display;
		if(state=="none"){
			window.location.hash="newArticle";
			subFragment.style.display="none";
			logFragment.style.display="none";
			articleFragment.style.display="inline";
			articles.style.display="none";
		}
	}
}

var postNewArticle = function() {
	console.log("posting new article");
	
	var title = formNewArt.children("#title").val();
	var content = formNewArt.children("#content").val();
	
	if (title == null || content == null || title == "" || content == ""){
		alert("Le titre et le contenu doivent être non vide.");
	} else {
		console.log("titre et content valide");
		console.log(title);
		console.log(content);
		$.post("/new_article",{
			userName:login,
			authorisation:authorisation,
			title:title,
			content:content
		}, function(data){
			if (data.indexOf("Unauthorized")>-1){
				connexion();
				deconnexion();
				alert("Vous devez être enregistré pour poster un article");
			} else if (data.indexOf("error")>-1) {
				alert("Nous ne pouvons accèder à votre requête à cause d'un problème interne");
			} else {
				getArticles();
				alert("Votre article a bien été posté!");
			}
		});
	}
}

function getArticles(){
	loadArticles()
	
	window.location.hash="articles";
	subFragment.style.display="none";
	logFragment.style.display="none";
	articleFragment.style.display="none";
	articles.style.display="inline";
}

var loadArticles = function() {
	console.log("loading articles");
	$.get("/articles/1",function(data){
		console.log(data);
	});
}

var logedIn = function() {
	//userDisplay.text(login);
	userDisplay.style.display="inline";
	buttonSub.style.display="none";
	buttonLogin.style.display="none";
	buttonLogout.style.display="inline";
}

function deconnexion(){
	userDisplay.style.display="none";
	buttonSub.style.display="inline";
	buttonLogin.style.display="inline";
	buttonLogout.style.display="none";
	login="";
	authorisation="";
}

$(document).ready(

		function(){
			console.log("ready");
			
			userDisplay = document.getElementById("userDisplay");
			buttonSub = document.getElementById("buttonInscription");
			buttonLogin = document.getElementById("buttonConnexion");
			buttonLogout = document.getElementById("buttonDeconnexion");
			subFragment = document.getElementById("fragmentInscription");
			logFragment = document.getElementById("fragmentConnexion");
			articleFragment = document.getElementById("fragmentArticle");
			articles = $("#listArticles");
			articleTemplate = $("#articleTemplate");
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
			
			formNewArt.children("#postArticle").click(postNewArticle);
			
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