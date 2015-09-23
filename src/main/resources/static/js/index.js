var toto = {};

toto.mafonction = function() {
	
	console.log(this.valeur);
};

toto.valeur = 5;

toto.mafonction();


$(document).ready(

	function(){
		console.log("ready");
		
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