var subFragment = {};
var logFragment = {};
var articleFragment = {};
var articles = {};
var test = "test";
var formLogin = {};
var formSub = {};
var formNewArt = {};

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
	console.log("Send login");
	$.post("/login",{userName:test,password:test}, function(data, status){
		console.log("data : " + data + ", status " + status);
	});
//		$.ajax({
//			url: "http://localhost:8090/login",
//			type: "POST",
//			data: {userName:test,password:test},
//			dataType: "json",
//			success: function(data){
//				console.log("test " + data);
//			}
//		});
		console.log("loged in")
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
			formSub = $("#formSub");
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