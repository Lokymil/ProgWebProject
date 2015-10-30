var subForm = {};
var logForm = {};
var articleForm = {};
var articles = {};

function inscription(){
	state=subForm.style.visibility;
	if(state=="hidden"){
		window.location.hash="subscribe";
		subForm.style.visibility="visible";
		logForm.style.visibility="hidden";
		articleForm.style.visibility="hidden";
		articles.style.visibility="hidden";
	}
}

function connexion(){
	state=logForm.style.visibility;
	if(state=="hidden"){
		window.location.hash="login";
		subForm.style.visibility="hidden";
		logForm.style.visibility="visible";
		articleForm.style.visibility="hidden";
		articles.style.visibility="hidden";
	}
}

function addArticle(){
	state=articleForm.style.visibility;
	if(state=="hidden"){
		window.location.hash="newArticle";
		subForm.style.visibility="hidden";
		logForm.style.visibility="hidden";
		articleForm.style.visibility="visible";
		articles.style.visibility="hidden";
	}
}

function getArticles(){
	state=articleForm.style.visibility;
	if(state=="hidden"){
		window.location.hash="articles";
		subForm.style.visibility="hidden";
		logForm.style.visibility="hidden";
		articleForm.style.visibility="hidden";
		articles.style.visibility="visible";
	}
}

$(document).ready(

		function(){
			console.log("ready");
			
			subForm = document.getElementById("formInscription");
			logForm = document.getElementById("formConnexion");
			articleForm = document.getElementById("formArticle");
			articles = document.getElementById("listArticles");
			
			var myData = {name:"testName"};
			var menu = $("#menu");
			var content = $("#content");
			
			var subscribe = function() {
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
			}
			
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